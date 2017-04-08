<#include "/_include/_management.ftl" />
<@management_head title="淘宝客-excel上传">
</@management_head>
<@management_body js="tbk.js">
	  <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">淘宝客</strong> / <small>Personal information</small></div>
      </div>
      <hr/>
	  <div class="am-g">
	  	<div class="am-u-sm-6">
	  	<form id="form_upload" class="am-form" 
                  		action="./taobaoke-upload.html" method="POST" 
                  		target="ifr_async" enctype="multipart/form-data">
          <input type="file" name="file" style="display: inline;">
          <input type="hidden" id="f_callback" name="callback" value="uploadExcelCallback" />
          <button id="f_b_submit" onclick="uploadExcel()" 
          	type="button" class="am-btn am-btn-primary am-btn-xs"
          	>保存</button>
        </form>
        </div>
        <div class="am-u-sm-6">
          <div class="am-progress am-progress-striped am-active ">
			<div id="upload_progress" 
				class="am-progress-bar am-progress-bar-secondary"  style="margin-bottom: 0"></div>
		  </div>
	      <div id="upload_text" style="text-align: center; margin-top: -2rem;"></div>
        </div>
	  </div>
	  <div class="am-g">
	  	<div class="am-u-sm-12">
		  <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                </th><th class="table-id">ID</th>
                <th class="table-title">标题</th>
                <th class="table-date am-hide-sm-only">修改日期</th>
                <th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
              <!-- 循环 -->
              <#list list as upload>
	          <tr>
                <td>${upload_index + 1}</td>
                <td><a href="#">${upload.name}</a></td>
                <td class="am-hide-sm-only">${upload.creationTime?string('yyyy-MM-dd')}</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button onclick="initCommoditySettle('${upload.id}')" 
                      	class="am-btn am-btn-default am-btn-xs am-text-secondary">
                      	<span class="am-icon-pencil-square-o"></span> 转化
                      </button>
                    </div>
                  </div>
                </td>
              </tr>
	          </#list>
              </tbody>
            </table>
		</div>
		<div id="div_page" class="am-u-sm-12" style="text-align: center; margin:16px;"
		data-pages="${pages!0}" data-page="${page!0}" >
		</div>
	  </div>
		
      <!-- 异步提交表单使用 -->
      <iframe name="ifr_async" style="display:none;"></iframe>
</@management_body>