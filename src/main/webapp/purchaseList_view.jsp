<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 상품목록</title>
</head>
<body>

<h1>구매 상품목록</h1>
	<table border=1>
	    <tr>
		  <th>상품ID</th>
		  <th>상품명</th>	
		  <th>날짜</th>
		
	   	</tr>
	   		<c:forEach items="${pList}" var="purchase">
		<tr>
			<td><a href="purchaseList.do?pName=${purchase.pName}">${purchase.pName}</a></td>			
			<td>${purchase.mId}</td>	
			<td>${purchase.pId}</td>
			<td>${purchase.pQty}</td>
			<td>${purchase.pDate}</td>		
		</tr>
			</c:forEach>				
	</table>
</body>
</html>