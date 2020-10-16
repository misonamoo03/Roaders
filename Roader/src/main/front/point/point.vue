<template>
  <div id="app">
    <form>
      <input type="text" id="ruserPoint" v-bind:value="ruserPoint" readonly />
      <button @click="plusP" type="button">입금버튼</button>
      <button @click="minusP" type="button">출금버튼</button>

      <li
        v-for="review in reviews"
        :key="review.index"
      >{{review.pointUpdate}} {{review.reason}} {{review.ruserId}} {{review.pointType}}{{review.ruserPoint}}</li>

      <div v-show="plusShow">
        <h5>입금하기</h5>
        <p>
          <input type="text" id="ruserPoint" v-bind:value="ruserPoint" readonly />
        </p>
        <button type="button" v-on:click="setPlusRuserPoint(1000)">+1,000</button>
        <button type="button" v-on:click="setPlusRuserPoint(10000)">+10,000</button>
        <button type="button" v-on:click="setPlusRuserPoint(100000)">+100,000</button>
        <button @click="plusP" type="button">확인</button>
      </div>

      <div v-show="minusShow">
        <h5>출금하기</h5>
        <p>
          <input type="text" id="ruserPoint" v-bind:value="ruserPoint" readonly />
        </p>
        <button type="button" v-on:click="setMinusRuserPoint(1000)">-1,000</button>
        <button type="button" v-on:click="setMinusRuserPoint(10000)">-10,000</button>
        <button type="button" v-on:click="setMinusRuserPoint(100000)">-100,000</button>
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
      pointType: ""
    };
  },
  watch: {
    getPosts: function(event) {
      let self=this;
      if (self.ruserPoint <= 0) {
        self.ruserPoint = 0;
      }
    }
  },
  methods: {
    setPlusRuserPoint: function(point) {
      this.ruserPoint += point;
      return false;
    },
    setMinusRuserPoint: function(point) {
      this.ruserPoint -= point;
      if (this.ruserPoint <= 0) {
        this.ruserPoint = 0;
      }
      return false;
    },
    plusP: function() {
      let self = this;
      this.plusShow = !this.plusShow; // #2, #3
      this.minusShow = false; // #2, #3
      axios({
        url: "/pointUpdate",
        method: "post",
        data: {
          ruserId: self.ruserId,
          ruserPoint: self.ruserPoint
        }
      });
    },
    minusP: function() {
      let self = this;
      this.minusShow = !this.minusShow; // #2, #3
      this.plusShow = false;
      axios({
        url: "/pointUpdate",
        method: "post",
        data: {
          ruserId: self.ruserId,
          ruserPoint: self.ruserPoint
        }
      });
      axios({
        url: "/reviewUpdate",
        method: "post",
        data: {
          ruserId: self.ruserId,
          reason: (self.reason = "출금"),
          pointType: (self.pointType = "출금"),
          ruserPoint: self.ruserPoint
        }
      });
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

  created: function() {
    let self = this;
    this.getPosts();
    this.getW();
    console.log(self);
  }
};
</script>

<style>
</style>