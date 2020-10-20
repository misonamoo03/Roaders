<template>
  <div id="app">
    <form>
      <input type="text" id="ruserPoint" v-bind:value="ruserPoint" readonly />
      <button @click="plusPS" type="button">입금버튼</button>
      <button @click="minusPS" type="button">출금버튼</button>

      <li
        v-for="review in reviews"
        :key="review.index"
      >{{review.pointUpdate}}  {{review.reason}}  {{review.pointType}} {{review.ruserPoint}}₩</li>

      <div v-show="plusShow">
        <h5>입금하기</h5>
        <p>
          <input type="text" id="ruserPoint" :value="varPoint" readonly />
        </p>
        <button type="button" v-on:click="setPlusRuserPoint(1000)">+1,000</button>
        <button type="button" v-on:click="setPlusRuserPoint(10000)">+10,000</button>
        <button type="button" v-on:click="setPlusRuserPoint(100000)">+100,000</button>
        <button @click="plusP" type="button">확인</button>
      </div>

      <div v-show="minusShow">
        <h5>출금하기</h5>
        <p>
          <input type="text" id="ruserPoint" :value="varPoint" readonly />
        </p>
        <button type="button" @click="setMinusRuserPoint(1000)">-1,000</button>
        <button type="button" @click="setMinusRuserPoint(10000)">-10,000</button>
        <button type="button" @click="setMinusRuserPoint(100000)">-100,000</button>
        <button @click="minusP" type="button">확인</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data: function() {
    return {
      ruserId: "",
      ruserPoint: 0,
      plusShow: false,
      minusShow: false,
      reviews: [],
      reason: "",
      varPoint: 0,
      pointType: ""
    };
  },
  // computed: {
  //      zeroPoint: function () {
  //       if(this.ruserPoint < 0){
  //           this.ruserPoint = 0;
  //       }
  //       return this.ruserPoint;
  //     }
  // },
  methods: {
    //입금 시킬 돈을 모으는 함수
    setPlusRuserPoint: function(point) {
      this.varPoint += point;
      return false;
    },

    //출금 시킬 돈을 모으는 함수 단 ruserPoint의 돈보다 많은 돈을 출금할 경우 제한
    setMinusRuserPoint: function(point) {  
      this.varPoint += point;
      if(this.ruserPoint-this.varPoint<0){
        alert("할 수 없습니다. 금액확인 후 다시해주세요.");
        this.varPoint=0;
      }
      return false;
    },
    //입금버튼을 눌렀을 때 뜨는 팝업
    plusPS: function() {
      let self = this;
      this.plusShow = !this.plusShow; // #2, #3
      this.minusShow = false; // #2, #3
      this.varPoint = 0;
    },
    //입금시킬 돈을 입력 후 확인을 눌렀을 떄 그 돈을 DB에 보내주고 리스트를 다시 불러오는 함수
    plusP: async function() {
      let self = this;
      let response;
      this.plusShow = false;
      this.ruserPoint+=this.varPoint;
      response = await axios({
        url: "/pointUpdate",
        method: "post",
        data: {
          ruserId: self.ruserId,
          ruserPoint: self.ruserPoint
        }
      });
      response = await axios({
        url: "/reviewUpdate",
        method: "post",
        data: {
          ruserId: self.ruserId,
          reason: (self.reason = "입금"),
          pointType: (self.pointType = "입금"),
          ruserPoint: self.varPoint
        }
      });
      response = await axios({
        url: "/reviewHistory",
        method: "post",
        data: {
          ruserId: self.ruserId
        }
      });
      self.reviews = response.data;
      this.varPoint=0;
    },
    //출금버튼을 눌렀을 때 뜨는 팝업
    minusPS: function(){
      let self = this;
      this.minusShow = !this.minusShow; // #2, #3
      this.plusShow = false;
      this.varPoint = 0;
     },
    //출금시킬 돈을 입력 후 확인을 눌렀을 떄 그 돈을 DB에 보내주고 리스트를 다시 불러오는 함수
    minusP: async function() {
      let self = this;
      let response;
      this.minusShow = false;
      this.ruserPoint-=this.varPoint;
      response = await axios({
        url: "/pointUpdate",
        method: "post",
        data: {
          ruserId: self.ruserId,
          ruserPoint: self.ruserPoint
        }
      });
      //ruserPoint의 값이 0일경우 확인을 눌렀을 때 0을 로그에 안찍게 하기 위한 조건
      if(!this.ruserPoint==0){
      response = await axios({
        url: "/reviewUpdate",
        method: "post",
        data: {
          ruserId: self.ruserId,
          reason: (self.reason = "출금"),
          pointType: (self.pointType = "출금"),
          ruserPoint: self.varPoint
        }
      });
      response = await axios({
        url: "/reviewHistory",
        method: "post",
        data: {
          ruserId: self.ruserId
        }
      });
      self.reviews = response.data;
      }
      this.varPoint=0;
    },
    getPosts: async function(event) {
      let self = this,
        response;

      var params = location.search.substr(location.search.indexOf("?") + 1);
      var sval = "";
      params = params.split("&");
      for (var i = 0; i < params.length; i++) {
        let temp = params[i].split("=");
        if ([temp[0]] == "ruserId") {
          sval = temp[1];
        }
      }
      response = await axios.get("/pointRead?ruserId=" + sval);
      self.ruserPoint = response.data.ruserPoint;
      self.ruserId = response.data.ruserId;
      response = await axios({
        url: "/reviewHistory",
        method: "post",
        data: {
          ruserId: self.ruserId
        }
      });
      self.reviews = response.data;
    }
  },
  //시작하자마자 실
  created: function() {
    let self = this;
    this.getPosts();
  }
};
</script>

<style>
</style>