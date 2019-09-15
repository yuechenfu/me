package com.pib.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("EmailController")
@RequestMapping("/email")
public class EmailController {
	
	@PostMapping({"/send/code"})
    public String sendCheckCode() throws Exception {
		//SecurityCode securityCode = securityCodeService.saveCodeByPerson(person, SecurityCodeType.REGISTER);  
        //return Rest.createSuccess(service.update(data));
		return "";
    }
	 
}
