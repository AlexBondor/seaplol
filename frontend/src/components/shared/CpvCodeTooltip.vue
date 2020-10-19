<template>
  <v-tooltip bottom>
    <template v-slot:activator="{ on, attrs }">
      <span
        v-bind="attrs"
        v-on="on"
        v-bind:style="{ fontSize: fontSize + 'px' }"
        >CPV: {{ cpvData.code }}
      </span>
    </template>
    <span>{{ cpvData.description }}</span>
  </v-tooltip>
</template>

<script>
export default {
  name: "CpvCodeTooltip",
  props: {
    cpvData: Object,
    fontSize: Number
  }
};
</script>

<style scoped></style>
