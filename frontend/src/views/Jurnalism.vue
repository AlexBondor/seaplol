<template>
  <div class="about">
    <h1>Jurnalism</h1>
    <h2>Coming soon!</h2>
  </div>
</template>

<script>
import api from "@/api";

export default {
  name: "jurnalism",
  components: {},
  methods: {
    buttonPress() {
      api.test.test();
    }
  }
};
</script>
