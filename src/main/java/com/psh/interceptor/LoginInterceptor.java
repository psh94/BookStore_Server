package com.psh.interceptor;

import com.psh.model.member.Member;
import com.psh.utill.SessionConst;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		System.out.println("LoginInterceptor preHandle 작동");

		String requestURI = request.getRequestURI();

		HttpSession session = request.getSession();

		if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER)==null){
			//redirect를 requestURI로 하면 다시 interceptor가 호출 되어 무한 반복 된다.
			response.sendRedirect("login?requestURL=" + requestURI);
			return false;
		}

		return true;

	}



	
}
