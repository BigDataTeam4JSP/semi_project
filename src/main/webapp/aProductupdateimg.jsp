<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl 사용을 위한 페이지 속성 추가--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
		* ----------------------------------------
		 *  Description : 상품의 사진을 등록하는 페이지
		 				  상품의 id를 받아와서 해당 상품에 사진 파일을 추가하도록 한다.
		 				  상품 등록과 동시에 진행하고 싶었으나, form을 두개를 써야하는 로직 구현이 어려워 페이지를 나누게 됨
		 *  Date        : 2024.01.29 - 2024.01.30
		 *  Author      : 김소리
		 * ----------------------------------------
 --%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Upload Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body class="text-center">

	<c:import url="admin_head.jsp" />
	<br>
	<%
	// aProductList에서 pid를 get방식으로 받아 session에 저장해줘야 aProductImgUpdateCommand에서 사용 가능함
	int pid = Integer.parseInt(request.getParameter("pId"));
	session.setAttribute("ID", pid);
	%>
	<p class="display-3">사진 등록</p>
	<br>

	<div class="container">
	<%-- 파일을 업로드 하려면 form의 enctype을 multipart/form-data로 지정해줘야함 --%>
		<form action="imageUpdate.do" method="post" enctype="multipart/form-data" class="needs-validation">
			<div class="mb-3">
			
				<label for="customFile" class="form-label">Upload</label> 
				<%-- input type을 file로 지정해줘야 파일을 받을 수 있음 --%>
				<input type="file" name="file" class="form-control" id="customFile" required>
			</div>
			<button class="btn btn-outline-secondary" type="submit">업로드</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofNtDz1v9A6srmK4G5h1QFt8U1bW2JdAEn"
		crossorigin="anonymous"></script>

</body>
</html>
