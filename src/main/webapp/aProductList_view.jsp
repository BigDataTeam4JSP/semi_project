<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container text-center"> <!-- Added text-center class for centering -->
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
	</div>
</body>
</html>
