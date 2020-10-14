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
	<input name="secCode">보안코드를 입력하세요.<br>
	<input type="submit" formaction="/insertCode" formmethod="post" id="getPwBtn" value="완료">
</form>
</body>
</html>