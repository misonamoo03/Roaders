<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.CodeVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form onsubmit="success()">
		<input type="text" value="${codeVO.secNo}"> <input
			name="ruserPw">변경할 비밀번호를 입력하세요.<br> <input
			name="ruserPwre">다시 <input type="submit"
			formaction="/changePw?secNo=${codeVO.secNo}" formmethod="post"
			id="getPwBtn" value="완료">
	</form>
</body>
<script type="text/javascript">
fuction success(){
	alert("변경완료");
	loation.href='/index';
}

</script>
</html>