package com.web.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Course;
import com.web.study.domain.entity.Lecture;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.CourseRespDto;
import com.web.study.dto.response.LectureRespDto;
import com.web.study.repository.CourseRepository;
import com.web.study.repository.LectureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
	
	private final LectureRepository lectureRepository;
	
	@Override
	public void registerLecture(LectureReqDto lectureReqDto) {
		// DTO -> ENTITY 변환
		Lecture lecture = lectureReqDto.toEntity();
		System.out.println("변환: " + lecture);
		lectureRepository.registe(lecture);
	}

	@Override
	public List<LectureRespDto> getLectureAll() {
		List<LectureRespDto> dtos = new ArrayList<>();
		lectureRepository.getLectureAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		return dtos;
	}

	@Override
	public LectureRespDto findLectureById(int id) {
		return lectureRepository.findLectureById(id).toDto();
	}

	@Override
	public List<LectureRespDto> searchLecture(int type, String searchValue) {
		Map<String, Object> paramterMap = new HashMap<>();
		paramterMap.put("type", type);
		paramterMap.put("searchValue", searchValue);
		
		List<LectureRespDto> dtos = new ArrayList<>();
		lectureRepository.searchLecture(paramterMap).forEach(entity -> {
			dtos.add(entity.toDto());
		});
		return dtos;
	}


	
	
}
