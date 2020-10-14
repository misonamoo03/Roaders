<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>센더스</title>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
    <header class="header">
        <h1>
            <span class="font-color-orange">가는길에</span> @센더스
        </h1>
    </header>
    <main class="main login-main">
        <section class="login">
            <h1>
                가는길에 @ <span class="font-color-orange">센더스</span>
            </h1>
            <form>
	            <input type="text" id="ruserId" name="ruserId" size="40" placeholder="아이디 * (4~20)">
	
	            <input type="password" id="ruserPw"  name="ruserPw" size="40" placeholder="비밀번호 *(영문 + 숫자 + 특수기호 8~20)">
	
	            <span>
	                <input type="checkbox" id="checkbox" class="keepLogin" name="saveId">
					<label class="keepLogin">아이디 저장</label>
	            </span>
	            <span>
	                <a href="/idchk">아이디 찾기 |</a>
	                <a href="/pwSearch">비밀번호 찾기 |</a>
	                <a href="/signup">회원가입</a>
	            </span>
	            <input type="submit" formaction="login" formmethod="post" id="loginBtn" value="로그인">
	 		</form>

        </section>
    </main>
</body>
</html>