<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var="dto" value="${detailSession }" />
<html lang="en">
<head>
<meta charset="UTF-8">
<title>물품 상세보기</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="head.jsp" />
<br>
	<form action="cart.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="product-image">
						<img src="${dto.pimgpath }" alt="제품 이미지" width="100%" height="100%">
					</div>
				</div>
				<div class="col-md-6">
					<div class="product-info">
						<h1 class="product-name">${dto.pname }</h1>
						<br>
						<h2 class="product-price"><fmt:formatNumber value="${dto.pprice }" groupingUsed="true" />원</h2>
						<br>
						<p class="product-description">${dto.pcontent }</p>
						<br>
						<table class="table product-specs">
							<tbody>
								<tr style="height:65px">
									<td>색상</td>
									<td>${dto.pcolor }</td>
								</tr>
							</tbody>
							<tbody>
								<tr>
									<td>사이즈</td>
									<td><select class="form-control" name="size" style="width: 110px">
											<option value="230">230mm</option>
											<option value="240">240mm</option>
											<option value="250">250mm</option>
											<option value="260">260mm</option>
											<option value="270">270mm</option>
									</select></td>
								</tr>
							</tbody>
							<tbody>
								<tr>
									<td>수량</td>
									<td><select class="form-control" name="qty" style="width: 65px">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
									</select></td>
								</tr>
							</tbody>
						</table>
						<div class="product-button">
							<button type="submit" class="btn btn-primary">구매하기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
