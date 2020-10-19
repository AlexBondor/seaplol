<template>
  <v-layout row>
    <v-flex v-for="problem in problems" :key="problem">
      <v-tooltip bottom>
        <template v-slot:activator="{ on, attrs }">
          <v-icon v-bind="attrs" v-on="on">
            {{ icon(problem) }}
          </v-icon>
        </template>
        <span>
          <div>
            {{ text(problem) }}
          </div>
        </span>
      </v-tooltip>
    </v-flex>
  </v-layout>
</template>

<script>
export default {
  name: "ContractProblems",
  props: {
    problems: Array
  },
  methods: {
    icon(problem) {
      switch (problem) {
        case "VALUE_5k_MARGIN":
          return "extension";
        case "PRICE_ABOVE_AVERAGE":
          return "monetization_on";
      }
    },
    text(problem) {
      switch (problem) {
        case "VALUE_5k_MARGIN":
          return "Valoarea este apropiată de 5k EUR";
        case "PRICE_ABOVE_AVERAGE":
          return "Prețul este mult (>500%) peste medie.";
      }
    }
  }
};
</script>

<style scoped></style>
