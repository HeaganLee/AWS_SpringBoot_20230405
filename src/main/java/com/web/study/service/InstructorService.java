package com.web.study.service;

import java.util.List;


import com.web.study.domain.entity.Instructor;
import com.web.study.dto.request.lecturer.InstructorReqDto;
import com.web.study.dto.response.InstructorRespDto;

public interface InstructorService {
	
	public void registeInstructor(InstructorReqDto instructorReqDto);
	public List<InstructorRespDto> getInstructorAll();
	public InstructorRespDto findInstructorById(int id);

}
