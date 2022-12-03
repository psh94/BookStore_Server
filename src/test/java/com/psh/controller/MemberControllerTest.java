package com.psh.controller;

import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
import com.psh.model.member.MemberLoginParam;
import com.psh.service.LoginService;
import com.psh.service.MemberService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberControllerTest{

    @Autowired
    private MemberService memberService;

    @Autowired
    private LoginService loginService;

//    @Test
//    public void joinTest(){
//        Member member = new Member();
//        member.setMemberId("test5");
//        member.setPassword("1234a");
//        member.setName("park");
//        member.setEmail("test2@test.com");
//        member.setAddress("city2");
//
//        memberService.memberJoin(member);
//    }

    // 회원가입 성공
    @Test
    public void joinTestWhenSuccess(){
        MemberJoinParam param = new MemberJoinParam();
        param.setMemberId("test7");
        param.setPassword("1234aa");
        param.setName("lee");
        param.setEmail("test2@test.com");
        param.setAddress("city2");

        memberService.memberJoin(param);
    }

    // 회원가입 실패 (password가 @NotBlank)
    @Test
    public void joinTestWhenFailBecauseParamIsNotValid(){
        MemberJoinParam param = new MemberJoinParam();
        param.setMemberId("test7");
        param.setPassword("");
        param.setName("lee");
        param.setEmail("test2@test.com");
        param.setAddress("city2");

        memberService.memberJoin(param);
    }

    @Test
    public void memberIdChk(){
        String isExistId = "test";
        String  notExistId= "aaa";

        memberService.idCheck(isExistId); // 결과값 : 1
        memberService.idCheck(notExistId); // 결과값 : 0

    }

    @Test
    public void loginTest(){

        MemberLoginParam param = new MemberLoginParam();
        param.setMemberId("test");
        param.setPassword("test");

        Member member = loginService.memberLogin(param);

        if(param.getMemberId().equals(member.getMemberId()) &&
                param.getPassword().equals(member.getPassword()))
            System.out.println("로그인 성공");


    }

}