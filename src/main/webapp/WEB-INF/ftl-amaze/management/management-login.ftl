<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Login Page | Amaze UI Example</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="../static/favicon.png">
  <link rel="stylesheet" href="../assets/css/amazeui.min.css"/>
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1>淘宝客</h1>
    <p>Integrated Development Environment<br/>2017-3-13</p>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>登录</h3>
    <hr>
    <div class="am-btn-group">
    </div>

    <form id="form_login" method="post" class="am-form">
      <label for="u_name">用户名:</label>
      <input type="text" name="u_name" id="u_name" value="songyu">
      <br>
      <label for="u_pwd_temp">密码:</label>
      <input type="password" id="u_pwd_temp" value="1224@qq.com">
      <br>
      
      <input type="hidden" name="u_pwd" id="u_pwd" />
      <input type="hidden" name="salt" id="salt" /> 
      <label for="remember-me">
      	<!--
        <input id="remember-me" type="checkbox">
        	记住密码
        -->
  	  </label>
      
      <br />
      <div class="am-cf">
        <input type="button" value="登 录" onclick="mySubmit()" 
        	class="am-btn am-btn-primary am-btn-sm am-fl">
        <!--
        <input type="submit" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
        -->
      </div>
    </form>
    <hr>
    <p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
  </div>
</div>
<script src="../static/assets/js/kits/md5.js"></script>
<script type="text/javascript">
<#if message??>
alert('${message}');
</#if>
function g(id){
	return document.getElementById(id);
}

function mySubmit(){
	var pwd = g('u_pwd_temp').value;
	g('u_pwd').value = MD5(pwd);
	g('form_login').submit();
}
</script>
</body>
</html>
