package x.webapp.session;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class SessionStore {
	
	private static HashMap<String, HttpSession> sessionMap = new HashMap<String, HttpSession>(); 
	
	static void addSession(HttpSession session){
		sessionMap.put(session.getId(), session);
	}
	
	static void destroySession(HttpSession session){
		sessionMap.remove(session.getId());
	}
	
	public static Object get(String key){
		Object r = null;
		
		return r;
	}
	
	
}
