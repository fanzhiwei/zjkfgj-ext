App.StatisticsDev1 = function() {
    return {

        currentFormValues: {},

        getStore: function() {
            var store = new Ext.data.Store({
                autoLoad: {
					params : {}
//            		params : {start:0, limit:15,recordYearMonth:queryDate}
				},
				proxy: new Ext.data.HttpProxy({
					url : 'statistics/dev1?t=' + new Date().getTime()
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
            	id:'gridIdS1',
                loadMask: true,
                title:'开发商报送情况统计',
                tbar: [{
                    xtype: 'datefield',
                    id: 'dev1',
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
                        	App.StatisticsDev1.store.reload({params:{recordYearMonth:document.getElementById("dev1").value.replace("-","")}});
                        },
		                change: function(obj, date) {
		                	App.StatisticsDev1.store.reload({params:{recordYearMonth:document.getElementById("dev1").value.replace("-","")}});
		                }
                    }
                }],
                
                store: this.store,
                sm: sm,
                columns: [sm, {
                    header: "编号",
                    width: 40,
                    sortable: true,
                    dataIndex: 'id',
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
                }],
	            bbar:new Ext.Toolbar({
	                buttons: [new Ext.Button({
	                    text: '导出到Excel',
	                    handler: function() {
	                        var vExportContent = Ext.getCmp("gridIdS1").getExcelXml();
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
            }
            this.createGrid(id);
        }
    };
} ();
