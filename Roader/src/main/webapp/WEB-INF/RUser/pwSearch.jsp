<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<input name="ruserId">아이디를 입력하세요.<br>
	<input name="ruserEmail">이메일을 입력하세요.
	<input type="submit" formaction="/pwc" formmethod="post" id="getPwBtn" value="이메일 전송">
</form>
</body>
</html>