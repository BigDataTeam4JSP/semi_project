<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl 사용을 위한 페이지 속성 추가--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
		* ----------------------------------------
		 *  Description : admin 계정으로 로그인 했을 시 출력 되는 페이지
		 				  aProductListCommand 에서 전달 받은 상품 정보 데이터들을 화면에 출력다.
		 				  상품 코드를 클릭시 해당 상품 코드가 aProductDetail.do 에 전달되어 해당 상품의 상세 페이지로 넘어간다.
		 				  사진 등록 클릭시 같은 줄에 있는 상품 코드가 imageUpdate_view.do에 전달되어 해당 상품의 사진을 등록할 수 있는 페이지로 넘어간다.
		 *  Date        : 2024.01.26
		 *  Author      : 김소리
		 * ----------------------------------------
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Product List Page</title>
<%-- 부트스트랩을 사용하기 위해 링크 추가 --%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
	
</head>
<body>
	<c:import url="admin_head.jsp" />
	<br>
	<div class="container text-center">
		<%-- Added text-center class for centering --%>
		<p class="display-1">상품 목록</p>
		<div class="text-end mb-2">
			<form action="aProductInsert_view.do" method="post">
				<input type="submit" value="글쓰기" class="btn btn-outline-secondary">
			</form>
		</div>
		<table class="table table-hover">
			<tr>
				<th>상품코드</th>
				<th>상품명</th>
				<th>색상</th>
				<th>가격</th>
				<th>사진등록</th>
			</tr>
			<%-- 반복문을 사용하여 list arraylist에 담긴 정보들 순차대로 출력  --%>
			<c:forEach items="${list}" var="item">
				<tr>
					<%--하이퍼 링크로 aProductDetail.do에 상품코드 전송 --%>
					<td><a href="aProductDetail.do?pId=${item.pId}">${item.pId}</a></td>
					<td>${item.pName}</td>
					<td>${item.pColor}</td>
					<td>${item.pPrice}</td>
					<%--하이퍼 링크로 imageUpdate_view.do에 상품코드 전송 --%>
					<td><a href="imageUpdate_view.do?pId=${item.pId}">사진등록</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
