<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

	<c:import url="head.jsp" />
	<br>
	<%
	int pid = Integer.parseInt(request.getParameter("pId"));
	session.setAttribute("ID", pid);
	%>
	<p class="display-3">사진 등록</p>
	<br>

	<div class="container">
		<form action="imageUpdate.do" method="post"
			enctype="multipart/form-data" class="needs-validation">
			<div class="mb-3">
				<label for="customFile" class="form-label">Upload</label> <input
					type="file" name="file" class="form-control" id="customFile" required>
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
