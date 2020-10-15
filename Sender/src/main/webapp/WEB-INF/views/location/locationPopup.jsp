<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.UserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/resources/js/delivery/location.js"></script>
</head>
<body>
	<form>
				<table border="1" style="width: 800px;" class="location-pop-table">
			<tr>
				<td width="77">
					<p align="center">장소</p>
				</td>
				<td width="327">
					<p align="center">주소</p>
				</td>
				<td width="197">
					<p align="center">연락처</p>
				</td>
				<td width="100">
					<p align="center">선택</p>
				</td>
			</tr>

			<c:forEach items="${list}" var="locationVO">
				<tr>
					<td align="center">${locationVO.locationName}</td>
					<td align="center">
					
						<span class="location-post">${locationVO.locationPost}</span>
						<span class="location-address">${locationVO.locationAddress1}</span>
						<span class="location-address-dtl">${locationVO.locationAddress2}</span>
					</td>
					<td align="center" class="location-phone">${locationVO.locationPhone}</td>
					<td><button type="button" class="depart-btn">선택</button></td>
				</tr>
			</c:forEach>
		</table>
		</form>
</body>
</html>