function uploadExcel() {
	$.AMUI.progress.inc(0.5);
	$('#f_b_submit').button('loading');
	$('#form_upload').get(0).submit();
}

function uploadExcelCallback(result, message) {
	$('#f_b_submit').button('reset');
	$.AMUI.progress.done(true);
	layer.alert(message);
	queryUploadInfoContinue = true;
	queryUploadInfo();
	//window.location.reload();
}

function initCommoditySettle(uploadId){
	$.ajax({
		url : './tbk-cs-init.html',
		data : {'uploadId':uploadId},
		method : 'GET',
		dataType : 'text',
		success : function(_data) {
			layer.alert('转化成功'+_data+'条数据');
		}
	});
}

var $lastTr
function trClick(tr){
	if($lastTr){
		$lastTr.css('background-color','');
	}
	
	var self = $lastTr = $(tr);
	self.css('background-color','#CCFFFF');
}


var queryUploadInfoContinue = false;
function queryUploadInfo() {
	$.ajax({
		url : './tbk-upload-info.html',
		method : 'GET',
		dataType : 'text',
		success : function(_data) {
			var data;
			eval('data = ' + _data);
			if (data.count == -1) {
				queryUploadInfoContinue = false;
				return;
			}

			var progress = parseInt(data.current / data.count * 100);
			console.log(data.current, data.count, progress);
			if (progress >= 100) {
				progress = 100;
				queryUploadInfoContinue = false;
			} else if (progress < 100) {
				queryUploadInfoContinue = true;
			}
			var text = progress + '% (共' + data.count + '条,已插入' + data.current + '条)';
			$('#upload_progress').css('width', progress + '%');
			$('#upload_text').html(text);
		},
		complete : function() {
			if (!queryUploadInfoContinue) {
				return;
			}

			setTimeout(queryUploadInfo, 2000);
		}
	})
}


$(function() {
	/*查询上传任务*/
	queryUploadInfo();
	
	function getUri(href) {
		var index = href.lastIndexOf('?');
		if (index == -1) {
			return href;
		}

		return href.substring(0, index);
	}

	//查询分页信息
	var $page = $('#div_page');
	if ($page.get(0)) {
		var pages = Number($page.attr('data-pages'));
		var page = Number($page.attr('data-page'));
		//console.log(pages, page);
		laypage({
			cont : $page,
			pages : pages,
			curr : page,
			skip : true,
			skin : 'molv',
			first : 1,
			last : pages,
			groups : 5,
			jump : function(e, first) {
				if (first) {
					return;
				}
				location.href = getUri(location.href) + '?page=' + e.curr;
			}
		});
	}
	
	
	var $divTable = $('#div_table');
	if($divTable.get(0)){
		var height = $('.admin-content-body').height() - 160;
		$divTable.height(height);
		
		$divTable.niceScroll({
			cursorcolor : "#ccc",
			cursoropacitymax : 1,
			touchbehavior : false,
			cursorwidth : "8px",
			cursorborder : "0",
			cursorborderradius : "5px",
			autohidemode : true
		});
	}
});