<template>
  <div id="app">
    <v-app id="inspire">
      <v-app id="sandbox">
        <Sidebar :primary-drawer="primaryDrawer" />
        <Topbar :primary-drawer="primaryDrawer" />

        <v-main>
          <v-container fluid>
            <router-view></router-view>
          </v-container>
        </v-main>

        <FooterBar />
      </v-app>
    </v-app>
  </div>
</template>

<script>
import Sidebar from "./Sidebar";
import Topbar from "./Topbar";
import FooterBar from "./FooterBar";

export default {
  name: "App",
  components: { FooterBar, Topbar, Sidebar },
  data: () => ({
    primaryDrawer: {
      model: null,
      clipped: true,
      floating: false,
      mini: false
    }
  })
};
</script>

<style lang="scss">
#app {
  font-family: Source Sans Pro, Helvetica Neue, Helvetica, Roboto, Arial,
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
