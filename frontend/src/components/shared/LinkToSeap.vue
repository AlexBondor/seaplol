<template>
  <div @click.stop="open" style="cursor: pointer">
    <v-icon>
      launch
    </v-icon>
  </div>
</template>

<script>
export default {
  name: "LinkToSeap",
  props: {
    id: Number,
    type: String
  },
  methods: {
    open() {
      if (this.type === "SUPPLIER") {
        window.open(
          "http://e-licitatie.ro/pub/participants/view/su/" + this.id,
          "_blank"
        );
      } else if (this.type === "CONTRACTING_AUTHORITY") {
        window.open(
          "http://e-licitatie.ro/pub/participants/view/ac/" + this.id,
          "_blank"
        );
      } else if (this.type === "CONTRACT") {
        window.open(
          "http://e-licitatie.ro/pub/direct-acquisition/view/" + this.id,
          "_blank"
        );
      }
    }
  }
};
</script>

<style scoped></style>
