App.DistrictReport7 = function() {
    return {

        currentFormValues: {},

        getStore: function() {
            var store = new Ext.data.Store({
                autoLoad: {
					params : {}
//            		params : {start:0, limit:15,recordYearMonth:queryDate}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'district/listReport7?t=' + new Date().getTime()
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
						name: 'createTime',
						type: 'date',
						dateFormat: 'time'
					},
					{
						name: 'modifyTime',
						type: 'date',
						dateFormat: 'time'
					},
					{
						name: 'recordYearMonth'
					},
					{
						name: 'dealNumber'
					},
					{
						name: 'dealArea'
					},
					{
						name: 'totalPrice'
					},
					{
						name: 'averagePrice'
					}
					]
				})
            });
            return store;
        },

        getForm: function() {
            var form = new Ext.form.FormPanel({
				url:'district/saveReport7',
                labelAlign: 'right',
                buttonAlign: 'center',
                bodyStyle: 'padding:5px',
                frame: true,
                labelWidth: 120,
                defaultType: 'textfield',
                defaults: {
                    allowBlank: false,
                    anchor: '90%',
                    enableKeyEvents: true
                },
                items: [
                {
                    xtype: 'hidden',
                    name: 'id',
                    value: ''
                },
                {
                    name: 'recordYearMonth',
                    fieldLabel: '报送年月',
                    readOnly:true
                },
                {
                	name: 'dealNumber',
                	maxLength: 9,
                	fieldLabel: '套数',
	      	    	regex:/^\d{0,9}$/,
	      	    	regexText:'最多输入9位数字'
                },
                {
                	name: 'dealArea',
                	maxLength: 50,
                	fieldLabel: '面积（m2）',
            		regex:/^\d{0,12}\.?\d{0,2}$/,
            		regexText:'最多输入14位数字，且只能有两位小数'
                },
                {
                	name: 'totalPrice',
                	maxLength: 11,
                	fieldLabel: '总金额（万元）',
                	regex:/^\d{0,10}$/,
                	regexText:'最多输入10位数字'
                },
                {
                	name: 'averagePrice',
                	maxLength: 50,
                	fieldLabel: '平均价（元）',
                	regex:/^\d{0,12}\.?\d{0,2}$/,
                	regexText:'最多输入14位数字，且只能有两位小数'
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
                },
                {
                    text: '关闭',
                    scope: this,
                    handler: function() {
                    	this.dlg.hide();
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
                                //TODO有时间改进，不关闭，但把记录在reset后保留
                                this.dlg.hide();
                                this.add();
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
                width: 500,
                height: 220,
                autoScroll:true,
                bodyStyle:'overflow-y:auto;overflow-x:hidden;',
                title: '',
                plain: true,
                closable: true,
                resizable: false,
                frame: true,
//                layout: 'fit',
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
                    xtype: 'datefield',
                    id: 'queryDateReport7',
                    name: 'queryDate',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxLength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	App.DistrictReport7.store.reload({params:{recordYearMonth:document.getElementById("queryDateReport7").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	App.DistrictReport7.store.reload({params:{recordYearMonth:document.getElementById("queryDateReport7").value.replace("-","")}});
		                }
                    }
                },{
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
                    renderer:function(value,metadata,record,rowIndex){
                    	if(this.rowspan){ 
                    	p.cellAttr = 'rowspan="'+this.rowspan+'"'; 
                    	}
                    	var start = 0;
                    	return start + rowIndex+1;
                    }//自动编号
                },
                {
                    header: "套数",
                    width: 100,
                    sortable: true,
                    dataIndex: 'dealNumber'
                },
                {
                	header: "面积（m2）",
                	width: 100,
                	sortable: true,
                	dataIndex: 'dealArea'
                },
                {
                	header: "总金额（万元）",
                	width: 100,
                	sortable: true,
                	dataIndex: 'totalPrice'
                },
                {
                	header: "平均价（元）",
                	width: 100,
                	sortable: true,
                	dataIndex: 'averagePrice'
                },
                {
                    header: "创建日期",
                    width: 140,
                    sortable: true,
                    dataIndex: 'createTime',
                    renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s')
                },
                {
                	header: "修改日期",
                	width: 140,
                	sortable: true,
                	dataIndex: 'modifyTime',
                	renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s')
                }]
            });
            panel.add(this.grid);
        },

        add: function() {
            Ext.apply(this.currentFormValues, {
            	id:'',
            	recordYearMonth: document.getElementById("queryDateReport7").value.replace("-",""),
            	dealNumber:'',
            	dealArea:'',
            	totalPrice:'',
            	averagePrice:''
            });
            this.dlg.setTitle("新增记录");
            this.dlg.show();
        },

        edit: function() {
            if (this.grid.getSelectionModel().hasSelection()) {
                this.dlg.setTitle("编辑记录");
                var rec = this.grid.getSelectionModel().getSelected();
                Ext.apply(this.currentFormValues, {
                	id:rec.data.id,
                	recordYearMonth:rec.data.recordYearMonth,
                	dealNumber:rec.data.dealNumber,
                	dealArea:rec.data.dealArea,
                	totalPrice:rec.data.totalPrice,
                	averagePrice:rec.data.averagePrice     
                });
                this.dlg.show();
            } else {
                Ext.Msg.alert('信息', '请选择要编辑的记录。');
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
                    titles += data.developerName + '<br>';
                }
                Ext.Msg.confirm('删除记录', '确定删除当前记录？',
                function(btn) {
                    if (btn == 'yes') {
						Ext.Ajax.request({
							method:'post',
							url:'district/removeReport7',
							params:{
								ids:ids.toString()
							},
							success: function(resp, opts) {
								var result = Ext.util.JSON.decode(resp.responseText);
								var info = result.info;
								if(result.success=='true') {
									Ext.Msg.alert('信息', info);
                                    App.DistrictReport7.store.reload();
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
                Ext.Msg.alert('信息', '请选择要删除的记录！');
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
