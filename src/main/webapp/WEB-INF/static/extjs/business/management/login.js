Ext.onReady(function() {
  //创建登录panel
  function createLoginPanel() {
    var r = Ext.create('Ext.form.FormPanel', {
      id : 'fp-login',
      title : '管理员登录',
      method : 'POST',
      url : './login.html',
      standardSubmit : true,
      width : 320,
      height : 260,
      fieldDefaults : {
        labelAlign : 'right',
        labelWidth : 100,
        width : 280,
        //anchor: '100%', 
        //错误提示显示在下方，还可以配置为side、title、none  
        msgTarget : 'under'
      },
      items : [
        {
          id : 'inp-user',
          name : 'u_name',
          xtype : 'textfield',
          fieldLabel : '用户名',
          padding : 15,
          value : 'songyu',
          margin : '80 0 0 0'
        },
        {
          id : 'inp-pwd',
          xtype : 'textfield',
          inputType : 'password',
          fieldLabel : '密 码',
          value : '1224@qq.com',
          padding : 15
        },
        {
          id : 'inp-pwd-real',
          name : 'u_pwd',
          xtype : 'textfield',
          hidden : true,
          padding : 15
        },
        {
          name : 'salt',
          xtype : 'textfield',
          hidden : true,
          padding : 15
        }

      ],
      buttonAlign : 'center',
      buttons : [
        {
          xtype : 'button',
          text : '登录',
          handler : function() {
            //console.log(r.form.submit);
            r.form.submit();
          }
        }
      ]
    });

    return r;
  }

  //创建center panel
  function createCenterPanel() {
    var r = Ext.create('Ext.panel.Panel', {
      region : 'center',
      layout : {
        align : 'middle',
        pack : 'center',
        type : 'hbox'
      },
      border : false,
      items : [
        createLoginPanel()
      ]
    });

    return r;
  }

  //初始化viewport
  var panel = Ext.create('Ext.container.Viewport', {
    defaults : {
      bodyStyle : 'background-color: #CCCCCC;'
    },
    layout : {
      type : 'border',
      padding : 6
    },
    items : [
      createCenterPanel()
    ]
  });

  //提示信息
  var message = _app.html('div-massage');
  if (message) {
    _app.alert(message);
  }
});