package com.callor.food.service;

import java.util.List;

import com.callor.food.model.EatVO;
import com.callor.food.model.FoodDTO;

public interface EatService {

	public List<FoodDTO> selectAll();
	
	public List<FoodDTO> findByDate(String date);
	
	public int insert(EatVO eatVO);
	public int update(EatVO eatVO);
	public int delete(EatVO eatVO);
}
