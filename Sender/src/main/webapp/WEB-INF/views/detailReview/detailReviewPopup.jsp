<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/resources/css/star.css">
<body>
미소나무 <br>
<script>
	$(document).ready(function(){
		var strar = 

	});
}
</script>
★★★★☆
<c:forEach items="${review}" var="reviewList">
		<c:if test="${reviewList.reviewCode eq '1'}">
			친절 ${reviewList.reviewStar} 
		</c:if>
		<c:if test="${reviewList.reviewCode  eq '2'}">
			약속 ${reviewList.reviewStar} 
		</c:if>
		<c:if test="${reviewList.reviewCode  eq '3'}">
			속도 ${reviewList.reviewStar} 
		</c:if>
</c:forEach>
${DetailReviewVO.reviewNumber}
<br>
배송에 너무 만족드립니다.
다음에 또 부탁드립니다.
</body>
</html>


