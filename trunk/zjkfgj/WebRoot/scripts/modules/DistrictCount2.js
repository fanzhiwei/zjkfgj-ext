App.DistrictCount2 = function() {
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
					url : 'district/count2?t=' + new Date().getTime()
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
						name: 'houseNumberSum1'
					},
					{
						name: 'areaSum1'
					},
					{
						name: 'totalPriceSum1'
					},
					{
						name: 'averagePriceSum1'
					},
					{
						name: 'houseNumberSum2'
					},
					{
						name: 'areaSum2'
					},
					{
						name: 'totalPriceSum2'
					},
					{
						name: 'averagePriceSum2'
					},
					{
						name: 'houseNumberSum3'
					},
					{
						name: 'areaSum3'
					},
					{
						name: 'totalPriceSum3'
					},
					{
						name: 'averagePriceSum3'
					},
					{
						name: 'houseNumberSum4'
					},
					{
						name: 'areaSum4'
					},
					{
						name: 'totalPriceSum4'
					},
					{
						name: 'averagePriceSum4'
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
            	id:'gridIdD2',
                loadMask: true,
                title:'张家口市商品房销售情况汇总表',
                tbar: [' ','张家口市',{
                    xtype: 'datefield',
                    id: 'startMonthD2',
                    name: 'startMonthD2',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                    	scope: this,
                    	select: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonthD2").value.replace("-",""),endMonth:document.getElementById("endMonthD2").value.replace("-","")}});
                    	},
                    	change: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonthD2").value.replace("-",""),endMonth:document.getElementById("endMonthD2").value.replace("-","")}});
                    	}
                    }
                },'至',{
                    xtype: 'datefield',
                    id: 'endMonthD2',
                    name: 'endMonthD2',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	this.store.reload({params:{startMonth:document.getElementById("startMonthD2").value.replace("-",""),endMonth:document.getElementById("endMonthD2").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	this.store.reload({params:{startMonth:document.getElementById("startMonthD2").value.replace("-",""),endMonth:document.getElementById("endMonthD2").value.replace("-","")}});
		                }
                    }
                },'商品房销售情况汇总表'
                ],
                store: this.store,
                colModel: new Ext.grid.ColumnModel({
    				columns: [
    					{header: '序号', width: 40, dataIndex: 'id'},
    					{header: '统计日期', width: 80, dataIndex: 'recordMonth', align: 'center'},
    					{header: '县（区）', width: 80, dataIndex: 'district', align: 'center'},
    					{header: '套数', width: 60, dataIndex: 'houseNumberSum1', align: 'center'},
    					{header: '面积(㎡)', width: 70, dataIndex: 'areaSum1', align: 'center'},
    					{header: '合同总价（万元）', width: 110, dataIndex: 'totalPriceSum1', align: 'center'},
    					{header: '平均价（元）', width: 100, dataIndex: 'averagePriceSum1', align: 'center'},
    					{header: '套数', width: 60, dataIndex: 'houseNumberSum2', align: 'center'},
    					{header: '面积(㎡)', width: 70, dataIndex: 'areaSum2', align: 'center'},
    					{header: '合同总价（万元）', width: 110, dataIndex: 'totalPriceSum2', align: 'center'},
    					{header: '平均价（元）', width: 100, dataIndex: 'averagePriceSum2', align: 'center'},
    					{header: '套数', width: 60, dataIndex: 'houseNumberSum3', align: 'center'},
    					{header: '面积(㎡)', width: 70, dataIndex: 'areaSum3', align: 'center'},
    					{header: '合同总价（万元）', width: 110, dataIndex: 'totalPriceSum3', align: 'center'},
    					{header: '平均价（元）', width: 100, dataIndex: 'averagePriceSum3', align: 'center'},
    					{header: '套数', width: 60, dataIndex: 'houseNumberSum4', align: 'center'},
    					{header: '面积(㎡)', width: 70, dataIndex: 'areaSum4', align: 'center'},
    					{header: '合同总价（万元）', width: 110, dataIndex: 'totalPriceSum4', align: 'center'},
    					{header: '平均价（元）', width: 100, dataIndex: 'averagePriceSum4', align: 'center'}
    				],
    				defaultSortable: false,
    				rows: [
    					[
    						{},{},{},
    						{header: '商品住房', colspan: 4, align: 'center'},
    						{header: '商业营业房', colspan: 4, align: 'center'},
    						{header: '办公房', colspan: 4, align: 'center'},
    						{header: '其他房', colspan: 4, align: 'center'}
    					]
    				]
    			}),
    			enableColumnMove: false,
    			enableColumnHide: false,
    			viewConfig: {
//    				forceFit: true
    			},
    			plugins: [new Ext.ux.plugins.GroupHeaderGrid()],                
                
                bbar:new Ext.Toolbar({
                    buttons: [new Ext.Button({
                        text: '导出到Excel',
                        handler: function() {
//                        	var params = {startMonth:document.getElementById("startMonthD2").value.replace("-",""),endMonth:document.getElementById("endMonthD2").value.replace("-","")};
//                		    $.post("district/exportCount2",params,
//                		    function(data){
//                			   //donothing
//                		    },"json");//这里返回的类型有：json,html,xml,text
                        	window.location.href = "district/exportShangPinXiaoShou?startMonth=" + document.getElementById("startMonthD2").value.replace("-","") + "&endMonth=" + document.getElementById("endMonthD2").value.replace("-","");
                        }
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