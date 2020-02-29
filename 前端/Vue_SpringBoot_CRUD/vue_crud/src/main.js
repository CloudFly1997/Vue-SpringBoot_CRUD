import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vuex from 'vuex'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);
Vue.config.productionTip = false

//vuex
Vue.use(Vuex)
const store = new Vuex.Store({
  state: { // 相当于 date
    departmentList: []
  },
  // 设置值 使用：this.$store.commit('setCount',this.$store.getters.getCount)
  mutations: { // 相当于 methods
    SET_DEPARTMENT_LIST(state,val){
      state.departmentList = val
    }
  },
  // 获取值 使用：this$store.getters.getCount
  getters:{
		getDepartmentList() {
  		return store.state.departmentList
		}
	}
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
