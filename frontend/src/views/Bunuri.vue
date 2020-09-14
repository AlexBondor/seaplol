<template>
  <div class="about">
    <h1>Bunuri</h1>
  </div>
</template>

<script>
import api from "@/api";

export default {
  name: "bunuri",
  components: {},
  methods: {
    buttonPress() {
      api.test.test();
    }
  }
};
</script>
