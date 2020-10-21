<template>
   <div v-bind:style="detailContainer">
      <section class="reg-delivery" v-bind:style="itemDetail">
         
         
         <div v-bind:style="itemImg">               
            <img :src="item.delContentPicture">
         </div>
         <div>
            <h1 v-bind:style="title">{{item.delContentName}}</h1>
            <table>
               <tr>
                  <td class="title-col">카테고리</td>
                  <td>{{item.categoryName}}</td>
               </tr>
               <tr>
                  <td>상품구분</td>
                  <td>{{item.delContentType}}</td>
               </tr>
               <tr>
                  <td>상품가격</td>
                  <td>{{item.delContentPrice}}</td>
               </tr>
               <tr>
                  <td>가로+세로+높이</td>
                  <td>{{itemSize}}</td>
               </tr>
               <tr>
                  <td>무게</td>
                  <td>{{item.delContentWeight}}</td>
               </tr>
               <tr>
                  <td>배송비</td>
                  <td>{{item.delContentPrice}}</td>
               </tr>
            </table>
            <div v-bind:style="buttonWrap">
               <span v-if="item.deliveryState == '0'">
                  <button @click="requestPop" type="button">배송지원</button>
               </span>
               <span v-if="item.deliveryState == '1'">
                  배송지원이 완료되었습니다.
               </span>
               <span v-else-if="item.deliveryState == '2'">
                  <button @click="pickupPop" type="button">픽업하기</button>
               </span>
               <span v-else-if="item.deliveryState == '3'">
                  센더가 픽업 승인 중.
               </span>
               <span v-else-if="item.deliveryState == '4'">
                  <button @click="completePop" type="button">배송완료</button>
               </span> 
               <span v-else-if="item.deliveryState == '5'">
               샌더가 로더 평가 중.
               </span>         
               <span v-else-if="item.deliveryState == '6'">
                  <button @click="reviewPop" type="button">평가하기</button>
               </span>
               <span v-else-if="item.deliveryState == '7'">완료</span>
            </div>
         </div>
      </section>

   <!--
      <section class="reg-delivery">
         <h1>SENDERS 정보</h1>

         <ul>
            <li>
               <b>{{item.suserId}} ({{item.suserName}})</b>
               <span v-if="item.gradeCode === '1'"> 골드회원</span>
               <span v-else-if="item.gradeCode === '2'"> 실버회원</span>
               <span v-else-if="item.gradeCode === '3'"> 브론즈회원</span>
            </li>
            <li>
               <span v-if="item.sendAvrPoint === '5'">★★★★★</span>
               <span v-else-if="item.sendAvrPoint === '4'">★★★★☆</span>
               <span v-else-if="item.sendAvrPoint === '3'">★★★☆☆</span>
               <span v-else-if="item.sendAvrPoint === '2'">★★☆☆☆</span>
               <span v-else-if="item.sendAvrPoint === '1'">★☆☆☆☆</span>
               <span v-else-if="item.sendAvrPoint === null"></span>
            </li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
         </ul>

         

      </section>
