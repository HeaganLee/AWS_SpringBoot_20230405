package com.web.study.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.LoginReqDto;
import com.web.study.dto.request.auth.RegisteUserReqDto;
import com.web.study.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/auth/register")
	public ResponseEntity<? extends ResponseDto> registe(@RequestBody RegisteUserReqDto registeUserReqDto) {
		authService.duplicatedUsername(registeUserReqDto);
		authService.registeUser(registeUserReqDto);
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	// 클라이언트가 요청을 보내면 LoginReqDto에서 정보를 받아서 Controller로 넘겨준다.
	@PostMapping("/auth/login")
	public ResponseEntity<? extends ResponseDto> login(@RequestBody LoginReqDto loginReqDto) {
		
		// 받은 LoginReqDto는 authService에 loginReqDto를 넘겨줌
		return ResponseEntity.ok().body(DataResponseDto.of(authService.login(loginReqDto)));
	}
}
