
var _temp;
/*首页*/
(function() {
  var tab = webapp.workPanel.getActiveTab();
  //console.log(tab);

  var storeParamtes = {};

  var server = {};

  /*搜索*/
  server.search = function() {
    //var searchInput = Ext.getCmp('favorite-search-text');
    //console.log(searchInput);
    //获取不到,不知道为什么
    store.currentPage = 1;
    storeParamtes.query = $('#favorite-search-text-inputEl').val();
    store.load({
      params : Ext.apply({
        page : 1
      }, storeParamtes)
    });
  }
  /*清空*/
  server.clear = function() {
    $('#favorite-search-text-inputEl').val('');
    storeParamtes = {};
    store.currentPage = 1;
    store.proxy.extraParams = {};
    store.load({
      params : {
        page : 1
      }
    });
  }
  server.save = function() {}
  /*打开搜藏*/
  server.open = function() {
    var grid = Ext.getCmp('favorite-grid');
    var selModel = grid.getSelectionModel();
    var isGridSelected = selModel.hasSelection();
    if (!isGridSelected) { //没有被选中      
      _app.alert('请选中后操作');
      return;
    }

    var lstSelRec = selModel.getLastSelected(); //获取最后一个选择的一行的数据 
    //console.log(lstSelRec.data);
    window.open(lstSelRec.get('href'));
  };

  function getUuid(pUuid) {
    var uuid;
    if (Ext.isString(pUuid)) {
      return pUuid;
    }

    var grid = Ext.getCmp('favorite-grid');
    var selModel = grid.getSelectionModel();
    var isGridSelected = selModel.hasSelection();
    if (!isGridSelected) {
      return;
    }

    var lstSelRec = selModel.getLastSelected();
    return lstSelRec.data.uuid;
  }
  /*便捷收藏*/
  server.edit = function(pUuid) {
    //    var grid = Ext.getCmp('favorite-grid');
    //    var selModel = grid.getSelectionModel();
    //    var isGridSelected = selModel.hasSelection();
    //    if (!isGridSelected) { //没有被选中      
    //      _app.alert('请选中一条数据');
    //      return;
    //    }
    //
    //    var lstSelRec = selModel.getLastSelected(); //获取最后一个选择的一行的数据 
    //    console.log(lstSelRec.data);
    var uuid = getUuid(pUuid);
    if (!uuid) {
      _app.alert('请选中一条数据');
      return;
    }

    favoriteWindow.show();

  };

  server.del = function(pUuid) {
    var uuid = getUuid(pUuid);
    if (!uuid) {
      _app.alert('请选中一条数据');
      return;
    }
    _app.confirm('确认删除该条数据?', function() {
      $.ajax({
        url : '/tools/favorite-item/' + uuid + '.html',
        type : 'delete',
        dataType : 'json',
        success : function(data) {
          //console.log(result);
          if (data.result == 'success') {
            _app.alert('删除成功');
            store.load();
          }
        }
      })
    });
  };



  server.upload = function() {

    $('#webapp-input-file')
      .attr('accept', 'text/html')
      .change(function() {
        var callback = _app.callback(function(result, message) {
          _app.alert(message);
        });
        var action = '../tools/favorite-upload.html?callback=' + callback;
        $('#webapp-form-file')
          .attr('action', action)
          .submit();
      })
      .click();
  }

  var toolbar = Ext.create("Ext.toolbar.Toolbar", {
    items : [
      {
        id : 'favorite-search-text',
        xtype : 'textfield', //默认是一个button所以其他都没写  
        emptyText : '输入您的搜索关键词'
      },
      {
        text : '搜索',
        handler : server.search
      },
      {
        text : '清空',
        handler : server.clear
      },
      {
        text : '标签',
        handler : function() {}
      },
      '->', //右对齐
      {
        text : '打开',
        handler : server.open
      },
      {
        text : '编辑',
        handler : server.edit
      },
      {
        text : '删除',
        handler : server.del
      },
      {
        text : '保存',
        handler : server.save
      },
      {
        text : '上传',
        handler : server.upload
      }
    ]
  });

  //定义Model
  var model = Ext.define("WebApp.model.Favorite", {
    extend : "Ext.data.Model",
    fields : [
      {
        name : 'uuid',
        type : 'string'
      },
      {
        name : 'title',
        type : 'string'
      },
      {
        name : 'href',
        type : 'string'
      }
    ]
  });

  var store = Ext.create("Ext.data.Store", {
    model : "WebApp.model.Favorite",
    /*autoLoad : true,*/
    pageSize : 20,
    remoteSort : true,
    proxy : {
      type : "ajax",
      url : "../tools/favorite-list.html",
      reader : {
        type : 'json',
        root : 'list'
      },
    /*
    actionMethods : {
      create : 'POST',
      read : 'POST', // by default GET  
      update : 'POST',
      destroy : 'POST'
    }
    */
    }
  });
  //分页传参
  store.on('beforeload', function(store, options) {
    Ext.apply(store.proxy.extraParams, storeParamtes);
  });

  //列配置
  var columns = [
    {
      text : 'ID',
      dataIndex : 'uuid',
      hideable : true,
      hidden : true
    },
    {
      text : '标题',
      dataIndex : 'title',
      flex : 1,
      editor : {
        xtype : 'textfield',
        selectOnFocus : true
      }
    },
    {
      text : '标签',
      width : 400,
    },
    {
      text : '操作',
      xtype : 'actioncolumn',
      items : [
        {
          icon : '/static/extjs/style/icon/adit.png',
          tooltip : 'Edit',
          handler : function(grid, rowIndex, colIndex) {
            var rec = grid.getStore().getAt(rowIndex);
            var uuid = rec.get('uuid');
            server.edit(uuid);
          }
        }, '', {
          icon : '/static/extjs/style/icon/delete.png',
          tooltip : 'Delete',
          handler : function(grid, rowIndex, colIndex) {
            var rec = grid.getStore().getAt(rowIndex);
            var uuid = rec.get('uuid');
            server.del(uuid);
          }
        }
      ]
    }
  ];

  var favoritePanl = Ext.define('WebApp.tools.favorite', {
    extend : 'Ext.grid.Panel',
    id : 'favorite-grid',
    initComponent : function() {
      Ext.apply(this, {
        columnLines : true,
        scroll : true,
        forceFit : true,
        store : store,
        tbar : toolbar,
        columns : columns,
        plugins : [
          Ext.create('Ext.grid.plugin.CellEditing', {
            clicksToEdit : 1
          })
        ],
        listeners : {
          //双击事件的操作
          itemdblclick : function(me, record, item, index, e, eOpts) {}
        },
        bbar : {
          xtype : "pagingtoolbar",
          store : store,
          displayInfo : true
        }
      });

      store.reload();
      this.callParent(arguments);
    }
  });


  var favoriteWindow = Ext.create('Ext.window.Window', {
    title : '网址编辑',
    height : 400,
    width : 600,
    layout : 'fit',
    closeAction : 'hide',
    items : {
      xtype : '',
      layout : 'form',
      defaults : {
        labelAlign : 'right',
        labelWidth : 120,
        style : {
          padding : '15px'
        }
      },
      items : [
        {
          xtype : 'textfield',
          fieldLabel : '名称'
        },
        {
          xtype : 'textfield',
          fieldLabel : '年龄'
        },
        {
          xtype : 'textfield',
          fieldLabel : '性别'
        }
      ]
    },
    buttonAlign : 'center',
    buttons : [
      {
        text : '保存',
        handler : function() {
          //Ext.Msg.alert('保存', '表单提交');  
        }
      },
      {
        text : '取消',
        handler : function() {
          favoriteWindow.hide();
        //mainForm.getForm().reset();
        //Ext.Msg.alert('取消', '取消按钮');  
        }
      }
    ]
  });

//  var grid = Ext.create("WebApp.tools.favorite");
//  tab.items.add(grid);
//  tab.update();
})();