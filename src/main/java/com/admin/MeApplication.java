package com.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice
@SpringBootApplication(scanBasePackages = "com.admin")
@MapperScan("com.admin.dao")
public class MeApplication extends SpringBootServletInitializer implements ApplicationRunner{
	
	@Value("${server.port}")
    public int port;
	
   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MeApplication.class);
    }
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handle(Throwable e) {
        e.printStackTrace();
        return e.getMessage();
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("starting ： http://localhost:" + port+"/admin");
    }
    
    public static void main (String[] args) {
        SpringApplication.run(MeApplication.class, args);
    }
}