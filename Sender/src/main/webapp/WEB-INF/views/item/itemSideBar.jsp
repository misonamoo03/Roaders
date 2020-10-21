<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<ul>
		<li><a href="/catagory?SUSER_ID=${cookie.id.value}">상품카테고리</a></li>
		<li><a href="/itemList?SUSER_ID=${cookie.id.value}">상품목록</a></li>
		<li><a href="/regist?SUSER_ID=${cookie.id.value}">상품등록</a></li>
	</ul>
</body>
</html>