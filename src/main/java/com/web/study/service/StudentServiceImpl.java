package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Student;
import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.dto.response.StudentRespDto;
import com.web.study.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	
	// final => 상수: 초기화가 무조건 일어나야함.
	private final StudentRepository studentRepository;

	@Override
	public void registeStudent(StudentReqDto studentReqDto) {
		System.out.println(studentReqDto);
		Student student = studentReqDto.toEntity();
		studentRepository.saveStudent(student);
	}

	@Override
	public List<StudentRespDto> getStudentAll() {
		List<StudentRespDto> dtos = new ArrayList<>();
		studentRepository.getStudentAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		return dtos;
	}

	@Override
	public StudentRespDto findStudentById(int id) {
		return studentRepository.findStudentById(id).toDto();
	}
	
	
}
