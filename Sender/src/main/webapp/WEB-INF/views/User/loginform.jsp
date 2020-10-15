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
	            <input type="text" id="SUSER_ID" name="SUSER_ID" size="40" placeholder="아이디 * (4~20)">
	
	            <input type="password" id="SUSER_PW"  name="SUSER_PW" size="40" placeholder="비밀번호 *(영문 + 숫자 + 특수기호 8~20)">
	
	            <span>
	                <input type="checkbox"> 아이디 저장
	            </span>
	            <span>
	                <a>아이디 찾기 |</a>
	                <a>비밀번호 찾기 |</a>
	                <a href="/signup">회원가입</a>
	            </span>
	            <input type="submit" formaction="login" formmethod="post" id="loginBtn" value="로그인">
	 		</form>

        </section>
    </main>
    <footer class="footer">
        <h1>(주) 미소나무</h1>
        <div class="company">
            <dl>
                <dt>사업자 등록번호:</dt>
                <dd>217-81-41971</dd>
            </dl>
            <dl>
                <dt>대표:</dt>
                <dd>손성택</dd>
            </dl>
            <dl>
                <dt>주소:</dt>
                <dd>경기도 남양주시 덕송2로 70-9 504호</dd>
            </dl>
            <dl>
                <dt>대표번호:</dt>
                <dd>02) 6232-7000</dd>
            </dl>
            <dl>
                <dt>fax:</dt>
                <dd>02) 6232-7700</dd>
            </dl>
        </div>
        ⓒ Misonamoo Corp
    </footer>
</body>
</html>