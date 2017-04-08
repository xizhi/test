package x.superman.controller.tools;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;

import x.helper.JsonHelper;
import x.helper.map.BeanMap;
import x.superman.mapper.FavoriteMapper;
import x.superman.pojo.generator.Favorite;
import x.superman.pojo.generator.FavoriteExample;
import x.superman.service.FavoriteService;

/**
 * 
 * 
 * @author 收藏夹
 *
 */
@Controller
public class FavoriteController {
	private static Logger logger = LoggerFactory
	        .getLogger(FavoriteController.class);

	@Autowired
	FavoriteMapper mapper;

	@Autowired
	FavoriteService servicer;

	@RequestMapping(value = "/tools/favorite.html", method = RequestMethod.GET)
	public String showIndex(Model model) {
		logger.debug("showIndex");
		Page<Object> page = PageHelper.startPage(1, 10);
		List<Favorite> list = servicer.query();
		// System.out.println(list);
		model.addAttribute("list", list);
		page.getTotal();

		return "/management/management-favorite";
	}

	@RequestMapping(value = "/tools/favorite-item/{uuid}.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String handeQuery(@PathVariable String uuid) {
		BeanMap r = new BeanMap();
		Page<Object> pageHelper = PageHelper.startPage(1,
		        10);
		List<Favorite> list = servicer.query();

		r.put("list", list);
		r.put("pages", pageHelper.getPages());
		r.put("page", pageHelper.getPageNum());
		r.put("total", pageHelper.getTotal());
		return JSONUtils.toJSONString(r);
	}

	@RequestMapping(value = "/tools/favorite-item/{uuid}.html", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String handeUpdate(@PathVariable String uuid, @RequestBody String body) {
		System.out.println(uuid);
		System.out.println(body);
		BeanMap r = new BeanMap();
		r.put("result", "success");
		return JSONUtils.toJSONString(r);
	}

	@RequestMapping(value = "/tools/favorite-item/{uuid}.html", method = RequestMethod.DELETE, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String handeDelete(@PathVariable String uuid) {
		mapper.deleteByPrimaryKey(uuid);
		BeanMap r = new BeanMap();
		r.put("result", "success");
		return JSONUtils.toJSONString(r);
	}

	@RequestMapping(value = "/tools/favorite-item.html", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String handeAdd(@PathVariable String id) {
		BeanMap r = new BeanMap();
		Page<Object> pageHelper = PageHelper.startPage(1,
		        10);
		List<Favorite> list = servicer.query();

		r.put("list", list);
		r.put("pages", pageHelper.getPages());
		r.put("page", pageHelper.getPageNum());
		r.put("total", pageHelper.getTotal());
		return JSONUtils.toJSONString(r);
	}

	@RequestMapping(value = "/tools/favorite-list.html", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String handeQueryList(
	        @RequestParam(value = "page") int page,
	        @RequestParam(value = "limit") int size,
	        @RequestParam(value = "query", required = false) String query) {
		BeanMap r = new BeanMap();
		Page<Object> pageHelper = PageHelper.startPage(page,
		        size);
		List<Favorite> list = null;
		if (Strings.isNullOrEmpty(query)) {
			list = mapper.selectByExample(null);
		} else {
			FavoriteExample example = new FavoriteExample();
			String[] likes = query.split("\\s+");
			for (String like : likes) {
				example.createCriteria().andTitleLike("%"+like+"%");
			}
			list = mapper.selectByExample(example);
		}

		r.put("list", list);
		r.put("pages", pageHelper.getPages());
		r.put("page", pageHelper.getPageNum());
		r.put("total", pageHelper.getTotal());
		return JsonHelper.bean2string(r);
	}

	/**
	 * 
	 * 接收上传文件
	 * 
	 * @return
	 */
	@RequestMapping(value = "/tools/favorite-upload.html", method = RequestMethod.POST)
	public String handleUpload(
	        @RequestParam(value = "file") MultipartFile file,
	        @RequestParam(value = "callback") String callback,
	        Model model) {
		model.addAttribute("callback", callback);
		logger.debug("callback is {}", callback);
		try {
			String content = new String(file.getBytes(),
			        "utf-8");
			List<Map<String, String>> analysis = servicer
			        .analysis(content);
			servicer.save(analysis);
			model.addAttribute("result", "success");
			model.addAttribute("message", "上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "fail");
			model.addAttribute("message", "上传失败");
		}
		return "/common/callback-ifr";
	}

}