-->
      <section class="reg-delivery">
         <h1>배송 정보</h1>
         <table>
            <tr>
               <td class="title-col">제품 설명</td>
               <td>{{item.delContentExplain}}</td>
            </tr>
            <tr>
               <td>주의 사항</td>
               <td>{{item.delContentWarn}}</td>
            </tr>
         </table>
      </section>

      <div id="map" style="margin-bottom: 30px; width: 100%; height: 450px; z-inde: 1"></div>

      <input type="hidden" v-bind:value="item.departLatitude">
      <input type="hidden" v-bind:value="item.departLongTitude">
      <input type="hidden" v-bind:value="item.arrivalLatitude">
      <input type="hidden" v-bind:value="item.arrivalLongTitude">

      <section class="reg-delivery">
         <h1>출발 장소</h1>
         <table>
            <tr>
               <td class="title-col">담당자</td>
               <td>{{item.departCharher}}</td>
            </tr>
            <tr>
               <td>연락처</td>
               <td>{{item.departPhone}}</td>
            </tr>
            <tr>
               <td>출발장소 주소</td>
               <td>
                  {{item.departPost}} / {{item.departAddress}} {{item.departAddressDetail}}
               </td>
            </tr>
         </table>
      </section>

      <section class="reg-delivery">
         <h1>도착 장소</h1>
         <table>
            <tr>
               <td class="title-col">담당자</td>
               <td>{{item.arrivalCharher}}</td>
            </tr>
            <tr>
               <td>연락처</td>
               <td>{{item.arrivalPhone}}</td>
            </tr>
            <tr>
               <td>도착장소 주소</td>
               <td>
                  {{item.arrivalPost}} / {{item.arrivalAddress}} {{item.arrivalAddressDetail}}
               </td>
            </tr>
         </table>
      </section>

      <section class="reg-delivery">
         <h1>배송 정보</h1>
         <table>
            <tr>
               <td class="title-col">픽업시간</td>
               <td>{{item.minPickupTime}} ~ {{item.maxPickupTime}}</td>
            </tr>
            <tr>
               <td>도착시간</td>
               <td>{{item.minArriveTime}} ~ {{item.maxArriveTime}}</td>
            </tr>
            <tr>
               <td>마감시간</td>
               <td>
                  {{item.finishTime}}
               </td>
            </tr>
            <tr>
               <td>배송방법</td>
               <td>
                  <span v-if="delMethodCode == '1'">도보</span>
                  <span v-else-if="delMethodCode == '2'">자전거</span>
                  <span v-else-if="delMethodCode == '3'">대중교통</span>
                  <span v-else-if="delMethodCode == '4'">오토바이</span>
                  <span v-else-if="delMethodCode == '5'">자가용</span>
               </td>
            </tr>
         </table>
      </section>

      <span v-if="item.deliveryState == '0'">
         <button @click="requestPop" type="button">배송지원</button>
      </span>
      <span v-if="item.deliveryState == '1'">
         배송지원이 완료되었습니다.
      </span>
      <span v-else-if="item.deliveryState == '2'">
         <button @click="pickupPop" type="button">픽업하기</button>
      </span>
      <span v-else-if="item.deliveryState == '3'">
         센더가 픽업 승인 중.
      </span>
      <span v-else-if="item.deliveryState == '4'">
         <button @click="completePop" type="button">배송완료</button>
      </span> 
      <span v-else-if="item.deliveryState == '5'">
        샌더가 로더 평가 중.
      </span>         
      <span v-else-if="item.deliveryState == '6'">
         <button @click="reviewPop" type="button">평가하기</button>
      </span>
      <span v-else-if="item.deliveryState == '7'">완료</span>
      
      <div v-bind:style="popup" v-show="requestDelivery_show" style="z-index: 999;">
     
            
            <b>배송지원메세지</b> <br>
            <input type="text" v-model="message"><br>
            <input type="time" v-model="pickupTime"><br>
            
            <input type="hidden" v-bind:value="item.deliveryNumber"><br>

            <button type="button" @click="requestDelivery">배송지원 </button>

         <button @click="requestPop" type="button">닫기 </button>               
      </div>

      <div v-bind:style="popup" v-show="registPickup_show" style="z-index: 999;">
            
         <b>픽업메세지</b><br>
         <input type="text" v-model="message"><br>
         
         <input type="hidden" v-bind:value="item.deliveryNumber"><br>

         <button type="button" @click="registPickup">픽업하기 </button>

         <button @click="pickupPop" type="button">닫기</button>            
      </div>

      <div v-bind:style="popup" v-show="completeDelHistory_show" style="z-index: 999;">
            
            <b>배송완료메세지</b><br>
            <input type="text" v-model="message"><br>
            
            <input type="hidden" v-bind:value="item.deliveryNumber"><br>

            <button type="button" @click="completeDelHistory">배송완료  </button>
         <button @click="completePop" type="button">닫기 </button>            
      </div>

      <div v-bind:style="popup" v-show="reviewDelivery_show" style="z-index: 999;">

         
         <b>평가하기</b><br>

                     친절
         <select v-model="kindly">
            <option 
               v-for="kindlyOption in kindlyOptions" 
               v-bind:value="kindlyOption.value" 
               v-bind:key="kindlyOption.id">
               {{ kindlyOption.text }}
            </option>
         </select><br>
         <input type="hidden" v-model="kindly">

                     약속 
         <select v-model="promise">
            <option 
               v-for="promiseOption in promiseOptions" 
               v-bind:value="promiseOption.value" 
               v-bind:key="promiseOption.id">
               {{ promiseOption.text }}
            </option>
         </select><br>
         <input type="hidden" v-model="promise"><br>

         
         <input type="text" v-model="message"><br>


         <input type="hidden" v-bind:value="item.deliveryNumber" name="delNumber">
         <input type="hidden" v-bind:value="item.suserNo" name="suserNo">
         

         <button type="button" @click="reviewDelivery">평가 </button>

         <button @click="reviewPop" type="button">닫기 </button>            
      </div>
   </div>
