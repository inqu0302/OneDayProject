package com.callor.food.service;

import java.util.List;

import com.callor.food.model.EatDTO;
import com.callor.food.model.EatVO;

public interface EatService {

	public List<EatDTO> selectAll();
	
	public List<EatDTO> findByDate(String date);
	
	public int insert(EatVO eatVO);
	public int update(EatVO eatVO);
	public int delete(EatVO eatVO);
}
