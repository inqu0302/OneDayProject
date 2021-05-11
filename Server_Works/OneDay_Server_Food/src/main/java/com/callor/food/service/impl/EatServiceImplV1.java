package com.callor.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.food.model.EatDTO;
import com.callor.food.model.EatVO;
import com.callor.food.model.FoodDTO;
import com.callor.food.persistenece.DBContract;
import com.callor.food.persistenece.EatInfo;
import com.callor.food.service.EatService;

public class EatServiceImplV1 implements EatService {

	protected Connection dbConn;
	
	public EatServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}	
	
	protected List<EatDTO> select(PreparedStatement pStr) throws SQLException{
		
		List<EatDTO> eatList = new ArrayList<EatDTO>();
		ResultSet rSet = pStr.executeQuery();
		
		while(rSet.next()) {
					
			EatDTO eatDTO = new EatDTO();
			eatDTO.setMf_date(rSet.getString(EatInfo.EAT.mf_date));
			eatDTO.setFd_name(rSet.getString(EatInfo.EAT.fd_name));
			eatDTO.setMf_eat(rSet.getInt(EatInfo.EAT.mf_eat));
			eatDTO.setMf_kcal(rSet.getInt(EatInfo.EAT.mf_kcal));
			eatDTO.setMf_protein(rSet.getInt(EatInfo.EAT.mf_protein));
			eatDTO.setMf_fat(rSet.getInt(EatInfo.EAT.mf_fat));
			eatDTO.setMf_carbohydrate(rSet.getInt(EatInfo.EAT.mf_carbohydrate));
			eatDTO.setMf_sugar(rSet.getInt(EatInfo.EAT.mf_sugar));
			eatList.add(eatDTO);
			}
		rSet.close();
		return eatList;
		
	}
	
	@Override
	public List<EatDTO> selectAll() {
		String sql = " SELECT * FROM view_섭취정보 ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<EatDTO> eatList = this.select(pStr);
			pStr.close();
			return eatList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 명령문 오류");
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<EatDTO> findByDate(String date) {
		String sql = " SELECT * FROM view_섭취정보 ";
		sql += " WHERE 날짜 LIKE ? ";
		
		PreparedStatement pStr = null;
		
		try {
			
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, date);
			List<EatDTO> eatList = this.select(pStr);
			pStr.close();
			
			System.out.println(eatList.toString());
			
			return eatList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int insert(EatVO eatVO) {
		String sql = " INSERT INTO tbl_myfoods ";
		sql += " (mf_date, mf_code, mf_eat) ";
		sql += " VALUES ( ?, ?, ? ) ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString (1, eatVO.getMf_date());
			pStr.setString(2, eatVO.getMf_code());
			pStr.setInt(3, eatVO.getMf_eat());
			
			int result = pStr.executeUpdate();
			pStr.close();
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(EatVO eatVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(EatVO eatVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
