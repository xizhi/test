package x.superman.controller.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(PackStore.route)
public class ZhihuController {
private static Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value = "zhihu.html",method = RequestMethod.GET)
	public String showIndex(){
		logger.debug("showIndex");
		return "/management/zhihu-index";
	}
}
