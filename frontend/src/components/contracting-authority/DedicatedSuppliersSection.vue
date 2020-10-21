<template>
  <v-container class="grey lighten-5">
    <v-row no-gutters v-for="r in numberOfRows" :key="r">
      <v-col v-for="c in columnsForRow(r - 1)" :key="c" cols="12" sm="4">
        <v-card class="pa-2" outlined tile>
          {{ dedicatedSupplierByRowColumn(r - 1, c - 1) }}
          <DedicatedSupplierChart
            :data="dedicatedSupplierData(r - 1, c - 1)"
          ></DedicatedSupplierChart>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import DedicatedSupplierChart from "@/components/contracting-authority/DedicatedSupplierChart";

const NR_COLS = 3;
export default {
  name: "DedicatedSuppliersSection",
  components: { DedicatedSupplierChart },
  props: {
    dedicatedSuppliers: Array
  },
  methods: {
    dedicatedSupplierByRowColumn(row, column) {
      return this.dedicatedSuppliers[this.indexByRowColumn(row, column)]
        .supplierName;
    },
    dedicatedSupplierData(row, column) {
      return this.dedicatedSuppliers[this.indexByRowColumn(row, column)].data;
    },
    columnsForRow(row) {
      let skip = NR_COLS * row;
      return Math.min(this.dedicatedSuppliers.length - skip, NR_COLS);
    },
    indexByRowColumn(row, column) {
      return NR_COLS * row + column;
    }
  },
  computed: {
    numberOfRows() {
      return Math.ceil(this.dedicatedSuppliers.length / NR_COLS);
    }
  }
};
</script>

<style scoped>
.hello {
  width: 100%;
  height: 250px;
}
</style>
