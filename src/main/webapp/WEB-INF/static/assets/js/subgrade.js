'use strict';
/**
 * 基础js,项目中的公用部分提取
 */

/*************************************************************
 * 
 * is 判断
 * 
 **************************************************************/


/**
 * 无效的
 * 是否为null 或 undefined
 * @param {Object} object
 */
function _isVain(object){
    return object == null || typeof object == 'undefined';
}

/**
 * 有效的
 * !_isVain()
 * @param {Object} object
 */
function _isValid(object){
	return !_isVain(object);
}

/**
 * 是否为对象
 * @param {Object} obejct
 */
function _isObject(obejct){
	return _.isObject(obejct);
	//return typeof obejct == 'object';
}

/**
 * 是否为对象,暂未实现
 * @param {Object} obejct
 */
function _isMap(obejct){
	return typeof obejct == 'object';
}

/**
 * 是否为数组或列表,暂未实现
 * @param {Object} obejct
 */
function _isList(obejct){
	return typeof obejct == 'string';
}

/**
 * 是否为字符串
 * @param {Object} obejct
 */
function _isString(obejct){
	return typeof obejct == 'string';
}

/**
 * 
 * 是否是function类型对象
 * @param {Object} object
 */
function _isFunction(object){
	return _.isFunction(object);
}

/*************************************************************
 * 
 * object 操作
 * 
 **************************************************************/

/**
 * 如果
 * @param {Object} object
 * @param {Object} defaultValue
 */
function _default(object,defaultValue){
	if(_isValid(object)){
		return object;
	}
	
	return defaultValue;
}

/**
 * 
 * 获取对象属性,多级;如果没有,会返回null
 *  
 * @param object
 * @param keys  使用数组,明确keys内容
 * @returns
 */
function _get(object, keys){
    if($.isEmptyObject(object)){
        return null;
    }
    
    if(!$.isArray(keys) || keys.length < 1){
        return null;
    }
    
    var temp = object[keys[0]];
    for(var i = 1, l = keys.length; i < l; i++){
        if(_isVain(temp)){
            return null;
        }
        temp = temp[keys[i]];
    }
    
    return temp;
};

/**
 * 设置对象属性，多级
 * 
 * @param object
 * @param keys 使用数组,明确keys内容
 * @param value
 */
function _set(object, keys, value){
    if(object == null || typeof object != 'object'){
        return;
    }
    
    if(!$.isArray(keys) || keys.length < 1){
        return;
    }
    
    var temp = object;
    for(var i = 0, l = keys.length - 1; i < l; i++){
        if(_isVain(temp[keys[i]])){
            temp[keys[i]] = {};
        }
        temp = temp[keys[i]];
    }
    
    temp[keys[keys.length -1 ]] = value;
}

/**
 * 
 * 遍历
 * 
 * @param {Object} object
 * @param {Object} fun
 */
function _each(object,fun){
	$.each(object, fun);
}

/*************************************************************
 * 
 * array 操作
 * 
 **************************************************************/

/**
 * ie8 一下不支持indexOf
 */
if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
    var len = this.length >>> 0;
    var from = Number(arguments[1]) || 0;
    from = (from < 0)
         ? Math.ceil(from)
         : Math.floor(from);
    if (from < 0)
      from += len;
    for (; from < len; from++)
    {
      if (from in this &&
          this[from] === elt)
        return from;
    }
    return -1;
  };
}

