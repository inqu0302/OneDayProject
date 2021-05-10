package com.callor.food.service;

import java.util.List;

import com.callor.food.model.FoodDTO;

public interface FoodService {

	public List<FoodDTO> selectAll();
	
	public FoodDTO findByID(String fd_code);
	
	public List<FoodDTO> findBytitle(String fd_name);
}
