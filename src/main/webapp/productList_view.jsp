<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>

<h1>상품목록</h1>
	<table border=1>
	    <tr>
		  <th>상품ID</th>
		  <th>상품명</th>	
		  <th>사진</th>
		
	   	</tr>
	   		<c:forEach items="${list}" var="product">
		<tr>
			<td><a href="detail.do?pId=${product.pId}">${product.pId}</a></td>			
			<td>${product.pName}</td>				
		</tr>
			</c:forEach>				
	</table>
</body>
</html>