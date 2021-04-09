import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    accounts: [
      {
        name: "Alfa Saving Account",
        balance: 159000,
      },
      {
        name: "Tinkoff Deposit",
        balance: 75000,
      },
    ],
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
