App.DistrictCount1 = function() {
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
					url : 'district/count1?t=' + new Date().getTime()
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
						name: 'licenceSum'
					},
					{
						name: 'houseNumberSum'
					},
					{
						name: 'houseAreaSum'
					},
					{
						name: 'businessSum'
					},
					{
						name: 'officeSum'
					},
					{
						name: 'otherSum'
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
            	id:'gridIdD1',
                loadMask: true,
                title:'张家口市颁发商品房预售许可证情况汇总表',
                tbar: [' ','张家口市',{
                    xtype: 'wmdatefield',
                    id: 'startMonthD1',
                    name: 'startMonthD1',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                    	scope: this,
                    	select: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonthD1").value.replace("-",""),endMonth:document.getElementById("endMonthD1").value.replace("-","")}});
                    	},
                    	change: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonthD1").value.replace("-",""),endMonth:document.getElementById("endMonthD1").value.replace("-","")}});
                    	}
                    }
                },'至',{
                    xtype: 'wmdatefield',
                    id: 'endMonthD1',
                    name: 'endMonthD1',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	this.store.reload({params:{startMonth:document.getElementById("startMonthD1").value.replace("-",""),endMonth:document.getElementById("endMonthD1").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	this.store.reload({params:{startMonth:document.getElementById("startMonthD1").value.replace("-",""),endMonth:document.getElementById("endMonthD1").value.replace("-","")}});
		                }
                    }
                },'颁发商品房预售许可证情况汇总表'
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
                	header: "预售许可证份数",
                	width: 100,
                	//sortable: true,
                	dataIndex: 'licenceSum'
                },
                {
                    header: "住宅套数",
                    width: 100,
                    //sortable: true,
                    dataIndex: 'houseNumberSum'
                },
                {
                	header: "住宅面积(㎡)",
                	width: 100,
                	//sortable: true,
                	dataIndex: 'houseAreaSum'
                },
                {
                	header: "商业营业  房  (㎡)",
                	width: 120,
                	//sortable: true,
                	dataIndex: 'businessSum'
                },
                {
                	header: "办公房(㎡)",
                	width: 100,
                	//sortable: true,
                	dataIndex: 'officeSum'
                },
                {
                	header: "其他房(㎡)",
                	width: 100,
                	//sortable: true,
                	dataIndex: 'otherSum'
                }],
                bbar:new Ext.Toolbar({
                    buttons: [new Ext.Button({
                        text: '导出到Excel',
                        handler: function() {
                            var vExportContent = Ext.getCmp("gridIdD1").getExcelXml();
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