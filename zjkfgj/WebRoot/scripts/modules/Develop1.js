App.Develop1 = function() {
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
					url : 'develop/count1?t=' + new Date().getTime()
				}),
                remoteSort: false,
				reader: new Ext.data.JsonReader({
					totalProperty : 'totalCount',
					root : 'rows',
//					idProperty : 'id',
					fields: [
					{
						name: 'recordMonth'
					},
					{
						name: 'subject'
					},
					{
						name: 'subTotal'
					},
					{
						name: 'catagory'
					},
					{
						name: 'sum',
						type: 'float'
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
            	id:'gridId',
                loadMask: true,
                title:'张家口市房地产开发企业开发情况汇总表',
                tbar: [' ','张家口市',{
                    xtype: 'datefield',
                    id: 'startMonth',
                    name: 'startMonth',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                    	scope: this,
                    	select: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonth").value.replace("-",""),endMonth:document.getElementById("endMonth").value.replace("-","")}});
                    	},
                    	change: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonth").value.replace("-",""),endMonth:document.getElementById("endMonth").value.replace("-","")}});
                    	}
                    }
                },'至',{
                    xtype: 'datefield',
                    id: 'endMonth',
                    name: 'endMonth',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	this.store.reload({params:{startMonth:document.getElementById("startMonth").value.replace("-",""),endMonth:document.getElementById("endMonth").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	this.store.reload({params:{startMonth:document.getElementById("startMonth").value.replace("-",""),endMonth:document.getElementById("endMonth").value.replace("-","")}});
		                }
                    }
                },'房地产开发企业开发情况汇总表'
                ],
                store: this.store,
                columns: [
                {
                    header: "统计日期",
                    width: 200,
                    sortable: true,
                    dataIndex: 'recordMonth'
                },
                {
                    header: "科  目",
                    width: 200,
                    sortable: true,
                    dataIndex: 'subject'
                },
                {
                	header: "小计",
                	width: 100,
                	sortable: true,
                	dataIndex: 'subTotal'
                },
                {
                    header: "分类",
                    width: 150,
                    sortable: true,
                    dataIndex: 'catagory'
                },
                {
                	header: "累计",
                	width: 100,
                	sortable: true,
                	dataIndex: 'sum'
                }],
                bbar:new Ext.Toolbar({
                    buttons: [new Ext.Button({
                        text: '导出到Excel',
                        handler: function() {
                            var vExportContent = Ext.getCmp("gridId").getExcelXml();
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