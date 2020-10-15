<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.UserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
	${ruvo.ruserPhoto}/
	<c:if test="${ruvo.ruserGrade == 3}">
		브론즈회원
	</c:if>
	<c:if test="${ruvo.ruserGrade == 2}">
		실버회원
	</c:if>
	<c:if test="${ruvo.ruserGrade == 1}">
		골드회원
	</c:if>
	/${ruvo.ruserId}/${ruvo.ruserName}/${ruvo.ruserDeliveryCnt}/${ruvo.ruserPoint}/
	<c:forEach var = "i" begin = "1" end = "${ruvo.ruserStar}">
						 ★
						 </c:forEach>
	<c:forEach var = "i" begin = "${ruvo.ruserStar}" end ="4" >
						 ☆
	</c:forEach>
		<table border="1" style="width: 800px;">
			<tr>
				<td width="77">
					<p align="center">로더 이름</p>
				</td>
				<td width="77">
					<p align="center">센더 이름</p>
				</td>
				<td width="77">
					<p align="center">별점</p>
				</td>	
				<td width="100">
					<p align="center">작성일</p>
				</td>
				<td width="500">
					<p align="center">내용</p>
				</td>
			</tr>
			<c:forEach items="${review}" var="list">
				<tr>
					<td align="center">${list.ruserId}</td>
					<td align="center">${list.suserName}</td>
					<td align="center">${list.totalStar}</td>
					<td align="center">${list.reviewRegDate}</td>
					<td align="center">
					<c:forEach items="${list.starScoreList}" var="starList">
						<c:if test="${starList.reviewCode eq '1' }">
						친절 
						</c:if>
						<c:if test="${starList.reviewCode eq '2' }">
						약속 
						</c:if>
						<c:if test="${starList.reviewCode eq '3' }">
						속도 	
						</c:if>
						 <c:forEach var = "i" begin = "1" end = "${starList.reviewStar}">
						 ★
						 </c:forEach>
						 <c:forEach var = "i" begin = "${starList.reviewStar}" end ="4" >
						 ☆
						 </c:forEach>
					</c:forEach><br>
					<br>
					${list.reviewContent}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<c:if test="${pageMaker.prev}">
		<li><a
			href="/review/reviewPopup${pageMaker.makeQuery(pageMaker.startPage - 1)}&ruserId=${ruserId}">&laquo;</a>
		</li>
	</c:if>

	<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
		var="idx">
		<li <c:out value="${pageMaker.criPage == idx?'class =active':''}"/>>
			<a href="/review/reviewPopup${pageMaker.makeQuery(idx)}&ruserId=${ruserId}">[${idx}]</a>
		</li>
	</c:forEach>

	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		<li><a
			href="/review/reviewPopup${pageMaker.makeQuery(pageMaker.endPage + 1)}&ruserId=${ruserId}">&raquo;</a>
		</li>
	</c:if>
</body>
</html>