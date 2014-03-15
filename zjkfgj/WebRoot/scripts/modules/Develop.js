App.Develop = function() {
    return {

        currentFormValues: {},

        getStore: function() {
//        	var queryDateObj = document.getElementById("queryDate");
//        	var queryDate;
//        	if (queryDateObj == null) {
//        		queryDate = "";
//        	} else {
//        		queryDate = queryDateObj.value.replace(".","");
//        	}
            var store = new Ext.data.Store({
                autoLoad: {
					params : {}
//            		params : {start:0, limit:15,recordYearMonth:queryDate}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'develop/lists?t=' + new Date().getTime()
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
						dateFormat: 'time'
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
					},
					{
						name: "workingAreaHouse"
					},
					{
						name: "workingAreaBusiness"
					},
					{
						name: "workingAreaOffice"
					},
					{
						name: "workingAreaOther"
					},
					{
						name: "newAreaHouse"
					},
					{
						name: "newAreaBusiness"
					},
					{
						name: "newAreaOffice"
					},
					{
						name: "newAreaOther"
					},
					{
						name: "completeAreaHouse"
					},
					{
						name: "completeAreaBusiness"
					},
					{
						name: "completeAreaOffice"
					},
					{
						name: "completeAreaOther"
					},
					{
						name: "saledAreaHouse"
					},
					{
						name: "saledAreaBusiness"
					},
					{
						name: "saledAreaOffice"
					},
					{
						name: "saledAreaOther"
					},
					{
						name: "incomingHouse"
					},
					{
						name: "incomingBusiness"
					},
					{
						name: "incomingOffice"
					},
					{
						name: "incomingOther"
					},
					{
						name: "onsaleAreaHouse"
					},
					{
						name: "onsaleAreaBusiness"
					},
					{
						name: "onsaleAreaOffice"
					},
					{
						name: "onsaleAreaOther"
					}
					]
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
        	var investHouse = {
	        		xtype:'textfield',
	      	    	fieldLabel: '住宅',
	      	    	name: 'investHouse',
	      	    	regex:/^\d{0,12}\.?\d{0,2}$/,
	      	    	regexText:'最多输入14位数字，且只能有两位小数',
	      	    	allowBlank: false
        	},investBusiness = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'investBusiness'
            },investOffice = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'investOffice'
            },investOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'investOther'
            },financialSourcingInland = {
            		xtype:'textfield',
          	    	fieldLabel: '国内筹款',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'financialSourcingInland'
            },financialSourcingForeign = {
            		xtype:'textfield',
          	    	fieldLabel: '利用外资',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'financialSourcingForeign'
            },financialSourcingSelf = {
            		xtype:'textfield',
          	    	fieldLabel: '自筹资金',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'financialSourcingSelf'
            },financialSourcingOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他资金',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'financialSourcingOther'
            },workingAreaHouse = {
	        		xtype:'textfield',
	      	    	fieldLabel: '住宅',
	      	    	name: 'workingAreaHouse',
	      	    	regex:/^\d{0,12}\.?\d{0,2}$/,
	      	    	regexText:'最多输入14位数字，且只能有两位小数',
	      	    	allowBlank: false
        	},workingAreaBusiness = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'workingAreaBusiness'
            },workingAreaOffice = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'workingAreaOffice'
            },workingAreaOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'workingAreaOther'
            },newAreaHouse = {
	        		xtype:'textfield',
	      	    	fieldLabel: '住宅',
	      	    	name: 'newAreaHouse',
	      	    	regex:/^\d{0,12}\.?\d{0,2}$/,
	      	    	regexText:'最多输入14位数字，且只能有两位小数',
	      	    	allowBlank: false
        	},newAreaBusiness = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'newAreaBusiness'
            },newAreaOffice = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'newAreaOffice'
            },newAreaOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'newAreaOther'
            },completeAreaHouse = {
	        		xtype:'textfield',
	      	    	fieldLabel: '住宅',
	      	    	name: 'completeAreaHouse',
	      	    	regex:/^\d{0,12}\.?\d{0,2}$/,
	      	    	regexText:'最多输入14位数字，且只能有两位小数',
	      	    	allowBlank: false
        	},completeAreaBusiness = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'completeAreaBusiness'
            },completeAreaOffice = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'completeAreaOffice'
            },completeAreaOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'completeAreaOther'
            },saledAreaHouse = {
	        		xtype:'textfield',
	      	    	fieldLabel: '住宅',
	      	    	name: 'saledAreaHouse',
	      	    	regex:/^\d{0,12}\.?\d{0,2}$/,
	      	    	regexText:'最多输入14位数字，且只能有两位小数',
	      	    	allowBlank: false
        	},saledAreaBusiness = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'saledAreaBusiness'
            },saledAreaOffice = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'saledAreaOffice'
            },saledAreaOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'saledAreaOther'
            },incomingHouse = {
	        		xtype:'textfield',
	      	    	fieldLabel: '住宅',
	      	    	name: 'incomingHouse',
	      	    	regex:/^\d{0,12}\.?\d{0,2}$/,
	      	    	regexText:'最多输入14位数字，且只能有两位小数',
	      	    	allowBlank: false
        	},incomingBusiness = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'incomingBusiness'
            },incomingOffice = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'incomingOffice'
            },incomingOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'incomingOther'
            },onsaleAreaHouse = {
	        		xtype:'textfield',
	      	    	fieldLabel: '住宅',
	      	    	name: 'onsaleAreaHouse',
	      	    	regex:/^\d{0,12}\.?\d{0,2}$/,
	      	    	regexText:'最多输入14位数字，且只能有两位小数',
	      	    	allowBlank: false
        	},onsaleAreaBusiness = {
            		xtype:'textfield',
          	    	fieldLabel: '商业营业房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'onsaleAreaBusiness'
            },onsaleAreaOffice = {
            		xtype:'textfield',
          	    	fieldLabel: '办公房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'onsaleAreaOffice'
            },onsaleAreaOther = {
            		xtype:'textfield',
          	    	fieldLabel: '其他房',
          	    	regex:/^\d{0,12}\.?\d{0,2}$/,
          	    	regexText:'最多输入14位数字，且只能有两位小数',
          	    	allowBlank: false,
          	    	name: 'onsaleAreaOther'
            };
            var form = new Ext.form.FormPanel({
				url:'develop/save',
                labelAlign: 'right',
                buttonAlign: 'center',
                bodyStyle: 'padding:5px',
                frame: true,
//                labelWidth: 60,
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
                	id:'area',
                    xtype: 'combo',
                    allowBlank: false,
                    name: 'area',
                    hiddenName:'areaId',
                    fieldLabel: '报送区域',
                    maxlength: 20,
                    store: new Ext.data.Store({
						proxy: new Ext.data.HttpProxy({
							url : 'develop/area'
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
								name: 'areaName'
							}]
						})
                    }),
					mode: 'local',
                    forceSelection: true,
                    valueField: 'id',
                    displayField: 'areaName',
					listeners:{
						"expand":function(combo, store,index){ 
						Ext.getCmp("area").getStore().load();
						} 
					}                    
