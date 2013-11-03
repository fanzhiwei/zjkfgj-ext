App.DistrictCount3 = function() {
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
					url : 'district/count3?t=' + new Date().getTime()
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
						name: 'totalNumber'
					},
					{
						name: 'totalArea'
					},
					{
						name: 'firstNumberSum'
					},
					{
						name: 'firstAreaSum'
					},
					{
						name: 'secondNumberSum'
					},
					{
						name: 'secondAreaSum'
					},
					{
						name: 'threeNumberSum'
					},
					{
						name: 'threeAreaSum'
					},
					{
						name: 'fourNumberSum'
					},
					{
						name: 'fourAreaSum'
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
            	id:'gridIdD3',
                loadMask: true,
                title:'张家口市登记在册私有住宅汇总表',
                tbar: [' ','张家口市',{
                    xtype: 'datefield',
                    id: 'startMonthD3',
                    name: 'startMonthD3',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                    	scope: this,
                    	select: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonthD3").value.replace("-",""),endMonth:document.getElementById("endMonthD3").value.replace("-","")}});
                    	},
                    	change: function(obj, date) {
                    		this.store.reload({params:{startMonth:document.getElementById("startMonthD3").value.replace("-",""),endMonth:document.getElementById("endMonthD3").value.replace("-","")}});
                    	}
                    }
                },'至',{
                    xtype: 'datefield',
                    id: 'endMonthD3',
                    name: 'endMonthD3',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                    listeners: {
                        scope: this,
                        select: function(obj, date) {
                        	this.store.reload({params:{startMonth:document.getElementById("startMonthD3").value.replace("-",""),endMonth:document.getElementById("endMonthD3").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	this.store.reload({params:{startMonth:document.getElementById("startMonthD3").value.replace("-",""),endMonth:document.getElementById("endMonthD3").value.replace("-","")}});
		                }
                    }
                },'登记在册私有住宅汇总表'
                ],
                store: this.store,
                colModel: new Ext.grid.ColumnModel({
    				columns: [
    					{header: '序号', width: 50, dataIndex: 'id'},
    					{header: '统计日期', width: 140, dataIndex: 'recordMonth'},
    					{header: '县（区）', width: 80, dataIndex: 'district'},
    					{header: '总套数', width: 85, dataIndex: 'totalNumber'},
    					{header: '总面积（万㎡）', width: 120, dataIndex: 'totalArea'},
    					{header: '套数', width: 80, dataIndex: 'firstNumberSum'},
    					{header: '面积（万㎡）', width: 110, dataIndex: 'firstAreaSum'},
    					{header: '套数', width: 80, dataIndex: 'secondNumberSum'},
    					{header: '面积（万㎡）', width: 110, dataIndex: 'secondAreaSum'},
    					{header: '套数', width: 80, dataIndex: 'threeNumberSum'},
    					{header: '面积（万㎡）', width: 110, dataIndex: 'threeAreaSum'},
    					{header: '套数', width: 80, dataIndex: 'fourNumberSum'},
    					{header: '面积（万㎡）', width: 110, dataIndex: 'fourAreaSum'}
    				],
    				defaultSortable: false,
    				rows: [
    					[
    						{},{},{},{},{},
    						{header: '1990年之前', colspan: 2, align: 'center'},
    						{header: '1991年-2000年', colspan: 2, align: 'center'},
    						{header: '2001年-2010年', colspan: 2, align: 'center'},
    						{header: '2011年—本年本月', colspan: 2, align: 'center'}
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
                        	window.location.href = "district/exportDengJiZaiCe?startMonth=" + document.getElementById("startMonthD2").value.replace("-","") + "&endMonth=" + document.getElementById("endMonthD2").value.replace("-","");
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