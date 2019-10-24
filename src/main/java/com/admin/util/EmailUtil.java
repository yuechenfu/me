package com.admin.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
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
	
	@Value("${mail.port}")
	private  String emailPort ;
	
	@Value("${mail.fromAccount}")
	public  String fromEmailAccount ;
	
	@Value("${mail.fromPassword}")
	private  String fromEmailPassword ;
	
	@Value("${mail.userName}")
	private  String fromUserNick ;
	
	@Value("${mail.default.recevieAccount}")
	public  String defaultRecevieAccount ;
	
	@Value("${mail.default.recevieUserName}")
	public  String defaultRecevieUserName ;
	/**
	 * 发送
	 * 
	 * @param users
	 * @throws Exception
	 */
	
	public   boolean sendMail ( String toEmail, String subject, String text) {
		String serverUserName = fromEmailAccount;
		String serverPassWord = fromEmailPassword;
		String host = myEmailSMTPHost;
		String port = emailPort ;
		String starttls ="true";
		String auth ="true";
		boolean debug =true;
		String socketFactoryClass ="javax.net.ssl.SSLSocketFactory";
		String fallback ="false";
		if(toEmail == null) toEmail = defaultRecevieAccount;
		String[] to = { toEmail };

        Properties props = new Properties();
        props.put("mail.smtp.user", serverUserName);
        props.put("mail.smtp.host", host);
        props.put("port", port);
        props.put("mail.smtp.starttls.enable", starttls);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", auth);
        if (debug) {
            props.put("mail.smtp.debug", "true");
        } else {
            props.put("mail.smtp.debug", "false");
        }
        try {
            Session smtpSession = Session.getDefaultInstance(props, null);
            smtpSession.setDebug(true);
            MimeMessage msg = new MimeMessage(smtpSession);
            msg.setText(text);
            msg.setSubject(subject);
            msg.setFrom(new InternetAddress("no-replay@pib.com"));
            for (int i = 0; i < to.length; i++) {
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
                //msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail, "no-replay", "UTF-8"));
            }
            msg.saveChanges();
            Transport transport = smtpSession.getTransport("smtp");
            transport.connect(host, serverUserName, serverPassWord);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception mex) {
            mex.printStackTrace();
            System.out.println(mex.getLocalizedMessage());
            return false;
        }
    }
	
	

	public static void main(String[] args) throws Exception {
		EmailUtil eu =new EmailUtil();
		eu.sendMail("marketingmark89@gmail.com","hello", "how are you !");
		 
	}

	 
}
