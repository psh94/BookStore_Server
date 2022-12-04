package com.psh.service;

import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
import com.psh.model.member.MemberLoginParam;
import com.psh.model.member.MemberUpdateParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberServiceTests{

    @Autowired
    private MemberService memberService;

    @Autowired
    private LoginService loginService;

    // 회원가입 성공
    @Test
    public void joinTestWhenSuccess(){
        MemberJoinParam param = new MemberJoinParam();
        param.setMemberId("test");
        param.setPassword("1234aa");
        param.setName("lee");
        param.setEmail("test2@test.com");
        param.setAddress("city2");

        memberService.memberJoin(param);
    }

    // 회원가입 실패 (Bean Validation)
    @Test
    public void joinTestWhenFail(){
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
        String existId = "test2";
        String notExistId= "aaa";

        memberService.isExistMemberId(existId); // 결과값 : true
        memberService.isExistMemberId(notExistId); // 결과값 : false

    }

    @Test
    public void UpdateMemberTest(){
        MemberUpdateParam memberUpdateParam = new MemberUpdateParam();
        //memberId가 test인 경우
        memberUpdateParam.setMemberId("test");
        memberUpdateParam.setPassword("abcd");
        memberUpdateParam.setEmail("abcd@test.com");
        memberUpdateParam.setAddress("seoul");

        memberService.memberUpdate(memberUpdateParam);
    }

    @Test
    public void loginTest(){

        MemberLoginParam param = new MemberLoginParam();
        param.setMemberId("test");
        param.setPassword("abcd");

        Member member = loginService.memberLogin(param);

        if(param.getMemberId().equals(member.getMemberId()) &&
                param.getPassword().equals(member.getPassword()))
            System.out.println("로그인 성공");

    }


    @Test
    public void DeleteMemberTest(){
        Member member = new Member();
        member.setMemberId("test");
        member.setPassword("abcd");

        memberService.memberDelete(member);
    }



}