package x.superman.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FavoriteServiceTest {

	
	FavoriteService favoriteService;
	//@Before
	public void before(){
		 ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring.xml");//这里路径之前没有配对于是一直出错
		 favoriteService = (FavoriteService)context.getBean("favoriteService");
	}
	
	//@Test
	public void test() {
		assertNotNull(favoriteService);
	}

}
