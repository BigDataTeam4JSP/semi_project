<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>


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
  <table class="table table-bordered">
    <thead>
      <tr>
        <th class="text-center">상품코드</th>
        <th>상품명</th>
        <th class="text-center">사진</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="product">
        <tr>
          <td class="text-center">${product.pId}</td>
          <td><a href="detail.do?pId=${product.pId}">${product.pName}</a></td>
          <td class="text-center">
            <img src="img/${product.pImgPath }" width="100" height="100">
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

</div>

</body>
</html>