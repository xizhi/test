package x.helper;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

public class EmailHelper {

	private static String smtpServer;
	private static String username;
	private static String password;
	private static String nick="希之";

	public static void setEmailGlobalConfilg(String smtpServer, String username, String password, boolean ifAuth) {
		EmailHelper.smtpServer = smtpServer;
		EmailHelper.username = username;
		EmailHelper.password = password;
	}

	public static boolean send(String recipient, String subject, String content) {
		boolean r = false;
		try {
			//Properties props = System.getProperties();
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", smtpServer);
			// props.put("mail.transport.protocol", "smtp");// 发送邮件的协议
			props.put("mail.smtp.port", "25");// 发送邮件的端口
			MailAuthenticator authenticator = new MailAuthenticator(username, password);
			// 创建session
			Session session = Session.getInstance(props, authenticator);
			
			final MimeMessage message = new MimeMessage(session);
			message.setFrom(String.format("%s<%s>", MimeUtility.encodeText(nick),username));
			// 设置收件人
			message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
			// 设置主题
			message.setSubject(subject);
			// 设置邮件内容
			message.setContent(content.toString(), "text/html;charset=utf-8");
			// 发送
			Transport.send(message);
			
			r = true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public static boolean sends(){
		boolean r = false;
		
		return r;
	}
}

/*
 * 邮箱账号类，可以单独写一个java文件。
 */
class MailAuthenticator extends Authenticator {
	/**
	 * 用户名（登录邮箱）
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 初始化邮箱和密码
	 * 
	 * @param username
	 *            邮箱
	 * @param password
	 *            密码
	 */
	public MailAuthenticator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	String getPassword() {
		return password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}

	String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}