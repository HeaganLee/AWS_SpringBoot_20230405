package com.web.study.dto.response.auth;

import lombok.Builder;
import lombok.Data;

@Builder // 인자 순서를 생각하지 않고 객체를 생성가능
@Data  	 // Getter, Setter, EqualsAndHashCode, ToString 자동생성
public class JwtTokenRespDto {
	// OAuth2 인증 방식 중 하나인 grant_type에 해당하는 값을 저장하는 필드
	private String grantType;
	// accessToken은 JWT 토큰을 저장하는 필드
	private String accessToken;
	
}
