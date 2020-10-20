<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.UserVO"%>
<%@page import="com.misonamoo.smileway.domain.LocationVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/postcode.js"></script>
<meta charset="UTF-8">
<title>센더스</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/style.css">
<script>

$(document).ready(function(){
	
	var defaultLocationChk = "${location.defaultLocationChk}";
	if(defaultLocationChk == "Y"){
		$("#defaultLocationChk").prop("checked", true);
	}
	
	
});
$(function(){
    $("#locationUpdateBtn").click(function(){
    	var regExp1 = /\s/g;//공백 체크
    	var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/; //휴대폰번호 체크
    	if ( $('#locationName').val().replace(/\s/g,"").length == 0 ) {
  	      alert("장소명 입력해주세요.");
  	      return false
  		}
  		if ( $('#charher').val().replace(/\s/g,"").length == 0 ) {
  	      alert("담당자를 입력해주세요.");
  	      return false
  		}
  		if ( $('#locationCellphone').val().replace(/\s/g,"").length == 0 ) {
  	      alert("연락처를 입력해주세요.");
  	      return false
	  	}
	  	if ( $('#locationPhone').val().replace(/\s/g,"").length == 0 ) {
  	      alert("전화번호를 입력해주세요.");
  	      return false
 	 	}
	  	if ( !regExp.test( $("#locationPhone").val() ) ) {
  	      alert("잘못된 휴대폰 번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
  	      return false
  		}
 		if ( $('#locationPost').val().replace(/\s/g,"").length == 0 ) {
  	      alert("우편번호를 입력해주세요.");
  	      return false
 	 	}
 	 	if ( $('#locationAddress1').val().replace(/\s/g,"").length == 0 ) {
  	      alert("주소를 입력해주세요.");
  	      return false
  		}
 	 	if ( $('#locationAddress2').val().replace(/\s/g,"").length == 0 ) {
  	      alert("상세주소를 입력해주세요.");
  	      return false
  		}
    	
    	
    });
});
</script>
</head>

<body>
	 <header class="header">
    <div>
        <h1>
            <span class="font-color-orange">가는길에</span> @센더스
        </h1>
        <form>
         <c:if test="${cookie.id == null }">
            <nav>
               <ul>
                  <li><a href="/loginform">로그인</a></li>
                  <li><a href="/signup">회원가입</a></li>
               </ul>
            </nav>
         </c:if>	
		<c:if test="${cookie.id != null }">
            <nav>
          <a href="/read?SUSER_ID=${cookie.id.value}">${cookie.id.value}님 안녕하세요</a>  | <input type="submit" formaction="logout" formmethod="get" id="logoutBtn" value="로그아웃">
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
                <li>상품관리</li>
                <li>배송관리</li>
                <li>회원정보</li>
            </ul>
        </nav>
		</c:if>
          <c:if test="${msg == false}">
        	 <p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
		</c:if>
      </form>
      
    </header>

	<main class="main">
		<section class="main-container">
			<aside class="aside">
				<ul>
					<li><a href="">전체배송</a></li>
					<li><a href="">배송중 상품</a></li>
					<li><a href="">패송완료 상품</a></li>
					<li><a href="">배송요청</a></li>
					<li><a href="">장소 관리</a></li>
				</ul>
			</aside>
			<form action="">
			<input type="hidden" name="locationNumber" value="${location.locationNumber}">
			<div class="sub-main">
			* 장소명		<input type="text" name="locationName" id="locationName"  value="${location.locationName}"><br>
			* 담당자*		<input type="text" name="charher" id ="charher" value="${location.charher}"><br>
			* 연락처*		<input type="text" name="locationCellphone" id="locationCellphone" value="${location.locationCellphone}"><br>
			* 전화번호*	<input type="text" name="locationPhone" id="locationPhone" value="${location.locationPhone}"><br>
			* 배송우편번호	<input type="text" name="locationPost" id="locationPost" class="zip required" value="${location.locationPost}">
			<button class="address-search-button">주소찾기</button><br>
			* 주소		<input type="text"  name="locationAddress1" id="locationAddress1" class="address-basic required" value="${location.locationAddress1}"><br>
			* 상세주소		<input type="text" name="locationAddress2" id="locationAddress2" class="address-detail" value="${location.locationAddress2}"><br>
			<input type="checkbox" name="defaultLocationChk" id="defaultLocationChk"  value="Y" >기본장소여부<br>
			
			<input type="submit" formaction="updateLocation" formmethod="post" name="locationUpdateBtn" id="locationUpdateBtn" value="수정"> 
			</div>
		</section>
		</form>
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