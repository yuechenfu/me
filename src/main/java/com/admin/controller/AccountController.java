package com.admin.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.admin.entity.Account;
import com.admin.exception.ServiceException;
import com.admin.model.ProjectRestCode;
import com.admin.service.AccountService;


 
@RestController(value = "AccountController")
@RequestMapping({"/account"})
public class AccountController {
	
	@Autowired
    private AccountService service;
	
	@GetMapping(value="/login")
	@ResponseBody
	public ModelAndView login(Account e, HttpServletRequest request)throws ServiceException{
		ModelAndView mode = new ModelAndView();
		Account inDb = service.findByLogin(e);
		if (inDb.isNull()) mode.setViewName("pages/login");
		else {
			HttpSession session = request.getSession();
	        session.setAttribute("loginAccount",inDb);
	        mode.setViewName("pages/dashboard");
		}
		return mode;
	}
	
    
	@GetMapping(value="/logout")
	@ResponseBody
	public ModelAndView signout(HttpServletRequest request){
		System.out.println("ssssssssssssssssssssssss");
		ModelAndView mode = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("loginAccount");
		mode.setViewName("pages/login");
		return mode;
	}
	  	    
 
}
