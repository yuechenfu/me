package com.pib.util;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.pib.admin.util.EmailUtil;
  

@SpringBootTest
@ActiveProfiles("test")
public class MailTest {
	@Test
	public void sendMail() throws UnsupportedEncodingException, MessagingException{
		//EmailUtil.sendTextEmail("f0346@163.com","abc","hello","how are you");
	}
	 
}
