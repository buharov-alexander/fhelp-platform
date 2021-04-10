<template>
  <v-sheet class="sheet" elevation="1" color="deep-purple lighten-4" rounded>
    <v-data-table
      :headers="headers"
      :items="accounts"
      class="elevation-1"
      hide-default-footer
    ></v-data-table>
  </v-sheet>
</template>

<script>
export default {
  data() {
    return {
      headers: [
        { text: "Name", value: "name" },
        { text: "Balance", value: "state.balance" },
      ],
    };
  },
  computed: {
    accounts() {
      return this.$store.state.accounts;
    },
  },
  mounted() {
    this.fetchAccounts();
  },
  methods: {
    fetchAccounts() {
      return this.$store.dispatch("fetchAccounts");
    },
  },
};
</script>

<style scope>
.sheet {
  padding: 20px;
  margin: 30px;
}
</style>