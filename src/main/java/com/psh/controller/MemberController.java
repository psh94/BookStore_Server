package com.psh.controller;

import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
import com.psh.model.member.MemberLoginParam;
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


	//회원가입 페이지 이동
	@GetMapping("/join")
	public void loginGET() {

		log.info("회원가입 페이지 진입");

	}

	//회원가입
	@PostMapping("/join")
	public ResponseEntity<Void> joinPOST(@Valid @ModelAttribute MemberJoinParam param) throws Exception{

		/* 회원가입 쿼리 실행 */
		memberService.memberJoin(param);

		return RESPONSE_OK;

	}

	// 아이디 중복 검사
	@PostMapping("/{memberId}/memberIdChk")
	public ResponseEntity<Void> memberIdChkPOST(@PathVariable String memberId) throws Exception{

		log.info("memberIdChk() 진입");

		int result = memberService.idCheck(memberId);

		if(result != 0) {

			return RESPONSE_CONFLICT;	// 중복 아이디 o

		} else {

			return RESPONSE_OK;	// 중복 아이디 x

		}

	} // memberIdChkPOST() 종료

	//로그인 페이지 이동
	@GetMapping("/login")
	public void joinGET() {

		log.info("로그인 페이지 진입");

	}

	/* 로그인 */
	@PostMapping("/login")
	public String loginPOST(@Valid @ModelAttribute MemberLoginParam param, BindingResult bindingResult, HttpServletRequest request) throws Exception {

		Member loginMember = loginService.memberLogin(param);

		//--------로그인 실패 시----------
		//바인딩 에러
		if (bindingResult.hasErrors()) {
			return "1";
		}

		//loginMember를 찾을 수 없을 때
		if (loginMember == null) {
			bindingResult.reject("loginFail", "로그인에 실패했습니다. 아이디 또는 비밀번호를 확인해 주세요.");
			return "2";
		}

		//--------로그인 성공 시--------
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
		return "3";

	}





    // session을 제거해서 로그아웃
   	@PostMapping("/logout")
    public ResponseEntity<Void> logoutMainGET(HttpServletRequest request){

        HttpSession session = request.getSession();

        session.invalidate();

		return RESPONSE_OK;

    }


}
