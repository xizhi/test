package x.superman.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import x.superman.mapper.TbkCommodityMapper;
import x.superman.mapper.TbkCommoditySettleMapper;
import x.superman.pojo.generator.TbkCommodity;
import x.superman.pojo.generator.TbkCommoditySettle;
import x.superman.pojo.generator.TbkCommoditySettleExample;

@Controller
public class HomeController {

	private static Logger logger = LoggerFactory
	        .getLogger(HomeController.class);

	@Autowired
	TbkCommodityMapper commodityMapper;

	@Autowired
	TbkCommoditySettleMapper csMapper;


	@RequestMapping(value = { "", "/",
	        "/index.html" }, method = RequestMethod.GET)
	public String showIndex(
	        @RequestParam(value = "page", defaultValue = "1") int page,
	        Model model) {
		PageHelper.startPage(page, 6);
		TbkCommoditySettleExample example = new TbkCommoditySettleExample();
		List<TbkCommoditySettle> list = csMapper.selectByExample(example);
		model.addAttribute("list", list);
		
		Page<Object> pageHelper = PageHelper.startPage(page, 60);
		list = csMapper.selectByExample(example);
		model.addAttribute("liveList", list);
		model.addAttribute("pages", pageHelper.getPages());
		model.addAttribute("page", pageHelper.getPageNum());
		return "index";
	}
	
	@RequestMapping("commodity-{id}.html")
	public String showCommodity(@PathVariable String id,
	        HttpServletResponse response) throws IOException {
		TbkCommodity record = commodityMapper.selectByPrimaryKey(id);
		response.sendRedirect(record.getTbklj());
		return null;
	}
	
	@RequestMapping("buy-{id}.html")
	public String showBuyCommodity(@PathVariable String id,
	        HttpServletResponse response) throws IOException {
		TbkCommodity record = commodityMapper.selectByPrimaryKey(id);
		response.sendRedirect(record.getSpyhqtglj());
		return null;
	}

	@RequestMapping(value = "building.html", method = RequestMethod.GET)
	public String showBuilding() {
		return "building";
	}

	@RequestMapping(value = "", method = RequestMethod.GET, params = "m=show")
	public String showIndex3() {

		return "";
	}

	/**
	 * 
	 * 异常处理
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}

	@RequestMapping("/error.html")
	public String error() {
		int i = 5 / 0;
		return "hello";
	}
}
