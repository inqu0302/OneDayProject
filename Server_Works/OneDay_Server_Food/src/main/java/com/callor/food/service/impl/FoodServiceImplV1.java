package com.callor.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.food.model.FoodDTO;
import com.callor.food.persistenece.DBContract;
import com.callor.food.persistenece.DBInfo;
import com.callor.food.service.FoodService;

public class FoodServiceImplV1 implements FoodService{

	protected Connection dbConn;
	
	public FoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}

	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException{
		
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		ResultSet rSet = pStr.executeQuery();
		
		while(rSet.next()) {
			
			FoodDTO foodDTO = new FoodDTO();
			foodDTO.setFd_code(rSet.getString(DBInfo.FOOD.fd_code));
			foodDTO.setFd_name(rSet.getString(DBInfo.FOOD.fd_name));
			foodDTO.setFd_year(rSet.getString(DBInfo.FOOD.fd_year));
			foodDTO.setCp_name(rSet.getString(DBInfo.FOOD.cp_name));
			foodDTO.setIt_name(rSet.getString(DBInfo.FOOD.it_name));
			foodDTO.setFd_ssize(rSet.getInt(DBInfo.FOOD.fd_ssize));
			foodDTO.setFd_gram(rSet.getInt(DBInfo.FOOD.fd_ssize));
			foodDTO.setFd_kcal(rSet.getInt(DBInfo.FOOD.fd_kcal));
			foodDTO.setFd_protein(rSet.getInt(DBInfo.FOOD.fd_protein));
			foodDTO.setFd_fat(rSet.getInt(DBInfo.FOOD.fd_fat));
			foodDTO.setFd_carbohydrate(rSet.getInt(DBInfo.FOOD.fd_carbohydrate));
			foodDTO.setFd_sugar(rSet.getInt(DBInfo.FOOD.fd_sugar));
			foodList.add(foodDTO);
		}
		rSet.close();
		return foodList;
		
	}
	@Override
	public List<FoodDTO> selectAll() {
		String sql = " SELECT * FROM view_식품정보 ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> foodList = this.select(pStr);
			pStr.close();
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 명령문 오류");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public FoodDTO findByID(String fd_code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodDTO> findBytitle(String fd_name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
