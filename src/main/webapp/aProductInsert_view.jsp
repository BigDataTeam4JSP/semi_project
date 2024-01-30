<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl 사용을 위한 페이지 속성 추가--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
		* ----------------------------------------
		 *  Description : 상품 등록하는 페이지, 해당 페이지에서는 상품명, 상품색상, 상품 가격, 상품 정보만 입력할 수 있다.
		 				  상품명은 상품명은 40자 이하의 한글, 영어, 숫자만 입력 가능하고
		 				  상품 색상은 영어로만 입력 가능하다.
		 				  상품 가격은 숫자로만 입력 가능하다.
		 				  상품 등록과 동시에 상품의 재고들이 0개로 초기화되어 데이터에 저장된다.
		 *  Date        : 2024.01.28 - 2024.01.30
		 *  Author      : 김소리
		 * ----------------------------------------
 --%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Insert Page</title>
<%-- 부트 스트랩사용을 위한 링크 추가--%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<%-- 유효성 검사 JavaScript --%>
<script type="text/javascript">
	function validateForm() {
		var productName = document.getElementById("productName").value;
		var productColor = document.getElementById("productColor").value;
		var productPrice = document.getElementById("productPrice").value;

		// 상품명 유효성 검사
		if (productName.length > 40 || !/^[a-zA-Z0-9가-힣]+$/.test(productName)) {
			alert("상품명은 40자 이하의 한글, 영어, 숫자만 입력 가능합니다.");
			return false;
		}

		// 색상 유효성 검사
		if (!/^[a-zA-Z]+$/.test(productColor)) {
			alert("색상은 영어로만 입력 가능합니다.");
			return false;
		}

		// 가격 유효성 검사
		if (!/^[0-9]+$/.test(productPrice)) {
			alert("가격은 숫자로만 입력 가능합니다.");
			return false;
		}

		return true;
	}
</script>
</head>
<body class="text-center">

	<c:import url="admin_head.jsp" />
	<br>
	<p class="display-3">상품 등록</p>
	<br>

	<div class="container">
		<%-- 상품 정보 등록하는 form 유효성 검사하기위해 onsubmit 추가--%>
		<form action="aProductInsert.do" method="post" class="needs-validation" onsubmit="return validateForm();">
			<div class="mb-3">
				<label for="productName" class="form-label visually-hidden">상품명</label>
				<input type="text" class="form-control" id="productName" name="name"placeholder="상품명" required>
			</div>
			<br>
			<div class="mb-3">
				<label for="productColor" class="form-label visually-hidden">색상</label>
				<input type="text" class="form-control" id="productColor" name="color" placeholder="색상" required>
			</div>
			<br>
			<div class="mb-3">
				<label for="productPrice" class="form-label visually-hidden">가격</label>
				<input type="text" class="form-control" id="productPrice" name="price" placeholder="가격" required>
			</div>
			<br>
			<div class="mb-3">
				<label for="productContent" class="form-label visually-hidden">정보</label>
				<input type="text" class="form-control" id="productContent" name="content" placeholder="정보" required>
			</div>
			<br>
			<button type="submit" class="btn btn-secondary">등록하기</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofNtDz1v9A6srmK4G5h1QFt8U1bW2JdAEn"
		crossorigin="anonymous"></script>

</body>
</html>
