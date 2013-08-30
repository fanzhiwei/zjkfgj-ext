App.Money = function() {
    return {
	
        currentFormValues: {},
        currentGridEditRow: null,

        getStore: function() {
            var store = new Ext.data.Store({
                proxy: new Ext.data.HttpProxy({
					url : 'money/moneys'
				}),
                autoLoad: {
					params : {start:0, limit:2}
				},
				remoteSort: false,
				reader: new Ext.data.JsonReader({
					totalProperty: 'totalCount',
					idProperty: 'id',
					root: 'rows',
					fields: [{
						name: 'id',
						type: 'int'
					},
					{
						name: 'operator'
					},
					{
						name: 'createTime',
						type: 'date',
						dateFormat: 'time'
					},
					{
						name: 'total',
						type: 'float'
					},
					{
						name: 'subList'
					}]
				}),
                listeners: {
                    scope: this,
                    load: function(store, recs) {
                        if (recs.length > 0) {
                            this.grid.getSelectionModel().selectFirstRow();
                            this.substore.loadData(recs[0].data.subList);
                        }
                    }
                }
            });
            return store;
        },

        getSubStore: function() {
            var store = new Ext.data.JsonStore({
                idIndex: 0,
                fields: [{
                    name: 'id',
                    type: 'int'
                },
                {
                    name: 'name'
                },
                {
                    name: 'price',
                    type: 'float'
                }],
                remoteSort: false
            });
            return store;
        },

        getForm: function() {
            this.frmStore = new Ext.data.JsonStore({
                idIndex: 0,
                fields: [{
                    name: 'id'
                },
                {
                    name: 'name'
                },
                {
                    name: 'price',
                    type: 'float'
                }],
                listeners: {
                    scope: this,
                    remove: function(store, rec, index) {
                        this.frm.form.findField("total")
                            .setValue(Ext.util.Format.number(store.sum("price"), '0.00'));
                    }
                }

            });

            var cm = new Ext.grid.ColumnModel([{
                header: "编号",
                width: 150,
                sortable: true,
                dataIndex: 'id'
            },
            {
                header: "名称",
                width: 150,
                sortable: true,
                dataIndex: 'name',
				editor:new Ext.form.TextField({
					allowBlank:false  
				})
            },
            {
                header: "价格",
                width: 100,
                sortable: true,
                dataIndex: 'price',
                align: 'right',
				editor:new Ext.form.NumberField({
					allowBlank:false
				}),
                renderer: function(v) {
                    return Ext.util.Format.number(v, "0.00");
                }
            }]);

            this.frmGrid = new Ext.grid.EditorGridPanel({
                width: 660,
                height: 300,
                title: "消费明细",
                frame: true,
                clicksToEdit: 1,
                tbar: [{
                    text: '增加',
                    scope: this,
                    handler: function() {
                        var u = new this.frmGrid.store.recordType({
                            id: Ext.id(),
                            name: '',
                            price: 0
                        });
                        this.frmGrid.store.insert(0, u);
                    }
                },
                {
                    text: '删除',
                    scope: this,
                    handler: function() {
                        var cell = this.frmGrid.getSelectionModel().getSelectedCell();
                        if (Ext.isArray(cell)) {
                            var rec = this.frmGrid.store.getAt(cell[0]);
                            if (!rec) {
                                return false;
                            }
                            this.frmGrid.store.remove(rec);
                        }
                    }
                }],
                store: this.frmStore,
                cm: cm,
                listeners: {
                    scope: this,
                    beforeedit: function(e) {
                        this.currentGridEditRow = e.row;
                    },
                    afteredit: function(e) {
                        App.Money.frm.form.findField("total").setValue(Ext.util.Format.number(e.grid.store.sum("price"), '0.00'));
                    }
                }
            });

            var frm = new Ext.form.FormPanel({
				url:'money/save',
                labelAlign: 'left',
                buttonAlign: 'center',
                bodyStyle: 'padding:5px',
                frame: true,
                labelWidth: 80,
                defaultType: 'textfield',
                defaults: {
                    allowBlank: true,
                    anchor: '90%',
                    enableKeyEvents: true
                },
                items: [{
                    xtype: 'hidden',
                    name: 'id',
                    value: ''
                },
                {
                    xtype: 'datefield',
                    name: 'createTime',
                    fieldLabel: '消费日期',
                    maxlength: 20,
                    format: 'Y-m-d',
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.frm.form.findField("operator");
                                if (obj) obj.focus();
                            }
                        } //keypress
                    }
                },
                {
                    xtype: 'combo',
                    name: 'operator',
                    fieldLabel: '消费人',
                    maxlength: 50,
                    store: new Ext.data.Store({
						proxy: new Ext.data.HttpProxy({
							url : 'user/userNames'
						}),
						autoLoad: true,
						remoteSort: false,
						reader: new Ext.data.JsonReader({
							totalProperty: 'totalCount',
							idProperty: 'id',
							root: 'rows',
							fields: [{
								name: 'name'
							}]
						})
                    }),
					mode: 'local',
                    forceSelection: true,
                    displayField: "name",
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                var obj = this.frm.form.findField("total");
                                if (obj) obj.focus();
                            }
                        } //keypress
                    }
                },
                {
                    name: 'total',
                    fieldLabel: '总金额',
                    maxlength: 100,
                    allowBlank: true,
                    readOnly: true,
                    listeners: {
                        scope: this,
                        keypress: function(field, e) {
                            if (e.getKey() == 13) {
                                this.submit();
                            }
                        } //keypress
                    }
                },
                this.frmGrid],
                //items
                buttons: [{
                    text: '确认',
                    scope: this,
                    handler: function() {
                        this.submit();
                    }
                },
                {
                    text: '重置',
                    scope: this,
                    handler: function() {
                        this.frm.form.reset();
                        this.frm.form.setValues(this.currentFormValues);
                        this.frm.form.clearInvalid();
                    }
                }] //buttons
            }); //FormPanel
            return frm;
        },

        submit: function() {
            if (this.frm.form.isValid()) {
                var id = this.frm.form.findField("id").getValue();
                var params = {};
				params["subListSize"] = this.frmStore.getCount();
                for (var i = 0; i < this.frmStore.getCount(); i++) {
                    var rec = this.frmStore.getAt(i);
                    params["sub_name_" + i] = rec.data.name;
                    params["sub_price_" + i] = rec.data.price;
                }
				this.frm.form.submit({
					waitTitle: '保存数据',
                    waitMsg: '正在保存……',
                    scope: this,
                    method: 'post',
                    params: params,
					success: function(form, action) {
                        var info = action.result.info;
                        if (action.result.success) {
                            this.store.reload();
                            if (action.result.method == "Create") {
                                this.frm.form.reset();
                                this.frmStore.removeAll();
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
                width: 700,
                height: 500,
                title: '',
                plain: true,
                closable: true,
                resizable: false,
                frame: true,
                layout: 'fit',
                closeAction: 'hide',
                border: false,
                modal: true,
                items: [this.frm],
                listeners: {
                    scope: this,
                    render: function(fp) {
                        this.frm.form.waitMsgTarget = fp.getEl();
                    },
                    show: function() {
                        this.frm.form.setValues(this.currentFormValues);
                        this.frm.form.clearInvalid();
                    }
                }
            }); //dlg
            return dlg;
        },

        createGrid: function(id) {

            var panel = Ext.getCmp(id);

            panel.body.dom.innerHTML = "";

            var sm = new Ext.grid.CheckboxSelectionModel();

            this.grid = new Ext.grid.GridPanel({
                region: 'center',
                tbar: new Ext.PagingToolbar({
                    pageSize: 2,
                    displayInfo: true,
                    store: this.store,
                    items: ['-', {
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
                    }]
                }),
                store: this.store,
                sm: sm,
                columns: [sm, {
                    header: "编号",
                    width: 100,
                    sortable: true,
                    dataIndex: 'id'
                },
                {
                    header: "消费人",
                    width: 150,
                    sortable: true,
                    dataIndex: 'operator'
                },
                {
                    header: "消费日期",
                    width: 300,
                    sortable: true,
                    dataIndex: 'createTime',
                    renderer: Ext.util.Format.dateRenderer('Y-m-d')
                },
                {
                    header: "总金额",
                    width: 200,
                    sortable: true,
                    dataIndex: 'total',
                    align: 'right',
                    renderer: function(v) {
                        return Ext.util.Format.number(v, "0.00");
                    }
                }],
                listeners: {
                    scope: this,
                    rowclick: function(grid, rowIndex, e) {
                        var rec = this.store.getAt(rowIndex);
                        if (rec) {
                            this.substore.loadData(rec.data.subList);
                        }
                    }
                }
            });

            this.subGrid = new Ext.grid.GridPanel({
                store: this.substore,
                title: '消费明细',
                region: 'south',
                layout: 'fit',
                split: true,
                height: 225,
                minSize: 175,
                maxSize: 400,
                columns: [{
                    header: "编号",
                    width: 100,
                    sortable: true,
                    dataIndex: 'id'
                },
                {
                    header: "名称",
                    width: 150,
                    sortable: true,
                    dataIndex: 'name'
                },
                {
                    header: "价钱",
                    width: 200,
                    sortable: true,
                    dataIndex: 'price',
                    align: 'right',
                    renderer: function(v) {
                        return Ext.util.Format.number(v, "0.00");
                    }
                }]
            });

            panel.add(new Ext.Panel({
                layout: "border",
                items: [this.grid, this.subGrid]
            }));

            this.store.load({
                dir: "",
                sort: "",
                start: 0,
                limit: 50
            });
        },

        add: function() {
            var d = new Date();
            Ext.apply(this.currentFormValues, {
                id: '',
                createTime: Ext.util.Format.date(d, 'Y-m-d'),
                operator: "",
                total: '0.00'
            });
            this.frmStore.removeAll();
            this.dlg.setTitle("增加消费记录");
            this.dlg.show();
        },

        edit: function() {
            if (this.grid.getSelectionModel().hasSelection()) {
                this.dlg.setTitle("编辑消费记录");
                var rec = this.grid.getSelectionModel().getSelected();
                Ext.apply(this.currentFormValues, {
                    id: rec.data.id,
                    createTime: rec.data.createTime,
                    operator: rec.data.operator,
                    total: Ext.util.Format.number(rec.data.total, "0.00")
                });
                this.frmStore.loadData(rec.data.subList);
                this.dlg.show();
            } else {
                Ext.Msg.alert('信息', '请选择要编辑的消费记录！');
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
                    titles += data.id + '<br>';
                }
                Ext.Msg.confirm('删除消费记录', '确定删除以下消费记录？<br><font color="red">' + titles + '</font>',
                function(btn) {
                    if (btn == 'yes') {
						Ext.Ajax.request({
							method:'post',
							url:'money/remove',
							params:{
								ids:ids.toString()
							},
							success: function(resp, opts) {
								var result = Ext.util.JSON.decode(resp.responseText);
								var info = result.info;
								if(result.success=='true') {
									Ext.Msg.alert('信息', info);
                                    App.Money.store.reload();
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
                Ext.Msg.alert('信息', '请选择要删除的消费记录！');
            }
        },

        render: function(id) {
            if (!this.store) {
                this.store = this.getStore();
            }; //if(!this.store)
            if (!this.substore) {
                this.substore = this.getSubStore();
            }; //if(!this.subStore)
            if (!this.frm) {
                this.frm = this.getForm();
            }; //if(!this.frm)

            if (!this.dlg) {
                this.dlg = this.getDialog();
            }; //if(!this.dlg)
            this.createGrid(id);
        }
    };
} ();
