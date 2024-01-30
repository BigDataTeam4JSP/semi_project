package com.javalec.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/* ----------------------------------------
 *  Description : 로그인 DAO
 *  Date        : 2024.01.27- 2024.01.30
 *  Author      : 김수진
 * ----------------------------------------
 */
public class Login_Dao {
	// field
	DataSource dataSource;
	
	// Constructor
	public Login_Dao() {
		// TODO Auto-generated constructor stub
		try{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/shoes"); 	//[java:comp/env]는 context.xml의 위치. [jdbc/shoes]	는 이름. 		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	//checkID
	public boolean checkLogin(String id, String pw) {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();	// DB연결. 
			
			String query = "SELECT id, pw FROM member ";
			String where = " WHERE id = '" + id +"' AND pw = '" + pw +"'";
			
			ps = conn.prepareStatement(query+where);
			rs = ps.executeQuery();

			if(rs.next()) {
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {	
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}//checkID()
	
}
