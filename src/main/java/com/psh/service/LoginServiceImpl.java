package com.psh.service;

import com.psh.mapper.MemberMapper;
import com.psh.model.member.Member;
import com.psh.model.member.MemberLoginParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final MemberMapper memberMapper;

    @Override
    public Member memberLogin(MemberLoginParam param) {
        if (param.getMemberId() == null || param.getPassword() == null) {
            return null;
        }
        return memberMapper.memberLogin(param);
    }
}

