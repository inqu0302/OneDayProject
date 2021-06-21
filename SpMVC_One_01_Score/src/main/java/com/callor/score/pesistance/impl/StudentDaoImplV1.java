package com.callor.score.pesistance.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.callor.score.model.StudentDTO;
import com.callor.score.model.StudentVO;
import com.callor.score.pesistance.StudentDAO;
import com.callor.score.service.impl.StudentsServiceImplV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("StudentDaoV1")
public class StudentDaoImplV1 implements StudentDAO<StudentVO, String> {

	protected final StudentsServiceImplV1 studentV1;
	
	public StudentDaoImplV1(StudentsServiceImplV1 studentV1) {
		this.studentV1 = studentV1;
	}
	
	@Override
	public List<StudentDTO> selectAll() {
		
		return this.studentV1.selectAll();
	}

	@Override
	public int insert(StudentVO vo) {

		return this.studentV1.insert(vo);
	}

	@Override
	public int update(StudentVO vo) {

		return this.studentV1.update(vo);
	}

	@Override
	public int delete(String st_num) {

		return this.studentV1.delete(st_num);
	}

	@Override
	public List<StudentVO> findbyNum(String st_num) {

		return this.studentV1.findbyNum(st_num);
	}

}
