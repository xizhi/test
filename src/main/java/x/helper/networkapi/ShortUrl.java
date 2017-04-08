package x.helper.networkapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;

/**
 * 
 * 短连接
 * 
 * @author xizhi
 *
 */
public class ShortUrl {
	
	private static final Logger logger = LoggerFactory.getLogger(ShortUrl.class);
	
	public static String getUrl(String url) {
		String r = null;

		return r;
	}

	/**
	 * 
	 * 百度短链接
	 * 
	 * @param url
	 * @return
	 * @throws ShortUrlexception
	 */
	public static String getUrlByBaidu(String url) throws ShortUrlexception {
		String r = null;
		if (Strings.isNullOrEmpty(url)) {
			throw new ShortUrlexception("url is null");
		}
		
		String urlencode = null;
		try {
			urlencode = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new ShortUrlexception("URLEncoder encode error", e);
		}
		
		String realUrl = "http://dwz.cn/create.php";
		
		HttpPost httpPost = new HttpPost(realUrl);
		
		List <NameValuePair> params = new ArrayList<NameValuePair>();  
        params.add(new BasicNameValuePair("url", urlencode));  
        params.add(new BasicNameValuePair("alias", ""));  
        params.add(new BasicNameValuePair("access_type", "web"));  
		
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String result = null;
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params,"utf-8"));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity,"utf-8");
			
		} catch (IOException e) {
			throw new ShortUrlexception("http request error", e);
		} finally {
			//httpClient.close();
		}
		try {
			JSONObject json = JSON.parseObject(result);
			r = json.getString("tinyurl");
		} catch(Exception e){
			throw new ShortUrlexception("json parse error", e);
		}
		return r;
	}

	/**
	 * 
	 * 新浪短链接
	 * 
	 * @param url
	 * @return
	 */
	public static String getUrlBySina(String url) throws ShortUrlexception {
		String r = null;

		if (Strings.isNullOrEmpty(url)) {
			throw new ShortUrlexception("url is null");
		}
		
		String base64 = null;
		try {
			base64 = Base64.encodeBase64String(url.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new ShortUrlexception("base64 encode error", e);
		}
		
		String sinaUrl = "http://dwz.wailian.work/api.php?url=%s=&site=%s";
		String realUrl = String.format(sinaUrl, base64,"sina");
		
		HttpGet httpGet = new HttpGet(realUrl);
		httpGet.addHeader("Accept","application/json, text/javascript, */*; q=0.01");
		httpGet.addHeader("X-Requested-With","XMLHttpRequest");
		httpGet.addHeader("Referer","http://dwz.wailian.work/index.php");
		httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		String result = null;
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity,"utf-8");
			
		} catch (IOException e) {
			throw new ShortUrlexception("http request error", e);
		} finally {
			//httpClient.close();
		}
		try {
			JSONObject json = JSON.parseObject(result);
//			JSONObject data = json.getJSONObject("data");
//			r = data.getString("short_url");
		} catch(Exception e){
			throw new ShortUrlexception("json parse error", e);
		}
		return r;
	}

	/**
	 * 
	 * 淘宝短链接
	 * 
	 * @param url
	 * @return
	 */
	public static String getUrlByTaobao(String url) {
		String r = null;

		return r;
	}
	
	
	
	
	public static void main(String[] args) throws ShortUrlexception {
		//System.out.println(getUrlBySina("http://www.baidu.com"));
		System.out.println(getUrlByBaidu("http://www.baidu.com"));
	}
	
	

	static class ShortUrlexception extends Exception {

		public ShortUrlexception(String message, Throwable cause) {
			super(message, cause);
		}

		public ShortUrlexception(String message) {
			super(message);
		}

		public ShortUrlexception(Throwable cause) {
			super(cause);
		}
	}
}
