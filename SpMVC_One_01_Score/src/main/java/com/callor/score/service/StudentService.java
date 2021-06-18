package com.callor.score.service;

import java.util.List;

import com.callor.score.model.StudentDTO;
import com.callor.score.model.StudentVO;

public interface StudentService {

	public List<StudentDTO> selectAll();
	
	public void insert(StudentVO studentVO);
	
	public void update(StudentVO studentVO);
	
	public void delet(String st_num);
	
	public List<StudentVO> findbyNum(String st_num);
	
}
