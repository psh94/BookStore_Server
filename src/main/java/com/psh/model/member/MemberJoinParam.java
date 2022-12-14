package com.psh.model.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class MemberJoinParam {

	@NotBlank(message = "아이디를 입력하시오.")
	private String memberId;

	@NotBlank(message = "비밀번호를 입력하시오.")
	private String password;

	@NotBlank(message = "이름를 입력하시오.")
	private String name;

	@NotBlank(message = "이메일를 입력하시오.")
	private String email;

	@NotBlank(message = "주소를 입력하시오.")
	private String address;

	// 관리자 구분 키 (0은 일반 고객, 1은 관리자)
	@NotNull
	private int adminCk;
	
	//등록일자
	@NotNull
	private int regDate;
	
	//회원 계정에 있는 금액
	private int money;
	
	//회원 포인트
	private int point;
}
