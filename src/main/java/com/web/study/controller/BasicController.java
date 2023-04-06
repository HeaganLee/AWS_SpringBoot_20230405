package com.web.study.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;


// RestController는 데이터를 응답 Controller에 ResponseBody를 가지고 있음
// Controller는 view를 리턴(View 리턴시에는 BasicRestController 보다 Controller를 사용해야 한다.)
// Controller는 view를 리턴하기 위해 만들어진 어노테이션이다. 데이터를 응답하기 위해선 ResponseBody를 함께 서야 합니다.
// 만약 데이터를 통한 서버를 구축한 경우 계속해서 ResponseBody를 같이 써야하기에 RestController를 써야 합니다.


@RestController
public class BasicController {

	@GetMapping("/view/test")
	public ResponseEntity<? extends ResponseDto> view() {
		
		List<String> strList = new ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		strList.add("e");
		
//		if(strList.contains("e")) {
//			try {
//				throw new RuntimeException("오류오류오류오류오류");
//			} catch (Exception e) {
//				return ResponseEntity.internalServerError().body(ErrorResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, e));
//			}
//			
//		}
		
		return ResponseEntity.ok().body(DataResponseDto.of(strList));
	}

}
