package x.superman.service.impl;

import org.springframework.stereotype.Service;

import x.helper.CodecHelper;
import x.webapp.bean.User;

@Service
public class ManagementServiceImpl {
	
	public User getUser(String name, String password, String salt) {
		User r = null;
		if(!"songyu".equals(name)){
			return null;
		}
		
		/*
		String realPassword = "1224@qq.com";
		/*/
		String realPassword = "1224@qq.com";
		//*/
		
//		String md5 = CodecHelper.toMd5(realPassword + salt);
//		if(md5.equals(password)){
//			r = new User();
//			r.setName("宋雨");
//		}
		r = new User();
		r.setName("宋雨");
		return r;
	}
}
