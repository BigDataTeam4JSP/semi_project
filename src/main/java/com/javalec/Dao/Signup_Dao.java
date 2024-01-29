package com.javalec.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Signup_Dao {
	// Field
	DataSource dataSource;
	
	// Constructor
	public Signup_Dao() {
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
	public boolean checkID(String id) {
				Connection conn = null;
				PreparedStatement ps = null;	
				ResultSet rs = null;
				
				try {
					conn = dataSource.getConnection();	// DB연결. 
					
					String query = "SELECT id FROM member ";
					String where = " WHERE id = '" + id +"'";
					
					ps = conn.prepareStatement(query+where);
					rs = ps.executeQuery();

					if(rs.next()) {
						return false;
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
				return true;
	}//checkID()
	
	// 회원가입시 아이디 중복체크 후 바로 입력.
	public boolean insertID(String id) {
		Connection conn = null;
		PreparedStatement ps = null;	// 보안상 좋아용~~~
		
		try {
			conn = dataSource.getConnection();	// DB연결. 
			
			String query = "INSERT INTO member (id) VALUES (?)";
			
			ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {	// try끝난 경우와 에러걸려서 catch로 간 경우 어떤 경우에도 실행됩니다. 보통 메모리 정리하는 용도로 사용.
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}//insertID()
	
	// 입력된 아이디에 나머지 정보 추가.
	public void updateID(String id, String pw, String name, String tel) {
		Connection conn = null;
		PreparedStatement ps = null;	// 보안상 좋아용~~~

		try {
			conn = dataSource.getConnection();	// DB연결. 
			
			String query = "UPDATE member SET pw = ?, tel = ?, name = ? ";
			String where = " WHERE bid = ? ";
			
			ps = conn.prepareStatement(query+where);
			
			ps.setString(1, pw);
			ps.setString(2, tel);
			ps.setString(3, name);
			ps.setString(4, id);
			
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {	// try끝난 경우와 에러걸려서 catch로 간 경우 어떤 경우에도 실행됩니다. 보통 메모리 정리하는 용도로 사용.
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//updateID()
	
}
