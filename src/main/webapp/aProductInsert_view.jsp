<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Insert Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="text-center">

    <c:import url="head.jsp" />
    <br>
    <p class="display-3">상품 등록</p>
    <br>

    <div class="container">
        <form action="aProductInsert.do" method="post" class="needs-validation">
            <div class="mb-3">
                <label for="productName" class="form-label visually-hidden">상품명</label>
                <input type="text" class="form-control" id="productName" name="name" placeholder="상품명" required>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofNtDz1v9A6srmK4G5h1QFt8U1bW2JdAEn" crossorigin="anonymous"></script>

</body>
</html>
