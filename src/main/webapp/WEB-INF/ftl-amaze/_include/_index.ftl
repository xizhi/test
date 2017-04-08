<#macro commodity item clazz>
	<div class="pro_detail ${clazz}">
      <a rel="nofollow" href="./commodity-${item.id}.html" target="_blank">
        <img src="${item.zt}" height="272" style="border: 0;max-width:272px;"/>
      </a>
      <div class="pro_intro fr">
        <p class="pro_title">
            <a href="./commodity-${item.id}.html" rel="nofollow"
               target="_blank" title="【天天特价】${item.mc}" style="color: #616161; font-size: 16px;"
               >【天天特价】${item.mc}</a>
        </p>
	    <div class="pro_price color_p" style="color: #FB82A4;"><i class="iconfont" style="color:#fb973e;margin-right: 3px;">
	            &#xe60a;</i>内部券<em>${item.yhqJe}</em>元，过期时间<span style="font-family: Arial; margin-left: 6px;">${item.yhqJssj?string('yyyy-MM-dd')}</span>
	    </div>
        <div class="residue">优惠券剩余<i class="color_p">${item.yhqSy}</i>张，已领取 <span  style="font-family: Arial; font-size: 14px;">${item.yhqSl}</span> 张
        </div>
	    <div class="pro_nowPri"><span>下单价 ￥<em>${item.jg - item.yhqJe}</em></span>
	       	 在售价<em style="font-weight: normal;font-family: Arial;">￥${item.jg}</em>
	    </div>
        <div class="buy">
            <span style="color: #999999;  ">购买流程：</span>
            <a rel="nofollow" href="./buy-${item.id}.html" target="_blank">
                <span class="indexBorder">点击下单</span>
            </a>
        </div>
      </div>
    </div>
</#macro>
<#macro live item clazz>
	<li class="${clazz}">
    	<a href="./commodity-${item.id}.html" class="img" rel="nofollow" target="_blank">
            <i class="today-new"></i>
            <img src="${item.zt}" alt="">
        </a>
        <div class="goods-padding">
            <div class="coupon-wrap clearfix">
                <span class="price"><b><i>￥</i>${item.jg - item.yhqJe}</b>券后价</span>
                <span class="old-price"><i>￥</i>${item.jg}</span>
                <span class="coupon"><em class="quan-left"></em>券<b><i>￥</i>${item.yhqJe}</b><em class="quan-right"></em></span>
            </div>
            <div class="title">
                <a target="_blank" href="./buy-${item.id}.html">${item.mc}</a>
            </div>
            <div class="goods-num-type">
                <span class="goods-num">销量<b>${item.yxl}</b></span>
                <div class="goods-type">
                    <i class="tmall" title="天猫"></i>                                                                                                                                                                                                                    </div>
            </div>
        </div>
    </li>
</#macro>