package com.pib;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = "com.pib")
@MapperScan("com.pib.property.dao")
public class PibApplication extends SpringBootServletInitializer{
   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PibApplication.class);
    }
	       
    public static void main (String[] args) {
        SpringApplication.run(PibApplication.class, args);
    }
}