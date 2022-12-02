package com.psh.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psh.model.member.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {

	@Autowired
	private MemberMapper memberMapper;			//MemberMapper.java 인터페이스 의존성 주입
	
//	@Test
//	public void memberJoin() throws Exception{
//		Member member = new Member();
//
//		member.setMemberId("test");
//		member.setPassword("test");
//		member.setName("Kim");
//		member.setEmail("test@test.com");
//		member.setAddress("city");
//
//		System.out.println(member);
//
//		//패지키 설정 잘못하면 error 발생
//		memberMapper.memberJoin(member);			//쿼리 메서드 실행
//	}
//	
//
//
//	// 아이디 중복검사
//	@Test
//	public void memberIdChk() throws Exception{
//		String id = "admin";	// 존재하는 아이디
//		String id2 = "test123";	// 존재하지 않는 아이디
//		memberMapper.idCheck(id);
//		memberMapper.idCheck(id2);
//	}
//
//
//
//    /* 로그인 쿼리 mapper 메서드 테스트 */
//    @Test
//    public void memberLogin() throws Exception{
//
//        Member member = new Member();    // MemberVO 변수 선언 및 초기화
//
//        /* 올바른 아이디 비번 입력경우 */
//        member.setMemberId("test1");
//        member.setMemberPw("test1");
//
//        /* 올바른 않은 아이디 비번 입력경우 */
//        //member.setMemberId("test1123");
//        //member.setMemberPw("test1321321");
//
//        memberMapper.memberLogin(member);
//        System.out.println("결과 값 : " + memberMapper.memberLogin(member));
//
//    }
//
	
}