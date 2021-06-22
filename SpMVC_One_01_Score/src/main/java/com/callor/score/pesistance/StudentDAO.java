package com.callor.score.pesistance;

import java.util.List;

import com.callor.score.model.StudentDTO;

public interface StudentDAO<StudentVO, String> {

	public List<StudentDTO> selectScoreAndStudent();
	
	public List<StudentVO> selectStudent();
	
	public int insert(StudentVO vo);
	
	public int update(StudentVO vo);
	
	public int delete(String st_num);
	
	public List<StudentVO> findbyNum(String st_num);
	
}
