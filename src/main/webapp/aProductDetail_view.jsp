<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 사용을 위한 페이지 속성 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
		* ----------------------------------------
		 *  Description : aProductList 페이지에서 상품 코드를 눌렀을 시 출력되는 상품 상세보기 페이지.
		 				  상품의 정보와 상품의 재고들을 출력한다.
		 				  이 페이지에서는 상품의 재고를 수정할 수도 있다.
		 *  Date        : 2024.01.27- 2024.01.30
		 *  Author      : 김소리
		 * ----------------------------------------
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail Page</title>
<%-- 부트 스트랩 사용을 위한 링크 추가--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="text-center">
<%-- 관리자 페이지 헤드 설정--%>
<c:import url="admin_head.jsp" />
<br>
    <div class="container">
        <p class="display-1">상품 디테일</p>
        <%-- 상품 이미지 출력--%>
        <img src="img/<%=request.getAttribute("FILEPATH") %>" alt="제품 이미지" width="600px" height="600px"><br><br>
        
        <%-- aProcuctListCommand에서 setAttribute 해준-상품정보 출력--%>
        <p>상품명 : <%=request.getAttribute("NAME") %></p><br>
        <p>색상 : <%=request.getAttribute("COLOR") %></p><br>
        <p>가격 : <%=request.getAttribute("PRICE") %></p><br>
        <p>정보 : <%=request.getAttribute("CONTENT") %></p><br><br>
        
        <%-- 재고 출력할 테이블 생성--%>
        <table class="table table-striped table-s">
            <tr>
                <th>사이즈</th>
                <th>현재 재고</th>
                <th>재고 수정</th>
            </tr>
             <%-- 재고를 arrayList로 받아오기 때문에 반복문 사용--%>
            <c:forEach items="${spec}" var="spec">
                <tr>
                	 <%-- 사이즈 별로 수정 정보를 변경하기 위해 테이블 안에 form 생성 이렇게하면 사이즈별로 form이 생성된다 --%>
       				 <form action ="aProcuctUpdate.do" method="post">
	                    <td><input type="hidden" name="psize" value="${spec.pSize}">${spec.pSize}</td>
	                    <td><input type="hidden" name="pid" value="${spec.pId}"><input type="text" name="pqty" value="${spec.pQty}"></td>
	                    <td><input type="submit" value="수정하기"></td>
       				 </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
