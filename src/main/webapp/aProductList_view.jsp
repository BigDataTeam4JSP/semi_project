<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1>
	<table border=1>
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>색상</th>
			<th>가격</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td><a href="aProductDetail.do?pId=${list.pId}">${list.pId}</a></td>
				<td>${list.pName}</td>
				<td>${list.pColor}</td>
				<td>${list.pPrice}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
