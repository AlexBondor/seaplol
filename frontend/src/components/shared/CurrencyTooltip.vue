<template>
  <v-tooltip bottom>
    <template v-slot:activator="{ on, attrs }">
      <span v-bind="attrs" v-on="on">{{ ron | formatCurrency }} </span>
    </template>
    <span>{{ eur | formatCurrencyEur }}</span>
  </v-tooltip>
</template>

<script>
export default {
  name: "CurrencyTooltip",
  props: {
    ron: Number,
    eur: Number
  }
};
</script>

<style scoped></style>
