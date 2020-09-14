<template>
  <v-footer :inset="footer.inset" app>
    <span class="px-4">&copy; {{ new Date().getFullYear() }}</span>
  </v-footer>
</template>
<script>
export default {
  name: "FooterBar",
  data: () => ({
    footer: {
      inset: false
    }
  })
};
</script>
