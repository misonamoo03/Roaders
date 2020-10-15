<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		 
		<p>
			회원 등급 :
			<c:if test="${sevo.GRADE_CODE == 3}">브론즈회원</c:if>
			<c:if test="${sevo.GRADE_CODE == 2}">실버회원</c:if>
			<c:if test="${sevo.GRADE_CODE == 1}">골드회원</c:if>
		</p>
		<p>
			회원사진 : <img src="${sevo.SUSER_PHOTO}">
		</p>
		<p>회원 아이디(이름) : ${sevo.SUSER_ID}(${sevo.SUSER_NAME})</p>
		<p>회원 전화번호 : ${sevo.SPHONE}</p>
		<hr>
	<c:forEach items="${list}" var="list">
		<p>시간 : ${list.DEL_CHANGE_TIME}</p>
		<p>
			배송상태 :
			<c:if test="${list.DELIVERY_STATE == 1}">픽업요청</c:if>
			<c:if test="${list.DELIVERY_STATE == 2}">픽업대기</c:if>
			<c:if test="${list.DELIVERY_STATE == 3}">픽업</c:if>
			<c:if test="${list.DELIVERY_STATE == 4}">픽업승인</c:if>
			<c:if test="${list.DELIVERY_STATE == 5}">배송완료</c:if>
			<c:if test="${list.DELIVERY_STATE == 6}">배송확정 및 평가</c:if>
			<c:if test="${list.DELIVERY_STATE == 7}">완료</c:if>
		</p>
		<p>메세지 : ${list.DEL_MESSAGE}</p>
		<p>
			사진1 : <img src="${list.DEL_PIC1}">
		</p>
		<p>
			사진2 : <img src="${list.DEL_PIC2}">
		</p>
		<p>
			사진3 : <img src="${list.DEL_PIC3}">
		</p>

	</c:forEach>
</body>
</html>