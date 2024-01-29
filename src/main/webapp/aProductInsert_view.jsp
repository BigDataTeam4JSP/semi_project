<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품 등록</h1>
	<form action="aProductInsert.do" method="post">
		상품명 : <input type="text" name="name"><br>
		색상 : <input type="text" name="color"><br>
		가격 : <input type="text" name="price"><br>
		<!-- <input type="file" name="file"><br> -->
		<input type="submit" value="전송">
	</form>	
</body>
</html>