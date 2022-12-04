package com.psh.controller;

import com.psh.model.member.Member;
import com.psh.utill.HttpResponses;
import com.psh.utill.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.psh.utill.HttpResponses.*;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public ResponseEntity<Void> homeLogin(HttpServletRequest request, Model model) {

		// session 존재 x
		HttpSession session = request.getSession(false);
		if(session == null){
			return RESPONSE_OK;
		}

		Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
		// session 존재 o
		// session에 loginMember가 없을 때,
		if(loginMember == null){
			return RESPONSE_OK;
		}

		// session 존재 o, loginMember도 있을 때,
		model.addAttribute("member", loginMember);
		return RESPONSE_OK;

	}

	
}
