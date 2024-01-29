<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>로그인 화면</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
	    function validateForm() {
	        let form = document.loginForm;
	        
            // Validate ID
            let id = form.id.value.trim();
            if (id === "") {
                alert("아이디를 입력해주세요.");
                form.id.focus();
                return false;
            }

            // Validate Password
            let pw = form.pw.value.trim();
            if (pw === "") {
                alert("비밀번호를 입력해주세요.");
                form.pw.focus();
                return false;
            }
	        
	    	// Validate ID (only alphanumeric, up to 10 characters)
	        let idRegex = /^[a-zA-Z0-9]{1,10}$/;
	        if (!idRegex.test(id)) {
	            alert("아이디는 숫자와 영어로만 10자 이내로 입력해주세요.");
	            form.id.select();
	            return false;
	        }
	
	        // Validate Password (alphanumeric and special characters, up to 10 characters)
	        let pwRegex = /^[a-zA-Z0-9!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]{1,10}$/;
	        if (!pwRegex.test(pw)) {
	            alert("비밀번호는 숫자, 영어, 특수문자로 10자 이내로 입력해주세요.");
	            form.pw.select();
	            return false;
	        }

	        form.submit();
	    }
	    
	    // Server-side value passed to client-side JavaScript
        let id = "${id}";
        
        window.onload = function() {
	        // Compare the values
	        if(id != "" ){
	            alert("아이디나 패스워드가 올바르지 않습니다.");
	        }
    	}
    </script>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    <h3>로그인</h3>
                </div>
                <div class="card-body">
                    <form name="loginForm" action="login.do" method="post">
                        <div class="mb-3">
                            <label for="id" class="form-label">ID :</label>
                            <input type="text" class="form-control" id="id" name="id" value="${id}" required>
                        </div>
                        <div class="mb-3">
                            <label for="pw" class="form-label">PASSWORD :</label>
                            <input type="password" class="form-control" id="pw" name="pw" required>
                        </div>
                        <button type="button" onClick="validateForm()" class="btn btn-primary">로그인</button>
                        <a href="signupStart.do" class="btn btn-link">회원가입</a>
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
