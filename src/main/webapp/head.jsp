<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
		* ----------------------------------------
		 *  Description : 사용자 헤더.
		 *  Date        : 2024.01.27- 2024.01.30
		 *  Author      : 김수진
		 * ----------------------------------------
 --%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>신발가게</title>
    <!-- 부트스트랩 CDN 링크 추가 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="productList.do">신발가게</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
			<!--    <li class="nav-item active">
                        <a class="nav-link" href="#">홈</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">상품</a>
                    </li> -->
                    <li class="nav-item">
                        <a class="nav-link" href="#">${loginID} 님 안녕하세요 !</a>
                    </li>
                    <li class="nav-item">
                         <a class="nav-link" href="logout.do"><button id="logoutBtn" class="btn btn-light ml-2">로그아웃</button></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="script.js"></script>
</body>
</html>