<template>
  <v-footer :inset="footer.inset" app>
    <v-container>
      <v-row :justify="'space-between'">
        <span class="px-4">&copy; {{ new Date().getFullYear() }}</span>
        <span class="px-4" style="cursor: pointer" @click="goToOpenApi"
          >Powered by openapi</span
        >
      </v-row>
    </v-container>
  </v-footer>
</template>
<script>
export default {
  name: "FooterBar",
  data: () => ({
    footer: {
      inset: false
    }
  }),
  methods: {
    goToOpenApi() {
      window.open("https://openapi.ro/", "_blank");
    }
  }
};
</script>
