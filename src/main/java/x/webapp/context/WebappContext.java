package x.webapp.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import x.helper.map.BeanMap;

public class WebappContext {

	private static ThreadLocal<BeanMap> threadLocal = new ThreadLocal<BeanMap>();

	private static final String KEY_REQUEST = "context.request";
	private static final String KEY_RESPONSE = "context.response";

	public static BeanMap init() {
		BeanMap r = new BeanMap();
		init(r);
		return r;
	}

	public static void init(BeanMap beanMap) {
		threadLocal.set(beanMap);
	}

	public static HttpServletRequest request() {
		return (HttpServletRequest) val(KEY_REQUEST);
	}

	public static void request(HttpServletRequest request) {
		setVal(KEY_REQUEST, request);
	}

	public static HttpServletResponse response() {
		return (HttpServletResponse) val(KEY_RESPONSE);
	}

	public static void response(HttpServletResponse response) {
		setVal(KEY_RESPONSE, response);
	}

	/**
	 * 
	 * 获取
	 * 
	 * @param key
	 * @return
	 */
	public static Object val(String key) {
		BeanMap beanMap = threadLocal.get();
		if (beanMap == null) {
			return null;
		}
		return beanMap.get(key);
	}

	/**
	 * 
	 * 设置
	 * 
	 * @param key
	 * @param value
	 */
	public static void setVal(String key, Object value) {
		BeanMap beanMap = threadLocal.get();
		if (beanMap == null) {
			beanMap = new BeanMap();
			threadLocal.set(beanMap);
		}
		beanMap.put(key, value);
	}
}
