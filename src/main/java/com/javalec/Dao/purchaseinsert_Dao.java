package com.javalec.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class purchaseinsert_Dao {
	
	// Field
	DataSource dataSource;
	
	// Constructor
	public purchaseinsert_Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	// purchase table에 insert하는 method 만들기
	public boolean purchaseInsert(String mid, int pid, String qty, String size) {
		boolean result;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// data 베이스 연결
			connection = dataSource.getConnection();
			// 쿼리 작성
			String insert = "INSERT INTO purchase (mid, pid, qty, size, date)";
			String value = " VALUES (? , ?, ?, ?, now())";
			System.out.println(insert + value);

			// 작성한 쿼리를 데이터 connection을 사용하여 실행
			preparedStatement = connection.prepareStatement(insert + value);
			preparedStatement.setString(1, mid);
			preparedStatement.setInt(2, pid);
			preparedStatement.setString(3, qty);
			preparedStatement.setString(4, size);

			// 쿼리문 닫아주기
			preparedStatement.executeUpdate();
			
			result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			result = false;
			
		} finally { // 데이터 정리하는 용도로 쓰임 (만든 순서 거꾸로 정리해야함)
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {

			}
		}

		return result;
		
	} //purchaseInsert()

	// spec table에 qty를 update하는 method 만들기
	public boolean specQtyUpdate(int uqty, int pid) {
		boolean result;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// data 베이스 연결
			connection = dataSource.getConnection();
			// 쿼리 작성
			String update = "UPDATE spec SET pqty = ?";
			String where = " WHERE pid = ?";
			System.out.println(update + where);
			
			// 작성한 쿼리를 데이터 connection을 사용하여 실행
			preparedStatement = connection.prepareStatement(update + where);
			preparedStatement.setInt(1, uqty);
			preparedStatement.setInt(2, pid);
			
			// 쿼리문 닫아주기
			preparedStatement.executeUpdate();
			
			result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			result = false;
			
		} finally { // 데이터 정리하는 용도로 쓰임 (만든 순서 거꾸로 정리해야함)
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				
			}
		}
		
		return result;
		
	} //purchaseInsert()

	
	

}
