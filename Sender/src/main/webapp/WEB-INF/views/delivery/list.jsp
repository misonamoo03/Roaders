<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <header class="header">
		<h1>
			<span class="font-color-orange">가는길에</span> @센더스
		</h1>
		<form>
			<c:if test="${User == null }">
				<nav>
					<ul>
						<li><a href="/loginform">로그인</a></li>
						<li><a href="/signup">회원가입</a></li>
					</ul>
				</nav>
			</c:if>
			<c:if test="${User != null }">
				<nav>
					${User.SUSER_ID}님 안녕하세요 | <input type="submit" formaction="/logout"
						formmethod="get" id="logoutBtn" value="로그아웃">
				</nav>
			</c:if>
		</form>
	</header>  

    <main class="main">
        <nav class="sub-menu">
            <ul>
                <li>상품관리</li>
                <li>배송관리</li>
                <li>회원정보</li>
            </ul>
        </nav>
        <section class="main-container">
            <aside class="aside">
                <ul>
                    <li><a href="">전체배송</a></li>
                    <li><a href="">배송중 상품</a></li>
                    <li><a href="">배송완료 상품</a></li>
                    <li><a href="">배송요청</a></li>
                    <li><a href="">장소 관리</a></li>
                </ul>
            </aside>
            <div class="sub-main">
            <style>
            	.delivery-list-table {
            		width: 1300px;
            		border: 1px solid #979797;
            	}
            	.delivery-list-table th {
            		height: 50px;
            		text-align: center;
            		background-color: #ddd;
            		border-bottom: 1px solid #979797;
            	}
            	.delivery-list-table td {
            		padding: 5px;
            		text-align: center;
            		border-right: 1px solid #979797;
            		border-bottom: 1px solid #979797;
            	}
            	.delivery-list-table .location-td {
            		text-align: left;
            		text-indent: 10px;
            	}
            </style>
            	<ul>
				
					<li>상품명  <input type="text" name='keyword' id="keywordInput" value='${cri.keyword}'>
					<li>
						배송타입  
						<input type="radio" name="searchType" value="A" <c:out value="${cri.searchType == null?'checked':''}"/>> 전체 
						<input type="radio" name="searchType" value="Y" <c:out value="${cri.searchType eq 'Y'?'checked':''}"/>> 보내기 
						<input type="radio" name="searchType" value="N" <c:out value="${cri.searchType eq 'N'?'checked':''}"/>> 가져오기
					<li><button id='searchBtn'>조회</button>
					
				</ul>
            
	            
                <table class="delivery-list-table">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>배송타입</th>
                            <th>이미지</th>
                            <th>상품명</th>
                            <th>출발</th>
                            <th>도착</th>
                            <th>상태</th>
                            <th>로더</th>
                            <th>배송비</th>
                            <th>관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="list" varStatus="st" >
                            <tr>
                                <td>${list.DELIVERY_NUMBER}</td>
                                <td>${list.DEL_CONTENT_STATE}</td>
                                <td>
                                	<img style="width: 120px;" src="${list.DEL_CONTENT_PICTURE_Thum}">
                                </td>
                                <td>
                                	<a href="${list.DELIVERY_NUMBER}">
                                		${list.DEL_CONTENT_NAME}
                                	</a>
                                </td>
                                <td class="location-td">
                                	${list.MIN_PICKUP_TIME} ~ 
                                	${list.MAX_PICKUP_TIME}<br>
                                	${list.DEPART_ADDRESS }
                                	${list.DEPART_ADDRESS_DTL }
                                </td>
                                <td class="location-td">                                
                                	${list.MIN_ARRIVE_TIME} ~ 
                                	${list.MAX_ARRIVE_TIME}<br>
                                	${list.ARRIVAL_ADDRESS }
                                	${list.ARRIVAL_ADDRESS_DTL }
                                </td>
                                <td>
                                	<c:if test="${list.DELIVERY_STATE eq 1}">
	                               		픽업 요청
	                              	</c:if>
	                              	<c:if test="${list.DELIVERY_STATE eq 2}">
	                               		픽업 대기
	                              	</c:if>
	                              	<c:if test="${list.DELIVERY_STATE eq 3}">
	                               		픽업 완료 
	                              	</c:if>
	                              	<c:if test="${list.DELIVERY_STATE eq 4}">
	                              		픽업승인 
	                              	</c:if>
	                              	<c:if test="${list.DELIVERY_STATE eq 5}">
	                               		배송완료
	                              	</c:if>
	                              	<c:if test="${list.DELIVERY_STATE eq 6}">
	                               		로더 평가중
	                              	</c:if>
	                              	<c:if test="${list.DELIVERY_STATE eq 7}">
	                               		완료
	                              	</c:if>
                                
                                </td>
                                <td>로더</td>
                                <td>${list.DELIVERY_PRICE}원</td>
                                <td>
                                	<a href="edit?DELIVERY_NUMBER=${list.DELIVERY_NUMBER}">
						            	<input type="button" value="수정"> 
						            </a>
						            <a href="delete?DELIVERY_NUMBER=${list.DELIVERY_NUMBER}">
						            	<input type="button" value="삭제"> 
						            </a>
                                </td>
                            </tr>
                        </c:forEach>                        
                    </tbody>
                </table>
                
                <div>
					<ul style="display:flex; justify-content:center">
	
						<c:if test="${pageMaker.prev}">
							<li>
							 <a href="/delivery/list${pageMaker.makeQuery(pageMaker.startPage - 1)}">&laquo;</a>
							</li>
						</c:if>
	
						<c:forEach begin="${pageMaker.startPage }"
							end="${pageMaker.endPage }" var="idx">
							<li
								<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							 	<a href="/delivery/list${pageMaker.makeQuery(idx)}">[${idx}]</a>
							</li>
						</c:forEach>
	
						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li>
							 <a href="/delivery/list${pageMaker.makeQuery(pageMaker.endPage + 1)}">&raquo;</a>
							</li>
						</c:if>
	
					</ul>
				</div>  
                
                
            </div>
        </section>
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
    <script type="text/javascript">
	$(document).ready(
			function() {
				$('#searchBtn').on(
						"click",
						function(event) {
							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $('input[name=searchType]:checked').val()
									+ "&keyword=" + $('#keywordInput').val();
						});
			});
	</script>

</body>
</html>