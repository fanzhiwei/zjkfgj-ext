App.Menu = function() {
    return {
        currentFormValues: {},
        
        getStore: function() {
            var store = new Ext.data.Store({
                autoLoad: {
					params : {start:0, limit:15}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'menu/menus'
				}),
                remoteSort: false,
				reader: new Ext.data.JsonReader({
					totalProperty : 'totalCount',
					root : 'rows',
					idProperty : 'id',
					fields: [{
						name: 'id',
						type: 'int'
					},
					{
						name: 'name'
					},
					{
						name: 'url'
					},
					{
						name: 'sort_num',
						type: 'int'
					},
					{
						name: "parent_menu"
					},
					{
						name: "description"
					}]
				})
            });
            return store;
        },
        
        getForm: function() {
            var form = new Ext.form.FormPanel({
				url:'menu/save',
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
                    fieldLabel: '菜单名称',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.getForm().findField("url");
                                if (obj) obj.focus();
                            }
                        }
                    }
                },
                {
                    name: 'url',
                    fieldLabel: '菜单链接',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.getForm().findField("sort_num");
                                if (obj) obj.focus();
                            }
                        }
                    }
                },
                {
                    name: 'sort_num',
                    fieldLabel: '菜单排位',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.getForm().findField("parent_menu");
                                if (obj) obj.focus();
                            }
                        }
                    }
                },
                {
                    xtype: 'combo',
                    allowBlank: true,
                    name: 'parent_menu',
                    hiddenName:'parent_id',
                    fieldLabel: '父菜单',
                    maxlength: 50,
                    store: new Ext.data.Store({
						proxy: new Ext.data.HttpProxy({
							url : 'menu/parentMenus'
						}),
						autoLoad: true,
						remoteSort: false,
						reader: new Ext.data.JsonReader({
							totalProperty: 'totalCount',
							idProperty: 'id',
							root: 'rows',
							fields: [{
								name: 'id'
							},
							{
								name: 'name'
							}]
						})
                    }),
					mode: 'local',
                    forceSelection: true,
                    valueField: 'id',
                    displayField: 'name',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.getForm().findField("description");
                                if (obj) obj.focus();
                            }
                        } //keypress
                    }
                },
                {
                	 name: 'description',
                     fieldLabel: '菜单描述',
                     listeners: {
                            scope: this,
                            keypress: function(field, e) {
                                if (e.getKey() == 13) {
                                    this.submit();
                                }
                            }
                        }
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
                        var f = this.form.getForm();
                        f.reset();
                        f.setValues(this.currentFormValues);
                        f.clearInvalid();
                    }
                }]
            });
            return form;
        },

        submit: function() {
            if (this.form.getForm().isValid()) {
                var id = this.form.getForm().findField("id").getValue();
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
                height: 230,
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
                loadMask: true,
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
                    header: "菜单名称",
                    width: 200,
                    sortable: true,
                    dataIndex: 'name'
                },
                {
                    header: "菜单链接",
                    width: 200,
                    sortable: true,
                    dataIndex: 'url'
                },
                {
                    header: "菜单排位",
                    width: 100,
                    sortable: true,
                    dataIndex: 'sort_num'
                },
                {
                    header: "父菜单名称",
                    width: 200,
                    sortable: true,
                    dataIndex: 'parent_menu'
                },
                {
                    header: "菜单描述",
                    width: 400,
                    sortable: true,
                    dataIndex: 'description'
                }]
            });
            panel.add(this.grid);
        },

        add: function() {
            Ext.apply(this.currentFormValues, {
                id: '',
                name: "",
                url: "",
                sort_num: "",
                parent_menu: "",
                description:""
            });
            this.dlg.setTitle("增加菜单");
            this.dlg.show();
        },

        edit: function() {
            if (this.grid.getSelectionModel().hasSelection()) {
                this.dlg.setTitle("编辑菜单");
                var rec = this.grid.getSelectionModel().getSelected();
                Ext.apply(this.currentFormValues, {
                    id: rec.data.id,
                    name: rec.data.name,
                    url: rec.data.url,
                    sort_num: rec.data.sort_num,
                    parent_menu: rec.data.parent_menu,
                    description:rec.data.description
                });
                this.dlg.show();
            } else {
                Ext.Msg.alert('信息', '请选择要编辑的菜单。');
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
                Ext.Msg.confirm('删除菜单', '确定删除以下菜单？<br><font color="red">' + titles + '</font>',
                function(btn) {
                    if (btn == 'yes') {
						Ext.Ajax.request({
							method:'post',
							url:'menu/remove',
							params:{
								ids:ids.toString()
							},
							success: function(resp, opts) {
								var result = Ext.util.JSON.decode(resp.responseText);
								var info = result.info;
								if(result.success=='true') {
									Ext.Msg.alert('信息', info);
                                    App.User.store.reload();
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
                Ext.Msg.alert('信息', '请选择要删除的菜单！');
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
