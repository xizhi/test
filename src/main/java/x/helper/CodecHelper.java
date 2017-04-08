package x.helper;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * 常用编码辅助类
 * 
 * @author xizhi
 *
 */
public class CodecHelper {
	
	public static String toMd5(String content) {
		String r = null;
		r = DigestUtils.md5Hex(content);
		return r;
	}
}
