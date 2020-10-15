import Vue from 'vue';
import Com from './com.vue';
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import routes from './router.js'

new Vue({
  render: h => h(Com),
  router:routes, // router: router 와 같은 말인 축약형 ES6 문법
}).$mount('#root');