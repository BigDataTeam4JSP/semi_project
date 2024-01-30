package com.javalec.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.Dto.productList_Dto;


public class productList_Dao {
	
	//Field
	DataSource dataSource;
	
	//Constructor
	
	public productList_Dao() {		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	
	public ArrayList<productList_Dto> list() {
		
		ArrayList<productList_Dto> dtos = new ArrayList<productList_Dto>();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultset = null;
	 
		try {
			
			connection = dataSource.getConnection();	
			String query ="SELECT pid, pname, pimgpath FROM product";			
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				
				int pid = resultset.getInt("pid"); 
				String pname = resultset.getString("pname"); 
				String pimgpath = resultset.getString("pimgpath");
				
				productList_Dto dto = new productList_Dto(pid, pname, pimgpath);

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
	
}