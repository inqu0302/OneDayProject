package com.callor.food.persistenece;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn = null;
	
	static {
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "food";
		String password = "food";
		
		try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url, username, password);
			System.out.println("오라클 접속 성공");
		} catch (SQLException e) {
			System.out.println("오라클 DB 연결오류");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 DB Driver 없음");
			System.out.println();
		}
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
