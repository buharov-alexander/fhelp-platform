<template>
  <v-app>
    <AppBar />
    <Drawer />
    <v-main>
      <AccountTable />
    </v-main>
  </v-app>
</template>

<script>
import AppBar from "./components/AppBar";
import Drawer from "./components/Drawer";
import AccountTable from "./components/home/AccountTable";

export default {
  name: "App",

  components: {
    AppBar,
    Drawer,
    AccountTable,
  },

  data: () => ({}),
};
</script>
