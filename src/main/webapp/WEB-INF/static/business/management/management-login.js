<!DOCTYPE html>
<html><head><meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>控制台登录页</title>
  <link rel="icon" type="image/png" href="../favicon.ico">
  <link type="text/css" rel="stylesheet"
    href="../static/extjs/style/ext-theme-neptune/ext-theme-neptune-all.css" />
  <style type="text/css">
  </style>
  <script type="text/javascript" src="../static/extjs/ext-all.js"></script>
  <script>
  Ext.onReady(function() {
      function createCenterPanel(){
          var r = Ext.create('Ext.panel.Panel', {
            region : 'center',
            layout: {
            align: 'middle',
            pack: 'center',
            type: 'hbox'
          },
          border : false,
          items : [
            Ext.create('Ext.form.FormPanel',{
                id: 'fp-login',
                title: '管理员登录',
                method: 'POST',
                url: './login.html',
                width: 320,
                height: 260,
                fieldDefaults: {  
                    labelAlign: 'right',  
                    labelWidth: 100,
                    width: 280,  
                    //anchor: '100%', 
                    //错误提示显示在下方，还可以配置为side、title、none  
                    msgTarget: 'under'  
                },  
                items : [
                    {
                        id: 'inp-user',
                        name: 'uname',
                        xtype: 'textfield',
                        fieldLabel: '用户名',
                        padding: 15,
                        margin: '80 0 0 0'
                    },
                    {
                        id: 'inp-pwd',
                        name: 'upwd',
                        xtype: 'textfield',
                        inputType: 'password',
                        fieldLabel: '密 码',
                        padding: 15
                    }
                ],
                buttonAlign: 'center',
                buttons : [
                  {
                    xtype: 'button',
                    text: '登录',
                    handler: function(){
                    	
                    }
                  }
                ]
            })
          ]
          });
          
          return r;
      }
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
  });
  </script>
</head>
<body></body></html>