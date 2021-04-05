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
        { text: "Balance", value: "balance" },
      ],
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
    };
  },
};
</script>

<style scope>
.sheet {
  padding: 20px;
  margin: 30px;
}
</style>