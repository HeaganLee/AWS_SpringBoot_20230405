package com.web.study.service;

import com.web.study.dto.request.LoginReqDto;
import com.web.study.dto.request.auth.RegisteUserReqDto;
import com.web.study.dto.response.auth.JwtTokenRespDto;

public interface AuthService {
	
	public void registeUser(RegisteUserReqDto registeUserReqDto);
	public void duplicatedUsername(RegisteUserReqDto registeUserReqDto);
	
	// JwtTokenRespDto를 반환하는 login 메소드 이다.
	public JwtTokenRespDto login(LoginReqDto loginReqDto);
}
