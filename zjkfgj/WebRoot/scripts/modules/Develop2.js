﻿App.Develop2 = function() {
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
					url : 'develop/count2?t=' + new Date().getTime()
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
						name: 'investHouseSum'
					},
					{
						name: 'investBusinessSum'
					},
					{
						name: 'investOfficeSum'
					},
					{
						name: 'investOtherSum'
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
            	id:'gridId2',
                loadMask: true,
                title:'张家口市房地产开发企业完成投资情况汇总表',
                tbar: [' ','张家口市',{
                    xtype: 'wmdatefield',
                    id: 'startMonth2',
                    name: 'startMonth2',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                    	scope: this,
                    	select: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonth2").value.replace("-",""),endMonth:document.getElementById("endMonth2").value.replace("-","")}});
                    	},
                    	change: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonth2").value.replace("-",""),endMonth:document.getElementById("endMonth2").value.replace("-","")}});
                    	}
                    }
                },'至',{
                    xtype: 'wmdatefield',
                    id: 'endMonth2',
                    name: 'endMonth2',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	this.store.reload({params:{startMonth:document.getElementById("startMonth2").value.replace("-",""),endMonth:document.getElementById("endMonth2").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	this.store.reload({params:{startMonth:document.getElementById("startMonth2").value.replace("-",""),endMonth:document.getElementById("endMonth2").value.replace("-","")}});
		                }
                    }
                },'房地产开发企业完成投资情况汇总表'
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
                    header: "住宅（万元）",
                    width: 100,
                    //sortable: true,
                    dataIndex: 'investHouseSum'
                },
                {
                	header: "商业营业房（万元）",
                	width: 120,
                	//sortable: true,
                	dataIndex: 'investBusinessSum'
                },
                {
                	header: "办公房（万元）",
                	width: 100,
                	//sortable: true,
                	dataIndex: 'investOfficeSum'
                },
                {
                	header: "其他房（万元）",
                	width: 100,
                	//sortable: true,
                	dataIndex: 'investOtherSum'
                }],
                bbar:new Ext.Toolbar({
                    buttons: [new Ext.Button({
                        text: '导出到Excel',
                        handler: function() {
                            var vExportContent = Ext.getCmp("gridId2").getExcelXml();
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