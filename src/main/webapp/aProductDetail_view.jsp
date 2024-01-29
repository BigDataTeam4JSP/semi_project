<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="text-center">
    <div class="container">
        <p class="display-1">상품 디테일</p>
        <img src="${pageContext.request.contextPath}/img/superstar_white.jpeg" class="img-fluid" alt="상품 이미지" style="width: 500px; height: 500px;"><br><br>
        <p>상품명 : <%=session.getAttribute("NAME") %></p><br>
        <p>색상 : <%=session.getAttribute("COLOR") %></p><br>
        <p>가격 : <%=session.getAttribute("PRICE") %></p><br><br>

        <%session.invalidate(); %>
        
        <form action ="aProcuctUpdate.do" method="post">
        <table class="table table-striped table-s">
            <tr>
                <th>사이즈</th>
                <th>재고</th>
            </tr>
            <c:forEach items="${spec}" var="spec">
                <tr>
                    <td>${spec.pSize}</td>
                    <td><input type="text" name="Qty" value="${spec.pQty}"></td>
                </tr>
            </c:forEach>
            <tr>
            	<td colspan="2"><input type="submit" value="수정하기"></td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>
