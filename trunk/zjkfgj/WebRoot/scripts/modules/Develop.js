App.Develop = function() {
    return {

        currentFormValues: {},

        getStore: function() {
        	var queryDateObj = document.getElementById("queryDate");
        	var queryDate;
        	if (queryDateObj == null) {
        		queryDate = "";
        	} else {
        		queryDate = queryDateObj.value;
        	}
            var store = new Ext.data.Store({
                autoLoad: {
					params : {start:0, limit:15,recordYearMonth:queryDate}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'develop/lists'
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
						name: 'areaId'
					},
					{
						name: 'areaName'
					},
					{
						name: 'createTime',
						type: 'date',
						dateFormat: 'time'
					},
					{
						name: 'modifyTime',
						type: 'date',
						dateFormat: 'time',
					},
					{
						name: 'recordYearMonth'
					},
					{
						name: 'investHouse'
					},
					{
						name: 'investBusiness'
					},
					{
						name: 'investOffice'
					},
					{
						name: 'investOther'
					},
					{
						name: 'financialSourcingInland'
					},
					{
						name: 'financialSourcingForeign'
					},
					{
						name: 'financialSourcingSelf'
					},
					{
						name: 'financialSourcingOther'
//					},
//					{
//						name: "investBusiness"
//						convert: this.roleList
					}]
				})
            });
            return store;
        },

//        roleList: function(value, rec) {
//            var list = "";
//            for (var i = 0; i < rec.roles.length; i++) {
//                list += rec.roles[i].name + ",";
//            }
//            return list.substr(0, list.length - 1);
//        },

        getForm: function() {
        	var areaDataType = new Ext.data.SimpleStore({  
        	    fields : ['key', 'value'],  
        	    data : [['1', '桥东区'], ['2', '桥西区']]  
        	});  
        	          
        	var areaTypeCombo = new Ext.form.ComboBox({  
        	        colspan : 2,  
        	        fieldLabel : '区县',  
        	        store : areaDataType,  
        	        displayField : 'value',  
        	        valueField : 'key',  
        	        mode : 'local',  
        	        typeAhead : true,  
        	        forceSelection : true,  
        	        triggerAction : 'all',  
        	        width : 155,  
//        	        emptyText : '请选择 .... ',  
        	        selectOnFocus : true  
        	});  
        	
        	var investHouse = {
        		xtype:'textfield',
      	    	fieldLabel: '住宅',
      	    	name: 'investHouse',
      	    	allowBlank: false
        	},investBusiness = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房',
          	    	name: 'investBusiness'
            },investOffice = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房',
          	    	name: 'investOffice'
            },investOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房',
          	    	name: 'investOther'
            },financialSourcingInland = {
            		xtype:'textfield',
          	    	fieldLabel: '国内筹款',
          	    	name: 'financialSourcingInland'
            },financialSourcingForeign = {
            		xtype:'textfield',
          	    	fieldLabel: '利用外资',
          	    	name: 'financialSourcingForeign'
            },financialSourcingSelf = {
            		xtype:'textfield',
          	    	fieldLabel: '自筹资金',
          	    	name: 'financialSourcingSelf'
            },financialSourcingOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他资金',
          	    	name: 'financialSourcingOther'
            };
            var form = new Ext.form.FormPanel({
				url:'develop/save',
                labelAlign: 'right',
                buttonAlign: 'center',
                bodyStyle: 'padding:5px',
                frame: true,
                labelWidth: 60,
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
                    name: 'areaId',
                    fieldLabel: '区域名称',
                },
                {
                    name: 'recordYearMonth',
                    fieldLabel: '记录年月',
                },
                {
                	xtype:'fieldset',
                	title:'完成投资（万元）',
                	collapsible:true,
                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.3,
            	    	   items:investHouse
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.3,
            	    	   labelWidth: 90,
            	    	   items:investBusiness
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.3,
            	    	   items:investOffice
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.3,
            	    	   items:investOther
            	       }
                	],
                	layout:"column"
                },
                {
                	xtype:'fieldset',
                	title:'资金来源总数（万元）',
                	collapsible:true,
                	height:100,
                	items:
                	[
                		 {
                			 layout:'form',
                			 columnWidth:.33,
                			 items:financialSourcingInland
                		 },
                		 {
                			 layout:'form',
                			 columnWidth:.33,
                			 items:financialSourcingForeign
                		 },
                		 {
                			 layout:'form',
                			 columnWidth:.33,
                			 items:financialSourcingSelf
                		 },
                		 {
                			 layout:'form',
                			 columnWidth:.33,
                			 items:financialSourcingOther
                		 }
                	],
                	layout:"column"
                }
                ],
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
                width: 750,
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
                    id: 'queryDate',
                    name: 'queryDate',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y.m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	this.getStore();
                        },
		                change: function(obj, date) {
		                	this.getStore();
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
                    dataIndex: 'id'
                },
                {
                    header: "记录地区",
                    width: 100,
                    sortable: true,
                    dataIndex: 'areaName'
                },
                {
                	header: "记录年月",
                	width: 100,
                	sortable: true,
                	dataIndex: 'recordYearMonth'
                },
                {
                    header: "创建日期",
                    width: 300,
                    sortable: true,
                    dataIndex: 'createTime',
                    renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s')
                },
                {
                	header: "修改日期",
                	width: 300,
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
            	areaId:'',
            	recordYearMonth:'',
            	investHouse:'',
            	investBusiness:'',
            	investOffice:'',
            	investOther:'',
            	financialSourcingInland:'',
            	financialSourcingForeign:'',
            	financialSourcingSelf:'',
            	financialSourcingOther:''
            });
            this.dlg.setTitle("新增记录");
            this.dlg.show();
        },

        edit: function() {
            if (this.grid.getSelectionModel().hasSelection()) {
                this.dlg.setTitle("编辑记录");
                var rec = this.grid.getSelectionModel().getSelected();
//                var ml = [];
//                for (var i = 0; i < rec.data.roles.length; i++) {
//                    ml.push(rec.data.roles[i].id);
//                }
                Ext.apply(this.currentFormValues, {
                	id:rec.data.id,
                	areaId:rec.data.areaId,
                	recordYearMonth:rec.data.recordYearMonth,
                	investHouse:rec.data.investHouse,
                	investBusiness:rec.data.investBusiness,
                	investOffice:rec.data.investOffice,
                	investOther:rec.data.investOther,
                	financialSourcingInland:rec.data.financialSourcingInland,
                	financialSourcingForeign:rec.data.financialSourcingForeign,
                	financialSourcingSelf:rec.data.financialSourcingSelf,
                	financialSourcingOther:rec.data.financialSourcingOther
//                    id: rec.data.id,
//                    name: rec.data.name,
//                    password: "",
//                    confirmPassword: "",
//                    roleList: ml.toString()
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
                    titles += data.id + '<br>';
                }
                Ext.Msg.confirm('删除记录', '确定删除以下记录？<br><font color="red">' + titles + '</font>',
                function(btn) {
                    if (btn == 'yes') {
						Ext.Ajax.request({
							method:'post',
							url:'develop/remove',
							params:{
								ids:ids.toString()
							},
							success: function(resp, opts) {
								var result = Ext.util.JSON.decode(resp.responseText);
								var info = result.info;
								if(result.success=='true') {
									Ext.Msg.alert('信息', info);
                                    App.Develop.store.reload();
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

//        query: function() {
//        	App.Develop.store.reload();
//        },
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
