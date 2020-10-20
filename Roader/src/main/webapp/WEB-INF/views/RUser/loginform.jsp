<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>센더스</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<script>
	$( document ).ready(function() {

		let ruserId = $('.ruserId').val();
		let ruserPw = $('.ruserPw');
		let loginBtn = $('.loginBtn');
		let loginId = false;
		
		$('.login-btn').on("click", function(event) {
			ruserId = $('.ruserId').val();
			let param={ruserId: ruserId};
			$.ajax({
				type : "POST",            // HTTP method type(GET, POST) 형식이다.
				dataType: "json",
				contentType: "application/json",
				url : "/idCheck",      // 컨트롤러에서 대기중인 URL 주소이다.
				async: false,
				data : JSON.stringify(param),
				success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
					 if(res == 1) {
		                	loginId=true;
		                	return;
		                }else{
		                	loginId=false;
		                }
				},
				error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
					loginId=false;
					alert("아이디를 다시 입력해 주세요.");
				}
			});
			ruserPw = $('.ruserPw').val();
				param={ruserPw: ruserPw};
			$.ajax({
				type : "POST",            // HTTP method type(GET, POST) 형식이다.
				dataType: "json",
				contentType: "application/json",
				url : "/checkPw",      // 컨트롤러에서 대기중인 URL 주소이다.
				async: false,
				data : JSON.stringify(param),
				success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
					 if(res > 0) {
		                	loginPw=true;
		                	
		                	return;
		                }else{
		                	loginPw=false;
		                }
				}
			});
		      if(loginId == true && loginPw == true){
		    	  param={ruserId: ruserId,ruserPw: ruserPw};
		    	  $.ajax({
						type : "POST",            // HTTP method type(GET, POST) 형식이다.
						dataType: "json",
						contentType: "application/json",
						url : "login",      // 컨트롤러에서 대기중인 URL 주소이다.
						async: false,
						data : JSON.stringify(param),
						success : function(res){
							if(res != 0){
							alert("성공");
							location.href="/";
							}else{
								alert("아이디와 비밀번호를 확인바랍니다.");
							}		
						},error : function(data,status,er){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
							alert("error: "+data+" status: "+status+" er:"+er);
						}
		    	  });
		      }else{
		    	  alert("아이디와 비밀번호를 확인해주세요.");
		      }
	});
});
	
</script>
<body>
	<header class="header">
		<h1>
			<span class="font-color-orange">가는길에</span> @로더스
		</h1>
	</header>
	<main class="main login-main">
		<section class="login">
			<h1>
				가는길에 @ <span class="font-color-orange">로더스</span>
			</h1>
			<form>
				<input type="text" id="ruserId" name="ruserId" class="ruserId" size="40" placeholder="아이디 * (4~20)"> 
				<input type="password" id="ruserPw" name="ruserPw" class="ruserPw" size="40" placeholder="비밀번호 *(영문 + 숫자 + 특수기호 8~20)"> 
				<span>
					<input type="checkbox" id="checkbox" class="keepLogin" name="saveId"> <label class="keepLogin">아이디 저장</label>
				</span> 
				<span> 
					<a href="/idchk">아이디 찾기 |</a> <a href="/pwSearch">비밀번호 찾기 |</a> <a href="/signup">회원가입</a>
				</span>
				 <input type="button" formaction="login" class="login-btn"
					formmethod="post" id="loginBtn" value="로그인">
			</form>
		</section>
	</main>
</body>
</html>