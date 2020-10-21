<template>
  <v-container class="grey lighten-5">
    <v-row no-gutters v-for="r in numberOfRows" :key="r">
      <v-col v-for="c in columnsForRow(r - 1)" :key="c" cols="12" sm="4">
        <v-card class="pa-2" outlined tile>
          {{ dedicatedSupplierByRowColumn(r - 1, c - 1) }}
          <div
            class="hello"
            :ref="'chartdiv' + indexByRowColumn(r - 1, c - 1)"
          ></div>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";
import am4themes_animated from "@amcharts/amcharts4/themes/animated";

am4core.useTheme(am4themes_animated);

const NR_COLS = 3;
export default {
  name: "DedicatedSuppliersSection",
  props: {
    dedicatedSuppliers: Array
  },
  methods: {
    dedicatedSupplierByRowColumn(row, column) {
      return this.dedicatedSuppliers[this.indexByRowColumn(row, column)]
        .supplierName;
    },
    columnsForRow(row) {
      let skip = NR_COLS * row;
      return Math.min(this.dedicatedSuppliers.length - skip, NR_COLS);
    },
    indexByRowColumn(row, column) {
      return NR_COLS * row + column;
    },
    setupCharts() {
      console.log(this.dedicatedSuppliers);
      for (var i = 0; i < this.dedicatedSuppliers.length; i++) {
        let chart = am4core.create(this.$refs.chartdiv + i, am4charts.PieChart);
        console.log(chart);
        chart.data = this.dedicatedSuppliers[i].data;
        let pieSeries = chart.series.push(new am4charts.PieSeries());
        pieSeries.dataFields.value = "contractsValue";
        pieSeries.dataFields.category = "label";
        pieSeries.slices.template.stroke = am4core.color("#fff");
        pieSeries.slices.template.strokeWidth = 2;
        pieSeries.slices.template.strokeOpacity = 1;

        // Disable sliding out of slices
        pieSeries.slices.template.states.getKey(
          "hover"
        ).properties.shiftRadius = 0;
        pieSeries.slices.template.states.getKey("hover").properties.scale = 0.9;

        var pieSeries2 = chart.series.push(new am4charts.PieSeries());
        pieSeries2.dataFields.value = "contractsCount";
        pieSeries2.dataFields.category = "label";
        pieSeries2.slices.template.stroke = am4core.color("#fff");
        pieSeries2.slices.template.strokeWidth = 2;
        pieSeries2.slices.template.strokeOpacity = 1;
        pieSeries2.slices.template.states.getKey(
          "hover"
        ).properties.shiftRadius = 0;
        pieSeries2.slices.template.states.getKey(
          "hover"
        ).properties.scale = 1.1;
      }
    }
  },
  computed: {
    numberOfRows() {
      return Math.ceil(this.dedicatedSuppliers.length / NR_COLS);
    }
  },
  created() {
    this.setupCharts();
  }
};
</script>

<style scoped>
.hello {
  width: 100%;
  height: 250px;
}
</style>
