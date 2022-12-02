package com.psh.controller;

import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
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

    @Test
    public void joinTest(){
        MemberJoinParam param = new MemberJoinParam();
        param.setMemberId("test7");
        param.setPassword("1234aa");
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

}