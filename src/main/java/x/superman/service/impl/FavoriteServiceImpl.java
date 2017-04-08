package x.superman.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x.superman.mapper.FavoriteMapper;
import x.superman.pojo.generator.Favorite;
import x.superman.pojo.generator.FavoriteExample;
import x.superman.service.FavoriteService;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	FavoriteMapper mapper;
	
	@Override
	public List<Map<String, String>> analysis(String content) {
		List<Map<String, String>> r = new ArrayList<Map<String,String>>();
		
		String tab_a_start = "<A HREF";
		String tab_a_end = "</A>";
		for(int index_a_start = content.indexOf(tab_a_start); 
				index_a_start != -1;
				index_a_start = content.indexOf(tab_a_start,index_a_start + tab_a_start.length())){
			
			int index_a_end = content.indexOf(tab_a_end,index_a_start + tab_a_start.length());
			String line = content.substring(index_a_start,index_a_end + tab_a_end.length());
			Map<String, String> data = analysisATag(line);
			r.add(data);
		}
		return r;
	}

	private Map<String, String> analysisATag(String aTag) {
		Map<String, String> r = new HashMap<String, String>();

		boolean isKey = false;
		boolean isValue = false;
		boolean isContent = false;

		StringBuilder key = new StringBuilder(32);
		StringBuilder value = new StringBuilder(512);
		for (int i = 0, l = aTag.length(); i < l; i++) {
			char c = aTag.charAt(i);

			// 开始key
			if (c == ' ') {
				key.delete(0, key.length());
				isKey = true;
				continue;
			}

			// 追加key
			if (isKey) {
				// 遇到 = 退出
				if (c == '=') {
					isKey = false;
					continue;
				}
				key.append(c);
			}

			if (c == '"') {
				if (isValue) {
					r.put(key.toString(), value.toString());
					isValue = false;
					continue;
				} else {
					value.delete(0, value.length());
					isValue = true;
					continue;
				}
			}

			if (isValue) {
				value.append(c);
			}

			if (c == '>') {
				isContent = true;
				value.delete(0, value.length());
				continue;
			}

			if (c == '<') {
				isContent = false;
				r.put("CONTENT", value.toString());
				continue;
			}

			if (isContent) {
				value.append(c);
			}
		}

		return r;
	}

	@Override
	public boolean save(List<Map<String, String>> data) {
		
		//System.out.println(tbkMpper.selectByPrimaryKey("1"));
		for (Map<String, String> map : data) {
			Favorite favorite = new Favorite();
			favorite.setHref(map.get("HREF"));
			favorite.setTitle(map.get("CONTENT"));
			//id为md5
			favorite.setUuid(DigestUtils.md5Hex(favorite.getHref()));
			try {
				if(!has(favorite)){
					//不充分才添加
					mapper.insert(favorite);
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private boolean has(Favorite favorite){
		boolean r =false;
		
		Favorite f = mapper.selectByPrimaryKey(favorite.getUuid());
		r = f != null;
		
//		FavoriteExample example = new FavoriteExample();
//		example.createCriteria()
//			.andHrefEqualTo(favorite.getHref());
//		r = mapper.selectByExample(example).size() != 0;
		return r;
	}

	@Override
	public List<Favorite> query() {
		List<Favorite> r = null;
		FavoriteExample example = new FavoriteExample();
		r = mapper.selectByExample(example);
		return r;
	}
	
	

}
