package com.pib.property.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "AccountController")
@RequestMapping({"/account"})
public class AccountController {

	@GetMapping(value="/login")
	@ResponseBody
	public ModelAndView login(){
		ModelAndView mode = new ModelAndView();
		mode.setViewName("pages/login");
		return mode;
	}
}
