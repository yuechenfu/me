package com.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "AdminController")
public class AdminController {
   @GetMapping("/profile")
   public ModelAndView index() {
	   ModelAndView model = new ModelAndView();
		model.setViewName("/pages/index");
		return model;
   }

}
