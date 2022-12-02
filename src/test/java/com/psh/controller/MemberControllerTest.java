package com.psh.controller;

import com.psh.model.member.Member;
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

    @Test
    public void joinTest(){
        Member member = new Member();
        member.setMemberId("test4");
        member.setPassword("1234a");
        member.setName("park");
        member.setEmail("test2@test.com");
        member.setAddress("city2");

        memberService.memberJoin(member);
    }

}