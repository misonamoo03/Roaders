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
                    <section class="reg-delivery">
                        <h1>택배 기본정보</h1>
                        <table>
                            <tbody>
                                <tr>
                                    <td class="title-col">택배 종류</td>
                                    <td>
            							<input type="radio" name="DEL_CONTENT_STATE" value="보내기" <c:if test = "${d.DEL_CONTENT_STATE eq '보내기'}">checked="checked"</c:if>> 보내기                        
                                      	<input type="radio" name="DEL_CONTENT_STATE" value="가져오기" <c:if test = "${d.DEL_CONTENT_STATE eq '가져오기'}">checked="checked"</c:if>> 가져오기                    	
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
                                        <input type="text" name="DEL_CONTENT_NAME" value="${d.DEL_CONTENT_NAME}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>카테고리</td>
                                    <td>
                                        <select name="CATAGORY_ID" class="catagory">
                                            <option value="">선택</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품구분</td>
                                    <td>
                                        <select name="DEL_CONTENT_TYPE" class="item-section-select require itemType">
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
                                        <input type="text" name="DEL_CONTENT_PRICE" class="require" value="${d.DEL_CONTENT_PRICE}"> 원
                                    </td>
                                </tr>
                                <tr>
                                    <td>가로+세로+높이</td>
                                    <td>
                                        가로: <input type="text" name="DEL_CONTENT_WIDTH" value="${d.DEL_CONTENT_WIDTH}" class="item-width require">
                                        세로: <input type="text" name="DEL_CONTENT_LENGTH" value="${d.DEL_CONTENT_LENGTH}" class="item-length require">
                                        높이: <input type="text" name="DEL_CONTENT_HEIGHT" value="${d.DEL_CONTENT_HEIGHT}" class="item-height require">
                                    </td>
                                </tr>
                                <tr>
                                    <td>무게</td>
                                    <td>
                                        <select name="DEL_CONTENT_WEIGHT" class="item-weight-select weight require">
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
	                                     
	                                    <input type="file" id="DEL_CONTENT_PICTURE" name="file" />
	                                    <div class="select_img">
	                                    <img src="${d.DEL_CONTENT_PICTURE_Thum}"/>
	                                    <input type="hidden" name = "DEL_CONTENT_PICTURE" value="${d.DEL_CONTENT_PICTURE}">
	                                    <input type="hidden" name = "DEL_CONTENT_PICTURE_Thum" value="${d.DEL_CONTENT_PICTURE_Thum}">
	                                    </div>
	                                     <%=request.getRealPath("/") %>
	                                </td>
                                </tr>
                                <tr>
                                    <td>제품설명</td>
                                    <td>
                                        <textarea name="DEL_CONTENT_EXPLAIN">${d.DEL_CONTENT_EXPLAIN}</textarea>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>주의사항</td>
                                    <td class="text-col">
                                        <textarea name="DEL_CONTENT_WARN">${d.DEL_CONTENT_WARN}</textarea>
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
                                    <td class="title-col">출발지 선택</td>
                                    <td>
                                        <input type="checkbox"> 신규장소
                                        <input type="button" value="장소 목록 선택">
                                        <input type="hidden" name="LOCATION_TYPE" value="출발">
                                    </td>
                                </tr>
                                <tr>
                                    <td>담당자</td>
                                    <td>
                                        <input type="text" name="CHARHER" value="${d.DEPART_CHARHER}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>연락처</td>
                                    <td>
                                        <input type="text" name="LOCATION_CELLPHONE" value="${d.DEPART_PHONE}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송지 주소</td>
                                    <td class="add-row departure-add-row">
                                        <input type="text" class="zip required" name="LOCATION_POST" value="${d.DEPART_POST}" readonly>
                                        <button class="address-search-button">우편번호</button>
                                        <input type="checkbox"> 장소 목록 추가
                                        <br>
                                        <input type="text" class="address-basic address required" name="LOCATION_ADDRESS" value="${d.DEPART_ADDRESS}" readonly><br>
                                        <input type="text" class="address-detail address" name="LOCATION_ADDRESS_DTL" value="${d.DEPART_ADDRESS_DTL}" placeholder="상세 주소">
                                    	<input type="hidden" class="depart-x require" name="departureLatitudeX" value="${d.DEPART_LATITUDE}">
                                        <input type="hidden" class="depart-y require" name="departureLongitudeY" value="${d.DEPART_LONGITUDE}">
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
                                        <input type="button" value="장소 목록 선택">
                                        <input type="hidden" name="LOCATION_TYPE_ARRIVAL" value="도착">
                                    </td>
                                </tr>
                                <tr>
                                    <td>담당자</td>
                                    <td>
                                        <input type="text" name="CHARHER_ARRIVAL" value="${d.ARRIVAL_CHARHER}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>연락처</td>
                                    <td>
                                        <input type="text" name="LOCATION_CELLPHONE_ARRIVAL" value="${d.ARRIVAL_PHONE}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송지 주소</td>
                                    <td class="add-row arrival-add-row">
                                        <input type="text" class="zip required" name="LOCATION_POST_ARRIVAL" value="${d.ARRIVAL_POST}" readonly>
                                        <button class="address-search-button">우편번호</button>
                                        <input type="checkbox"> 장소 목록 추가
                                        <br>
                                        <input type="text" class="address-basic address required" name="LOCATION_ADDRESS_ARRIVAL" value="${d.ARRIVAL_ADDRESS}" readonly><br>
                                        <input type="text" class="address-detail address" name="LOCATION_ADDRESS_DTL_ARRIVAL" value="${d.ARRIVAL_ADDRESS_DTL}" placeholder="상세 주소">
                                    	<input type="hidden" class="arrival-x require" name="arrivalLatitudeX" value="${d.ARRIVAL_LATITUDE}">
                                        <input type="hidden" class="arrival-y require" name="arrivalLongitudeY" value="${d.ARRIVAL_LONGITUDE}">
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
                                        최소 픽업 시간: <input type="time" name="MIN_PICKUP_TIME" value="${d.MIN_PICKUP_TIME}">
                                         최대 픽업 시간: <input type="time" name="MAX_PICKUP_TIME" value="${d.MAX_PICKUP_TIME}">                         
                                    </td>
                                </tr>
                                <tr>
                                    <td>도착시간</td>
                                    <td>
                                        최소 도착 시간: <input type="time" name="MIN_ARRIVE_TIME" value="${d.MIN_ARRIVE_TIME}">
                                         최대 도착 시간: <input type="time" name="MAX_ARRIVE_TIME" value="${d.MAX_ARRIVE_TIME}">                                
                                    </td>
                                </tr>
                                <tr>
                                    <td>마감시간</td>
                                    <td>
                                        <input type="time" name="FINISH_TIME" value="${d.FINISH_TIME}">                                   
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송방법</td>
                                    <td>
                                        <input type="radio" name="DEL_METHOD_CODE" value="1" <c:if test = "${d.DEL_METHOD_CODE eq '1'}">checked="checked"</c:if>> 도보 
                                        <input type="radio" name="DEL_METHOD_CODE" value="2" <c:if test = "${d.DEL_METHOD_CODE eq '2'}">checked="checked"</c:if>> 자전거 
                                        <input type="radio" name="DEL_METHOD_CODE" value="3" <c:if test = "${d.DEL_METHOD_CODE eq '3'}">checked="checked"</c:if>> 대중교통 
                                        <input type="radio" name="DEL_METHOD_CODE" value="4" <c:if test = "${d.DEL_METHOD_CODE eq '4'}">checked="checked"</c:if>> 오토바이 
                                        <input type="radio" name="DEL_METHOD_CODE" value="5" <c:if test = "${d.DEL_METHOD_CODE eq '5'}">checked="checked"</c:if>> 자가용
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                
                    <div class="btn-wrap" style="margin-bottom: 50px;">
                        <input type="button" value="배송비 계산" class="add-price">
                    </div>
                    <section class="delivery-fee-box d-none" style="margin-bottom: 50px;">
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
                                        <span class="item-weight"></span>: 
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
        
                        <div class="layer-popup2 popup">
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
                    <div class="btn-wrap del-edit-btn d-none" style="margin: 0 100px;">
	                    <a href="/delivery/list">
	                    	<input type="button" value="목록">
	                    </a>
                    	
                        <input type="submit" value="수정" class="reg-delivery-btn">
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
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9208a49e43122414ba9c09f6888a8f3e&libraries=services"></script>
    
    <script src="/resources/js/postcode.js"></script>

    <script>
		//컨트롤러에서 데이터 받기
		var jsonData = JSON.parse('${catagoryList}');

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

		// 셀렉트 박스에 불러온 데이터값 넣어주기
		var catagory_id = '${d.CATAGORY_ID}';
		var select_catagory_name = '${d.CATAGORY_NAME}';
		
        $(".catagory").val(catagory_id);
        $(".catagory").append("<option value='"
            + catagory_id + "'>" + select_catagory_name + "</option>");


        var itemTypeId = '${d.DEL_CONTENT_TYPE}';
        
        $(".itemType").val(itemTypeId);
        $(".itemType").append("<option value='"
                    + itemTypeId + "'>" + "</option>");
        

        var weightId = '${d.DEL_CONTENT_WEIGHT}';
        
        $(".weight").val(weightId);
        $(".weight").append("<option value='"
                    + weightId + "'>" + "</option>");
		
	</script>
</body>
</html>