import Vue from 'vue';
import VueRouter from 'vue-router'

// 라우터에서 사용할 페이지 놈들을 임포트
import NewsView from './NewsView.vue';
// import AskView from './AskView.vue';
// import JobsView from './JobsView.vue';


let routes=[
     {
      // path: url 주소
      path: '/news',
      // component: url 주소로 갔을 때 표시될 컴포넌트
      component: NewsView,
    },
    // {
    //   path: '/ask',
    //   component: AskView,
    // },
    // {
    //   path: '/jobs',
    //   component: JobsView,
    // }
];

export default new VueRouter({routes});