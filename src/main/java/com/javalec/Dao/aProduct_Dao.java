package com.javalec.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.Dto.aProduct_Dto;

public class aProduct_Dao {
	
	// Field
		DataSource dataSource;

		// Constructor
		public aProduct_Dao() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoes");
				// lookup은 데이터를 찾는 api
				// java:com/env = Context.xml
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Method

		// (Read)상품 리스트 불러오는 메소드
		public ArrayList<aProduct_Dto> list() {

			ArrayList<aProduct_Dto> dtos = new ArrayList<aProduct_Dto>();// arraylist 생성

			// connection, preparedstatement, resultset 에 값을 미리 넣어두면 해킹당할 위험이 높음
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
				String query = "select pid, pname, pcolor, pprice from product";

				// 작성한 쿼리를 데이터 connection을 사용하여 실행
				preparedStatement = connection.prepareStatement(query);

				// 실행한 쿼리문을 resultset에 삽입
				resultset = preparedStatement.executeQuery();

				while (resultset.next()) {
					// 데이터 불러오기
					int pid = resultset.getInt("pid"); // 칼럼 이름을 넣어야함
					String pname = resultset.getString("pname"); 
					String pcolor = resultset.getString("pcolor"); 
					String pprice = resultset.getString("pprice"); 
					
					// 불러온 데이터들을 dto 객체에 추가
					aProduct_Dto dto = new aProduct_Dto(pid,pname,pcolor,pprice);

					// 데이터들이 담겨있는 dto객체를 dtos(arraylist)에 추가
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
		
		// (Read)상품 스펙 불러오는 메소드
		public ArrayList<aProduct_Dto> spec(int pid) { // aProductDetail에 쓰일 데이터 read하기

			ArrayList<aProduct_Dto> dtos = new ArrayList<aProduct_Dto>();

			// connection, preparedstatement, resultset 에 값을 미리 넣어두면 해킹당할 위험이 높음
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
				String query1 = "select p.pname, p.pcolor, p.pprice, p.pcontent, s.psize, s.pqty ";
				String query2 = "from product as p, spec as s ";
				String query3 = "where p.pid = s.pid and p.pid =" + pid;

				// 작성한 쿼리를 데이터 connection을 사용하여 실행
				preparedStatement = connection.prepareStatement(query1+query2+query3);

				// 실행한 쿼리문을 resultset에 삽입
				resultset = preparedStatement.executeQuery();

				while (resultset.next()) {
					// 데이터 불러오기
					String pname = resultset.getString("pname"); 
					String pcolor = resultset.getString("pcolor"); 
					String pprice = resultset.getString("pprice"); 
					String pcontent = resultset.getString("pcontent"); 
					int psize = resultset.getInt("psize");
					int pqty = resultset.getInt("pqty");
					
					// 불러온 데이터들을 dto 객체에 추가
					aProduct_Dto dto = new aProduct_Dto(pid,pname,pcolor,pprice,pcontent,psize,pqty);
					
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
		
		// (Create)상품 등록하는 메소드
		// aProductInsert_view에서 상품명,상품색상,상품가격,상품정보를 입력받아옴
		public void insertProduct(String pName, String pColor, String pPrice,String pContent) {

			// connection, preparedstatement, resultset 에 값을 미리 넣어두면 해킹당할 위험이 높음
			// Connection 인터페이스는 데이터베이스와의 연결
			// PreparedStatement 인터페이스는 SQL 쿼리를 실행하기 위한 객체
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				// data 베이스 연결
				connection = dataSource.getConnection();
				// 쿼리 작성
				String query = "insert into product(pname, pcolor, pprice , pcontent) values(?,?,?,?)";

				// 작성한 쿼리를 데이터 connection을 사용하여 실행
				preparedStatement = connection.prepareStatement(query);

				// ?에 값 넣어주기
				preparedStatement.setString(1, pName);
				preparedStatement.setString(2, pColor);
				preparedStatement.setString(3, pPrice);
				preparedStatement.setString(4, pContent);

				// 실행
				preparedStatement.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
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
		}
		
		// (Create)새 상품 등록 시 등록한 상품의 재고를 0개로 초기화시켜주는 메소드
		// 상품 등록과 동시에 실행될 메소드라 상품의 아이디를 불러오기 어려움
		// 때문에 등록한 상품의 이름, 색상, 가격의 정보를 사용하여 상품의 아이디를 찾음
		public void insertSpec(String pName, String pColor, String pPrice) {

			// connection, preparedstatement, resultset 에 값을 미리 넣어두면 해킹당할 위험이 높음
			// Connection 인터페이스는 데이터베이스와의 연결
			// PreparedStatement 인터페이스는 SQL 쿼리를 실행하기 위한 객체
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				// data 베이스 연결
				connection = dataSource.getConnection();
				// 쿼리 작성
				String query = "INSERT INTO spec (pid, psize, pqty) "
                        + "SELECT pid, psize_range.psize, 0 "
                        + "FROM product "
                        + "CROSS JOIN ( "
                        + "    SELECT 230 AS psize "
                        + "    UNION SELECT 240 "
                        + "    UNION SELECT 250 "
                        + "    UNION SELECT 260 "
                        + ") AS psize_range "
                        + "WHERE pname = ? AND pcolor = ? AND pprice = ?";


				// 작성한 쿼리를 데이터 connection을 사용하여 실행
				preparedStatement = connection.prepareStatement(query);

				// ?에 값 넣어주기
				preparedStatement.setString(1, pName);
				preparedStatement.setString(2, pColor);
				preparedStatement.setString(3, pPrice);

				// 실행
				preparedStatement.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
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
		}
		
		// (Update)재고 수정하는 메소드
		public void update(int pid, int psize, int pqty) {

			// connection, preparedstatement, resultset 에 값을 미리 넣어두면 해킹당할 위험이 높음
			// Connection 인터페이스는 데이터베이스와의 연결
			// PreparedStatement 인터페이스는 SQL 쿼리를 실행하기 위한 객체
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				// data 베이스 연결
				connection = dataSource.getConnection();
				// 쿼리 작성
				String query = "update spec set pqty = ? where pid = ? and psize = ?;";

				// 작성한 쿼리를 데이터 connection을 사용하여 실행
				preparedStatement = connection.prepareStatement(query);

				// ?에 값 넣어주기
				preparedStatement.setInt(1, pqty);
				preparedStatement.setInt(2, pid);
				preparedStatement.setInt(3, psize);

				// 실행
				preparedStatement.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
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
		}
		
		// (Update) 추가한 이미지 파일의 경로를 추가하는 메소드
		public void updateImg(int pid, String filepath) {

			// connection, preparedstatement, resultset 에 값을 미리 넣어두면 해킹당할 위험이 높음
			// Connection 인터페이스는 데이터베이스와의 연결
			// PreparedStatement 인터페이스는 SQL 쿼리를 실행하기 위한 객체
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				// data 베이스 연결
				connection = dataSource.getConnection();
				// 쿼리 작성
				String query = "update product set pimgpath = ? where pid = ?;";

				// 작성한 쿼리를 데이터 connection을 사용하여 실행
				preparedStatement = connection.prepareStatement(query);

				// ?에 값 넣어주기
				preparedStatement.setString(1, filepath);
				preparedStatement.setInt(2, pid);

				// 실행
				preparedStatement.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
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
		}
		
		// (Read) 저장된 이미지 파일 경로 불러오는 메소드
		public aProduct_Dto imgpath(int pid) { // aProductDetail에 쓰일 데이터 read하기

			aProduct_Dto dto = new aProduct_Dto();

			// connection, preparedstatement, resultset 에 값을 미리 넣어두면 해킹당할 위험이 높음
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
				String query1 = "select pimgpath from product where pid = "+pid;

				// 작성한 쿼리를 데이터 connection을 사용하여 실행
				preparedStatement = connection.prepareStatement(query1);

				// 실행한 쿼리문을 resultset에 삽입
				resultset = preparedStatement.executeQuery();

				while (resultset.next()) {
					// 데이터 불러오기
					String pimgpath = resultset.getString("pimgpath"); 
					
					// 불러온 데이터들을 dto 객체에 추가
					dto = new aProduct_Dto(pid,pimgpath);
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
		}
		
		
		
		
}
