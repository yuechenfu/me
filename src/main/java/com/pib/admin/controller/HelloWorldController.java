package com.pib.admin.controller;
 

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pib.admin.entity.HelloWorld;
import com.pib.admin.entity.Person;
import com.pib.admin.service.HelloWorldService;
 


@Controller
@RequestMapping({"/anon"})
public class HelloWorldController {
	
	@Autowired
    private HelloWorldService service;
	
	@GetMapping(value="/home2")
	@ResponseBody
	public ModelAndView home(){
		ModelAndView mode = new ModelAndView();
		mode.setViewName("index");
		return mode;
	}
	
	@GetMapping(value="/home/getJson")
	@ResponseBody
	public void homeJson(@RequestAttribute("loginPerson") Person loginPerson){
		System.out.println(loginPerson.toString());
		 
	}
	
	@GetMapping(value="/home/getLog")
	@ResponseBody
	public String getLog(@RequestAttribute("pdf") String loginPerson)throws Exception{
		System.out.println(loginPerson.toString());
		//HelloWorld hello = new HelloWorld.Builder().set("id", loginPerson.getId()).build();
		return loginPerson;
	}
	
	@GetMapping("/home/{name}")
    public ModelAndView findByName(@PathVariable String name) {
		ModelAndView mode = new ModelAndView();
		mode.addObject("name", name);
		mode.setViewName("index");
        return mode;
    }
	
	@GetMapping("/interface")
    public ModelAndView jsonInterface() {
		ModelAndView mode = new ModelAndView();
		mode.setViewName("/pages/interface");
        return mode;
    }
	
	 
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public void handleMissingParams(MissingServletRequestParameterException ex) {
	    String name = ex.getParameterName();
	    System.out.println(name + " parameter is missing");
	    // Actual exception handling
	}
	@GetMapping("/googleLogin")
    public ModelAndView googleLogin() {
		ModelAndView mode = new ModelAndView();
		mode.setViewName("/pages/googleLogin");
        return mode;
    }
	
	@GetMapping("/go")
    public ModelAndView go() {
		ModelAndView mode = new ModelAndView();
		mode.setViewName("/pages/index");
        return mode;
    }
	
}
