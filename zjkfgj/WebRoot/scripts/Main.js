
Ext.ns('App');

App.initMain = function() {
    Ext.QuickTips.init();
    Ext.form.Field.prototype.msgTarget = 'side';
    Ext.Msg.minWidth = 300;

    App.createViewport();

    setTimeout(function() {
      Ext.get('loading').remove();
      Ext.get('loading-mask').fadeOut({ remove: true });
    }, 250);
};

Ext.onReady(App.initMain);

App.createViewport = function() {
    var viewport = new Ext.Viewport({
        layout: 'border',
        items: [
            App.createNorth(),
            App.createWest(),
            App.createCenter()
        ]
    });
};

App.createNorth = function() {
    return {
        region: 'north',
        height: 28,
        bbar: [
            '<b style="font-size:12px;">欢迎您，<font color=red>'+loginUserName+'</font></b>',
            '->', {
            text: '修改密码',
            scope: this,
            handler: function() {
                if (App.ChangePasswordDialog) {
                    App.ChangePasswordDialog.show();
                }
            }
        }, {
            text: '退出',
            scope: this,
            handler: function() {
                window.location = 'quit.jsp'
            }
        }]
    };
};

App.createWest = function() {
	Ext.Ajax.request({
		method:'post',
		url:'user/menus',
		success: function(resp, opts) {
	        var result = Ext.util.JSON.decode(resp.responseText);
	        if(result.success=='true') {
	            for (var i = 0; i < result.data.length; i++) {
					var item = result.data[i];
					var title = "<div style='background:url(" + item.image
						+ ") no-repeat;padding-left:20px;'>" + item.name + "</div>";
					for (var j = 0; j < item.children.length; j++) {
						var o = item.children[j];
						o.text = o.name;
						o.icon = o.image;
					}
					var node = new Ext.tree.TreePanel({
						title: title,
						rootVisible: false,
						lines: false,
						autoScroll: true,
						qtips: item.qitps,
						root: {
							editable: false,
							expanded: true,
							text: item.name,
							draggable: false,
							children: item.children
						},
						listeners: {
							click: function(node, e) {
								App.mainPanel.openTab(node);
							}
						}
					});
					Ext.getCmp('mainMenu').add(node);
				}
				Ext.getCmp('mainMenu').doLayout();
	        }else {
	            Ext.Msg.alert('提示',respText.info);
	        }
	    },
	    failure: function(resp,opts) {
	        //系统请求出错
	        Ext.Msg.alert('提示', '系统请求错误！'); 
	    }
	});
    return {
        id: 'mainMenu',
        region: 'west',
        layout: 'accordion',
        title: '功能菜单',
        split: true,
        width: 225,
        minSize: 175,
        maxSize: 400,
        collapsible: true,
        margin: '0 0 5 5',
        cmargins: '0 5 5 5',
        lines: false,
        autoScroll: true
    };
};

App.createCenter = function() {
    var mainPanel = new Ext.TabPanel({
        id: 'main-tabs',
        activeTab: 0,
        region: 'center',
        margins: '0 5 5 0',
        resizeTabs: true,
        tabWidth: 150,
        minTabWidth: 120,
        enableTabScroll: true,
        items: [{
            id: 'main-view',
            layout: 'fit',
            title: '欢迎您',
            closable: false,
            hideMode: 'offsets',
            html: "<div style='background-image:url(images/background.jpg);background-repeat: no-repeat;background-attachment: fixed;width:1600px;height:1000px;font:normal small-caps bold 40px/2 Simsun,arial,sans-serif;padding:20 0 0 50;'>张家口市房地产市场数据统计系统</div>"
//            html: "张家口市房地产市场数据统计系统"
        }]
    });

    mainPanel.openTab = function(node) {
        var id = node.attributes.url;
        var newTab = false;
        var tab = this.getItem(id);
        if (!tab) {
            tab = new Ext.Panel({
                id: id,
                title: node.text,
                tabTip: node.text,
                layout: 'fit',
                html: '<img alt="" src="scripts/ext-3.4.0/resources/images/default/shared/large-loading.gif" width="32" height="32" style="margin-right:8px;" align="absmiddle"/>正在加载...',
                closable: true,
                autoScroll: true,
                border: true
            });
            this.add(tab);
            newTab = true;
        }
        this.setActiveTab(tab);

        if (newTab) {
			if (App[id]) {
                App[id].render(id);
                this.doLayout();
            } else {
                Ext.Ajax.request({
                    panelId: id,
                    url: 'scripts/modules/' + id + '.js',
                    success: function(response, opts) {
                        var o = eval(response.responseText);
                        if (o) {
                            App[id].render(opts.panelId);
                            this.doLayout();
                        }
                    },
                    failure: function() {
                        Ext.Msg.alert("错误","加载模块失败！");
                    },
                    scope: this
                });
            }
        }
    };

    App.mainPanel = mainPanel;
    return mainPanel;
};
