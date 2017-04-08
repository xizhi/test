package x.superman.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import x.superman.var.SessionKeys;
import x.superman.var.WebApp;

/**
 * @author xizhi
 *
 */
public class ManagementInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ManagementInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//logger.debug("preHandle");
		
		String uri = request.getRequestURI();
		if(WebApp.URI_MANAGEMENT_LOGIN.equals(uri)){
			return true;
		}
		
		HttpSession session = request.getSession(false);
		if(session == null){
			redirectLogin(response);
			return false;
		}
		
		Object admin = session.getAttribute(SessionKeys.WEBAPP_ADMIN);
		if(admin == null){
			redirectLogin(response);
			return false;
		}
		return true;
	}
	
	private void redirectLogin(HttpServletResponse response) throws IOException{
		response.sendRedirect(WebApp.URI_MANAGEMENT_LOGIN);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("afterCompletion");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("afterConcurrentHandlingStarted");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
