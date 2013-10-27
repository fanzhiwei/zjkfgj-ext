App.StatisticsDis2 = function() {
    return {

        currentFormValues: {},

        getStore: function() {
            var store = new Ext.data.Store({
                autoLoad: {
					params : {}
//            		params : {start:0, limit:15,recordYearMonth:queryDate}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'statistics/dis2_5?category=1&t=' + new Date().getTime()
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
						name: 'userName'
					},
					{
						name: 'recordFlag'
					}
					]
				})
            });
            return store;
        },

        createGrid: function(id) {
            var panel = Ext.getCmp(id);

            panel.body.dom.innerHTML = "";

            var sm = new Ext.grid.CheckboxSelectionModel();
            this.grid = new Ext.grid.GridPanel({
                loadMask: true,
                tbar: [{
                    xtype: 'datefield',
                    id: 'dis2',
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
                        	App.StatisticsDis2.store.reload({params:{recordYearMonth:document.getElementById("dis2").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	App.StatisticsDis2.store.reload({params:{recordYearMonth:document.getElementById("dis2").value.replace("-","")}});
		                }
                    }
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
                    	return start + rowIndex;
                    }//自动编号
                },
                {
                    header: "用户名称",
                    width: 200,
                    sortable: false,
                    dataIndex: 'userName'
                },
                {
                	header: "填写情况",
                	width: 100,
                	sortable: false,
                	dataIndex: 'recordFlag'
                }]
            });
            panel.add(this.grid);
        },

        render: function(id) {
            if (!this.store) {
                this.store = this.getStore();
            }
            this.createGrid(id);
        }
    };
} ();
