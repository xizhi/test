package x.webapp.context;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import x.helper.map.BeanMap;
import x.superman.var.SessionKeys;
import x.superman.var.WebApp;

/**
 * @author xizhi
 *
 */
public class WebappContextInterceptor extends HandlerInterceptorAdapter {

	// private static final Logger logger =
	// LoggerFactory.getLogger(WebappContextInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod methodHandler = (HandlerMethod) handler;
			WebappContextAnnotation annotation = methodHandler
			        .getMethodAnnotation(WebappContextAnnotation.class);
			if (annotation != null) {
				WebappContext.init();
				WebappContext.request(request);
				WebappContext.response(response);
			}
		}
		return true;
	}
}
