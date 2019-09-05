package com.pib.property.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "IndexController")
public class IndexController {
   @GetMapping("")
   public ModelAndView index() {
       return new ModelAndView("pages/index");
   }
}
