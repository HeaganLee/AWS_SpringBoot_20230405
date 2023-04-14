package com.web.study.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Authority;
import com.web.study.domain.entity.User;
import com.web.study.dto.request.LoginReqDto;
import com.web.study.dto.request.auth.RegisteUserReqDto;
import com.web.study.dto.response.auth.JwtTokenRespDto;
import com.web.study.exception.CustomException;
import com.web.study.repository.UserRepository;
import com.web.study.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final JwtTokenProvider jwtTokenProvider;
	
	@Override
	public void registeUser(RegisteUserReqDto registeUserReqDto) {
		User userEntity = registeUserReqDto.toEntity();
		
		userRepository.saveUser(userEntity);
		
		List<Authority> authorities = new ArrayList<>();
		authorities.add(Authority.builder().user_id(userEntity.getUser_id()).role_id(1).build());
		
		userRepository.addAuthorities(authorities);
	}
	
	@Override
	public void duplicatedUsername(RegisteUserReqDto registeUserReqDto) {
		User userEntity = userRepository.findUserByUsername(registeUserReqDto.getUsername());
		
		if(userEntity != null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("username", "이미사용중인 사용자이름입니다.");
			
			throw new CustomException("중복 검사 오류", errorMap);
		}
		
		
	}
	
	// AuthService를 Override를 한 login 메소드 이다. 
	@Override
	public JwtTokenRespDto login(LoginReqDto loginReqDto) {
		// UsernamePasswordAuthenticationToken은 스프링 시큐리어티 프레임워크 입니다.
		// 클라이언트가 요청을 보낸 아이디와 비밀번호를 인증 처리 할때
		// UsernamePasswordAuthenticationToken 객체를 생성하여 사용자가 입력한 인증 정보를 담아서 인증 매니저(AuthenticationManager)에게 전달합니다.
		
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(loginReqDto.getUsername(), loginReqDto.getPassword());
		
		// 인증이 성공하면 Authentication 객체로 반환됩니다. 
		// UserDetailsService의 loadUserByUsername() 호출이 된다.!!!!
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		
		// authentication에 저장된 정보를 JwtTokenProvider로 보냄
		return jwtTokenProvider.creatToken(authentication);
	}

}
