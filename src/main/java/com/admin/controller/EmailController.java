package com.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.entity.Account;
import com.admin.util.EmailUtil; 


@Controller("EmailController")
@RequestMapping("/email")
public class EmailController {
	@Autowired
    private EmailUtil emailUtil;
	

    @PostMapping({"/me"})
	public ModelAndView sendToMe(HttpServletRequest request, Account message) throws Exception {
		sendEmail(request,message);
		return new ModelAndView("/pages/index");
	}
    
    private void sendEmail(HttpServletRequest request,Account message){
    	String toEmail =message.getEmail();
        StringBuffer content = new StringBuffer();
        if(toEmail.indexOf("@")!=-1){
        	
        	if(message.getUsername() !=null) content.append("Client name : "+message.getUsername());
        	content.append("\r\n");
        	if(message.getPhone() !=null) content.append("Client phone : "+message.getPhone());
        	content.append("\r\n");
        	if(message.getRemark() !=null) content.append("Client message: "+message.getRemark());
        	content.append("\r\n");
        	if(message.getEmail() !=null)  content.append("Client email : "+message.getEmail());
        	
            String subject ="from Tenedger.com ,One friend send a message! ";
            try {
                emailUtil.sendMail(emailUtil.fromEmailAccount,subject, content.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
   }
}
