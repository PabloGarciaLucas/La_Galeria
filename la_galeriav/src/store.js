/*import Vue from 'vue'
import Vuex from 'vuex'
import VueCookies from 'vue-cookies'

Vue.use(Vuex)
Vue.use(VueCookies)

export default new Vuex.Store({
  state: {
    token: Vue.$cookies.get('token')
  },
  mutations: {
    SET_TOKEN (state, token) {
      Vue.$cookies.set('token', token)
      state.token = token
    },
    CLEAR_TOKEN (state) {
      Vue.$cookies.remove('token')
      state.token = null
    }
  },
  actions: {
    login ({ commit }, token) {
      commit('SET_TOKEN', token)
    },
    logout ({ commit }) {
      commit('CLEAR_TOKEN')
    }
  },
  getters: {
    isAuthenticated (state) {
      return !!state.token
    }
  }
})*/