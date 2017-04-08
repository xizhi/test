(function($) {
	'use strict';

	$(function() {
		var $fullText = $('.admin-fullText');
		$('#admin-fullscreen').on('click', function() {
			$.AMUI.fullscreen.toggle();
		});

		$(document).on($.AMUI.fullscreen.raw.fullscreenchange, function() {
			$fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
		});
	});

	//滚动条初始化
	$(function() {
		$('#admin-offcanvas').niceScroll({
			cursorcolor : "#ccc",
			cursoropacitymax : 1,
			touchbehavior : false,
			cursorwidth : "5px",
			cursorborder : "0",
			cursorborderradius : "5px",
			autohidemode : true
		});
	});

})(jQuery);

/**
 * 控制台 _app 初始化
 */
(function() {
	'use strict';
	var _app = window['_app'] = {};
	var $appMenu = $('#app-menu');

	_app['menuInit'] = function(data) {
		//console.log(data);
		var menuArray = data.menus;
		$appMenu.html('');
		var content = '';
		var temp_chile;
		function getContent(menu) {
			var r = '<li><a href="{url}" {option}>\
					<span class="{ico}"></span> {title} {label}\
				</a></li>'.format(menu);
			return r;
		}

		function getSecondContent(menu, index) {
			var temp_chile = '';
			var children = menu.children;
			for (var j = 0, l = children.length; j < l; j++) {
				var child = children[j];
				temp_chile += getContent(child);
			}

			menu['collapse'] = "{target: '#collapse-nav-" + index + "'}";
			menu['ul-id'] = 'collapse-nav-' + index;
			menu['ul-content'] = temp_chile;
			var r = '<li class="admin-parent">\
	            <a class="am-cf" data-am-collapse="{collapse}">\
					<span class="am-icon-file"></span> {title} <span class="am-icon-angle-right am-fr am-margin-right"></span></a>\
	            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="{ul-id}">\
					{ul-content}\
	            </ul>\
	         </li>'.format(menu);

			return r;
		}

		for (var i = 0, l = menuArray.length; i < l; i++) {
			var menu = menuArray[i];
			var children = menu.children;
			if (children) {
				content += getSecondContent(menu, i);
			} else {
				content += getContent(menu);
			}
		}
		$appMenu.html(content);
		initSelectedMenu();
	}

	//路径对象
	var _href = (function(h) {
		var r = {};
		r['full'] = h;
		var index = h.indexOf('/');
		if (index == -1) {
			r['root'] = h;
		}
		r['root'] = h.substring(index);
		r['paths'] = window.location.pathname.split('/');
		return r;
	})(window.location.href);

	//通过相对路径获取全路径
	function getUrl(url) {
		if (url.startsWith('http')) {
			return url;
		}

		if (url.startsWith('/')) {
			return _href.root + url;
		}
		var paths = url.split('/');

		var pathsIndex = _href.paths.length - 1;
		var finalPaths = [];
		for (var i = 0; i < paths.length; i++) {
			var p = paths[i];
			if (p == '..') {

			}
		}

	}

	function initSelectedMenu() {
		var $as = $appMenu.find('a');
		$.each($as, function() {
			var self = $(this);
			var href = self.attr('href');
			if (href && _href.full == getUrl(href)) {
				//菜单选择操作
				self.css('color', '#FFF');
				self.parent('li').css('background-color', '#5eb95e');
			}
			return false;
		})
	}



	_app['alert'] = function(message) {
		alert(message);
	}
})();