package com.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class IdentityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object Handle)throws Exception{
		String uri=request.getRequestURI();
		if(uri.endsWith("/login")||uri.endsWith("/reg")||uri.endsWith("/tip")) {
			return true;
		}
		if(request.getSession().getAttribute("username")==null) {
			request.getRequestDispatcher("/login").forward(request,response);
			return false;
		}
		return true;
	}
}
