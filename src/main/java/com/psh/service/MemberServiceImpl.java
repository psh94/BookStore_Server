package com.psh.service;

import com.psh.mapper.MemberMapper;
import com.psh.model.member.Member;
import com.psh.model.member.MemberJoinParam;
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
	public int idCheck(String memberId) {
		return memberMapper.idCheck(memberId);
	}

	@Override
	public Member memberLogin(Member member) {
		return memberMapper.memberLogin(member);
	}

	@Override
	public Member getMemberInfo(String memberId) {
		return memberMapper.getMemberInfo(memberId);
	}
}
