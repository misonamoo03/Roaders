<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.UserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>상품 목록 팝업</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/resources/js/delivery/regist.js"></script>
</head>
<body>

	<main class="main">
		<section class="main-container">
			<div class="sub-main">
				<section class="reg-item">
				
					<form role="form" method="post" enctype="multipart/form-data">
						<table class="item-popup-table">
							<tbody>
								<tr>
									<td>No</td>
									<td>이미지</td>
									<td>상품명</td>
									<td>가격</td>
									<td>사이즈</td>
									<td>사용</td>
								</tr>

								<c:forEach items="${list}" var="list">
									<tr>
										<td>${list.ITEM_NO}</td>
										<td>
											<img style="width: 80px;" src="${list.ITEM_PICTURE_Thum}">
										</td>
										<td class="pop-item-name">${list.ITEM_NAME}</td>
										<td class="pop-item-price">${list.ITEM_PRICE}</td>
										<td>
											가로: <span>${list.ITEM_WIDTH}</span> 
											세로: <span>${list.ITEM_LENGTH}</span> 
											높이: <span>${list.ITEM_HEIGHT}</span>
										</td>
										<td>
											<input type="button" value="선택" class="send-data-btn">
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</form>
					
				
				</section>
			</div>
		</section>
	</main>
</body>
</html>