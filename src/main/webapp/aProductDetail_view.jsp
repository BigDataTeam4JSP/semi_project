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
	
	<h1>상품 디테일</h1>
	<img src=""><br>
	상품명 : <%=session.getAttribute("NAME") %><br>
	색상 : <%=session.getAttribute("COLOR") %><br>
	가격 : <%=session.getAttribute("PRICE") %><br>
	
	<%session.invalidate(); %>
	
	<table border=1>
		<tr>
			<th>사이즈</th>
			<th>재고</th>
		</tr>
		<c:forEach items="${spec}" var="spec">
			<tr>
				<td>${spec.pSize}</td>
				<td>${spec.pQty}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="aProductList.do">
		<input type="submit" value="뒤로가기">
	</form>
</body>
</html>
