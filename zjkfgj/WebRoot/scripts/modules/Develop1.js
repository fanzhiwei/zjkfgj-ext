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
					idProperty : 'id',
					fields: [{
						name: 'id',
						type: 'int'
					},
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
						name: 'sum'
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
                    id: 'startMonth',
                    name: 'startMonth',
                    allowBlank:false,
                    value:new Date(),
                    invalidText:"您输入的日期无效，必须符合yyyy-mm格式",
                    fieldLabel: '查询日期',
                    maxlength: 20,
                    format: 'Y-m',
                },{
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
                        	App.Develop1.store.reload({params:{startMonth:document.getElementById("startMonth").value.replace("-",""),endMonth:document.getElementById("endMonth").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	App.Develop1.store.reload({params:{startMonth:document.getElementById("startMonth").value.replace("-",""),endMonth:document.getElementById("endMonth").value.replace("-","")}});
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

        render: function(id) {
            if (!this.store) {
                this.store = this.getStore();
            };
            this.createGrid(id);
        }
    };
} ();
