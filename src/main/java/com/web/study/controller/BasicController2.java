package com.web.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.MajorDto;
import com.web.study.dto.request.PresidentsInfo;
import com.web.study.dto.request.SmartPhoneDto;

@RestController
public class BasicController2 {
	
	@GetMapping("/num")
	public ResponseEntity<? extends ResponseDto> number(@RequestParam int num ) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(num));
	}
	
	@GetMapping("/num2/{num}")
	public ResponseEntity<? extends ResponseDto> number2(@PathVariable int num ) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(num));
	}
	
	@GetMapping("/president")
	public ResponseEntity<? extends ResponseDto> president(PresidentsInfo presidentsInfo){
		Map<String, String> presidentMap = new HashMap<>();
		
		presidentMap.put("name",presidentsInfo.getName());
		presidentMap.put("age",presidentsInfo.getAge());
		presidentMap.put("country",presidentsInfo.getCountry());
		
		List<String> presidentList = new ArrayList<>();
		
		presidentList.add("name: " + presidentsInfo.getName());
		presidentList.add("age: " + presidentsInfo.getAge());
		presidentList.add("country: " +  presidentsInfo.getCountry());
		
		return ResponseEntity.ok().body(DataResponseDto.of(presidentList));
	}
	
	@PostMapping("/smartphone")
	public ResponseEntity<? extends ResponseDto> smartPhone(SmartPhoneDto smartPhoneDto) {
		
		return ResponseEntity.created(null).body(DataResponseDto.of(smartPhoneDto));
	}
	
	@PostMapping("/major")
	public ResponseEntity<? extends ResponseDto> majorLeager(@RequestBody MajorDto majorDto){
		
		return ResponseEntity.created(null).body(DataResponseDto.of(majorDto));
	}
	
	
}
