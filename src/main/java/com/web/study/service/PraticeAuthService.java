package com.web.study.service;

import com.web.study.dto.request.LoginReqDto;
import com.web.study.dto.request.pratice_auth.PraticeRegisteUserReqDto;
import com.web.study.dto.response.auth.JwtTokenRespDto;

public interface PraticeAuthService {
	
	public void registeUser(PraticeRegisteUserReqDto praticeRegisteUserReqDto);
	public void duplicatedUsername(PraticeRegisteUserReqDto praticeRegisteUserReqDto);
	
	public JwtTokenRespDto login(LoginReqDto loginReqDto);

}
