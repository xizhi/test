<#include "/_include/_management.ftl" />
<@management_head title="淘宝客-商品列表">
</@management_head>
<@management_body js="tbk.js">
	  <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">淘宝客-商品列表</strong> / <small>Personal information</small></div>
      </div>
      <hr/>
	  <div class="am-g">
	  	<div id="div_table" class="am-u-sm-12" style="height:300px; overflow:auto;">
		  <table style="width:2200px;" 
		  	class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th style="width:40px;" class="table-id">编号</th>
                <th style="width:220px;" class="table-title">标题</th>
                <th style="width:180px;" class="table-title">类目</th>
                <th style="width:80px;" class="table-title">价格</th>
                <th style="width:80px;" class="table-title">月销量</th>
                <th style="width:100px;" class="table-title">收入比率</th>
                <th style="width:100px;" class="table-title">佣金</th>
                <th style="width:100px;" class="table-title">平台类型</th>
                <th style="width:100px;" class="table-title">优惠券数量</th>
                <th style="width:120px;" class="table-title">优惠券剩余</th>
                <th style="width:120px;" class="table-title">优惠券面额</th>
                <th style="width:120px;" class="table-title">优惠券金额	</th>
                <th style="width:120px;" class="table-title">优惠券开始时间</th>
                <th style="width:120px;" class="table-title">优惠券结束时间</th>
              </tr>
              </thead>
              <tbody>
              <!-- 循环 -->
              <#list list as item>
	          <tr onclick="trClick(this)">
                <td>${item_index + 1}</td>
                <td><a href="./tbk-commodity-${item.id}.html" target="_blank">
                	${item.mc}</a>
                </td>
                <td>${item.lm}</td>
                <td>${item.jg}</td>
                <td>${item.yxl}</td>
                <td>${item.srbl}</td>
                <td>${item.yj}</td>
                <td>${item.ptlx}</td>
                <td>${item.yhqSl}</td>
                <td>${item.yhqSy}</td>
                <td>${item.yhqMe}</td>
                <td>${item.yhqJe}</td>
                <td>${item.yhqSksj?string('yyyy-MM-dd')}</td>
                <td>${item.yhqJssj?string('yyyy-MM-dd')}</td>
              </tr>
	          </#list>
              </tbody>
            </table>
		</div>
		<div id="div_page" class="am-u-sm-12" style="text-align: center; margin:16px;"
			data-pages="${pages!0}" data-page="${page!0}">
		</div>
	  </div>
		
      <!-- 异步提交表单使用 -->
      <iframe name="ifr_async" style="display:none;"></iframe>
</@management_body>