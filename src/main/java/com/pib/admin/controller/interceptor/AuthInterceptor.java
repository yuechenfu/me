package com.pib.admin.controller.interceptor;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.google.gson.Gson;
import com.pib.admin.entity.Account;
import com.pib.admin.entity.Person;
import com.pib.admin.model.Const;
import com.pib.admin.model.rest.BasicRestCode;
import com.pib.admin.model.rest.Rest;
import com.pib.admin.service.PersonService;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Autowired
    private PersonService personService;
	/**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * 基于URL实现的拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    	String path = request.getServletPath();
    	return true;
//        if(path.matches(Const.NO_INTERCEPTOR_PATH)) return true;
//    	HttpSession session = request.getSession();
//        Account account = (Account)session.getAttribute(session.getId()) ;
//        if (account != null) {
//        	Person person = personService.findByAccountId(new Person.Builder().set("id",1l).set("accountId", Long.valueOf(account.getId()) ).build());
//        	request.setAttribute("loginPerson",person);
//        	request.setAttribute("loginAccount",account);
//        	return true;
//        }
//        setResponse(response);
//        return false;
    }
    
    private void setResponse(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*, authorization");
        response.getWriter().print(new Gson().toJson(Rest.createFail(BasicRestCode.UNAUTHORIZED)));
        response.sendRedirect("/recurit/pages/login.jsp");
    }
}