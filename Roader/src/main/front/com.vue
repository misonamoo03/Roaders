<template>
   <div id="app">{{msg}}
  </div>
</template>
<script> 
import axios from 'axios';

export default {
   components: {
      ToolBar,
   },
   data: function (){
      return {
         msg : "ssssssssssdfdsfdf"
      }
   },
  methods: {
    getPosts: function (event) {
       let self = this;
      xios.get('/idCheckJson?ruserId=reviewTest')
      .then(function(response){
         alert(response.data.result);
         console.log(self);
         //self.msg=response.data.result // ��ü ���·� ��ȯ. �Ľ��۾� ���ʿ�
         self.msg= response.data.result;
      });
    }
  },
   created: function() {
     let self = this;
     this.getPosts();      
    console.log(self)
  }
}