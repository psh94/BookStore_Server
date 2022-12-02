package com.psh.controller;

import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
import com.psh.service.MemberService;
import com.psh.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import static com.psh.utill.HttpResponses.*;

@Controller
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	//회원가입 페이지 이동
	@GetMapping("/join")
	public void loginGET() {

		log.info("회원가입 페이지 진입");

	}

	//회원가입
	@PostMapping("/join")
	@ResponseBody
	public ResponseEntity<Void> joinPOST(@Valid @ModelAttribute MemberJoinParam param) throws Exception{

		/* 회원가입 쿼리 실행 */
		memberService.memberJoin(param);

		return RESPONSE_OK;

	}

	// 아이디 중복 검사
	@PostMapping("/memberIdChk")
	public ResponseEntity<Void> memberIdChkPOST(String memberId) throws Exception{

		log.info("memberIdChk() 진입");

		int result = memberService.idCheck(memberId);

		if(result != 0) {

			return RESPONSE_CONFLICT;	// 중복 아이디 o

		} else {

			return RESPONSE_OK;	// 중복 아이디 x

		}

	} // memberIdChkPOST() 종료

//	//로그인 페이지 이동
//	@RequestMapping(value="/login", method = RequestMethod.GET)
//	public void joinGET() {
//
//		logger.info("로그인 페이지 진입");
//
//	}
//
//
//	/* 이메일 인증 */
//	@RequestMapping(value="/mailCheck", method=RequestMethod.GET)
//	@ResponseBody
//	public String mailCheckGET(String email) throws Exception{
//
//		/* 뷰(View)로부터 넘어온 데이터 확인 */
//		logger.info("이메일 데이터 전송 확인");
//		logger.info("이메일 : " + email);
//
//		/* 인증번호(난수) 생성 */
//		Random random = new Random();
//		int checkNum = random.nextInt(888888) + 111111;
//		logger.info("인증번호 " + checkNum);
//
//		/* 이메일 보내기 */
//		String setFrom = "sjinjin6@naver.com";
//		String toMail = email;
//		String title = "회원가입 인증 이메일 입니다.";
//		String content =
//				"홈페이지를 방문해주셔서 감사합니다." +
//				"<br><br>" +
//				"인증 번호는 " + checkNum + "입니다." +
//				"<br>" +
//				"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
//
//		try {
//
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
//			helper.setFrom(setFrom);
//			helper.setTo(toMail);
//			helper.setSubject(title);
//			helper.setText(content,true);
//			mailSender.send(message);
//
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//
//		String num = Integer.toString(checkNum);
//
//		return num;
//
//	}
//
//	/* 로그인 */
//	@RequestMapping(value="login.do", method=RequestMethod.POST)
//	public String loginPOST(HttpServletRequest request, Member member, RedirectAttributes rttr) throws Exception{
//
//		HttpSession session = request.getSession();
//		String rawPw = "";
//		String encodePw = "";
//
//		Member lvo = memberservice.memberLogin(member);	// 제출한아이디와 일치하는 아이디 있는지
//
//		if(lvo != null) {			// 일치하는 아이디 존재시
//
//			rawPw = member.getMemberPw();		// 사용자가 제출한 비밀번호
//			encodePw = lvo.getMemberPw();		// 데이터베이스에 저장한 인코딩된 비밀번호
//
//			if(true == pwEncoder.matches(rawPw, encodePw)) {		// 비밀번호 일치여부 판단
//
//				lvo.setMemberPw("");					// 인코딩된 비밀번호 정보 지움
//				session.setAttribute("member", lvo); 	// session에 사용자의 정보 저장
//				return "redirect:/main";		// 메인페이지 이동
//
//
//			} else {
//
//				rttr.addFlashAttribute("result", 0);
//				return "redirect:/member/login";	// 로그인 페이지로 이동
//
//			}
//
//		} else {					// 일치하는 아이디가 존재하지 않을 시 (로그인 실패)
//
//			rttr.addFlashAttribute("result", 0);
//			return "redirect:/member/login";	// 로그인 페이지로 이동
//
//		}
//
//	}
//
//
//    /* 메인페이지 로그아웃 */
//    @RequestMapping(value="logout.do", method=RequestMethod.GET)
//    public String logoutMainGET(HttpServletRequest request) throws Exception{
//
//        logger.info("logoutMainGET메서드 진입");
//
//        HttpSession session = request.getSession();
//
//        session.invalidate();
//
//        return "redirect:/main";
//
//    }
//
//	/* 비동기방식 로그아웃 메서드 */
//    @RequestMapping(value="logout.do", method=RequestMethod.POST)
//    @ResponseBody
//    public void logoutPOST(HttpServletRequest request) throws Exception{
//
//    	logger.info("비동기 로그아웃 메서드 진입");
//
//    	HttpSession session = request.getSession();
//
//    	session.invalidate();
//
//    }


}
