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
<script src="/resources/js/delivery/item.js"></script>
<style>
	.pop-item-img img {
		width: 80px;
	}
</style>
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
									<td>카테고리</td>
									<td>상품구분</td>
									<td>상품명</td>
									<td>가격</td>
									<td>사이즈</td>
									<td>무게</td>
									<td>사용</td>
								</tr>

								<c:forEach items="${list}" var="list" varStatus="st">
									<tr class="itme-tr">
										<td>${st.count}</td>
										<td class="pop-item-img">
											<img src="${list.ITEM_PICTURE_Thum}">
										</td>
										<td class="pop-item-category">
											<input type="hidden" value="${list.CATAGORY_ID}"  class="pop-item-category-input">										
											${list.CATAGORY_NAME}
										</td>
										<td class="pop-item-type">
											<input type="hidden" class="pop-item-type-input" value="${list.ITEM_TYPE}">
											<c:if test="${list.ITEM_TYPE eq 1}">
			                                	공산품
			                              	</c:if>
			                              	<c:if test="${list.ITEM_TYPE eq 2}">
			                                	신선식품
			                              	</c:if>
			                              	<c:if test="${list.ITEM_TYPE eq 3}">
			                                	냉동식품
			                              	</c:if>
			                              	<c:if test="${list.ITEM_TYPE eq 4}">
			                                	화훼상품
			                              	</c:if>
										</td>
										<td class="pop-item-name">${list.ITEM_NAME}</td>
										<td class="pop-item-price">${list.ITEM_PRICE}</td>
										<td class="pop-size">
											가로: <span class="pop-item-width">${list.ITEM_WIDTH}</span><br>
											세로: <span class="pop-item-length">${list.ITEM_LENGTH}</span><br>
											높이: <span class="pop-item-height">${list.ITEM_HEIGHT}</span>
										</td>
										<td class="pop-item-weight">
											<input type="hidden" class="pop-item-weight-input" value="${list.ITEM_WEIGHT}">
											<c:if test="${list.ITEM_WEIGHT eq 1}">
				                                 1kg 이내
				                              </c:if>
				                              <c:if test="${list.ITEM_WEIGHT eq 2}">
				                                 2kg 이내
				                              </c:if>
				                              <c:if test="${list.ITEM_WEIGHT eq 3}">
				                                 3kg 이내
				                              </c:if>
				                              <c:if test="${list.ITEM_WEIGHT eq 4}">
				                                 4kg 이내
				                              </c:if>
				                              <c:if test="${list.ITEM_WEIGHT eq 5}">
				                                 5kg 이내
				                              </c:if>
				                              <c:if test="${list.ITEM_WEIGHT eq 6}">
				                                 7kg 이내
				                              </c:if>
				                              <c:if test="${list.ITEM_WEIGHT eq 7}">
				                                 10kg 이내
				                              </c:if>
				                              <c:if test="${list.ITEM_WEIGHT eq 8}">
				                                 10kg 초과
				                              </c:if>
										</td>
										<td>
											<input type="button" value="선택" class="item-data-btn">
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