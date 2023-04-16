package com.web.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Authority;
import com.web.study.domain.entity.User;
import com.web.study.dto.request.LoginReqDto;
import com.web.study.dto.request.pratice_auth.PraticeRegisteUserReqDto;
import com.web.study.dto.response.auth.JwtTokenRespDto;
import com.web.study.exception.CustomException;
import com.web.study.repository.UserRepository;
import com.web.study.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PraticeAuthServiceImpl implements PraticeAuthService {
	
	private final UserRepository userRepository;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final JwtTokenProvider jwtTokenProvider;
	
	@Override
	public void registeUser(PraticeRegisteUserReqDto praticeRegisteUserReqDto) {
		User userEntity = praticeRegisteUserReqDto.toEntity();
		
		userRepository.saveUser(userEntity);
		
		List<Authority> authorities = new ArrayList<>();
		authorities.add(Authority.builder().user_id(userEntity.getUser_id()).role_id(1).build());
		
		userRepository.addAuthorities(authorities);
	}

	@Override
	public void duplicatedUsername(PraticeRegisteUserReqDto praticeRegisteUserReqDto) {
		User userEntity = userRepository.findUserByUsername(praticeRegisteUserReqDto.getUsername());
		
		if(userEntity != null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("username", "이미사용중인 사용자이름입니다.");
			
			throw new CustomException("중복 검사 오류", errorMap);
		}
		
	}

	@Override
	public JwtTokenRespDto login(LoginReqDto loginReqDto) {
		
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword());
		
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		
		return jwtTokenProvider.creatToken(authentication);
	}

	
	
}