//                    listeners: {
//                        scope: this,
//                        keypress: function(field, e) {
//                            if (e.getKey() == 13) {
//                                var obj = this.form.getForm().findField("recordYearMonth");
//                                if (obj) obj.focus();
//                            }
//                        } //keypress
//                    }
                },
                {
//                	id:'recordYearMonth',
                    name: 'recordYearMonth',
                    fieldLabel: '报送年月',
                    readOnly:true
                },
                {
                	xtype:'fieldset',
                	title:'完成投资（万元）',
                	collapsible:true,
//                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:investHouse
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:investBusiness
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:investOffice
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:investOther
            	       }
                	],
                	layout:"column"
                },
                {
                	xtype:'fieldset',
                	title:'资金来源总数（万元）',
                	collapsible:true,
//                	height:100,
                	items:
                	[
                		 {
                			 layout:'form',
                			 columnWidth:.5,
                			 items:financialSourcingInland
                		 },
                		 {
                			 layout:'form',
                			 columnWidth:.5,
                			 items:financialSourcingForeign
                		 },
                		 {
                			 layout:'form',
                			 columnWidth:.5,
                			 items:financialSourcingSelf
                		 },
                		 {
                			 layout:'form',
                			 columnWidth:.5,
                			 items:financialSourcingOther
                		 }
                	],
                	layout:"column"
                },
                {
                	xtype:'fieldset',
                	title:'施工面积（㎡）',
                	collapsible:true,
//                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:workingAreaHouse
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:workingAreaBusiness
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:workingAreaOffice
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:workingAreaOther
            	       }
                	],
                	layout:"column"
                },
                {
                	xtype:'fieldset',
                	title:'新开工面积（㎡）',
                	collapsible:true,
//                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:newAreaHouse
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:newAreaBusiness
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:newAreaOffice
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:newAreaOther
            	       }
                	],
                	layout:"column"
                },
                {
                	xtype:'fieldset',
                	title:'竣工面积（㎡）',
                	collapsible:true,
//                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:completeAreaHouse
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:completeAreaBusiness
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:completeAreaOffice
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:completeAreaOther
            	       }
                	],
                	layout:"column"
                },
                {
                	xtype:'fieldset',
                	title:'销售面积（㎡）',
                	collapsible:true,
//                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:saledAreaHouse
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:saledAreaBusiness
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:saledAreaOffice
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:saledAreaOther
            	       }
                	],
                	layout:"column"
                },
                {
                	xtype:'fieldset',
                	title:'销售收入（万元）',
                	collapsible:true,
//                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:incomingHouse
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:incomingBusiness
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:incomingOffice
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:incomingOther
            	       }
                	],
                	layout:"column"
                },
                {
                	xtype:'fieldset',
                	title:'待售面积（㎡）',
                	collapsible:true,
//                	height:100,
                	items:
                	[
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:onsaleAreaHouse
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:onsaleAreaBusiness
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:onsaleAreaOffice
            	       },
            	       {
            	    	   layout:'form',
            	    	   columnWidth:0.5,
            	    	   items:onsaleAreaOther
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
                width: 800,
                height: 550,
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
                    xtype: 'wmdatefield',
                    id: 'queryDate',
                    name: 'queryDate',
                    allowBlank:false,
                    value:App.getPreMonth(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	App.Develop.store.reload({params:{recordYearMonth:document.getElementById("queryDate").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	App.Develop.store.reload({params:{recordYearMonth:document.getElementById("queryDate").value.replace("-","")}});
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
                    header: "记录地区",
                    width: 150,
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
                    width: 250,
                    sortable: true,
                    dataIndex: 'createTime',
                    renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s')
                },
                {
                	header: "修改日期",
                	width: 250,
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
            	recordYearMonth: document.getElementById("queryDate").value.replace("-",""),
            	investHouse:'',
            	investBusiness:'',
            	investOffice:'',
            	investOther:'',
            	financialSourcingInland:'',
            	financialSourcingForeign:'',
            	financialSourcingSelf:'',
            	financialSourcingOther:'',
				workingAreaHouse:'',
				workingAreaBusiness:'',
				workingAreaOffice:'',
				workingAreaOther:'',
				newAreaHouse:'',
				newAreaBusiness:'',
				newAreaOffice:'',
				newAreaOther:'',
				completeAreaHouse:'',
				completeAreaBusiness:'',
				completeAreaOffice:'',
				completeAreaOther:'',
				saledAreaHouse:'',
				saledAreaBusiness:'',
				saledAreaOffice:'',
				saledAreaOther:'',
				incomingHouse:'',
				incomingBusiness:'',
				incomingOffice:'',
				incomingOther:'',
				onsaleAreaHouse:'',
				onsaleAreaBusiness:'',
				onsaleAreaOffice:'',
				onsaleAreaOther:''
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
                	areaId:rec.data.areaId,
                	recordYearMonth:rec.data.recordYearMonth,
                	investHouse:rec.data.investHouse,
                	investBusiness:rec.data.investBusiness,
                	investOffice:rec.data.investOffice,
                	investOther:rec.data.investOther,
                	financialSourcingInland:rec.data.financialSourcingInland,
                	financialSourcingForeign:rec.data.financialSourcingForeign,
                	financialSourcingSelf:rec.data.financialSourcingSelf,
                	financialSourcingOther:rec.data.financialSourcingOther,
                	workingAreaHouse:rec.data.workingAreaHouse,
    				workingAreaBusiness:rec.data.workingAreaBusiness,
    				workingAreaOffice:rec.data.workingAreaOffice,
    				workingAreaOther:rec.data.workingAreaOther,
    				newAreaHouse:rec.data.newAreaHouse,
    				newAreaBusiness:rec.data.newAreaBusiness,
    				newAreaOffice:rec.data.newAreaOffice,
    				newAreaOther:rec.data.newAreaOther,
    				completeAreaHouse:rec.data.completeAreaHouse,
    				completeAreaBusiness:rec.data.completeAreaBusiness,
    				completeAreaOffice:rec.data.completeAreaOffice,
    				completeAreaOther:rec.data.completeAreaOther,
    				saledAreaHouse:rec.data.saledAreaHouse,
    				saledAreaBusiness:rec.data.saledAreaBusiness,
    				saledAreaOffice:rec.data.saledAreaOffice,
    				saledAreaOther:rec.data.saledAreaOther,
    				incomingHouse:rec.data.incomingHouse,
    				incomingBusiness:rec.data.incomingBusiness,
    				incomingOffice:rec.data.incomingOffice,
    				incomingOther:rec.data.incomingOther,
    				onsaleAreaHouse:rec.data.onsaleAreaHouse,
    				onsaleAreaBusiness:rec.data.onsaleAreaBusiness,
    				onsaleAreaOffice:rec.data.onsaleAreaOffice,
    				onsaleAreaOther:rec.data.onsaleAreaOther            
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
                    titles += data.recordYearMonth + data.areaName + '<br>';
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
