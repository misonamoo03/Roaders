<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.misonamoo.smileway.domain.UserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<body>
	<header class="header"></header>

	<main class="main">
		
			<c:forEach items="${list}" var="list">
				<div>
					<p>
						이미지 : <img style="width:100px;"src="../imgUpload/unnamed.jpg">
					</p>
					<p>
						회원등급 :
						<c:if test="${list.ruserGrade == 3}">브론즈회원</c:if>
						<c:if test="${list.ruserGrade == 2}">실버회원</c:if>
						<c:if test="${list.ruserGrade == 1}">골드회원</c:if>
					</p>
					<p>회원아이디 : ${list.ruserId}(${list.ruserName})</p>
					<p>평점 : ${list.ruserStar}</p>
					<p>배송횟수 : ${list.ruserDeliveryCnt}</p>
					<p>적립금 : ${list.ruserPoint}</p>
					<p>리뷰갯수 : ${list.reviewCount}</p>
					<p>픽업 가능 시간 : ${list.pickupTime}</p>
					<p>픽업 요청 메시지 : ${list.message}</p>
					<p>
						<input type="hidden" class="del-num-input" value="${list.deliveryNumber}">
						<input type="hidden" class="del-name-input" value="${list.ruserId}">
					</p>
					<p>
						<button class="pick-up">픽업</button>
						<!-- 
							<button id="wait">대기</button>
						 -->
					</p>
				</div>
				<hr>
					
			</c:forEach>
		
	</main>
	
	<script>
		$(document).ready(function() {

			var deliveryNum = $('.del-num-input').val();
			var pickUpBtn = $('.pick-up');


			//로더 지원 목록 팝업(한상희) - 지원자 여려명일때 팝업 안열림 ->id를 class로 수정
			pickUpBtn.click(function(){
				window.open("/delivery/RequestPickUp?DELIVERY_NUMBER="+deliveryNum, "픽업요청팝업", "width=550, height=500, left=600, top=100");
			})
			
		});
	</script>
	
</body>
</html>