</template>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9208a49e43122414ba9c09f6888a8f3e&libraries=services"></script>

<script>
   import axios from 'axios'
   import Vue from 'vue';
   import VueSession from 'vue-session'
   Vue.use(VueSession)

   export default {   
      data: function (){
         return {

            item : 'item',
            itemSize: 'itemSize',
            delMethodCode: 'delMethodCode',
            deliveryNumber: 'deliveryNumber',
            message: 'message',
            pickupTime: '',
            ruserId: '',

            suserNo: '1',            
            kindly: '5',
            kindlyOptions: [
               {text: '★★★★★', value: '5'},
               {text: '★★★★☆', value: '4'},
               {text: '★★★☆☆', value: '3'},
               {text: '★★☆☆☆', value: '2'},
               {text: '★☆☆☆☆', value: '1'}
            ],

            promise: '5',
            promiseOptions: [
               {text: '★★★★★', value: '5'},
               {text: '★★★★☆', value: '4'},
               {text: '★★★☆☆', value: '3'},
               {text: '★★☆☆☆', value: '2'},
               {text: '★☆☆☆☆', value: '1'}
            ],

            requestDelivery_show: false,
            registPickup_show: false,
            completeDelHistory_show: false,
            reviewDelivery_show: false,

            detailContainer: {
               position: 'relative',
               margin: '0 auto',
               width: '1000px',
               padding: '30px 0'
            },
            itemDetail: {
               marginBottom: '50px',
               display: 'flex'
            },
            itemImg: {
               minWidth: '400px'
            },
            buttonWrap: {
               marginTop: '30px'
            },
            title: {
               fontSize: '20px',
               fontWeight: 'bold'
            },
            popup: {
               position: 'absolute',
               top: '50%',
               left: '50%',
               trasform: 'translateX(-50%)',
               padding: '20px',
               boxSizing: 'border-box',
               width: '400px',
               height: '300px',
               backgroundColor: '#fff',
               border: '1px solid #979797'
            }
         }
      },
      methods: {
         getPosts: function (event) {
            let self = this;              

            var params = location.href.substr(location.href.indexOf("/") + 1);
            params = params.split("/");

            
            var ruserId = document.cookie.substr(document.cookie.indexOf("=") + 1);
            ruserId = ruserId.split("/");
            console.log();

            axios({
               method: 'post',
               url: '/delivery/detail',
               headers: {'Content-Type': 'application/json'},
               params: {
                  deliveryNumber: params[3]
               }
            })
            .then(function(res){
               console.log(res.data);
               self.item = res.data;
               self.itemSize = 
                  parseInt(res.data.delContentWidth) 
                  + parseInt(res.data.delContentHeight)
                  + parseInt(res.data.delContentLength);
               self.delMethodCode = res.data.delMethodCode;
               self.deliveryNumber = res.data.deliveryNumber;
               self.ruserId = ruserId[0];
            });
            
            // axios({
            //    method: 'get',
            //    url: '/loginChk',
            //    headers: {'Content-Type': 'application/json'}
            // })
            // .then(function(res){
            //    self.ruserId = res.data.ruserId;
            // });
         },

         requestPop: function(e){
            e.preventDefault();
            
            this.requestDelivery_show = !this.requestDelivery_show;
         },

         requestDelivery: function(e){
            let self = this;     
            e.preventDefault();

            axios({
               method: 'post',
               url: '/delivery/requestDelivery',
               headers: {'Content-Type': 'application/json'},
               data: {
                  deliveryNumber: this.deliveryNumber,
                  pickupTime: this.pickupTime,
                  message: this.message,
                  ruserId: this.ruserId
               }
            }).then(function(){
               self.requestDelivery_show = !self.requestDelivery_show;
               self.getPosts();
            });
         },

         pickupPop: function(e){
            e.preventDefault();
            
            this.registPickup_show = !this.registPickup_show;
         },

         registPickup: function(e){
            let self = this;     
            e.preventDefault();

            axios({
               method: 'post',
               url: '/delivery/registPickup',
               headers: {'Content-Type': 'application/json'},
               data: {
                  deliveryNumber: this.deliveryNumber,
                  message: this.message
               }
            }).then(function(){
               self.registPickup_show = !self.registPickup_show;
               self.getPosts();
            });
         },

         completePop: function(e) {            
            e.preventDefault();
            
            this.completeDelHistory_show = !this.completeDelHistory_show;
         },
         
         completeDelHistory: function(e){        
            
            let self = this;     
            e.preventDefault();

            axios({
               method: 'post',
               url: '/delivery/completeDelHistory',
               headers: {'Content-Type': 'application/json'},
               data: {
                  deliveryNumber: this.deliveryNumber,
                  message: this.message
               }
            }).then(function(){
               self.completeDelHistory_show = !self.completeDelHistory_show;
               self.getPosts();
            });
         },

         reviewPop: function(e){
            e.preventDefault();

            this.reviewDelivery_show = !this.reviewDelivery_show;
         },

         reviewDelivery: function(e){
            
            let self = this;     
            e.preventDefault();

            axios({
               method: 'post',
               url: '/delivery/reviewDelivery',
               headers: {'Content-Type': 'application/json'},
               data: {
                  totalStar: Math.round((parseInt(this.kindly)+parseInt(this.promise))/2),
                  kindly: this.kindly,
                  promise: this.promise,
                  deliveryNumber: this.deliveryNumber,
                  message: this.message,
                  suserNo: this.suserNo
               }
            }).then(function(){
               self.reviewDelivery_show = !self.reviewDelivery_show;
               self.getPosts();
            });

         },

         addKakaoMapScript: function() {
            const script = document.createElement("script");
            /* global kakao */
            script.onload = () => kakao.maps.load(this.initMap);
            script.src =
            "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9208a49e43122414ba9c09f6888a8f3e";
            document.head.appendChild(script);
         },
         initMap: function() {

            this.self = this;

            var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
            var options = {
               //지도를 생성할 때 필요한 기본 옵션
               center: new kakao.maps.LatLng(this.item.departLatitude, this.item.departLongTitude), //지도의 중심좌표.
               level: 10
            };

            var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

            // 마커를 표시할 위치와 title 객체 배열입니다 
            var positions = [
               {
                  latlng: new kakao.maps.LatLng(this.item.departLatitude, this.item.departLongTitude),
                  text: '출발'
               },
               {
                  latlng: new kakao.maps.LatLng(this.item.arrivalLatitude, this.item.arrivalLongTitude),
                  text: '도착'
               }
            ];

            // 마커 이미지의 이미지 주소입니다
            var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
               
            for (var i = 0; i < positions.length; i ++) {
               
               // 마커 이미지의 이미지 크기 입니다
               var imageSize = new kakao.maps.Size(50, 72); 
               
               // 마커 이미지를 생성합니다    
               var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
               
               // 마커를 생성합니다
               var marker = new kakao.maps.Marker({
                  map: map, // 마커를 표시할 지도
                  position: positions[i].latlng, // 마커를 표시할 위치
                  title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                  text: positions[i].text,
                  image : markerImage // 마커 이미지 
               });

            }
         }
                

      },
      created: function() {
         let self = this;
         this.getPosts();

         window.kakao && window.kakao.maps
         ? this.initMap()
         : this.addKakaoMapScript();
      },
      beforeUpdate: function(){
         let self = this;
      },
      update: function(){
         this.self = this;
         this.reviewDelivery();
      }

   };
</script>

<style>

</style>

