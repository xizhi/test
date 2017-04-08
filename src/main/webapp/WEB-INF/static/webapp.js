

/**
 * webapp api 
 */
(function(globe) {
  '';
  var app = globe['_app'] = {};

  function devLog(message) {
    console.error('开发时异常', message);
  }

  var $id = function(id) {
    return document.getElementById(id);
  };


  app.uuid = function() {}

  var gid = 0;
  app.gid = function() {
    return ++gid;
  }

  app.callback = function(func) {
    var funcName = '_callbackFunc' + app.gid();
    globe[funcName] = function() {
      delete globe[funcName];
      func.apply(null, arsguments);
    }
    return funcName;
  }

  app.extends = $.extend;
  app.ajax = $.ajax;

  app.ajaxDel = function(pSetting) {}

  app.ajaxUpdate = function() {}

  app.ajaxQuery = function() {}

  /*提示api*/
  app.alert = function(message, handler) {}

  app.confirm = function(message, yesHandler, noHandler) {};

  /*获取或设置文本*/
  app.text = function(id, text) {
    var el = $id(id);
    if (el) {
      return el.innerText;
    } else {
      devLog('id "' + id + '" not found!');
    }
  }

  /*获取或设置 html 内容*/
  app.html = function(id, html) {
    var el = $id(id);
    if (el) {
      if (html) {
        el.innerHTML = html;
      } else {
        return el.innerHTML;
      }
    } else {
      devLog('id "' + id + '" not found!');
    }
  }

  /*获取或设置value*/
  app.val = function(id, val) {}


})(window);


/*
 * extjs extends
 */
(function(globe) {
  var app = globe['_app'];

  function devLog(message) {
    console.error('开发时异常', message);
  }

  /*提示信息*/
  app.alert = function(message, handler) {
    if (handler) {
      Ext.MessageBox.alert('提示信息', message, handler);
      return;
    }
    //Ext.MessageBox.alert('提示信息', message, false);

    Ext.Msg.show({
      title : '提示信息 ',
      msg : message
    });
    setTimeout(function() {
      Ext.Msg.hide();
    }, 2000);
  };

  app.confirm = function(message, yesHandler, noHandler) {
    Ext.MessageBox.confirm('提示', message, function(optional) {
      //console.log(optional);
      if ('no' == optional) {
        if ($.isFunction(noHandler)) {
          noHandler();
        }
        return;
      }

      if ($.isFunction(yesHandler)) {
        yesHandler();
      }
    });
  };
})(window);