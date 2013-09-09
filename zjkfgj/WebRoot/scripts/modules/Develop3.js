App.Develop3 = function() {
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
					url : 'develop/count3?t=' + new Date().getTime()
				}),
                remoteSort: false,
				reader: new Ext.data.JsonReader({
					totalProperty : 'totalCount',
					root : 'rows',
//					idProperty : 'id',
					fields: [
					{
						name: 'id'
					},					         
					{
						name: 'recordMonth'
					},
					{
						name: 'district'
					},
					{
						name: 'sumCount'
					},
					{
						name: 'financialSourcingInlandSum'
					},
					{
						name: 'financialSourcingForeignSum'
					},
					{
						name: 'financialSourcingSelfSum'
					},
					{
						name: 'financialSourcingOtherSum'
					}
					]
				})
            });
            return store;
        },

        createGrid: function(id) {
            var panel = Ext.getCmp(id);
            panel.body.dom.innerHTML = "";
            
            this.grid = new Ext.grid.GridPanel({
            	id:'gridId3',
                loadMask: true,
                title:'张家口市房地产开发企业资金来源情况汇总表',
                tbar: [' ','张家口市',{
                    xtype: 'datefield',
                    id: 'startMonth3',
                    name: 'startMonth3',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                    	scope: this,
                    	select: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonth3").value.replace("-",""),endMonth:document.getElementById("endMonth3").value.replace("-","")}});
                    	},
                    	change: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonth3").value.replace("-",""),endMonth:document.getElementById("endMonth3").value.replace("-","")}});
                    	}
                    }
                },'至',{
                    xtype: 'datefield',
                    id: 'endMonth3',
                    name: 'endMonth3',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	this.store.reload({params:{startMonth:document.getElementById("startMonth3").value.replace("-",""),endMonth:document.getElementById("endMonth3").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	this.store.reload({params:{startMonth:document.getElementById("startMonth3").value.replace("-",""),endMonth:document.getElementById("endMonth3").value.replace("-","")}});
		                }
                    }
                },'房地产开发企业资金来源情况汇总表'
                ],
                store: this.store,
                columns: [
                {
                    header: "序号",
                    width: 50,
                    //sortable: true,
                    dataIndex: 'id'
                },
                {
                    header: "统计日期",
                    width: 160,
                    //sortable: true,
                    dataIndex: 'recordMonth'
                },                
                {
                    header: "县（区）",
                    width: 100,
                    //sortable: true,
                    dataIndex: 'district'
                },
                {
                	header: "小计（万元）",
                	width: 100,
                	//sortable: true,
                	dataIndex: 'sumCount'
                },
                {
                    header: "国内筹款（万元）",
                    width: 120,
                    //sortable: true,
                    dataIndex: 'financialSourcingInlandSum'
                },
                {
                	header: "利用外资（万元）",
                	width: 120,
                	//sortable: true,
                	dataIndex: 'financialSourcingForeignSum'
                },
                {
                	header: "自筹资金（万元）",
                	width: 120,
                	//sortable: true,
                	dataIndex: 'financialSourcingSelfSum'
                },
                {
                	header: "其他资金（万元）",
                	width: 120,
                	//sortable: true,
                	dataIndex: 'financialSourcingOtherSum'
                }],
                bbar:new Ext.Toolbar({
                    buttons: [new Ext.Button({
                        text: '导出到Excel',
                        handler: function() {
                            var vExportContent = Ext.getCmp("gridId3").getExcelXml();
                            if (Ext.isIE6 || Ext.isIE7 || Ext.isIE9 || Ext.isIE8|| Ext.isSafari || Ext.isSafari2 || Ext.isSafari3 || Ext.isSafari4) {
                                var fd=Ext.get('frmDummy');
                                if (!fd) {
                                    fd=Ext.DomHelper.append(Ext.getBody(),{tag:'form',method:'post',id:'frmDummy',action:'exportexcel.jsp', target:'_blank',name:'frmDummy',cls:'x-hidden',cn:[
                                        {tag:'input',name:'exportContent',id:'exportContent',type:'hidden'}
                                    ]},true);
                                }
                                fd.child('#exportContent').set({value:vExportContent});
                                fd.dom.submit();
                            } else {
                                document.location = 'data:application/vnd.ms-excel;base64,'+Base64.encode(vExportContent);
                            }}
                    })]
                })
            });
            
            panel.add(this.grid);
        },

        render: function(id) {
            if (!this.store) {
                this.store = this.getStore();
            };
            this.createGrid(id);
        }
    };
} ();