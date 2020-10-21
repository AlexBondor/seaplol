<template>
  <v-container class="grey lighten-5" v-if="dedicatedSuppliers">
    <v-row no-gutters v-for="r in numberOfRows" :key="r">
      <v-col v-for="c in columnsForRow(r - 1)" :key="c" cols="12" sm="4">
        <v-card class="pa-2" outlined tile>
          One of three columns
          {{ dedicatedSupplierByRowColumn(r - 1, c - 1) }}
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
const NR_COLS = 3;
export default {
  name: "DedicatedSuppliersSection",
  props: {
    dedicatedSuppliers: Array
  },
  methods: {
    dedicatedSupplierByRowColumn(row, column) {
      return NR_COLS * row + column;
    },
    columnsForRow(row) {
      let skip = NR_COLS * row;
      return Math.min(this.dedicatedSuppliers.length - skip, NR_COLS);
    }
  },
  computed: {
    numberOfRows() {
      return Math.ceil(this.dedicatedSuppliers.length / NR_COLS);
    }
  }
};
</script>

<style scoped></style>
