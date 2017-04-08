

var _tab;
/*首页*/
(function(){
  var tab = webapp.workPanel.getActiveTab();
  //console.log(tab);
  _tab = tab;
  var panel = Ext.create('Ext.form.FormPanel',{
    title : '管理员登录',
    method : 'POST',
    url : './login.html',
    standardSubmit:true, 
    width : 320,
    height : 260
  });
  tab.items.add(panel);
  
  tab.update();
})();