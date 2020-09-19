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
  methods: {},
  async mounted() {
    let res = await api.national.cpvData();
    console.log(res);
  }
};
</script>
