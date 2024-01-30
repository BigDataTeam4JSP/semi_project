<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
/*
* ---------------------------------------
*  Description : 상품 목록조회 
*  Date        : 2024.1.30
*  Author      : TaewooKi
* ----------------------------------------
*/
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>상품 목록</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<c:import url="head.jsp" />
<div class="container"> 
  <h1 class="mt-2">상품목록</h1>
  <div class="row">
    <c:forEach items="${list}" var="product">
      <div class="col-md-4">
        <div class="card">
       	 <a href="detail.do?pId=${product.pId}">
          <img src="img/${product.pImgPath }" class="card-img-top" alt="상품 이미지">
          </a>
          <div class="card-body">          
            <h5 class="card-title">${product.pName}</h5>                 
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>
