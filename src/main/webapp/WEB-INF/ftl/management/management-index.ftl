<!DOCTYPE html>
<html><head><meta name="content-type" content="text/html; charset=UTF-8">
<title>控制台-首页</title>
  <link rel="icon" type="image/png" href="../favicon.ico">
  <link type="text/css" rel="stylesheet"
    href="../static/extjs/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
  <style type="text/css">
  </style>
  <script type="text/javascript" src="../static/assets/js/jquery.min.js"></script>
  <script type="text/javascript" src="../static/webapp.js"></script>
  <script type="text/javascript" src="../static/extjs/ext-all.js"></script>
  <script type="text/javascript" src="../static/extjs/ext-lang-zh_CN.js"></script>
  <script type="text/javascript" src="../static/extjs/business/management/index.js"></script>
  <script type="text/javascript">
    var webapp = null; 
	Ext.onReady(function() {
		webapp = new WebApp.Main();
		//return;
		var treePanel = webapp.menuPanel.tree; 
        var root = treePanel.getRootNode();
        treePanel.getSelectionModel().select(root.firstChild);
        _server.handleMeunSelected(root.firstChild.data);
	});
  </script>
</head>
<body>
<div style="display:none;">
	<!-- file form -->
	<form id="webapp-form-file" method="POST" enctype="multipart/form-data" 
		target="webapp-iframe">
		<input id="webapp-input-file" type="file" name="file" />
	</form>
	<!-- iframe -->
	<iframe  name="webapp-iframe" id="webapp-iframe" style="display:none;"></iframe >
	<div id="webapp-div-comm">
	</div>
</div>
</body>
</html>
