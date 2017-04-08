package x.superman.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import x.superman.pojo.generator.Favorite;


@Service
public interface FavoriteService {
	
	/**
	 * 解析数据
	 * 
	 * @param content
	 * @return
	 */
	List<Map<String,String>> analysis(String content);
	
	/**
	 * 
	 * 保存数据
	 * 
	 * @param data
	 * @return
	 */
	boolean save(List<Map<String,String>> data);
	
	List<Favorite> query();
}
