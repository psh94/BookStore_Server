package com.psh.controller;

import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
import com.psh.model.member.MemberLoginParam;
import com.psh.model.member.MemberUpdateParam;
import com.psh.service.LoginService;
import com.psh.service.MemberService;
import com.psh.utill.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.psh.utill.HttpResponses.*;

@RestController
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	private final LoginService loginService;

	//회원가입
	@PostMapping("/join")
	public ResponseEntity<Void> join(@Valid @ModelAttribute MemberJoinParam param, BindingResult bindingResult) throws Exception{

		if(bindingResult.hasErrors()){
			return RESPONSE_CONFLICT;
		}
		memberService.memberJoin(param);
		return RESPONSE_OK;

	}

	// 아이디 중복 검사
	@PostMapping("/{memberId}/memberIdChk")
	public ResponseEntity<Void> memberIdChk(@PathVariable String memberId) throws Exception{

		log.info("memberIdChk() 진입");

		boolean duplicatedMemberId = memberService.isExistMemberId(memberId);

		if(duplicatedMemberId) {

			return RESPONSE_CONFLICT;	// 중복 아이디 o

		} else {

			return RESPONSE_OK;	// 중복 아이디 x

		}
	}

	@PostMapping("/{memberId}/update")
	public ResponseEntity<Void> memberUpdate(@Valid @ModelAttribute MemberUpdateParam param, BindingResult bindingResult){

		if(bindingResult.hasErrors()){
			return RESPONSE_CONFLICT;
		}

		memberService.memberUpdate(param);
		return RESPONSE_OK;

	}

	@GetMapping("/memberDelete")
	public ResponseEntity<Void> memberDelete(@Valid Member member){

		if(member !=null) {
			memberService.memberDelete(member);
			return RESPONSE_OK;
		}

		return  RESPONSE_BAD_REQUEST;
	}



	/* 로그인 */
	@PostMapping("/login")
	public ResponseEntity<Void> loginPOST(@Valid @ModelAttribute MemberLoginParam param, BindingResult bindingResult, HttpServletRequest request) throws Exception {

		Member loginMember = loginService.memberLogin(param);

		//--------로그인 실패 시----------
		//바인딩 에러
		if (bindingResult.hasErrors()) {
			return RESPONSE_CONFLICT;
		}

		//loginMember를 찾을 수 없을 때
		if (loginMember == null) {
			bindingResult.reject("loginFail", "로그인에 실패했습니다. 아이디 또는 비밀번호를 확인해 주세요.");
			return RESPONSE_CONFLICT;
		}

		//--------로그인 성공 시--------
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
		return RESPONSE_OK;

	}

    // session을 제거해서 로그아웃
   	@GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request){

        HttpSession session = request.getSession();

        session.invalidate();

		return RESPONSE_OK;

    }


}
