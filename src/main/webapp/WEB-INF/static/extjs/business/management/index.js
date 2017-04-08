
/*业务逻辑处理*/
var _server = (function() {
  //私有作用域
  var tabInitFuncMap = {};
  
  var r = {}
  
  r.registerFunc = function(func){
    
  };
  //处理菜单选中
  r.handleMeunSelected = function(menu) {
    //console.log(menu,menu.id);
    var data = _store.getMenuById(menu.id);
    //console.log(data);
    if (!data || !data.url) {
      return;
    }
    //新建页面
    if (data.url.startsWith("http")) {
      window.open(data.url);
      return;
    }
    
    

    //webapp.workPanel.getActiveTab()
    var tabPanel = webapp.workPanel;
    var tab = tabPanel.getComponent(data.id);
    if(tab){
      //激活
      webapp.workPanel.setActiveTab(tab);   
      return;
    } else {
      //新建
      var closable = webapp.workPanel.items.length == 0 ? false : true;
      tab = webapp.workPanel.add({
        id: data.id,
        itemId: data.id,
        title : data.text,
        closable : closable,
        /*bodyStyle : "background-color: #CCC;"*/
        html: '<iframe src="/ext/examples/calendar/index.html" style="height:100%; width:100%;" frameborder="no" border="0" marginwidth="0" marginheight="0" ></iframe>',
        layout:'fit',
      });
      webapp.workPanel.setActiveTab(tab);
    }
    
    return;
    //通过url 获取js路径
    var element = (function(url) {
      var index = url.lastIndexOf('.');
      if (index == -1) {
        return;
      }
      return 'WebApp' + url.substring(0, index).replace(/\//g,'.');
    })(data.url)

    if (!element) {
      return;
    }
    //console.log(js);
//    var func = tabInitFuncMap[element]; 
//    if(func){
//      func();
//      return;
//    }
    //加载js
    Ext.Loader.setConfig({disableCaching: false});
    Ext.Loader.setPath('WebApp','/static/extjs/business');
    Ext.require(element);
    if(closable){
      var panel = Ext.create(element);
      tab.items.add(panel);
      tab.update();
    }
  }
  return r;
})();

/*业务数据*/
var _store = (function() {
  var menuArray = [
    {
      id : '010000',
      text : "首页",
      url : '/management/home.html',
      parent : '_root'
    },
    {
      id : '020000',
      text : '工具',
      parent : '_root'
    },
    {
      id : '020100',
      text : '收藏夹',
      url : '/tools/favorite.html',
      parent : '020000'
    },
    {
      id : '020200',
      text : '记事本',
      url : 'http://www.baidu.com',
      parent : '020000'
    },
    {
      id : '030000',
      text : "拓者",
      parent : '_root'
    },
    {
      id : '030100',
      text : '设计师',
      url : '/tools/.html',
      parent : '030000'
    },
    {
      id : '030200',
      text : '案例',
      url : '/tools/.html',
      parent : '030000'
    },
    {
      id : '030300',
      text : '单独页',
      url : '/tools/.html',
      parent : '030000'
    }

  ];
  var menuMap = {};
  var menuChildren = [];

  //初始化 菜单信息
  (function(array, map, children) {
    var preItem;
    //初始化map
    for (var i = 0; i < array.length; i++) {
      var item = array[i];
      var key = item.id;
      map[key] = item;
    }

    //初始化children
    for (var i = 0; i < array.length; i++) {
      var item = array[i];
      item.leaf = true;
      var parentId = item.parent;
      var parentItem = map[parentId];
      //没有父元素
      if (!parentItem) {
        children.push(item);
      } else {
        var c = parentItem.children;
        if (!c) {
          c = parentItem.children = [];
        }
        c.push(item);
        parentItem.leaf = false;
      }
    }
  })(menuArray, menuMap, menuChildren);
  //console.log(menuArray,menuMap,menuChildren);

  var menu = Ext.create('Ext.data.TreeStore', {
    root : {
      expanded : true,
      children : menuChildren
    }
  });

  var r = {};
  r['menu'] = menu;
  r.getMenuById = function(id) {
    return menuMap[id];
  }

  return r;
})();


/* 菜单 */
Ext.define('WebApp.MenuPanel', {
  extend : 'Ext.panel.Panel',
  layout : 'fit',
  initComponent : function() {
    Ext.apply(this, {
      items : [
        this.createMenu()
      ]
    });
    this.callParent(arguments);
  },
  //创建panel
  createMenu : function() {
    var tbar = Ext.create("Ext.toolbar.Toolbar", {
      items : [ {
        text : '全部展开',
        handler : function() {
          treePanel.expandAll();
        }
      },
        {
          text : '全部收起',
          handler : function() {
            //选中某个
            //var node = treePanel.getStore().getNodeById('home');
            //treePanel.getSelectionModel().select(node);
            //获取选中
            //var selectedNode = treePanel.getSelectionModel().getLastSelected(); 
            //console.log(selectedNode.data);
            //获取选中
            //var selectedNodes = treePanel.getView().getSelectionModel().getSelection();
            //console.log(selectedNodes[0]);
            treePanel.collapseAll();
          }
        }, {
          text : '测试',
          handler : function() {
            _test();
          }
        } ]
    });

    var treePanel = this.treePanel = Ext.create('Ext.tree.Panel', {
      id : 'panel-tree',
      rootVisible : false,
      multiSelect : false,
      tbar : tbar,
      store : _store.menu,
      listeners : {
        /*
        //点击事件
        click : {
          element : 'el',
          fn : function(event, from, target) {
            console.log(event, from, target);
          }
        }//*/
        //*
        //程序设置选中不触发
        itemclick : {
          fn : function(view, record, item, index, event) {
            //console.log(record.data);
            _server.handleMeunSelected(record.data);
          }
        } //*/

      }
    });
    this.tree = treePanel;
    return treePanel;
  }
});
/*信息面板*/
Ext.define('WebApp.InfoPanel', {
  extend : 'Ext.panel.Panel',
  layout : {
    type : 'vbox', // 子元素垂直布局
    align : 'stretch', // 每个子元素宽度充满子容器
    padding : 5
  },
  initComponent : function() {
    Ext.apply(this, {
      items : [
        {
          id : 'text-search',
          xtype : 'textfield',
          fieldLabel : '描述'
        },
        {
          xtype : 'button',
          text : '搜索',
          width : 120,
          handler : function() {
            var text = Ext.getCmp('text-search').getValue();
            //Ext.MessageBox.alert('内容', text);
            Ext.getCmp('panel-info').body.update(text);
          }
        },
        {
          id : 'panel-info',
          xtype : 'panel',
          height : 200,
          margins : '5 0 5 0',
          html : 'test'
        }
      ]
    });
    this.callParent(arguments);
  }
});


/*webapp 布局容器*/
Ext.define('WebApp.Main', {
  extend : 'Ext.container.Viewport',
  /*初始化*/
  initComponent : function() {
    Ext.apply(this, {
      defaults : {
        /* frame : true, */
        bodyStyle : "background-color: #FFFFFF;"
      },
      layout : {
        type : 'border',
        padding : 5
      },
      items : [
        {
          region : "north",
          height : 100,
          html : '<h1 class="x-panel-header">Page Title</h1>',
          margins : '0 0 5 0',
          border : false
        },
        this.createMenuPanel({
          id : 'comp-menu'
        }),
        this.createInfoPanel({
          id : 'comp-info'
        }),
        this.createWorkPanel({
          id : 'comp-work'
        })
      ],
      listeners: {  
        'afterrender': function() {
          //var treePanel = webapp.menuPanel.tree; 
          //var root = treePanel.getRootNode();
          //treePanel.getSelectionModel().select(root.firstChild);
        }  
      } 
    });
    this.callParent(arguments);
  },
  /* 创建菜单 */
  createMenuPanel : function(pSetting) {
    var setting = {
      region : 'west',
      width : 260,
      title : '菜单',
      collapsible : true,
      minWidth : 260
    };
    if (pSetting && Ext.isObject(pSetting)) {
      for (var key in pSetting) {
        setting[key] = pSetting[key];
      }
    }
    this.menuPanel = Ext.create('WebApp.MenuPanel', setting);

    return this.menuPanel;
  },
  /* 信息面板 */
  createInfoPanel : function(pSetting) {
    var setting = {
      region : 'east',
      width : 260,
      title : '描述',
      collapsible : true,
      minWidth : 260,
      collapsed : true
    };
    if (pSetting && Ext.isObject(pSetting)) {
      for (var key in pSetting) {
        setting[key] = pSetting[key];
      }
    }
    this.infoPanel = Ext.create('WebApp.InfoPanel', setting);
    return this.infoPanel;
  },
  /* 工作区 */
  createWorkPanel : function(pSetting) {
    var setting = {
      region : 'center',
      split : true,
      border : true,
      height: '100%',  
      width: '100%',
      /*bodyStyle : "background-color: #CCC;",*/
      layout:'fit',
      /*layout : {
        
      },*/
      margins : '0 5 0 5',
      minTabWidth : 100,
      closeAction : 'hide',
      items : []
    };
    if (pSetting && Ext.isObject(pSetting)) {
      for (var key in pSetting) {
        setting[key] = pSetting[key];
      }
    }
    this.workPanel = Ext.create('Ext.tab.Panel', setting);
    return this.workPanel;
  }
});


function _test() {
}