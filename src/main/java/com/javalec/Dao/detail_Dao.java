package com.javalec.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.Dto.detail_Dto;

public class detail_Dao {
	
	// Field
	DataSource dataSource;

	// Constructor
	public detail_Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	// detail_view에 들어갈 dto 만들기 (select)
	public detail_Dto detail(int pid) {
		detail_Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			// data 베이스 연결
			connection = dataSource.getConnection();
			// 쿼리 작성
			String select = "SELECT p.pid ,p.pname ,p.pprice ,p.pcolor ,p.pcontent ,p.pimgpath ,s.seq ,s.psize ,s.pqty";
			String from = " FROM product as p, spec as s";
			String where = " WHERE p.pid = ? AND p.pid = s.pid ";

			// 작성한 쿼리를 데이터 connection을 사용하여 실행
			preparedStatement = connection.prepareStatement(select + from + where);
			preparedStatement.setInt(1, pid);

			// 실행한 쿼리문을 resultset에 삽입
			resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				// 데이터 불러오기
				int ppid = resultset.getInt("p.pid"); // 칼럼 이름을 넣어야함
				String ppname = resultset.getString("p.pname"); 
				int ppprice = resultset.getInt("p.pprice"); 
				String ppcolor = resultset.getString("p.pcolor");
				String ppcontent = resultset.getString("p.pcontent");
				String ppimgpath = resultset.getString("p.pimgpath");
				int sseq = resultset.getInt("s.seq");
				String spsize = resultset.getString("s.psize");
				String spqty = resultset.getString("s.pqty");
				
				// 불러온 데이터들을 dto 객체에 추가
				dto = new detail_Dto(ppid, ppname, ppprice, ppcolor, ppcontent, ppimgpath, sseq, spsize, spqty);
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

		return dto;
		
	} //detail()
	
	





















}// End
