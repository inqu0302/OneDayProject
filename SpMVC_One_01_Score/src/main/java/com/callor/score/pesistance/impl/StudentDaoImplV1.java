package com.callor.score.pesistance.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.callor.score.model.StudentDTO;
import com.callor.score.model.StudentVO;
import com.callor.score.pesistance.StudentDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("StudentDaoV1")
public class StudentDaoImplV1 implements StudentDAO<StudentVO, String> {

	@Override
	public List<StudentDTO> selectAll() {
		return null;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String st_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StudentVO> findbyNum(String st_num) {
		// TODO Auto-generated method stub
		return null;
	}

}
