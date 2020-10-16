<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.RUserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>센더스</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

//A $( document ).ready() block.

$(function(){
	$( document ).ready(function() {
		var ruserAgreOption = "${RUserVO.ruserAgreOption}";
		if(ruserAgreOption == "Y"){
			$("#option").prop('checked', true);
		}
		if(ruserAgreOption ==  "N"){
			$("#option").prop('checked', false);	
		}
		$("#optionId").click(function(){
			window.open("/optionPopup", "선택", "width=550, height=500, left=600, top=100");
			});
		})
		
var regExp = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/; //휴대폰번호 체크
var regExp2 =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 유효성 체크

	
	$("#updateBtn").click(function(){
		if ($("#ruserName").val()=="" ) {
			alert("이름을 입력해주세요.");
			$("#ruserName").focus();
			return false
		}
	
		if ($("#ruserEmail").val()=="" ) {
	    	alert("이메일을 입력해주세요.");
			$("#ruserEmail").focus();
			return false
		}
		if ( !regExp2.test( $("#ruserEmail").val() ) ) {
		      alert("잘못된 이메일입니다. 다시 기입해주세요.");
		      $("#ruserEmail").val("");
		      return false;
		}
		if ($("#ruserPcode").val()=="" ) {
			alert("우편번호를 입력해주세요.");
			$("#ruserPcode").focus();
			return false
		}
		if ($("#ruserAddress").val()=="" ) {
			alert("주소를 입력해주세요.");
			$("#ruserAddress").focus();
			return false
		}
		if ( !regExp.test( $("#rPhone").val() ) ) {
			      alert("잘못된 휴대폰 번호입니다. 숫자, - 를 뺀 숫자만 입력하세요.");
			      return false;
			}
		if ($("#rPhone").val()=="" ) {
			alert("폰번호를 입력해주세요.");
			$("#rPhone").focus();
			return false
		}
	
		if($("#option").is(":checked")){
			$("#ruserAgreOption").val("Y");
		}else{
			$("#ruserAgreOption").val("N");
		}
	})
	
})
</script>
</head>
<body>
	 <header class="header">
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
          <a href="/read?ruserId=${RUser.ruserId}">${RUser.ruserId}님 안녕하세요</a>  | <input type="submit" formaction="logout" formmethod="get" id="logoutBtn" value="로그아웃">
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
					<li><a href="">회원정보 변경</a></li>
					<li><a href="/PointPage?ruserId=${RUser.ruserId}">회원포인트</a></li>
				</ul>
			</aside>
			<form>
			<input type="hidden" name="ruserAgreOption" id="ruserAgreOption" value="${userVO.SUSER_AGRE_OPTION}">
			<div class="sub-main">

				아이디:	<input type="text" readonly="readonly" id="ruserId" name="ruserId" value="${RUserVO.ruserId}" size="40" > &nbsp;&nbsp;수정불가<br>
				이름 :	<input type="text" name="ruserName" id="ruserName" value="${RUserVO.ruserName}" size="40" maxlength="10" ><br>
				이메일 :	<input type="text" name="ruserEmail" id="ruserEmail" value="${RUserVO.ruserEmail1[0]}" size="40" >@
				<select	name="emailTwo">
					<option value="${RUserVO.ruserEmail1[1]}">${RUserVO.ruserEmail1[1]}</option>
					<option value="@gmail.com">gmail.com</option>
					<option value="@naver.com">naver.com</option>
					<option value="@daum.net">daum.net</option>
					<option value="@nate.com">nate.com</option>
				</select><br>
				우편번호 :	<input type="text" name="ruserPostCode" id="ruserPostCode" value="${RUserVO.ruserPostCode}" size="40" ><br>
				주소1 :	<input type="text" name="ruserAddress1" id="ruserAddress1" value="${RUserVO.ruserAddress1}" size="40" ><br>
				주소2 :	<input type="text" name="ruserAddress2" id="ruserAddress2" value="${RUserVO.ruserAddress2}" size="40" ><br>
				폰번호 :	<input type="text" name="rPhone" id="rPhone" value="${RUserVO.rPhone}" size="40" class="sphone"><br/>
				<input type="checkbox" name="option" id="option"  value="Y"><a id="optionId"> 광고성 정보 수신 동의(선택)</a><br>
				<input type="submit" formaction="modify" formmethod="post" id="updateBtn" value="수정완료" ><br>

			   	<span>
			   		
            </span>
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