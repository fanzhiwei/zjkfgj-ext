App.User = function() {
    return {

        currentFormValues: {},

        getStore: function() {
            var store = new Ext.data.Store({
                autoLoad: {
					params : {start:0, limit:15}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'user/users'
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
						name: 'name',
						allowBlank: false
					},
					{
						name: 'createDate',
						type: 'date',
						dateFormat: 'time'
					},
					{
						name: 'roles'
					},
					{
						name: "roleList",
						convert: this.roleList
					}]
				})
            });
            return store;
        },

        roleList: function(value, rec) {
            var list = "";
            for (var i = 0; i < rec.roles.length; i++) {
                list += rec.roles[i].name + ",";
            }
            return list.substr(0, list.length - 1);
        },

        getForm: function() {
            var form = new Ext.form.FormPanel({
				url:'user/save',
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
                    fieldLabel: '用户名称',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.getForm.findField("password");
                                if (obj) obj.focus();
                            }
                        }
                    }
                },
                {
                    inputType: 'password',
                    name: 'password',
                    fieldLabel: '密码',
                    id: 'password',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.getForm().findField("confirmPassword");
                                if (obj) obj.focus();
                            }
                        }
                    }
                },
                {
                    inputType: 'password',
                    name: 'confirmPassword',
                    fieldLabel: '确认密码',
                    vtype: 'password',
                    initialPassField: 'password',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.form.getForm().findField("roleList");
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
                        name: 'roleList',
                        allowBlank: true,
                        width: 330,
                        height: 240,
                        enableKeyEvents: true,
                        valueField: "id",
                        displayField: "name",
                        tbar: ["选择角色"],
                        store: new Ext.data.Store({
							autoLoad: true,
                            remoteSort: false,
							proxy: new Ext.data.HttpProxy({
								url : 'role/roleList'
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
                },
                {
                    xtype: 'panel',
                    border: false,
                    html: "<span id='pwdMsg' style='color:red;'></span>"
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
                height: 460,
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
                        this.form.getForm().waitMsgTarget = fp.getEl();
                    },
                    show: function() {
                        var f = this.form.getForm();
                        f.findField("roleList").store.reload();
                        f.setValues(this.currentFormValues);
                        f.clearInvalid();
                        if (this.currentFormValues.id) {
                            Ext.get("pwdMsg").dom.innerHTML = "<span style='color:red;line-height:30px;'>*如果不修改密码请不要输入密码和确认密码</span>";
                            f.findField("password").allowBlank = true;
                            f.findField("confirmPassword").allowBlank = true;
                        } else {
                            f.findField("password").allowBlank = false;
                            f.findField("confirmPassword").allowBlank = false;
                            Ext.get("pwdMsg").dom.innerHTML = "<span style='color:red;'></span>";
                        }
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
                    header: "用户名称",
                    width: 100,
                    sortable: true,
                    dataIndex: 'name'
                },
                {
                    header: "创建日期",
                    width: 300,
                    sortable: true,
                    dataIndex: 'createDate',
                    renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s')
                },
                {
                    header: "角色",
                    width: 300,
                    sortable: true,
                    dataIndex: 'roleList'
                }]
            });
            panel.add(this.grid);

        },

        add: function() {
            Ext.apply(this.currentFormValues, {
                id: '',
                name: "",
                password: "",
                confirmPassword: "",
                roleList: ""
            });
            this.dlg.setTitle("增加用户");
            this.dlg.show();
        },

        edit: function() {
            if (this.grid.getSelectionModel().hasSelection()) {
                this.dlg.setTitle("编辑用户");
                var rec = this.grid.getSelectionModel().getSelected();
                var ml = [];
                for (var i = 0; i < rec.data.roles.length; i++) {
                    ml.push(rec.data.roles[i].id);
                }
                Ext.apply(this.currentFormValues, {
                    id: rec.data.id,
                    name: rec.data.name,
                    password: "",
                    confirmPassword: "",
                    roleList: ml.toString()
                });
                this.dlg.show();
            } else {
                Ext.Msg.alert('信息', '请选择要编辑的用户。');
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
                Ext.Msg.confirm('删除用户', '确定删除以下用户？<br><font color="red">' + titles + '</font>',
                function(btn) {
                    if (btn == 'yes') {
						Ext.Ajax.request({
							method:'post',
							url:'user/remove',
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
                Ext.Msg.alert('信息', '请选择要删除的用户！');
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
