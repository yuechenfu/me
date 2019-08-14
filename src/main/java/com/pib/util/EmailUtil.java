package com.pib.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
 

@Component
@PropertySource({"classpath:application.properties"})
public class EmailUtil {
	@Value("${mail.smtpHost}")
	private  String myEmailSMTPHost ;
	@Value("${mail.fromAccount}")
	private  String fromEmailAccount ;
	@Value("${mail.fromPassword}")
	private  String fromEmailPassword ;
	@Value("${mail.userName}")
	private  String fromUserNick ;
	/**
	 * 发送
	 * 
	 * @param users
	 * @throws Exception
	 */
	public  boolean sendTextEmail(String toEmail, String toUserName, String subject, String content) {
		try {
			Session session = setParameter();
			// 3.循环发送
			MimeMessage message = null;
			Transport transport = null;
			//content ="<h1>This is actual message embedded in HTML tags</h1>";
			message = createEmailMessage(session, fromEmailAccount, toEmail, toUserName, subject, content);
			// 4. 根据 Session 获取邮件传输对象
			transport = session.getTransport();
			// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
			transport.connect(fromEmailAccount, fromEmailPassword);
			// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients()
			// 获取到的是在创建邮件对象时添加的所有收件人,
			// 抄送人, 密送人
			transport.sendMessage(message, message.getAllRecipients());
			// 7. 关闭连接
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	

	/**
	 * 创建email发送参数
	 * 
	 * @return
	 * @throws Exception
	 */
	public  Session setParameter() throws Exception {
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSMTPHost); // 发件人的邮箱的 SMTP
																// 服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		props.put("mail.smtp.port", "465");
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		// Session session = Session.getInstance(props);
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				System.out.println("aaa="+fromEmailAccount);
				return new PasswordAuthentication(fromEmailAccount, fromEmailPassword);
			}
		});
		// 设置为debug模式, 可以查看详细的发送 log
		session.setDebug(true);

		return session;
	}

	/**
	 * 创建一封批准新用户通过的邮件
	 *
	 * @param session
	 *            和服务器交互的会话
	 * @param sendMail
	 *            发件人邮箱
	 * @param receiveMail
	 *            收件人邮箱
	 * @return
	 * @throws Exception
	 */
	public  MimeMessage createEmailMessage(Session session, String fromEmail, String toEmail, String toUsername,
			String subject, String content) throws Exception {
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);

		// 2. From: 发件人
		message.setFrom(new InternetAddress(fromEmail, fromUserNick, "UTF-8"));

		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail, toUsername, "UTF-8"));

		// 4. Subject: 邮件主题
		message.setSubject(subject, "UTF-8");

		// 5. Content: 邮件正文（可以使用html标签）
		message.setContent(content, "text/html;charset=UTF-8");
		// 6. 设置发件时间
		message.setSentDate(new Date());

		// 7. 保存设置
		message.saveChanges();

		return message;
	}

	public static void main(String[] args) throws Exception {
		EmailUtil eu =new EmailUtil();
		eu.sendTextEmail("f0346@163.com","xx","hello", "how are you !");
		 
	}

	 
}
