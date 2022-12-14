package com.psh.mapper;

import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
import com.psh.model.member.MemberLoginParam;
import com.psh.model.member.MemberUpdateParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	/* 회원가입 */
	public void memberJoin(MemberJoinParam param);

	/* 아이디 중복 검사 */
	public boolean isExistMemberId(String memberId);

	/* 회원 정보 수정 */
	public void memberUpdate(MemberUpdateParam param);

	/* 회원 탈퇴 */
	public void memberDelete(Member member);

	/* 로그인 */
	public Member memberLogin(MemberLoginParam param);
	
	/* 주문자 주소 정보 */
	public Member getMemberInfo(String memberId);
	
}
