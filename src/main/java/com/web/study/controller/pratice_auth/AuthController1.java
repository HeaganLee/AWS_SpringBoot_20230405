package com.web.study.controller.pratice_auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.LoginReqDto;
import com.web.study.dto.request.pratice_auth.PraticeRegisteUserReqDto;
import com.web.study.service.PraticeAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController1 {
	
	private final PraticeAuthService praticeAuthService;
	
	@PostMapping("/auth/register1")
	public ResponseEntity<? extends ResponseDto> registe(@RequestBody PraticeRegisteUserReqDto praticeRegisteUserReqDto) {
		praticeAuthService.duplicatedUsername(praticeRegisteUserReqDto);
		praticeAuthService.registeUser(praticeRegisteUserReqDto);
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	public ResponseEntity<? extends ResponseDto> login(@RequestBody LoginReqDto loginReqDto) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(praticeAuthService.login(loginReqDto)));
	}
	
}
