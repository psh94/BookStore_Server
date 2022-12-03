package com.psh.service;

import com.psh.model.member.Member;
import com.psh.model.member.MemberLoginParam;
import org.apache.ibatis.annotations.Mapper;

public interface LoginService {

    /* 로그인 */
    public Member memberLogin(MemberLoginParam param);
}
