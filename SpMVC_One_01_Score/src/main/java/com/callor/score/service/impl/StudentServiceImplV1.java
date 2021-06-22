package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.model.StudentDTO;
import com.callor.score.model.StudentVO;
import com.callor.score.pesistance.StudentDAO;
import com.callor.score.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("bookServiceV1")
public class StudentServiceImplV1 implements StudentService{
	
	protected final StudentDAO studentDao;
	@Override
	public List<StudentDTO> selectScoreAndStudent() {
		// TODO 전체조회

		return studentDao.selectScoreAndStudent();
	}
	
	@Override
	public List<StudentVO> selectStudent() {
		// TODO Auto-generated method stub
		return studentDao.selectStudent();
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO 정보넣기
		
		return studentDao.insert(vo);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO 정보변경
		
		return studentDao.update(vo);
	}

	@Override
	public int delete(String st_num) {
		// TODO 정보삭제
		
		return studentDao.delete(st_num);
	}

	@Override
	public List<StudentVO> findbyNum(String st_num) {
		// TODO 학번으로 검색하기
		
		return studentDao.findbyNum(st_num);
	}

}
