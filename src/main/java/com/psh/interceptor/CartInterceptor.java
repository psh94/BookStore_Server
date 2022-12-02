package com.psh.interceptor;

import com.psh.model.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		Member mvo = (Member)session.getAttribute("member");
		
		if(mvo == null) {
			response.sendRedirect("/main");
			return false;
		} else {
			return true;
		}		
		
	}	
	
}
