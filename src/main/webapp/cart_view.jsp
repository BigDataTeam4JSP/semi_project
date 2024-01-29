<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var="dto" value="${detailSession }" />
<html lang="en">
<head>
<meta charset="UTF-8">
<title>구매상품 확인</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="head.jsp" />
<br>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<img src="${dto.pimgpath }" class="img-fluid" alt="이미지">
			</div>
			<div class="col-md-6">
				<h3>${dto.pname }</h3>
				<p>${dto.pcontent }</p>
				<ul class="list-group">
					<li class="list-group-item"><strong class="text-right">색상 &nbsp;&nbsp;:</strong>
						${dto.pcolor }</li>
					<li class="list-group-item"><strong class="text-right">사이즈 :</strong>
						${size }</li>
					<li class="list-group-item"><strong class="text-right">가격 &nbsp;&nbsp;:</strong>
						<fmt:formatNumber value="${dto.pprice }" groupingUsed="true" />원
					<li class="list-group-item"><strong class="text-right">수량 &nbsp;&nbsp;:</strong>
						${qty }</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-12 mt-2">
				<a href="purchaseList.do" class="btn btn-primary float-right">구매확정</a>
			</div>
		</div>
	</div>
</body>
</html>
