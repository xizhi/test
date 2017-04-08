package x.helper;

import com.alibaba.fastjson.JSON;

/**
 * 
 * JSON 辅助类
 * 
 * @author xizhi
 *
 */
public class JsonHelper {
	
	public static String bean2string(Object object){
		return JSON.toJSONString(object);
	}
	
	public static <E>E string2Bean(String text, Class<E> T){
		return JSON.parseObject(text, T);
	}
}
