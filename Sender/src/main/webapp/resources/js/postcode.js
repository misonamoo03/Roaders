window.addEventListener("load",()=>{
	
	let mapContainer = document.querySelector('.map');
    let mapOption;
    let map;
    let x,y = "";

    let departureAddressTd = document.querySelector(".departure-add-row");
	let departureAddressBtn = departureAddressTd.querySelector(".address-search-button");
    let departureZipcode = departureAddressTd.querySelector(".zip");
    let departureAddressBasic = departureAddressTd.querySelector(".address-basic");
    let departureAddressDetail = departureAddressTd.querySelector(".address-detail");
    let departX = departureAddressTd.querySelector('.depart-x');
    let departY = departureAddressTd.querySelector('.depart-y');
    
    let arrivalAddressTd = document.querySelector(".arrival-add-row");
	let arrivalAddressBtn = arrivalAddressTd.querySelector(".address-search-button");
    let arrivalZipcode = arrivalAddressTd.querySelector(".zip");
    let arrivalAddressBasic = arrivalAddressTd.querySelector(".address-basic");
    let arrivalAddressDetail = arrivalAddressTd.querySelector(".address-detail");
    let arrivalX = arrivalAddressTd.querySelector('.arrival-x');
    let arrivalY = arrivalAddressTd.querySelector('.arrival-y');

    let addPriceBtn = document.querySelector('.add-price');

    let dX = '';
    let dY = '';

    departureAddressBtn.onclick = (e)=>{    	
    	e.preventDefault();
        execPostCode1();        
	}
    
    arrivalAddressBtn.onclick = (e)=>{    	
    	e.preventDefault();
        execPostCode2();        
    }

    departureAddressDetail.onblur = (e)=>{    	
        e.preventDefault();
        departCoord();
	}
    
    arrivalAddressDetail.onblur = (e)=>{    	
    	e.preventDefault();
        arrivalCoords();
    }
    
	function execPostCode1() {
		
		new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                let addr = ''; // 주소 변수
                let extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                departureZipcode.value = data.zonecode;
                departureAddressBasic.value = addr;
                // 커서를 상세주소 필드로 이동한다.
                departureAddressDetail.focus();
            }            
        }).open();

    }
	
	//출발지 주소로 좌표 얻기
    if (departureAddressBasic.value=="") {
        mapOption = {
            center: new daum.maps.LatLng(33.450701, 126.570667), 
            // 임의의 지도 중심좌표 , 제주도 다음본사로 잡아봤다.
            level: 4
            // 지도의 확대 레벨
	    };
    }

    // 지도 생성
    map = new daum.maps.Map(mapContainer, mapOption);

    var departCoord = function departCoords(){
        var gap = departureAddressBasic.value; // 주소검색어
        if (gap=="") {
            alert("주소 검색어를 입력해 주십시오.");
            departureAddressBasic.focus();
            return;
        }
    
        // 주소-좌표 변환 객체를 생성
        var geocoder = new daum.maps.services.Geocoder();

        // 주소로 좌표를 검색
        geocoder.addressSearch(gap, function(result, status) {
        
            // 정상적으로 검색이 완료됐으면,
            if (status == daum.maps.services.Status.OK) {
        
                var coords = new daum.maps.LatLng(result[0].y, result[0].x);

                y = result[0].x;
                x = result[0].y;

                // 결과값으로 받은 위치를 마커로 표시합니다.
                var marker = new daum.maps.Marker({
                    map: map,
                    position: coords
                });

                // 인포윈도우로 장소에 대한 설명표시
                var infowindow = new daum.maps.InfoWindow({
                    content: '<div style="width:150px;text-align:center;padding:5px 0;">좌표위치</div>'
                });

                infowindow.open(map,marker);
                
                // 지도 중심을 이동
                map.setCenter(coords);

                departX.value = x;
                departY.value = y;

            }
        });
    }


	function execPostCode2() {
		
		new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

        
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                let addr = ''; // 주소 변수
                let extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                arrivalZipcode.value = data.zonecode;
                arrivalAddressBasic.value = addr;
                // 커서를 상세주소 필드로 이동한다.
                arrivalAddressDetail.focus();
            }
        }).open();

    }
    
    //도착지 주소로 좌표 얻기
    function arrivalCoords(){
        var gap = arrivalAddressBasic.value; // 주소검색어
        if (gap=="") {
            alert("주소 검색어를 입력해 주십시오.");
            arrivalAddressBasic.focus();
            return;
        }
    
        // 주소-좌표 변환 객체를 생성
        var geocoder = new daum.maps.services.Geocoder();

        // 주소로 좌표를 검색
        geocoder.addressSearch(gap, function(result, status) {
        
            // 정상적으로 검색이 완료됐으면,
            if (status == daum.maps.services.Status.OK) {
        
                var coords = new daum.maps.LatLng(result[0].y, result[0].x);

                y = result[0].x;
                x = result[0].y;

                // 결과값으로 받은 위치를 마커로 표시합니다.
                var marker = new daum.maps.Marker({
                    map: map,
                    position: coords
                });

                // 인포윈도우로 장소에 대한 설명표시
                var infowindow = new daum.maps.InfoWindow({
                    content: '<div style="width:150px;text-align:center;padding:5px 0;">좌표위치</div>'
                });

                infowindow.open(map,marker);
                
                // 지도 중심을 이동
                map.setCenter(coords);

                arrivalX.value = x;
                arrivalY.value = y;
                
            }
        });
    }

});