package com.web.study.service;

import java.util.List;

import com.web.study.domain.entity.Course;
import com.web.study.domain.entity.Instructor;
import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.LectureRespDto;
import com.web.study.dto.response.InstructorRespDto;

public interface LectureService {
	
	public void registerLecture(LectureReqDto lectureReqDto);
	public List<LectureRespDto> getLectureAll();
	public List<LectureRespDto> searchLecture(int type, String searchValue);
	public LectureRespDto findLectureById(int id);
	
	
}
