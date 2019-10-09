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
import com.pib.admin.model.Const;
import com.pib.admin.model.rest.BasicRestCode;
import com.pib.admin.model.rest.Rest;
import com.pib.admin.service.AccountService;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private AccountService accountService;

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前） 基于URL实现的拦截器
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {
		String path = request.getServletPath();
		if (path.matches(Const.INTERCEPTOR_PATH)) {
			HttpSession session = request.getSession();
			Account account = (Account) session.getAttribute("loginAccount");
			if (account == null) {
				setResponse(request, response);
				return false;
			}
		}
		return true;
	}

	private void setResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("setResponse............................");
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*, authorization");
		response.getWriter().print(new Gson().toJson(Rest.createFail(BasicRestCode.UNAUTHORIZED)));
		response.sendRedirect("/account/login");
	}
}