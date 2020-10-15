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
	<form name="f1" onsubmit="return success()">
		<input type="hidden"  value="${codeVO.secNo}">
		<input type="hidden" name="orgPw" value="${RuserVO.ruserPw}">
		<input type="password" name="ruserPw" maxlength="15">변경할 비밀번호를 입력하세요.<br> 
		<input type="password" name="ruserPwre" maxlength="15">다시 
		<input type="submit" formaction="/changePw?secNo=${codeVO.secNo}" formmethod="post" id="getPwBtn" value="완료">
	</form>
</body>
<script>
function success(){
	const regPwd = /^[a-zA-Z0-9!@#$%^*+=-]{4,12}$/;
	
	if(f1.ruserPw.value == ""){
		alert(" 수정할 비밀번호가 입력되지 않았습니다");
		return false;
	}
	else if(!f1.ruserPw.value.match(regPwd)){
		alert(" 비밀번호 형식이 올바르지 않습니다. 숫자 or 영문 4~15자리");
		f1.ruserPw.value = "";
		f1.ruserPw.focus();
		return false;
	}
	else if(f1.ruserPwre.value==""){
		alert("비밀번호 재입력 부분을 입력해주세요");
		return false;
	}
	else if(!f1.ruserPwre.value.match(regPwd)){
		alert(" 비밀번호 재입력란이 올바르지 않습니다.");
		f1.ruserPwre.value ="";
		f1.ruserPwre.focus();
		return false;
	}
	else if( f1.ruserPw.value != f1.ruserPwre.value){
		alert("입력된 비밀번호가 다릅니다.");
		f1.ruserPw.value= "";
		f1.ruserPwre.value= "";
		return false;
	}
	
	if(f1.orgPw.value == f1.ruserPw.value){
		alert("이전 비밀번호와 일치합니다.");
		f1.ruserPw.value= "";
		f1.ruserPwre.value= "";
		return false;
	}
	else{
	alert("변경완료");
	//loation.href='/index';
	}
}

</script>
</html>