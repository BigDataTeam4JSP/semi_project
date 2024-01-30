<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
		* ----------------------------------------
		 *  Description : 사용자 정보
		 *  Date        : 2024.01.27- 2024.01.30
		 *  Author      : 김수진
		 * ----------------------------------------
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 수정</title>
</head>
<body class="bg-light">
<c:import url="head.jsp" />
<!-- 
<c:import url="head.jsp" >
	<c:param name="" value=""></c:param>
</c:import>
 -->
 <div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    <h3>회원가입</h3>
                </div>
                <div class="card-body">
                    <form name="signupForm" action="signup.do" method="post">
                        <div class="mb-3">
                            <label for="id" class="form-label">아이디 :</label>
                            <input type="text" class="form-control" id="id" name="id" value="${clientId}" required>
                            <a href="javascript:checkDuplicateId()" class="btn btn-outline-secondary">중복체크</a>
                        </div>
                        <div class="mb-3">
                            <label for="pw" class="form-label">비밀번호 :</label>
                            <input type="password" class="form-control" id="pw" name="pw" required>
                        </div>
                        <div class="mb-3">
                            <label for="name" class="form-label">이름 :</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="mb-3">
                            <label for="tel" class="form-label">전화번호 :</label>
                            <input type="text" class="form-control" id="tel" name="tel" required>
                        </div>
                        <button type="button" onClick="validateForm()" class="btn btn-primary">회원가입</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js (Optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>