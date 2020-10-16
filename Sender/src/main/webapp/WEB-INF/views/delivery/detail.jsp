<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.misonamoo.smileway.domain.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
               ${User.SUSER_ID}님 안녕하세요 | <input type="submit" formaction="logout"
                  formmethod="get" id="logoutBtn" value="로그아웃">
            </nav>
         </c:if>
      </form>
   </header>  

    <main class="main">
        <form>
			<c:if test="${User == null }">
				
			</c:if>
			<c:if test="${User != null }">
				<%@include file="../nav.jsp" %>
			</c:if>
		</form>
        <section class="main-container">
            <aside class="aside">
                <ul>
                    <li><a href="/delivery/list">전체배송</a></li>
                    <li><a href="">배송중 상품</a></li>
                    <li><a href="">배송완료 상품</a></li>
                    <li><a href="">배송요청</a></li>
                    <li><a href="/location/locationList">장소 관리</a></li>
                </ul>
            </aside>
            <div class="sub-main">
               <section class="reg-delivery">
                   <h1>택배 기본정보</h1>
                   <table>
                       <tbody>
                           <tr>
                               <td class="title-col">택배 종류</td>
                               <td>
                                  ${d.DEL_CONTENT_STATE}  
                               </td>
                           </tr>
                       </tbody>
                   </table>
               </section>
               <section class="reg-delivery">
                   <h1>상품정보</h1>
                   <table>
                       <tbody>
                           <tr>
                               <td class="title-col">상품명</td>
                               <td>
                                   ${d.DEL_CONTENT_NAME}
                               </td>
                           </tr>
                           <tr>
                               <td>카테고리</td>
                               <td>
                                  ${d.CATAGORY_NAME}
                               </td>
                           </tr>
                           <tr>
                               <td>상품구분</td>
                               <td>
                                   ${d.DEL_CONTENT_TYPE}
                               </td>
                           </tr>
                           <tr>
                               <td>상품가격</td>
                               <td>
                                  ${d.DEL_CONTENT_PRICE}원
                               </td>
                           </tr>
                           <tr>
                               <td>가로+세로+높이</td>
                               <td>
                                  가로: ${d.DEL_CONTENT_WIDTH}cm
                                  세로: ${d.DEL_CONTENT_LENGTH}cm
                                  높이: ${d.DEL_CONTENT_HEIGHT}cm
                               </td>
                           </tr>
                           <tr>
                               <td>무게</td>
                               <td>
	                              <c:if test="${d.DEL_CONTENT_WEIGHT eq 1}">
	                                 1kg 이내
	                              </c:if>
	                              <c:if test="${d.DEL_CONTENT_WEIGHT eq 2}">
	                                 2kg 이내
	                              </c:if>
	                              <c:if test="${d.DEL_CONTENT_WEIGHT eq 3}">
	                                 3kg 이내
	                              </c:if>
	                              <c:if test="${d.DEL_CONTENT_WEIGHT eq 4}">
	                                 4kg 이내
	                              </c:if>
	                              <c:if test="${d.DEL_CONTENT_WEIGHT eq 5}">
	                                 5kg 이내
	                              </c:if>
	                              <c:if test="${d.DEL_CONTENT_WEIGHT eq 6}">
	                                 7kg 이내
	                              </c:if>
	                              <c:if test="${d.DEL_CONTENT_WEIGHT eq 7}">
	                                 10kg 이내
	                              </c:if>
	                              <c:if test="${d.DEL_CONTENT_WEIGHT eq 8}">
	                                 10kg 초과
	                              </c:if>
                               </td>
                           </tr>
                           <tr>
                               <td>이미지</td>
                               <td>
                                  <img style="width: 120px;" src="${d.DEL_CONTENT_PICTURE_Thum}">
                               </td>
                           </tr>
                           <tr>
                               <td>제품설명</td>
                               <td>
                                   ${d.DEL_CONTENT_EXPLAIN}
                               </td>
                           </tr>
                           
                           <tr>
                               <td>주의사항</td>
                               <td>
                                   ${d.DEL_CONTENT_WARN}
                               </td>
                           </tr>
                       </tbody>
                   </table>
               </section>
           
               <section class="reg-delivery location">
                   <h1>출발장소</h1>
                   <table>
                       <tbody>
                           <tr>
                               <td class="title-col">담당자</td>
                               <td>
                                   ${d.DEPART_CHARHER}
                               </td>
                           </tr>
                           <tr>
                               <td>연락처</td>
                               <td>
                                   ${d.DEPART_PHONE}
                               </td>
                           </tr>
                           <tr>
                               <td>배송지 주소</td>
                               <td class="add-row departure-add-row">
                                  우편번호: ${d.DEPART_POST}<br>
                                  주소: ${d.DEPART_ADDRESS} ${d.DEPART_ADDRESS_DTL}
                               </td>
                           </tr>
                       </tbody>
                   </table>
               </section>
               <section class="reg-delivery">
                   <h1>도착장소</h1>
                   <table>
                       <tbody>
                           <tr>
                               <td class="title-col">담당자</td>
                               <td>
                                   ${d.ARRIVAL_CHARHER}
                               </td>
                           </tr>
                           <tr>
                               <td>연락처</td>
                               <td>
                                   ${d.ARRIVAL_PHONE}
                               </td>
                           </tr>
                           <tr>
                               <td>배송지 주소</td>
                               <td class="add-row arrival-add-row">
                                  우편번호: ${d.ARRIVAL_POST}<br>
                                  주소: ${d.ARRIVAL_ADDRESS} ${d.ARRIVAL_ADDRESS_DTL}
                               </td>
                           </tr>
                       </tbody>
                   </table>
               </section>
                
               <section class="reg-delivery">
                   <h1>배송정보</h1>
                   <table>
                       <tbody>
                           <tr>
                               <td class="title-col">픽업시간</td>
                               <td>
                                   최소 픽업 시간: ${d.MIN_PICKUP_TIME} ~ 
                                   최대 픽업 시간: ${d.MAX_PICKUP_TIME}                      
                               </td>
                           </tr>
                           <tr>
                               <td>도착시간</td>
                               <td>
                                   최소 도착 시간: ${d.MIN_ARRIVE_TIME} ~ 
                                   최대 도착 시간: ${d.MAX_ARRIVE_TIME}                        
                               </td>
                           </tr>
                           <tr>
                               <td>마감시간</td>
                               <td>
                                  ${d.FINISH_TIME}
                               </td>
                           </tr>
                           <tr>
                               <td>배송방법</td>
                               <td>
                                  <c:if test="${d.DEL_METHOD_CODE eq 1}">
	                                 	도보
	                              </c:if>
	                              <c:if test="${d.DEL_METHOD_CODE eq 2}">
	                                 	자전거 
	                              </c:if>
	                              <c:if test="${d.DEL_METHOD_CODE eq 3}">
	                                 	대중교통 
	                              </c:if>
	                              <c:if test="${d.DEL_METHOD_CODE eq 4}">
	                                 	오토바이 
	                              </c:if>
	                              <c:if test="${d.DEL_METHOD_CODE eq 5}">
	                                 	자가용
	                              </c:if>
                               </td>
                           </tr>
                       </tbody>
                   </table>
               </section>
                
                <section class="reg-delivery">

	                <h1>배송비</h1>
	                <table>
	                    <tbody>
	                        <tr>
	                            <td class="title-col">배송비</td>
	                            <td>
	                                ${d.DELIVERY_PRICE}원
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </section>
	            <section class="reg-delivery">
	                <h1>배송관리</h1>
	                <table>
	                    <tbody>
	                        <tr>
	                            <td class="title-col">배송상태</td>
	                            <td>
	                            	<c:if test="${d.DELIVERY_STATE eq 0}">
	                               		배송요청이 등록된 상태입니다.
	                              	</c:if>
	                            	<c:if test="${d.DELIVERY_STATE eq 1}">
	                               		픽업 요청 <input type="button" id="applyRoader" value="지원로더">
	                              	</c:if>
	                              	<c:if test="${d.DELIVERY_STATE eq 2}">
	                               		픽업 대기 <input type="button" class="history-btn" value="배송상태 조회">
	                               		
	                               		
	                               		
	                              	</c:if>
	                              	<c:if test="${d.DELIVERY_STATE eq 3}">
	                               		픽업 완료 
	                               		<input type="button" class="history-btn" value="배송상태 조회"> 
	                               		<input type="button" id="pickUpApproval" value="픽업 승인">
	                              	</c:if>
	                              	<c:if test="${d.DELIVERY_STATE eq 4}">
                                           	픽업승인 
                                           <input type="button" class="history-btn" value="배송상태 조회"><br>
                                           
	                              	</c:if>
	                              	<c:if test="${d.DELIVERY_STATE eq 5}">
	                               		배송완료 
	                               		<input type="button" class="history-btn" value="배송상태 조회"> 
	                           			<input type="button" id="confirm" value="구매확정 및 평가">
	                              	</c:if>
	                              	<c:if test="${d.DELIVERY_STATE eq 6}">
	                               		로더가 샌더를 평가중입니다.
	                              	</c:if>
	                              	<c:if test="${d.DELIVERY_STATE eq 7}">
	                               		완료
	                              	</c:if>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </section>
	            
	            <div class="btn-wrap">
	            <c:choose>
	            	<c:when test="${d.DELIVERY_STATE eq 0}">
	            		<a href="edit?DELIVERY_NUMBER=${d.DELIVERY_NUMBER}">
			            	<input type="button" value="픽업 요청 수정"> 
			            </a>
			            <a href="delete?DELIVERY_NUMBER=${d.DELIVERY_NUMBER}">
			            	<input type="button" value="픽업 요청 삭제"> 
			            </a>
			            <input type="hidden" value="${d.DELIVERY_NUMBER}" class="delivery-number-input">
			            <input type="hidden" value="${r.ruserId }" class="ruser-id-input">
			            <input type="hidden" value="${User.SUSER_ID}" class="suser-id-input">
		            </c:when>
		            <c:when test="${d.DELIVERY_STATE eq 1}">
	            		<a href="edit?DELIVERY_NUMBER=${d.DELIVERY_NUMBER}">
			            	<input type="button" value="픽업 요청 수정"> 
			            </a>
			            <a href="delete?DELIVERY_NUMBER=${d.DELIVERY_NUMBER}">
			            	<input type="button" value="픽업 요청 삭제"> 
			            </a>
			            <input type="hidden" value="${d.DELIVERY_NUMBER}" class="delivery-number-input">
			            <input type="hidden" value="${r.ruserId }" class="ruser-id-input">
			            <input type="hidden" value="${User.SUSER_ID}" class="suser-id-input">
		            </c:when>
	            	<c:otherwise>
	            		로더가 지정된 이후로는 픽업을 수정 및 삭제할 수 없습니다.
			            <input type="hidden" value="${d.DELIVERY_NUMBER}" class="delivery-number-input">
			            <input type="hidden" value="${r.ruserId }" class="ruser-id-input">
			            <input type="hidden" value="${User.SUSER_ID}" class="suser-id-input">
	            	</c:otherwise>
	            </c:choose>
		            
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

   
	$(document).ready(function() {
        $('#searchBtn').on("click", function(event) {
            self.location = "list"
                    + '${pageMaker.makeQuery(1)}'
                    + "&searchType="
                    + $('input[name=searchType]:checked').val()
                    + "&keyword=" + $('#keywordInput').val();
        });
        
        
        //로더 지원 목록 팝업(한상희)
        $('#applyRoader').on("click", function(event) {
            window.open("/delivery/RoaderApplyPop?deliveryNumber=${d.DELIVERY_NUMBER}", "지원로더목록", "width=550, height=500, left=600, top=100");
        });
        
        //배송 승인 팝업(한상희)
        $('#pickUpApproval').on("click", function(event) {
            window.open("/delivery/pickUpApproval?DELIVERY_NUMBER=${d.DELIVERY_NUMBER}", "배송 승인", "width=550, height=500, left=600, top=100");
        });
        
        //구매확정 및 평가
        $('#confirm').on("click", function(event) {
            window.open("/delivery/confirm?DELIVERY_NUMBER=${d.DELIVERY_NUMBER}", "구매 확정 및 평가", "width=550, height=500, left=600, top=100");
		});

        //배송 히스토리 팝업 열기
        $('.history-btn').click(function(){
        	window.open("/delivery/deliHisPop?DELIVERY_NUMBER=${d.DELIVERY_NUMBER}", "배송히스토리", "width=550, height=500, left=600, top=100");
        });
	
    });
	
	
	</script>


</body>
</html>