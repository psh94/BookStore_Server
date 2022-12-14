package com.psh.interceptor;

import com.psh.model.member.Member;
import com.psh.utill.SessionConst;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

	//로그인이 제대로 되지 않았을 경우 다시 /member/login으로 돌아가는 interceptor
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		System.out.println("LoginInterceptor preHandle 작동");

		String requestURI = request.getRequestURI();

		HttpSession session = request.getSession();

		if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER)==null){
			response.sendRedirect("login?requestURL=" + requestURI);
			return false;
		}

		return true;

	}



	
}