/* 
*  方法:Array.remove(dx) 通过遍历,重构数组 
*  功能:删除数组元素. 
*  参数:dx删除元素的下标. 
*  
*  
*/ 
var ArrayPrototype = {
	isEmpty : function(){
		return this.length == 0;
	},
	
	isNotEmpty : function(){
		return this.length != 0;
	},
		
	remove : function(dx,byIndex){ 
		//通过元素内容删除
		if(!byIndex){
			dx = this.indexOf(dx);
		}
		
		//通过下标删除
		if(isNaN(dx) || dx > this.length ||dx < 0){
			return false;
		}
		
	    for(var i=dx;i<this.length-1;i++) 
	    { 
	    	this[i]=this[i+1];
	    } 
	    this.length-=1;  
	},


	/**
	 * 获取元素的下一个元素
	 */
	has : function(item){
		return this.indexOf(item) != -1;
	},

	/**
	 * 获取元素的下一个元素
	 */
	next : function(item){
		var index = this.indexOf(item);
		if(index == -1){
			return null;
		}
		
		//最后一个
		if(index == this.length - 1){
			return null;
		}
		
		return this[index+1];
	},

	/**
	 * 获取元素的上一个元素
	 */
	previous : function(item){
		if(this[0] == item){
			return null;
		}
		
		var index = this.indexOf(item);
		if(index == -1){
			return null;
		}
		
		return this[index-1];
	},

	/**
	 * 获取最后一个元素
	 */
	last : function(){
		if(this.length != 0){
			return this[this.length - 1];
		}
		
		return null;
	},

	/**
	 * 判断元素是否是最后一个 
	 */
	isLast : function(item){
		if(item == this.last()){
			return true;
		}
		
		return false;
	},
	
	/**
	 * 
	 * 合计计算
	 * 
	 * @param property
	 * @returns {Number}
	 */
	total : function(property){
		var total = 0;
		
		if(property){
			for(var i = 0, l = this.length; i < l; i++){
				total += _getNumber(this[i][property]);
			}
		} else {
			for(var i = 0, l = this.length; i < l; i++){
				total += _getNumber(this[i]);
			}
		}
		return total;
	}
};
$.extend(Array.prototype,ArrayPrototype);

/*************************************************************
 * 
 * function 操作
 * 
 **************************************************************/

/**
 * 
 * 以静默方式执行 方法
 * 如果出现类型 等其他异常, 不会抛出
 * 
 * @param {Object} fn
 * @param {Object} self fn 内部的this
 */
function _try(fn,domain) {
	if(!_isFunction(fn)){
		return null;
	}

    try {
    	var  args = Array.prototype.slice.call(arguments, 2);
        return fn.apply(domain,args);
    } catch (e) {
        return null;
    }
}

/**
 * 
 * 返回function的try catch 包装函数,并不执行. 
 * 
 * @param fn
 * @param catchFn
 * @returns {Function}
 */
function _tryWrap(fn, catchFn) {
    return function() {
        try {
            return fn.apply(null, arguments);
        } catch (e) {
            if (_isFunction(catchFn))
                catchFn.apply(null,arguments);
        }
    };
}



/*************************************************************
 * 
 * 字符串操作
 * 
 **************************************************************/

/**
 * 用正则表达式将前后空格用空字符串替代。
 */
String.prototype.trim = function(chart) {
    return this.replace(/(^\s*)|(\s*$)/g, '');
};

/**
 * 左填充一个字符串 
 */
String.prototype.lpad = function(length, padStr) {
	if(this.length >= length){
		return this;
	}
	
    var s = '';
    var chart = String(padStr).charAt(0);
    for(var i = 0, l = length - this.length; i < l; i++){
    	s += chart;
    }
    s += this.valueOf();
    return s;
};

/**
 * 右边填充一个字符串 
 */
String.prototype.rpad = function(length, padStr) {
	if(this.length >= length){
		return this;
	}
    var s = '';
    s += this.valueOf();
    var chart = String(padStr).charAt(0);
    for(var i = 0, l = length - this.length; i < l; i++){
    	s += chart;
    }
   
    return s;
};


/**
 *  var template1="我是{0}，今年{1}了";
 *  var template2="我是{name}，今年{age}了";
 *  var result1=template1.format("loogn",22);
 *  var result2=template2.format({name:"loogn",age:22});
 *  //两个结果都是"我是loogn，今年22了"
 * 
 */
