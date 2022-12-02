package com.psh.service;

import com.psh.model.member.Member;

public interface MemberService {

    /* 회원가입 */
    public void memberJoin(Member member);

    /* 아이디 중복 검사 */
    public int idCheck(String memberId);

    /* 로그인 */
    public Member memberLogin(Member member);

    /* 주문자 주소 정보 */
    public Member getMemberInfo(String memberId);
}
