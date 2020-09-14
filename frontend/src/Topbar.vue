<template>
  <v-app-bar :clipped-left="primaryDrawer.clipped" app>
    <v-app-bar-nav-icon
      @click.stop="primaryDrawer.mini = !primaryDrawer.mini"
    ></v-app-bar-nav-icon>
    <v-toolbar-title>Cine se uită?</v-toolbar-title>
  </v-app-bar>
</template>
<script>
export default {
  name: "Topbar",
  props: {
    primaryDrawer: {}
  }
};
</script>
