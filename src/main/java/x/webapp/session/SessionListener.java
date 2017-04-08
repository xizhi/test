package x.webapp.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		SessionStore.addSession(event.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		SessionStore.destroySession(event.getSession());
	}

}
