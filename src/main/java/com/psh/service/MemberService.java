package com.psh.service;

import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;

public interface MemberService {

    /* 회원가입 */
    public void memberJoin(MemberJoinParam param);

    /* 아이디 중복 검사 */
    public int idCheck(String memberId);


    /* 주문자 주소 정보 */
    public Member getMemberInfo(String memberId);
}
