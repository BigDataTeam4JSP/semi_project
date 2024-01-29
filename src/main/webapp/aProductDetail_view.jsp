<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="text-center">
<c:import url="head.jsp" />
<br>
    <div class="container">
        <p class="display-1">상품 디테일</p>
        
        <img src="img/${sessionScope.FILEPATH}" alt="제품 이미지" width="300px" height="300px"><br><br>
        
        <p>상품명 : ${sessionScope.NAME}</p><br>
        <p>색상 : ${sessionScope.COLOR}</p><br>
        <p>가격 : ${sessionScope.PRICE}</p><br>
        <p>정보 : ${sessionScope.CONTENT}</p><br><br>

        <%session.invalidate(); %>
        
        <form action ="aProcuctUpdate.do" method="post">
        <table class="table table-striped table-s">
            <tr>
                <th>사이즈</th>
                <th>현재 재고</th>
                <th>재고 수정</th>
            </tr>
            <c:forEach items="${spec}" var="spec">
                <tr>
                    <td><input type="hidden" name="psize" value="${spec.pSize}">${spec.pSize}</td>
                    <td><input type="hidden" name="pid" value="${spec.pId}"><input type="text" name="pqty" value="${spec.pQty}"></td>
                    <td><input type="submit" value="수정하기"></td>
                </tr>
            </c:forEach>
        </table>
        </form>
    </div>
</body>
</html>
