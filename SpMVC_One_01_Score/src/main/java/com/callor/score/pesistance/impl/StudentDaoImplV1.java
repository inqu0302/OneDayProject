package com.callor.score.pesistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.score.model.StudentDTO;
import com.callor.score.model.StudentVO;
import com.callor.score.pesistance.StudentDAO;

@Repository("authorV1`")
public class StudentDaoImplV1 implements StudentDAO<StudentVO, String>{

	protected JdbcTemplate JdbcTemplate;
	
	public StudentDaoImplV1(JdbcTemplate JdbcTemplate) {
		this.JdbcTemplate = JdbcTemplate;
	}
	
	@Override
	public List<StudentDTO> selectScoreAndStudent() {
		// TODO 점수랑 학생정보 전체조회
		
		String sql = " SELECT * FROM view_학생성적 ";
				
		List<StudentDTO> student = JdbcTemplate.query(sql, new BeanPropertyRowMapper<StudentDTO>(StudentDTO.class));
				
		return student;
	}
	
	@Override
	public List<StudentVO> selectStudent() {
		// TODO 학생정보 조회
		
		String sql = " SELECT * FROM tbl_student ";
		
		List<StudentVO> student = JdbcTemplate.query(sql, new BeanPropertyRowMapper<StudentVO>(StudentVO.class));
		
		return student;
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO 입력하기
		
		String sql = " INSERT INTO tbl_student ";
		sql += " (st_name, st_dept, st_grade, st_tel, st_addr) ";
		sql += " VALUES( ?, ?, ?, ?, ?) ";
		
		Object[] params = new Object[] {
				vo.getSt_name(),
				vo.getSt_dept(),
				vo.getSt_grade(),
				vo.getSt_tel(),
				vo.getSt_addr()	
		};
		
		
		return JdbcTemplate.update(sql, params);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO 수정하기
		
		String sql = " UPDATE tbl_student SET ";
		sql += " st_num = ?, ";
		sql += " st_name = ?, ";
		sql += " st_dept = ?, ";
		sql += " st_grade = ?, ";
		sql += " st_tel = ?, ";
		sql += " st_addr = ? ";
		sql += " WHERE st_num = ? ";
				
		Object[] params = new Object[] {
						vo.getSt_num(),
						vo.getSt_name(),
						vo.getSt_dept(),
						vo.getSt_grade(),
						vo.getSt_tel(),
						vo.getSt_addr(),
						vo.getSt_num()
		};
		
		return JdbcTemplate.update(sql, params);
	}

	@Override
	public int delete(String st_num) {
		// TODO 삭제하기
		
			String sql = " DELETE FROM tbl_student ";
			sql += " WHERE sc_stNum = ? ";
				
			Object[] params = new Object[] {st_num};
				
			return JdbcTemplate.update(sql, params);
				
	}
	
	@Override
	public List<StudentVO> findbyNum(String st_num) {
		// TODO 학번으로 조회하기
		
		String sql = " SELECT * FROM tbl_student ";
		sql += " WHERE st_num = ? ";
				
		Object[] params = new Object[] {st_num};
				
		List<StudentVO> student = JdbcTemplate.query(sql, params, new BeanPropertyRowMapper<StudentVO>());
				
		return student;
	}

}
