<template>
  <div class="hello" ref="chartdiv"></div>
</template>

<script>
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";
import am4themes_animated from "@amcharts/amcharts4/themes/animated";

am4core.useTheme(am4themes_animated);
export default {
  name: "DedicatedSupplierChart",
  props: {
    data: Array
  },
  methods: {
    setupChart() {
      console.log(this.data);
      let chart = am4core.create(this.$refs.chartdiv, am4charts.PieChart);
      chart.innerRadius = am4core.percent(40);
      chart.hiddenState.properties.opacity = 0; // this creates initial fade-in
      chart.data = this.data;
      let pieSeries = chart.series.push(new am4charts.PieSeries());
      pieSeries.dataFields.value = "value";
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
      pieSeries2.dataFields.value = "count";
      pieSeries2.dataFields.category = "label";
      pieSeries2.slices.template.stroke = am4core.color("#fff");
      pieSeries2.slices.template.strokeWidth = 2;
      pieSeries2.slices.template.strokeOpacity = 1;
      pieSeries2.slices.template.states.getKey(
        "hover"
      ).properties.shiftRadius = 0;
      pieSeries2.slices.template.states.getKey("hover").properties.scale = 1.1;
    }
  },
  mounted() {
    this.setupChart();
  }
};
</script>

<style scoped></style>
