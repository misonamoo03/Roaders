<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.RUserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>로더스</title>
	<link rel="stylesheet" href="resources/css/reset.css">
	<link rel="stylesheet" href="resources/css/style.css">
</head>
	
<body>
    <header class="main-header">
    <div>
        <h1>
            <span class="font-color-orange">가는길에</span> @센더스
        </h1>
        <form>
         <c:if test="${RUser == null }">
            <nav>
               <ul>
                  <li><a href="/loginform">로그인</a></li>
                  <li><a href="/signup">회원가입</a></li>
               </ul>
            </nav>
         </c:if>
		<c:if test="${RUser != null }">
            <nav>
          <img src="C:\Users\User\Desktop\1.jpg"><a href="/read?ruserId=${RUser.ruserId}">${RUser.ruserId}</a>  | <input type="submit" formaction="logout" formmethod="get" id="logoutBtn" value="로그아웃">
            </nav>
      </div>
    <style>
    	.main-sub-menu>ul {
    		height: 50px;
    		display: flex;
    		justify-content: center;
    		align-items: center;
    	}
    	.main-sub-menu>ul li {
    		margin-right: 30px;
    	}
    	.main-sub-menu>ul li:last-child {
    		margin-right: 0;
    	}
    </style>
       	 <nav class="main-sub-menu">
            <ul>
            	<li><a href="/Delivery/List">배송목록</a></li>
            </ul>
        </nav>
		</c:if>
          <c:if test="${msg == false}">
        	 <p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
		</c:if>
      </form>
      
    </header>
    <main class="main">
    <!-- 이 부분은 로그인 되면 나타나도록 수정해주세요  -->
        <p class="main-text">방문해 주셔서 감사합니다.</p>
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
	 <!--
	<div id="root">
      라우터 화면이 아래에 출력 
    </div>
    <script src="/resources/home.js">
    </script>-->
</body>
</html>