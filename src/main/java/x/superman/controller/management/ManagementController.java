package x.superman.controller.management;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import x.superman.service.impl.ManagementServiceImpl;
import x.superman.var.SessionKeys;
import x.superman.var.WebApp;
import x.webapp.bean.User;
import x.webapp.context.WebappContext;
import x.webapp.context.WebappContextAnnotation;
import x.webapp.context.WebappContextInterceptor;

/**
 * 
 * 后台管理
 * 
 * @author xizhi
 *
 */
@Controller
@RequestMapping(PackStore.route)
public class ManagementController {

	@Autowired
	ManagementServiceImpl server;

	private static Logger logger = LoggerFactory
	        .getLogger(ManagementController.class);

	@RequestMapping(value = { "",
	        "index.html" }, method = RequestMethod.GET)
	// @WebappContextAnnotation
	public String showIndex() {
		logger.info("request is '{}'",
		        WebappContext.request());
		return "/management/management-index";
	}

	@RequestMapping(value = "login.html", method = RequestMethod.GET)
	public String showLogin(HttpServletRequest request,
	        HttpServletResponse response) {
		User user = new User();
		request.getSession().setAttribute(
		        SessionKeys.WEBAPP_ADMIN, user);
		try {
			response.sendRedirect(WebApp.URI_MANAGEMENT_INDEX);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
		// return "/management/management-login";
	}

	@RequestMapping(value = "home.html", method = RequestMethod.GET)
	public String showHome() {
		return "/management/management-login";
	}

	/**
	 * 
	 * 登录
	 * 
	 * @param name
	 * @param password
	 * @param salt
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "login.html", method = RequestMethod.POST)
	public String handleLogin(
	        @RequestParam(value = "u_name") String name,
	        @RequestParam(value = "u_pwd") String password,
	        @RequestParam(value = "salt") String salt,
	        HttpServletResponse response,
	        HttpServletRequest request, Model model)
	                throws IOException {

		User user = server.getUser(name, password, salt);
		if (user != null) {
			request.getSession().setAttribute(
			        SessionKeys.WEBAPP_ADMIN, user);
			response.sendRedirect(
			        WebApp.URI_MANAGEMENT_INDEX);
			return null;
		}
		model.addAttribute("message", "密码错误");
		return "/management/management-login";
	}

	/**
	 * 
	 * 登出
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "logout.html", method = RequestMethod.GET)
	public String handleLogout(HttpServletRequest request,
	        HttpServletResponse response, Model model)
	                throws IOException {
		request.getSession()
		        .removeAttribute(SessionKeys.WEBAPP_ADMIN);
		response.sendRedirect(WebApp.URI_MANAGEMENT_INDEX);
		return null;
	}

	/**
	 * 
	 * 菜单初始化
	 * 
	 * @param callback
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "menu.js", method = RequestMethod.GET)
	public String showMenuJs(
	        @RequestParam(value = "callback") String callback,
	        Model model) {
		String url = "/management/management-menu-js";
		if (callback == null) {
			return url;
		}
		model.addAttribute("callback", callback);
		return url;
	}

}
