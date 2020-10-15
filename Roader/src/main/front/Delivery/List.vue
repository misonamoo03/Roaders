<template>
<div>
<ul>
	<li v-for="item in items" :key="item.deliveryNumber">
		<a :href="'/delivery/'+item.deliveryNumber">
			배송번호 : {{item.deliveryNumber}}
		</a>
		회원사진 : <img :src="item.suserPhoto">
		회원등급 : 
			<span v-if="item.gradeCode === '1'"> 골드회원</span>
			<span v-else-if="item.gradeCode === '2'"> 실버회원</span>
			<span v-else-if="item.gradeCode === '3'"> 브론즈회원</span>
		
		회원아이디 : {{item.suserId}}
		회원이름 : {{item.suserName}}
		회원평점 : {{item.sendAvrPoint}}
		회원별점 :
			<!--<span v-for="item in item.totalStar" v-bind:key="item">★</span>-->
		
			<span v-if="item.totalStar === '5'">★★★★★</span>
			<span v-else-if="item.totalStar === '4'">★★★★☆</span>
			<span v-else-if="item.totalStar === '3'">★★★☆☆</span>
			<span v-else-if="item.totalStar === '2'">★★☆☆☆</span>
			<span v-else-if="item.totalStar === '1'">★☆☆☆☆</span>
		
		지원자수 : {{item.candiNum}}
		배송횟수 : {{item.delicnt}}
		상품이름 : {{item.delContentName}}
		상품사진 : <img :src="item.delContentPicture">
		배송 출발 장소 : {{item.startPlace}}
		배송 도착 장소 : {{item.arrivePlace}}
		픽업시간 : {{item.maxPickupTime}} 이전
		도착시간 : {{item.maxArriveTime}} 이전
		배송비 : {{item.deliveryPrice}}
		<!--레이어 팝업 부분 이 버튼을 클릭하면 레이어 팝업이 열린다.-->
		
		<button @click="handle_toggle(item.deliveryNumber,$event)" type="button">지도보기</button>
		<!--버튼이 클릭되면 아레 내용의 레이어 팝업이 열린다 v-show의 is_show값이 true일때만 내용이 표시된다.--> 
		<div class="mapArea">
			<div v-bind:id="item.deliveryNumber" style="width:50vw; height:50vh;">
				
			</div><br><br>
			출발지 : {{item.startPlace}} 픽업시간 :{{item.maxPickupTime}} 이전 픽업 <br>
			도착지 : {{item.arrivePlace}} 도착시간 : {{item.maxArriveTime}} 이전 도착<br>
			거리 :<br>
			<button @click="close" type="button">확인</button>		
		</div>
		<hr>
	</li>
</ul>
</div>
</template>
<script async type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d2a2ae7eda6d26c99b88acf6a4ac0221"></script>
<script>
import axios from 'axios'

export default {
	data(){
		return{

			/*
			 모달창에서 클릭이벤트가 발생하면 해당 deliveryNumber를 세팅해줄 변수 이 변수를 이용해 v-if에서 item.delivery값과 비교해서 같을 때만
			 열리게 해준다
			*/
			items :[], 				// 목록을 받아오기 위한 변수 axios /listAll
			points:[]				// 모달창에서 위도와 경도를 받아오기 위한 배열 axios /selectPoint
		}
	},
	mounted(){
		axios.post('/listAll') //컨트롤러에 /listAll 에 매핑된다.
			 .then(response=>{ // 반응을 하면 실행될 부분
				 this.items = response.data;
			 }),

		//레이어 팝업 지도 api호출하기
		window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
			 
	},
	methods: {

		/** 
		 레이어팝업 구현 메서드 이다. 버튼이 클릭될떄 마다 이벤트에 반응해서 item.deliveryNumber값을 idxNumber에 세팅해 준다.
		*/
		handle_toggle: function(deliveryNumber,event){
			this.idxNumber = deliveryNumber;
			$(".mapArea").hide();
			$("#"+deliveryNumber).parents().show();

			//위도와 경도를 찾는 부분, 컨트롤러를 타서 위도와 경도를 가져와 points 배열에 결과를 담게 된다.
			axios.post('/selectPoint?deliveryNumber'+deliveryNumber ,{deliveryNumber: deliveryNumber})
			.then(response=>{
				this.points = response.data;
				console.log('gd');
				console.log(response.data[0].loLati);
			});
			
			
			// 여기부터는 지도를 그리기 시작하는 부
			var container = document.getElementById(deliveryNumber); 
			//alert("#mapArea #"+deliveryNumber)
			var options = { 

			//좌표 지정하는 부분
			center: new kakao.maps.LatLng(33.450701, 126.570667), 
			level: 3 //지도의 레벨(확대, 축소 정도) 
			}; 
			var map = new kakao.maps.Map(container, options); 
			//마커추가하려면 객체를 아래와 같이 하나 만든다. 
			var marker = new kakao.maps.Marker({ 
				position: map.getCenter() 
			});
			marker.setMap(map); 

		},

		/**
		 * 모달 창을 닫기 위한 함수 기존 handle_toggle 함수에서 idxNumber에 item.deliveryNumber값을 다시 0으로 초기화 시켜준다.
		 */
		close : function(){
			$(".mapArea").hide();
		},

		initMap() {

			/*var container = $('#map'); 
			var options = { 

			//초기 좌표 지정하는 부분
			center: new kakao.maps.LatLng(33.450701, 126.570667), 
			level: 3 //지도의 레벨(확대, 축소 정도) 
			}; 
			var map = new kakao.maps.Map(container, options); 
			//마커추가하려면 객체를 아래와 같이 하나 만든다. 
			var marker = new kakao.maps.Marker({ 
				position: map.getCenter() 
			});
			marker.setMap(map);*/
			$(".mapArea").hide();
		},
		addScript() { 
			const script = document.createElement('script'); 
			/* global kakao */ 
			script.onload = () => kakao.maps.load(this.initMap); 
			script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=d2a2ae7eda6d26c99b88acf6a4ac0221'; 
			document.head.appendChild(script); 
		}
	}

}
</script>

<style >

</style>