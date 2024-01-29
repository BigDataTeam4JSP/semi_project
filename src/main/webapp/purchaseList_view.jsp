<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>내구매내역</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
 <c:import url="head.jsp" />
<div class="container">
  
  <h1 class="mt-2">내구매내역</h1>

  <table class="table table-bordered">
    <thead>
      <tr>
        <th class="text-center">구매자</th>
        <th class="text-center">물품</th>
        <th class="text-center">색깔</th>
        <th class="text-center">사이즈</th>
        <th class="text-center">수량</th>
        <th class="text-center">날짜</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${pList}" var="purchase">
        <tr>
          <td class="text-center">${purchase.mId}</td>
          <td class="text-center">${purchase.pName}</td>
          <td class="text-center">${purchase.pColor}</td>
          <td class="text-center">${purchase.cSize}</td>
          <td class="text-center">${purchase.pQty}</td>
          <td class="text-center">${purchase.pDate}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <div class="mt-3 text-center">
    <a href="productList.do">돌아가기</a>
  </div>
</div>

</body>
</html>
