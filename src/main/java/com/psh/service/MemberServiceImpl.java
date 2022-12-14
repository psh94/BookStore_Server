package com.psh.service;

import com.psh.exception.LoginParamException;
import com.psh.mapper.MemberMapper;
import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
import com.psh.model.member.MemberUpdateParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;

	@Override
	public void memberJoin(MemberJoinParam param) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encryptedPassword = passwordEncoder.encode(param.getPassword());
		param.setPassword(encryptedPassword);
		memberMapper.memberJoin(param);
	}

	@Override
	public boolean isExistMemberId(String memberId) {
		return memberMapper.isExistMemberId(memberId);

	}

	@Override
	public void memberUpdate(MemberUpdateParam param) {
		memberMapper.memberUpdate(param);
	}

	@Override
	public void memberDelete(Member member) {
		if(member.getMemberId() == null || member.getPassword() == null){
			throw new LoginParamException("아이디 또는 비밀번호를 입력하지 않았습니다.");
		}
		memberMapper.memberDelete(member);
	}

	@Override
	public Member getMemberInfo(String memberId) {
		return memberMapper.getMemberInfo(memberId);
	}
}
