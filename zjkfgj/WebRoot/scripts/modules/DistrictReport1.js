App.DistrictReport1 = function() {
    return {

        currentFormValues: {},

        getStore: function() {
            var store = new Ext.data.Store({
                autoLoad: {
					params : {}
//            		params : {start:0, limit:15,recordYearMonth:queryDate}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'district/listReport1?t=' + new Date().getTime()
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
						name: 'developerName'
					},
					{
						name: 'licenceNo'
					},
					{
						name: 'licenceDate',
						type: 'date',
						dateFormat: 'Y-m-d'
					},
					{
						name: 'projectName'
					},
					{
						name: 'location'
					},
					{
						name: 'houseNumber'
					},
					{
						name: 'houseArea'
					},
					{
						name: 'business'
					},
					{
						name: "office"
					},
					{
						name: "other"
					}
					]
				})
            });
            return store;
        },

        getForm: function() {
        	var houseNumber = {
	        		xtype:'textfield',
	      	    	fieldLabel: '住宅套数',
	      	    	name: 'houseNumber',
	      	    	regex:/^\d{0,12}$/,
	      	    	regexText:'最多输入12位数字',
	      	    	allowBlank: false
        	},houseArea = {
            		xtype:'textfield',
          	    	fieldLabel: '住宅面积(㎡)',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'houseArea'
            },business = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房(㎡)',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'business'
            },office = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房(㎡)',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'office'
            },other = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房(㎡)',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'other'
            };
            var form = new Ext.form.FormPanel({
				url:'district/saveReport1',
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
//                {
//                	id:'area',
//                    xtype: 'combo',
//                    allowBlank: false,
//                    name: 'area',
//                    hiddenName:'areaId',
//                    fieldLabel: '报送区域',
//                    maxlength: 20,
//                    store: new Ext.data. Store({
//						proxy: new Ext.data.HttpProxy({
//							url : 'develop/area'
//						}),
//						autoLoad: true,
//						remoteSort: false,
//						reader: new Ext.data.JsonReader({
//							totalProperty: 'totalCount',
//							idProperty: 'id',
//							root: 'rows',
//							fields: [{
//								name: 'id'
//							},
//							{
//								name: 'areaName'
//							}]
//						})
//                    }),
//					mode: 'local',
//                    forceSelection: true,
//                    valueField: 'id',
//                    displayField: 'areaName',
//					listeners:{
//						"expand":function(combo, store,index){ 
//						Ext.getCmp("area").getStore().load();
//						} 
//					}                    
//                },
                {
                    name: 'recordYearMonth',
                    fieldLabel: '报送年月',
                    readOnly:true
                },
                {
                	name: 'developerName',
                	maxlength: 100,
                	fieldLabel: '开发企业名称'
                },
                {
                	name: 'licenceNo',
                	maxlength: 25,
                	fieldLabel: '预售许可证编号'
                },
                {
                	name: 'licenceDate',
                	fieldLabel: '预售许可证颁发时间',
                	xtype: 'datefield',
                	format: 'Y-m-d',
                	maxlength: 25
                },
                {
                	name: 'projectName',
                	maxlength: 50,
                	fieldLabel: '项目名称'
                },
                {
                	name: 'location',
                	maxlength: 150,
                	fieldLabel: '房屋坐落地'
                },
                {
                	xtype:'fieldset',
                	title:'房屋用途',
                	collapsible:true,
//                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:1,
            	    	   items:houseNumber
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:1,
            	    	   items:houseArea
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:1,
            	    	   items:business
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:1,
            	    	   items:office
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:1,
            	    	   items:other
            	       }
                	],
                	layout:"column"
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
                width: 550,
                height: 420,
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
                    id: 'queryDateReport1',
                    name: 'queryDate',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	App.DistrictReport1.store.reload({params:{recordYearMonth:document.getElementById("queryDateReport1").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	App.DistrictReport1.store.reload({params:{recordYearMonth:document.getElementById("queryDateReport1").value.replace("-","")}});
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
                    header: "开发企业名称",
                    width: 220,
                    sortable: true,
                    dataIndex: 'developerName'
                },
                {
                	header: "预售许可证编号",
                	width: 100,
                	sortable: true,
                	dataIndex: 'licenceNo'
                },
                {
                	header: "预售许可证颁发时间",
                	width: 120,
                	sortable: true,
                	dataIndex: 'licenceDate',
            		renderer: Ext.util.Format.dateRenderer('Y-m-d')
                },
                {
                	header: "项目名称",
                	width: 150,
                	sortable: true,
                	dataIndex: 'projectName'
                },
                {
                	header: "房屋坐落地",
                	width: 150,
                	sortable: true,
                	dataIndex: 'location'
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
            	recordYearMonth: document.getElementById("queryDateReport1").value.replace("-",""),
            	developerName:'',
            	licenceNo:'',
            	licenceDate:'',
            	projectName:'',
            	location:'',
            	houseNumber:'',
            	houseArea:'',
            	business:'',
            	office:'',
            	other:''
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
                	developerName:rec.data.developerName,
                	licenceNo:rec.data.licenceNo,
                	licenceDate:rec.data.licenceDate,
                	projectName:rec.data.projectName,
                	location:rec.data.location,
                	houseNumber:rec.data.houseNumber,
                	houseArea:rec.data.houseArea,
                	business:rec.data.business,
                	office:rec.data.office,
                	other:rec.data.other        
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
                Ext.Msg.confirm('删除记录', '确定删除以下记录？<br><font color="red">' + titles + '</font>',
                function(btn) {
                    if (btn == 'yes') {
						Ext.Ajax.request({
							method:'post',
							url:'district/removeReport1',
							params:{
								ids:ids.toString()
							},
							success: function(resp, opts) {
								var result = Ext.util.JSON.decode(resp.responseText);
								var info = result.info;
								if(result.success=='true') {
									Ext.Msg.alert('信息', info);
                                    App.DistrictReport1.store.reload();
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