String.prototype.format = function(args) {
    var result = this;
    if (arguments.length > 0) {    
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
            	var value = args[key]!=undefined ? args[key] : '';
            	var reg = new RegExp("({" + key + "})", "g");
            	result = result.replace(reg, value);
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    //var reg = new RegExp("({[" + i + "]})", "g");
                    //这个在索引大于9时会有问题
                    var reg= new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
};


/**
 * 字符串辅助方法
 */
var Strings = {
	/**
	 * 无效的字符串,包括 undefined,null,trim后的空字符串
	 */
	isVain : function(str){
		if(_isString(str)){
			//空字符 无效
			return str.trim() == '';	
		}
		//无效
		return true;
	},
	/**
	 * 
	 */
	'count' : function(str,sub){
		var r = 0;
		var index = str.indexOf(sub);
		while(index != -1){
			r++;
			index = str.indexOf(sub,i + sub.length)
		}
		return r;
	}
};



/*************************************************************
 * 
 * Number串操作
 * 
 **************************************************************/

/**
 * 获取 数字类型 对象
 */
function _getNumber(value){
	var r = Number(value);
	if(isNaN(r)){
		r = 0;
	}
	
	return r;
}


var Numbers = {
	format : function(number,decimals){
		number = _getNumber(number);
		decimals = decimals || 2;
		
		var snum = new String(number);
	    var sec = snum.split('.');
	    var whole = parseFloat(sec[0]);
	    var result = '';
	      
	    if(sec.length > 1){
	        var dec = new String(sec[1]);
	        dec = String(parseFloat(sec[1])/Math.pow(10,(dec.length - decimals)));
	        dec = String(whole + Math.round(parseFloat(dec))/Math.pow(10,decimals));
	        var dot = dec.indexOf('.');
	        if(dot == -1){
	            dec += '.';
	            dot = dec.indexOf('.');
	        }
	        while(dec.length <= dot + decimals) { dec += '0'; }
	        result = dec;
	    } else{
	        var dot;
	        var dec = new String(whole);
	        dec += '.';
	        dot = dec.indexOf('.');    
	        while(dec.length <= dot + decimals) { dec += '0'; }
	        result = dec;
	    }  
	    return result;
	}
};

var NumberPrototype = {

	/**
	 * 获取整数部分字符串
	 */
	getInt : function(){
		var value = String(this);
		var dot = value.indexOf('.');
		return value.substring(0,dot);
	},

	/**
	 * 获取小数部分字符串
	 */
	getDecimals : function(){
		var value = String(this);
		var dot = value.indexOf('.');
		return value.substring(dot+1);
	},
	format : function(format){
		return Numbers.format(this,format);
	}
};



$.extend(Number.prototype,NumberPrototype);

/*************************************************************
 * 
 * Date串操作
 * 
 **************************************************************/


//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
//例子：
//(new Date()).format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
//(new Date()).format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
Date.prototype.format = function(fmt) { // author: meizz
 var o = {
     "M+" : this.getMonth() + 1, // 月份
     "d+" : this.getDate(), // 日
     "h+" : this.getHours(), // 小时
     "m+" : this.getMinutes(), // 分
     "s+" : this.getSeconds(), // 秒
     "q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
     "S" : this.getMilliseconds()
 // 毫秒
 };
 if (/(y+)/.test(fmt))
     fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
 for ( var k in o)
     if (new RegExp("(" + k + ")").test(fmt))
         fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
 return fmt;
};

/**
* 
* 暂时只支持yyyy-MM-dd 格式
* 
* 
* @param str
* @param format
* @returns
*/
Date.parse = function(str,format){
	if(_isVain(str)){
		return null;
	}
 format = format || 'yyyy-MM-dd';
 
 var date = new Date();
 date.setTime(0);
  var map = {
  	 'y': function(value){date.setFullYear(value);},//年
     'M': function(value){date.setMonth(value-1);}, //月份 
     'd': function(value){date.setDate(value);}, //日 
     'h': function(value){date.setHours(value);}, //小时 
     'm': function(value){date.setMinutes(value);}, //分 
     's': function(value){date.setSeconds(value);}, //秒 
     //'q': function(value){Math.floor((date.getMonth() + 3) / 3)}, //季度 
     'S': function(value){date.setMilliseconds(value);} //毫秒 
 };
 
 
 for ( var key in map){
	    var patten = new RegExp('(' + key + '+)');
	    var result = patten.exec(format);
     if (result != null){
   	  var value = Number(str.substr(result.index,RegExp.$1.length));
   	  map[key].call(null,value);
   }
 }
 return date;

};

/*************************************************************
 * 
 * 公共方法
 * 
 **************************************************************/

if(!window['console']){
	window['console'] = (function(){ 
		var c = {}; c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile 
		= c.clear = c.exception = c.trace = c.assert = function(){}; 
		return c; 
	})();
}

function _log(){
	var args = arguments;
	_try(function(){
		console.log.apply(console,args);
	});
}


/**
 * uuid
 */
var createUUID = (function (uuidRegEx, uuidReplacer) {  
    return function () {  
        return "xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx".replace(uuidRegEx, uuidReplacer).toUpperCase();  
    };  
})(/[xy]/g, function (c) {  
    var r = Math.random() * 16 | 0,  
        v = c == "x" ? r : (r & 3 | 8);
    return v.toString(16);  
});


/**
 * WebService 辅助方法,将 webService 中的response 解析成Map
 * 将字符串
 * @param {Object} string
 */
function webServer2Map(string){
	try {
		var result = JSON.parse(string);
	} catch(e){
//		console.log(e);
		return null;
	}
	
	//无效判读	
	if(_isVain(result)){
 		 return null;
 	}
	
	var data = {};
	
	$.each(result.Web.response,function(index,item){
    	var key = null;
    	if(item.param){
    		key = item.param;
    		data[key] = item.value;
    		
    	} else if(item.list){
    		key = item.list;
    		var value = [];
    		
    		$.each(item.value,function(index_,item_){
    			var value_ = array2object(item_.value);
    			value.push(value_);
    			
    		});
    		
    		data[key] = value;
    	}
    });
    
    return data;
}


	

function array2object(array){
   	var r = {};
   	$.each(array,function(index,item){
   		var key = null;
   		var value = null;
   		
    	if(item.param){
    		key = item.param;
    		value = item.value;
    	} else if(item.list){
    		key = item.list;
    		value = [];
    		$.each(item.value,function(index_,item_){
    			var value_ = array2object(item_.value);
    			value.push(value_);
    		});
    	}
   		r[key] = value;
   	});
   	return r;
}

/**
 * 临时方法,后期整理到 ztree 工具中
 * @param {Object} string
 */
function zTreeParse(string){
	var map = webServer2Map(string);
	if(!map){
		return null;
	}
	try {
		var r = JSON.parse(map['json']);	
	} catch(e){
		r = null;
	}
	
	return r;
}



/**
 * ajax 方法
 */

function Ajax(extend){
	if(extend){
		//扩展ajax
		$.extend(this,extend);
	}
	this.init();
};

Ajax.prototype = {
	init : function(){},
	ajaxing : false,
	isAjaxing : function(){
		return this.ajaxing;	
	},
	
	handelAjaxingPrompt : function(){
		
	},
	
	before : function(){
		this.ajaxing = true;
		NProgress.start();
	},
	
	after : function(){
		this.ajaxing = false;
		NProgress.done();
	},
	
	/**
	 * 查询
	 * @param {Object} url
	 * @param {Object} parameters
	 * @param {Object} successFunc
	 */
	query : function(url,parameters,successFunc,failFunc){
		if(this.isAjaxing(arguments)){
			this.handelAjaxingPrompt(arguments);
			return;
		}
		var self = this;
		var service = new WebService(url);
		self.before();
		service.showLoading = false;
		if(_isValid(parameters)){
			for (var key in parameters) {
				var value = parameters[key];
				service.set(key,value);	
			}
		}
		
		
		service.callback=function(service){
			self.after();
			
			if(service.getText('exception') == 'true'){
				_app.fail('程序出现异常,请稍后再试');
				return;
			}
			
			if(successFunc){
				successFunc(service);
			}
		};
		service.run();
	},
	
	queryList : function(url,parameters,successFunc){
		if(this.isAjaxing(arguments)){
			this.handelAjaxingPrompt(arguments);
			return;
		}
		var self = this;
		var service = new WebService(url);
		self.before();
		service.showLoading = false;
		if(_isValid(parameters)){
			for (var key in parameters) {
				var value = parameters[key];
				service.set(key,value);	
			}
		}
		
		service.callback=function(service){
			self.after();
			var list = service.getList('list');
			if(_isVain(list)){
				list = [];
			}
			
			successFunc.call(null,list,service);
		};
		
		service.run();
	},
	
	/**
	 * 查询分页
	 * @param {Object} url
	 * @param {Object} parameters
	 * @param {Object} successFunc
	 * @param {Object} pagingFunc
	 */
	queryPaging : function(url,parameters,successFunc,pagingFunc){
		if(this.isAjaxing(arguments)){
			this.handelAjaxingPrompt(arguments);
			return;
		}
		
		var self = this;
		var service = new WebService(url);
		NProgress.start();
		service.showLoading = false;
		if(_isValid(parameters)){
			for (var key in parameters) {
				var value = parameters[key];
				service.set(key,value);	
			}
		}
		
		service.callback=function(service){
			self.ajaxing = false;
			NProgress.done();
			resultFunc.call(null,service);
		};
		
		this.ajaxing = true;
		service.run();
	},
	
	/**
	 * 发送操作
	 * @param {Object} url
	 * @param {Object} parameters
	 * @param {Object} resultFunc
	 */
	update : function(url,parameters,resultFunc){
		
		if(this.isAjaxing(arguments)){
			this.handelAjaxingPrompt(arguments);
			return;
		}
		var self = this;
		var service = new WebService(url);
		NProgress.start();
		service.showLoading = false;
		if(_isValid(parameters)){
			for (var key in parameters) {
				var value = parameters[key];
				service.set(key,value);	
			}
		}
		
		service.callback = function(service){
			self.ajaxing = false;
			NProgress.done();
			
			//操作是否成功
			var success = true;
			
			//提示信息
			/*if(service.getText('exception') == 'true'){
				_app.fail('程序出现异常,请稍后再试');
			} else*/ if(service.hasError() == true){
				success = false;
				_app.fail('程序出现异常:'+service.errorMsg+'<br>请稍后再试');
				//_app.fail('操作失败');
			} else {
				_app.success('操作成功');
			} 
			
			//如果有回调函数,使用回调函数
			if(resultFunc){
				resultFunc.call(null,success,service);
				return;
			}
			
		};
		
		this.ajaxing = true;
		service.run();
	}
};
var _ajax = new Ajax();

/**
 * ajax 队列
 */
function ajaxQueue(){
	var r = {
		before : function(){
			
		},
		
		after : function(){
			
		}
	};
	
	return r;
}



//table 控件实现,
Ajax.prototype.execute = function(parameters,callbackFunc){
	var self = this;
	
	if(!parameters){
		parameters = $.extend({},self.parameters,self.paging);
	} else {
		parameters = $.extend(self.parameters,self.paging,parameters);
	}
	//console.log(parameters);
	
	
	this.query(this.url,parameters,function(service){
		//console.log(service);
		var list = service.getList('list');
		if(_isVain(list) || list.length == 0){
//			_app.fail('没有查询到数据');
			var templateStr = $$(self.templateId).innerHTML;
			var htmlStr = template.compile(templateStr)({list:[]});
			$('#'+self.contentDivId).html(htmlStr);
//			return;
		}else{
			if(self.variant){
				list = self.variant(list); 
			}
			//table
			var templateStr = $$(self.templateId).innerHTML;
			var htmlStr = template.compile(templateStr)({list:list});
			$('#'+self.contentDivId).html(htmlStr)
				.find('[data-toggle="tooltip"]').tooltip(); //提示信息
		}
		
		//console.log(list);
		
		
		//分页信息
		if(self.paggingDivId){
			var rows = self.paging.rows = _getNumber(service.getText('rows'));
			var page = self.paging.page = _getNumber(service.getText('page'));
			var total = _getNumber(service.getText('total'));
			
			var pages = total % rows == 0 ? total / rows : parseInt(total / rows)+1; 
			
			var layPageSetting = {
			    cont: self.paggingDivId,
			    pages: pages, 
			    curr: page, 
			    jump: function(e, first){ //触发分页后的回调
			        if(first){ //一定要加此判断，否则初始时会无限刷新
			           return; 
			        }
			        //console.log(e);
			        self.execute({page:e.curr});
			    }
			};
			
			//console.log(layPageSetting);
			laypage(layPageSetting);
		}
		
		
		if(callbackFunc){
			callbackFunc();
		}
	});
};

// ajax over


function Store(Construction){
	
	//缓存
	var cache = {};
	var globalId = 1;
	var r = {
		getGlobalId : function(){
			return ++globalId;
		}
	};
	
	if(Construction){
		var self = new Construction(cache,parent);
		$.extend(r,self);
	}
	
	
	return r;
	
	if(window.parent == window){
		return;
	}
	var parentStore = window.parent['_store']; 
	if(parentStore){
		this.parent = parentStore; 
	}
}
// store over


function xForm(selector){
	if(!selector){
		return null;
	}
	var form ,r, elements;
	if(selector[0] == '#'){
		form = $(selector).get(0);
	} else {
		form = document.forms[formName];
	}
	
	if(!form){
		return null;
	}
	
	r = {
		/**
		 * 序列化
		 */
		serialize : function(){
			var r = {};
			return r;
		},
		/**
		 * 
		 */
		val : function(key,value){
			if(arguments.length == 1){
				return this.getValue(key);
			}
			
			return this.setValue(key,value);
			
		},
		
		getValue : function(key){
			
		},
		
		setValue : function(key,value){
			return this;
		},
		
		setValues : function(values){
			for(var key in values){
				var value = values[key];
				this.setValue(key, value);
			}
		},
		
		submit : function(){
			form.submit();
		}
		
	};
	return r;
}

/**
 * form 表单公共方法
 */
var Forms = {
	/**
	 * 设置select 的 options
	 */
	setOptions : function(selectElement,array){
		$.each(array,function(index,item){
			var option = new Option(item.text, item.value);
			selectElement.options.add(option);
		});	
	},
	/**
	 * 变成日期控件
	 */
	bringDate : function(){
		
	}
};


function _class(extend){
	function Clazz(){};
	var r = new Clazz();
	if(_isFunction(extend)){
		$.extend(r,extend());
	} else {
		$.extend(r,extend);
	}
	
	return r;
}

// form over

/*************************************************************
 * 
 * 前端方法
 * 
 **************************************************************/

function $$(elementId){
	return document.getElementById(elementId);
}

function $name(elementName){
	return document.getElementsByName(elementName);
}

function _isIe(){
	return /msie/.test(navigator.userAgent.toLowerCase());
}

function _isWebkit(){
	return  /webkit/.test(navigator.userAgent.toLowerCase());
} 


/**
 * 截断事件流
 */
function _stopBubble(evt) { 
	var e=(evt)?evt:window.event;
	if (window.event) {
	   e.cancelBubble = true;     // ie下阻止冒泡
	} else {
	   e.stopPropagation();     // 其它浏览器下阻止冒泡
	}
}




/**
 * div 加上遮罩层
 */
function lockDiv(){
	
}

function unlockDiv(){
	
}


// 处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外
/*
 * //禁止后退键 作用于Firefox、Opera 
	document.onkeypress=banBackSpace; 
	//禁止后退键 作用于IE、Chrome 
	document.onkeydown=banBackSpace; 
 */
function banBackSpace(e){ 
//	layer.msg("banBackSpace");
	var ev = e || window.event;// 获取event对象
	var obj = ev.target || ev.srcElement;// 获取事件源
	
	var t = obj.type || obj.getAttribute('type');// 获取事件源类型
	
	// 获取作为判断条件的事件类型
	var vReadOnly = obj.getAttribute('readonly'); 
	var vEnabled = obj.getAttribute('enabled'); 
	// 处理null值情况
	vReadOnly = (vReadOnly == null || vReadOnly=="") ? false : true; 
	vEnabled = (vEnabled == null || vEnabled=="") ? true : true; 
	
	// 当敲Backspace键时，事件源类型为密码或单行、多行文本的，
	// 并且readonly属性为true或enabled属性为false的，则退格键失效
	var flag1=(ev.keyCode == 8 && (t=="password" || t=="text" || t=="textarea") 
	&& (vReadOnly==true || vEnabled!=true))?true:false; 
	
	// 当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效
	var flag2=(ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea") 
	?true:false; 
	
	// 判断
	if(flag2){ 
	return false; 
	} 
	if(flag1){ 
	return false; 
	} 
} 
