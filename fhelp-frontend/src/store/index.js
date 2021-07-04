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
    setAccounts(state, accounts) {
      state.accounts = accounts;
    }
  },
  actions: {
    fetchAccounts (state) {
      fetch("http://localhost:8081/account/list")
        .then(response => response.json())
        .then(accounts => state.commit('setAccounts', accounts));
    }
  },
  modules: {
  }
})
