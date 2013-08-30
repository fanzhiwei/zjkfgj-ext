App.Role = function() {

    return {

        currentFormValues: {},

        getStore: function() {
            var store = new Ext.data.DirectStore({
				autoLoad: {
					params : {start:0, limit:15}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'role/roles'
				}),
                remoteSort: false,
                totalProperty: 'totalCount',
                idProperty: 'id',
                root: 'rows',
                fields: [{
                    name: 'id',
                    type: 'int'
                },
                {
                    name: 'name',
                    allowBlank: false
                },
                {
                    name: 'description'
                },
                {
                    name: 'menus'
                },
                {
                    name: "menuList",
                    convert: this.menuList
                }]
            });
            return store;
        },

        menuList: function(value, rec) {
            var list = "";
            for (var i = 0; i < rec.menus.length; i++) {
                list += rec.menus[i].name + ",";
            }
            return list.substr(0, list.length - 1);
        },

        getForm: function() {
            var form = new Ext.form.FormPanel({
				url:'role/save',
                labelAlign: 'left',
                buttonAlign: 'center',
                bodyStyle: 'padding:5px',
                frame: true,
                labelWidth: 80,
                defaultType: 'textfield',
                defaults: {
                    allowBlank: false,
                    anchor: '90%',
                    enableKeyEvents: true
                },
                items: [{
                    xtype: 'hidden',
                    name: 'id',
                    value: ''
                },
                {
                    name: 'name',
                    fieldLabel: '角色名称',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.getForm().findField("description");
                                if (obj) obj.focus();
                            }
                        }
                    }
                },
                {
                    name: 'description',
                    fieldLabel: '描述',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.form.findField("menuList");
                                if (obj) obj.focus();
                            }
                        }
                    }
                },
                {
                    xtype: 'panel',
                    width: 330,
                    height: 240,
                    layout: 'fit',
                    bodyStyle: 'background:white',
                    items: [{
                        xtype: 'multiselect',
                        name: 'menuList',
                        allowBlank: true,
                        width: 330,
                        height: 240,
                        enableKeyEvents: true,
                        valueField: "id",
                        displayField: "name",
                        tbar: ["选择权限"],
						store: new Ext.data.Store({
							autoLoad: true,
                            remoteSort: false,
							proxy: new Ext.data.HttpProxy({
								url : 'menu/menuList'
							}),
                            reader: new Ext.data.JsonReader({
								totalProperty : 'totalCount',
								root : 'rows',
								idProperty : 'id',
								fields: [{
									name: 'id'
								},
								{
									name: 'name'
								}]
							})
                        }),
                        listeners: {
                            scope: this,
                            keypress: function(field, e) {
                                if (e.getKey() == 13) {
                                    this.submit();
                                }
                            }
                        }
                    }]
                }],
                buttons: [{
                    text: '确定',
                    scope: this,
                    handler: function() {
                        this.submit();
                    }
                },
                {
                    text: '重置',
                    scope: this,
                    handler: function() {
                        this.form.getForm().reset();
                        this.form.getForm().setValues(this.currentFormValues);
                        this.form.getForm().clearInvalid();
                    }
                }]
            });
            return form;
        },

        submit: function() {
            if (this.form.form.isValid()) {
                var id = this.form.form.findField("id").getValue();
				this.form.getForm().submit({
                    waitTitle: '保存数据',
                    waitMsg: '正在保存……',
                    scope: this,
                    method: 'post',
                    params: '',
                    success: function(form, action) {
                        var info = action.result.info;
                        if (action.result.success) {
                            this.store.reload();
                            if (action.result.method == "Create") {
                                this.form.getForm().reset();
                            } else {
                                this.dlg.hide();
                            }
                        }
                        Ext.Msg.alert('信息', info);
                    },
                    failure: function(form, action) {
                        var info = action.result.info;
	    				Ext.Msg.alert('提示', info);
                    }
                });
            }
        },

        getDialog: function() {
            var dlg = new Ext.Window({
                width: 400,
                height: 400,
                title: '',
                plain: true,
                closable: true,
                resizable: false,
                frame: true,
                layout: 'fit',
                closeAction: 'hide',
                border: false,
                modal: true,
                items: [this.form],
                listeners: {
                    scope: this,
                    render: function(fp) {
                        this.form.form.waitMsgTarget = fp.getEl();
                    },
                    show: function() {
                        this.form.form.setValues(this.currentFormValues);
                        this.form.form.clearInvalid();
                    }
                }
            });
            return dlg;
        },

        createGrid: function(id) {

            var panel = Ext.getCmp(id);

            panel.body.dom.innerHTML = "";

            var sm = new Ext.grid.CheckboxSelectionModel();

            this.grid = new Ext.grid.GridPanel({
                tbar: [{
                    text: '增加',
                    scope: this,
                    handler: this.add
                },
                {
                    text: '编辑',
                    scope: this,
                    handler: this.edit
                },
                {
                    text: '删除',
                    scope: this,
                    handler: this.del
                }],
                store: this.store,
                sm: sm,
                columns: [sm, {
                    header: "编号",
                    width: 40,
                    sortable: true,
                    dataIndex: 'id'
                },
                {
                    header: "角色名称",
                    width: 100,
                    sortable: true,
                    dataIndex: 'name'
                },
                {
                    header: "描述",
                    width: 300,
                    sortable: true,
                    dataIndex: 'description'
                },
                {
                    header: "权限",
                    width: 300,
                    sortable: true,
                    dataIndex: 'menuList'
                }]
            });

            panel.add(this.grid);

        },

        add: function() {
            Ext.apply(this.currentFormValues, {
                id: '',
                name: "",
                description: "",
                menuList: ""
            });
            this.dlg.setTitle("增加角色");
            this.dlg.show();
        },

        edit: function() {
            if (this.grid.getSelectionModel().hasSelection()) {
                this.dlg.setTitle("编辑角色");
                var rec = this.grid.getSelectionModel().getSelected();
                var ml = [];
                for (var i = 0; i < rec.data.menus.length; i++) {
                    ml.push(rec.data.menus[i].id);
                }
                Ext.apply(this.currentFormValues, {
                    id: rec.data.id,
                    name: rec.data.name,
                    description: rec.data.description,
                    menuList: ml.toString()
                });
                this.dlg.show();
            } else {
                Ext.Msg.alert('信息', '请选择要编辑的角色。');
            }
        },

        del: function() {
            if (this.grid.getSelectionModel().hasSelection()) {
                var recs = this.grid.getSelectionModel().getSelections();
                var ids = [];
                var titles = '';
                for (var i = 0; i < recs.length; i++) {
                    var data = recs[i].data;
                    ids.push(data.id);
                    titles += data.name + '<br>';
                }
                Ext.Msg.confirm('删除角色', '确定删除以下角色？<br><font color="red">' + titles + '</font>',
                function(btn) {
                    if (btn == 'yes') {
                       Ext.Ajax.request({
							method:'post',
							url:'role/remove',
							params:{
								ids:ids.toString()
							},
							success: function(resp, opts) {
								var result = Ext.util.JSON.decode(resp.responseText);
								var info = result.info;
								if(result.success=='true') {
									Ext.Msg.alert('信息', info);
                                    App.Role.store.reload();
								}else {
                                    Ext.Msg.alert('信息', info);
                                }
							},
							failure: function(resp,opts) {
								var result = Ext.util.JSON.decode(resp.responseText);
								var info = result.info;
								Ext.Msg.alert('提示', info); 
							}
						});
                    }
                });
            } else {
                Ext.Msg.alert('信息', '请选择要删除的角色！');
            }
        },

        render: function(id) {
            if (!this.store) {
                this.store = this.getStore();
            };
            if (!this.form) {
                this.form = this.getForm();
            };

            if (!this.dlg) {
                this.dlg = this.getDialog();
            };
            this.createGrid(id);

        }

    };
} ();
