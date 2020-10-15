<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.UserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>센더스</title>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

	<script>
	  function chkCatagory(){
		  
		  if($('#CATAGORY_NAME').val()==""){
			  alert("카테고리명을 입력해주세요");
			  $('#CATAGORY_NAME').focus();
			  return false;
		  }
		  
	  }
	
	
	</script>
	
	
    <header class="header">
        <h1>
            <span class="font-color-orange">가는길에</span> @센더스
        </h1>
        <form>
			<c:if test="${User == null }">
				<nav>
					<ul>
						<li><a href="/loginform">로그인</a></li>
						<li><a href="/signup">회원가입</a></li>
					</ul>
				</nav>
			</c:if>
			<c:if test="${User != null }">
				<nav>
					${User.SUSER_ID}님 안녕하세요 | <input type="submit" formaction="logout" formmethod="get" id="logoutBtn" value="로그아웃">
				</nav>
			</c:if>
		</form>
    </header>    

    <main class="main">
        <nav class="sub-menu">
            <ul>
                <li>상품관리</li>
                <li>배송관리</li>
                <li>회원정보</li>
            </ul>
        </nav>
        <section class="main-container">
            <aside class="aside">
                <ul>
                    <li><a href="/item/catagory">상품카테고리</a></li>
					<li><a href="/item/itemList">상품목록</a></li>
					<li><a href="/item/regist">상품등록</a></li>
                </ul>
            </aside>
                <section class="reg-item">
                	<div>
                    	<h2>카테고리명</h2>
                    <form role="form" method="post">
                    	<input type="text" id="CATAGORY_NAME" name="CATAGORY_NAME">
                    	<button type="submit" id="cata_insert" onclick="chkCatagory()" >등록</button>
                    </form>
                   </div>
                   <hr align="left" style="width:100%;">
                    <c:forEach items="${list}" var="list">
  						<ul>
   							<li>${list.CATAGORY_NAME}</li>
  						</ul>   
  					</c:forEach>
                   
                </section>
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