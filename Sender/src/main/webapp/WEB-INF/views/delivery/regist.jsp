 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.misonamoo.smileway.domain.UserVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>센더스</title>
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
    <header class="header">
		<h1>
			<span class="font-color-orange">가는길에</span> @센더스
		</h1>
		<form>
			<c:if test="${cookie.id == null }">
				<nav>
					<ul>
						<li><a href="/loginform">로그인</a></li>
						<li><a href="/signup">회원가입</a></li>
					</ul>
				</nav>
			</c:if>
			<c:if test="${cookie.id != null }">
				<img src="C:\Users\User\Desktop\1.jpg">${cookie.id.value}
				 | <input type="submit" formaction="logout" formmethod="get" id="logoutBtn" value="로그아웃">
			</c:if>
		</form>
	</header>  

    <main class="main">
        <form>
			<c:if test="${cookie.id == null }">
				
			</c:if>
			<c:if test="${cookie.id != null }">
				<%@include file="../nav.jsp" %>
			</c:if>
		</form>
        
        <section class="main-container">
            <aside class="aside">
                <ul>
                    <li><a href="/deliveryList">전체배송</a></li>
                    <li class="delivery-ing delivery-menu">
                    	배송중 상품</li>
                    <li class="delivery-complete delivery-menu">
                    	배송완료 상품
                    </li>
                    <li><a href="/delivery/regist">배송요청</a></li>
                    <li><a href="/location/locationList">장소 관리</a></li>
                </ul>
            </aside>
            <div class="sub-main">
                <form role="form" method="post" enctype="multipart/form-data">
                
                	<input type="hidden" name="SUSER_ID" value="${cookie.id.value}">
                    <section class="reg-delivery">
                        <h1>택배 기본정보</h1>
                        <table>
                            <tbody>
                                <tr>
                                    <td class="title-col">택배 종류</td>
                                    <td>
                                        <input type="radio" name="DEL_CONTENT_STATE" value="보내기" required> 보내기
                                        <input type="radio" name="DEL_CONTENT_STATE" value="가져오기"> 가져오기
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                    <section class="reg-delivery">
                        <h1>상품정보</h1>
                        <table class="del-item-table">
                            <tbody>
                            
                                <tr>
                                    <td class="title-col">상품선택</td>
                                    <td>
                                        <input type="button" id="itemList" value="상품목록">
                                    </td>
                                </tr>
                              
                                <tr>
                                    <td class="title-col">상품명</td>
                                    <td>
                                        <input type="text" name="DEL_CONTENT_NAME" class="item-name" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>카테고리</td>
                                    <td>
                                        <select name="CATAGORY_ID" class="catagory item-catagory" required>
                                            <option value="">선택</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품구분</td>
                                    <td>
                                        <select name="DEL_CONTENT_TYPE" class="item-section-select require" required>
                                            <option value="">선택</option>
                                            <option value="공산품">공산품</option>
                                            <option value="신선식품">신선식품</option>
                                            <option value="냉동식품">냉동식품</option>
                                            <option value="화훼상품">화훼상품</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품가격</td>
                                    <td>
                                        <input type="text" name="DEL_CONTENT_PRICE" class="item-price require" required> 원
                                    </td>
                                </tr>
                                <tr>
                                    <td>가로+세로+높이</td>
                                    <td>
                                        가로: <input type="text" name="DEL_CONTENT_WIDTH" class="item-width require" required>
                                        세로: <input type="text" name="DEL_CONTENT_LENGTH" class="item-length require" required>
                                        높이: <input type="text" name="DEL_CONTENT_HEIGHT" class="item-height require" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>무게</td>
                                    <td>
                                        <select name="DEL_CONTENT_WEIGHT" class="item-weight-select require" required>
                                            <option value="">선택</option>
                                            <option value="1">1kg 이내</option>
                                            <option value="2">2kg 이내</option>
                                            <option value="3">3kg 이내</option>
                                            <option value="4">5kg 이내</option>
                                            <option value="5">7kg 이내</option>
                                            <option value="6">10kg 이내</option>
                                            <option value="7">10kg 초과</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>이미지</td>
                                    <td>
                                    <!-- 
                                        <ul class="image-container">
                                            <li><input type="file" id="DEL_CONTENT_PICTURE" name="DEL_CONTENT_PICTURE"></li>                                        
                                        </ul>
                                        <input type="button" value="추가" class="add-btn">
                                        <input type="button" value="삭제" class="del-btn">
                                      -->   
	                                    <input type="file" id="DEL_CONTENT_PICTURE" name="file" required/>
	                                    <div class="select_img"><img src=""/></div>
	                                     <%=request.getRealPath("/") %>
	                                </td>
                                </tr>
                                <tr>
                                    <td>제품설명</td>
                                    <td>
                                        <textarea name="DEL_CONTENT_EXPLAIN"></textarea>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>주의사항</td>
                                    <td class="text-col">
                                        <textarea name="DEL_CONTENT_WARN"></textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                
                    <section class="reg-delivery location depart">
                        <h1>출발장소</h1>
                        <table>
                            <tbody>
                                <tr>
                                    <td class="title-col">출발지 선택</td>
                                    <td>
                                        <input type="button" value="장소 목록 선택" class="add-popup-btn" required>
                                        <input type="hidden" name="LOCATION_TYPE" value="1">
                                    </td>
                                </tr>
                                <tr>
                                    <td>담당자</td>
                                    <td>
                                        <input type="text" name="CHARHER" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>연락처</td>
                                    <td>
                                        <input type="text" name="LOCATION_CELLPHONE" class="depart-phone" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송지 주소</td>
                                    <td class="add-row departure-add-row">
                                        <input type="text" class="zip require depart-zip" name="LOCATION_POST" readonly required>
                                        <input type="button" class="address-search-button" value="주소 검색">
                                        <br>
                                        <input type="text" id="LOCATION_ADDRESS" class="address-basic address require depart-add " name="LOCATION_ADDRESS" readonly required><br>
                                        <input type="text" id="LOCATION_ADDRESS_DTAIL" class="address-detail address depart-add-dtl" name="LOCATION_ADDRESS_DTL" placeholder="상세 주소">
                                        <input type="hidden" class="depart-x require" name="departureLatitudeX">
                                        <input type="hidden" class="depart-y require" name="departureLongitudeY">
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
                                    <td class="title-col">도착지 선택</td>
                                    <td>
                                        <input type="button" value="장소 목록 선택" class="add-popup-btn">
                                        <input type="hidden" name="LOCATION_TYPE_ARRIVAL" value="2">
                                    </td>
                                </tr>
                                <tr>
                                    <td>담당자</td>
                                    <td>
                                        <input type="text" name="CHARHER_ARRIVAL" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>연락처</td>
                                    <td>
                                        <input type="text" name="LOCATION_CELLPHONE_ARRIVAL" class="arrival-phone" required>
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송지 주소</td>
                                    <td class="add-row arrival-add-row">
                                        <input type="text" class="zip require arrival-zip" name="LOCATION_POST_ARRIVAL" readonly required>
                                        <button class="address-search-button">우편번호</button>
                                        <br>
                                        <input type="text" class="address-basic address require arrival-add" name="LOCATION_ADDRESS_ARRIVAL" readonly required><br>
                                        <input type="text" class="address-detail address arrival-add-dtl" name="LOCATION_ADDRESS_DTL_ARRIVAL" placeholder="상세 주소">
                                    	<input type="hidden" class="arrival-x require" name="arrivalLatitudeX">
                                        <input type="hidden" class="arrival-y require" name="arrivalLongitudeY">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                                    
					<div class="map" style="display: none"></div>
                     
                    <section class="reg-delivery">
                        <h1>배송정보</h1>
                        <table>
                            <tbody>
                                <tr>
                                    <td class="title-col">픽업시간</td>
                                    <td>
                                        최소 픽업 시간: <input type="time" name="MIN_PICKUP_TIME" required>
                                         최대 픽업 시간: <input type="time" name="MAX_PICKUP_TIME" required>                         
                                    </td>
                                </tr>
                                <tr>
                                    <td>도착시간</td>
                                    <td>
                                        최소 도착 시간: <input type="time" name="MIN_ARRIVE_TIME" required>
                                         최대 도착 시간: <input type="time" name="MAX_ARRIVE_TIME" required>                                
                                    </td>
                                </tr>
                                <tr>
                                    <td>마감시간</td>
                                    <td>
                                        <input type="time" name="FINISH_TIME" required>                                   
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송방법</td>
                                    <td>
                                        <input type="radio" name="DEL_METHOD_CODE" value="1" required> 도보 
                                        <input type="radio" name="DEL_METHOD_CODE" value="2"> 자전거 
                                        <input type="radio" name="DEL_METHOD_CODE" value="3"> 대중교통 
                                        <input type="radio" name="DEL_METHOD_CODE" value="4"> 오토바이 
                                        <input type="radio" name="DEL_METHOD_CODE" value="5"> 자가용
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                
                    <div class="btn-wrap" style="margin-bottom: 50px;">
                        <input type="button" value="배송비 계산" class="add-price">
                    </div>
                    <section class="delivery-fee-box d-none">
                        <div class="fee-box-container">
                            <div class="fee-box">
                                <h1>기본배송비</h1>
                                <ul>
                                    <li>기본배송비 3500</li>
                                    <li>
                                        + 가격 
                                        <span class="price"></span> X 5%
                                    </li>
                                    <li>
                                        = <span class="extra-price"></span>
                                    </li>
                                </ul>
                            </div>
                            <div class="fee-box">
                                <h1>할증/할인율</h1>
                                <ul>
                                    <li>
                                        [상품구분]
                                        <span class="item-section"></span>: 
                                        <span class="item-section-extra"></span>%
                                        <button class="popup-btn pop-btn1">i</button>
                                    </li>
                                    <li>
                                        [거리]
                                        <span class="item-distance"></span>km: 
                                        <span class="item-distance-extra"></span>%
                                        <button class="popup-btn pop-btn2">i</button>
                                    </li>
                                    <li>
                                        [크기]
                                        <span class="item-size"></span>cm: 
                                        <span class="item-size-extra"></span>%
                                        <button class="popup-btn pop-btn3">i</button>
                                    </li>
                                    <li>
                                        [무게]                                    
                                        <span class="item-weight"></span>kg: 
                                        <span class="item-weight-extra"></span>%
                                        <button class="popup-btn pop-btn4">i</button>
                                    </li>
                                    <li>
                                        = <span class="extra-total"></span>%
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="total-fee">
                            배송비 : <input type="text" class="total-price" value="0" name="DELIVERY_PRICE" readonly>원
                        </div>
                                
                        <div class="layer-popup1 popup">
                            <h1>
                                <span>상품 할증율</span>
                                <span class="close">X</span>
                            </h1>
                            <table>
                                <thead>
                                    <tr>
                                        <th>상품구분</th>
                                        <th>할증율</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>공산품</td>
                                        <td>0%</td>
                                    </tr>
                                    <tr>
                                        <td>신선식품</td>
                                        <td>10%</td>
                                    </tr>
                                    <tr>
                                        <td>냉동식품</td>
                                        <td>20%</td>
                                    </tr>
                                    <tr>
                                        <td>화훼상품</td>
                                        <td>30%</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
        
                        <div class="layer-popup3 popup">
                            <h1>
                                <span>거리 할증율</span>
                                <span class="close">X</span>
                            </h1>
                            <table>
                                <thead>
                                    <tr>
                                        <th>거리구분</th>
                                        <th>할증율</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>5km 이내</td>
                                        <td>0%</td>
                                    </tr>
                                    <tr>
                                        <td>10km 이내</td>
                                        <td>5%</td>
                                    </tr>
                                    <tr>
                                        <td>20km 이내</td>
                                        <td>10%</td>
                                    </tr>
                                    <tr>
                                        <td>30km 이내</td>
                                        <td>15%</td>
                                    </tr>
                                    <tr>
                                        <td>40km 이내</td>
                                        <td>20%</td>
                                    </tr>
                                    <tr>
                                        <td>4km 초과</td>
                                        <td>30%</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
        
                        <div class="layer-popup3 popup">
                            <h1>
                                <span>크기(가로+세로+높이) 할증율</span>
                                <span class="close">X</span>
                            </h1>
                            <table>
                                <thead>
                                    <tr>
                                        <th>크기구분</th>
                                        <th>할증율</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>60cm 이하</td>
                                        <td>0%</td>
                                    </tr>
                                    <tr>
                                        <td>80cm 이하</td>
                                        <td>5%</td>
                                    </tr>
                                    <tr>
                                        <td>100cm 이하</td>
                                        <td>10%</td>
                                    </tr>
                                    <tr>
                                        <td>150cm 이하</td>
                                        <td>15%</td>
                                    </tr>
                                    <tr>
                                        <td>200cm 이하</td>
                                        <td>20%</td>
                                    </tr>
                                    <tr>
                                        <td>200cm 초과</td>
                                        <td>30%</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                
                        <div class="layer-popup4 popup">
                            <h1>
                                <span>무게 할증율</span>
                                <span class="close">X</span>
                            </h1>
                            <table>
                                <thead>
                                    <tr>
                                        <th>무게구분</th>
                                        <th>할증율</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1kg 이내</td>
                                        <td>0%</td>
                                    </tr>
                                    <tr>
                                        <td>2kg 이내</td>
                                        <td>5%</td>
                                    </tr>
                                    <tr>
                                        <td>3kg 이내</td>
                                        <td>10%</td>
                                    </tr>
                                    <tr>
                                        <td>5kg 이내</td>
                                        <td>15%</td>
                                    </tr>
                                    <tr>
                                        <td>7kg 이내</td>
                                        <td>20%</td>
                                    </tr>
                                    <tr>
                                        <td>10kg 이내</td>
                                        <td>30%</td>
                                    </tr>
                                    <tr>
                                        <td>10kg 초과</td>
                                        <td>40%</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                
                    </section>
                    <div class="btn-wrap">
                        <input type="submit" value="픽업 요청" class="reg-delivery-btn d-none">
                    </div>
                    
                </form>
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="/resources/js/delivery/regist.js"></script>
    <script src="/resources/js/delivery/location.js"></script>
    <script src="/resources/js/delivery/item.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9208a49e43122414ba9c09f6888a8f3e&libraries=services"></script>
    <script src="/resources/js/postcode.js"></script>
    <script>
		//컨트롤러에서 데이터 받기
		var jsonData = JSON.parse('${catagoryList}');

		console.log(jsonData)

		var cateArr = new Array();
		var cateObj = new Object();

		//셀렉트 박스에 삽입할 데이터 준비
		for(var i = 0; i < jsonData.length; i++) {
 
            cateObj = new Object();  //초기화
            cateObj.CATAGORY_ID = jsonData[i].CATAGORY_ID;
            cateObj.CATAGORY_NAME = jsonData[i].CATAGORY_NAME;
            cateArr.push(cateObj);
		}

		//1차 분류 셀렉트 박스에 데이터 삽입
		var cateSelect = $("select.catagory")

		for(var i = 0; i < cateArr.length; i++) {  
			cateSelect.append("<option value='" + cateArr[i].CATAGORY_ID + "'>"
				      + cateArr[i].CATAGORY_NAME + "</option>");    
		}
		
		//이미지 첨부
		$("#DEL_CONTENT_PICTURE").change(function(){
  			 if(this.files && this.files[0]) {
    				var reader = new FileReader;
    				reader.onload = function(data) {
     				$(".select_img img").attr("src", data.target.result).width(500);        
    				}
    		reader.readAsDataURL(this.files[0]);
   				}
 		 });
		
		//상품 목록 페이지 버튼
		$(document).ready(
			function() {
			
			//로더 지원 목록 팝업(한상희)
			$('#itemList').on(
					"click",
					function(event) {
						window.open("/delivery/itemList", "상품목록", "width=800, height=500, left=600, top=100");
					});

			$('.delivery-ing').on("click", function(event) {
				location.href = "/deliveryList?"
				+ 'page=1'
				+ "&deliveryState=I"
				+ "&keyword=";
			});
			
			$('.delivery-complete').on("click", function(event) {
				location.href = "/deliveryList?"
				+ 'page=1'
				+ "&deliveryState=C"
				+ "&keyword=";
			});
		});
	</script>
</body>
</html>