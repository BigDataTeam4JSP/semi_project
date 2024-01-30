									package com.javalec.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.Dto.aProduct_Dto;
import com.javalec.Dto.purchaseList_Dto;

public class purchaseList_Dao {
	
	//Field
	DataSource dataSource;	
	
	// Constructor
	public purchaseList_Dao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoes");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	
	public ArrayList<purchaseList_Dto> spec(String mid) { //데이터 일기

		ArrayList<purchaseList_Dto> dtos = new ArrayList<purchaseList_Dto>();
		
		// Connection 인터페이스는 데이터베이스와의 연결
		// PreparedStatement 인터페이스는 SQL 쿼리를 실행하기 위한 객체
		// ResultSet 인터페이스는 데이터베이스에서 가져온 쿼리 결과
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;

		try {
			// data 베이스 연결
			connection = dataSource.getConnection();
			// 쿼리 작성
			String query1 = " SELECT d.pname, d.pcolor, c.mid, c.size, c.qty, c.date";
			String query2 = " From purchase as c, product as d";					
			String query3 = " where c.mid = ? and c.pid = d.pid";
			
						// 작성한 쿼리를 데이터 connection을 사용하여 실행
			preparedStatement = connection.prepareStatement(query1+query2+query3);
			preparedStatement.setString(1, mid);

			// 실행한 쿼리문을 resultset에 삽입
			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				// 데이터 불러오기
				String pname = resultset.getString("d.pname"); 
				String pcolor = resultset.getString("d.pcolor"); 
				String cmid = resultset.getString("c.mid"); 
				int cpid = resultset.getInt("c.size"); 
				int qty = resultset.getInt("c.qty");
				String date = resultset.getString("c.date");
				
				// 불러온 데이터들을 dto 객체에 추가
				purchaseList_Dto dto = new purchaseList_Dto(pname, pcolor, cmid, cpid, qty, date);
				
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 데이터 정리하는 용도로 쓰임 (만든 순서 거꾸로 정리해야함)
			try {
				if (resultset != null) {
					resultset.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {

			}
		}
		return dtos;
	}	
	

}// end

