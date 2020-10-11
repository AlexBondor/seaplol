<template>
  <v-tooltip bottom>
    <template v-slot:activator="{ on, attrs }">
      <v-icon color="primary" dark v-bind="attrs" v-on="on">
        {{ icon() }}
      </v-icon>
    </template>
    <span>
      <div v-if="bucket !== 'UM'">Alte exemple includ:</div>
      <div v-for="item in items" :key="item">
        {{ item }}
      </div>
      ...
    </span>
  </v-tooltip>
</template>

<script>
export default {
  name: "MeasurementsUnitTooltip",
  props: {
    items: Array,
    bucket: String
  },
  methods: {
    icon() {
      console.log(this.bucket);
      switch (this.bucket) {
        case "BUCATI":
          return "extension";
        case "GRAME":
          return "superscript";
        case "LITRI":
          return "opacity";
        case "CUTII":
          return "widgets";
        case "TIMP":
          return "schedule";
        case "SERVICIU":
          return "accessibility";
        default:
          return "multiline_chart";
      }
    }
  }
};
</script>

<style scoped></style>
