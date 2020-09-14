<template>
  <div class="hello" ref="chartdiv"></div>
</template>
<script>
import { CONTRACTING_AUTHORITY_TYPE } from "@/api/services/contractingAuthorities";
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";
import am4themes_animated from "@amcharts/amcharts4/themes/animated";
import api from "@/api";
import { SUPPLIER_TYPE } from "@/api/services/suppliers";

am4core.useTheme(am4themes_animated);

export default {
  name: "TreeMap",
  props: {
    entity: String,
    id: Number
  },
  data: function() {
    return {
      data: {},
      loadingIndicator: {}
    };
  },
  methods: {
    loadData: async function() {
      if (this.entity === CONTRACTING_AUTHORITY_TYPE) {
        return await api.contractingAuthorities.getTreeMapForContractingAuthority(
          this.id
        );
      } else if (this.entity === SUPPLIER_TYPE) {
        return await api.suppliers.getTreeMapForSupplier(this.id);
      }
    },
    setupChart() {
      this.setupChartBasics();
      this.setupLoadingIndicator();
      this.showLoadingIndicator();
      this.loadData().then(data => {
        this.setupChartData(data);
        this.setupChartClickEvents();
        this.setupChartLabels();
        this.loadingIndicator.hide();
      });
    },
    setupChartBasics() {
      let chart = am4core.create(this.$refs.chartdiv, am4charts.TreeMap);
      chart.paddingRight = 20;
      this.chart = chart;
    },
    setupChartData(data) {
      this.chart.data = data;
      this.chart.dataFields.value = "value";
      this.chart.dataFields.name = "name";
      this.chart.dataFields.exemplu = "exemplu"; // can add any
      this.chart.dataFields.children = "children";
    },
    setupChartClickEvents() {
      // adding click detection (separate for each level)
      const series = this.chart.seriesTemplates.create("1");
      series.columns.template.events.on("hit", function(ev) {
        const data = ev.target.dataItem.dataContext;
        console.log(data.name + " " + data.value);
      });
    },
    setupChartLabels() {
      // adding labels (separate for each level)
      let level1 = this.chart.seriesTemplates.create("0");
      let level1_bullet = level1.bullets.push(new am4charts.LabelBullet());
      level1_bullet.locationY = 0.5;
      level1_bullet.locationX = 0.5;
      level1_bullet.label.text = "{name}";
      level1_bullet.label.fill = am4core.color("#fff");
    },
    setupLoadingIndicator() {
      this.loadingIndicator = this.chart.tooltipContainer.createChild(
        am4core.Container
      );
      this.loadingIndicator.background.fill = am4core.color("#fff");
      this.loadingIndicator.background.fillOpacity = 0.8;
      this.loadingIndicator.width = am4core.percent(100);
      this.loadingIndicator.height = am4core.percent(100);
    },
    showLoadingIndicator() {
      let indicatorLabel = this.loadingIndicator.createChild(am4core.Label);
      indicatorLabel.text = "Se încarcă";
      indicatorLabel.align = "center";
      indicatorLabel.valign = "middle";
      indicatorLabel.fontSize = 20;
      indicatorLabel.dy = 50;

      let hourglass = this.loadingIndicator.createChild(am4core.Image);
      hourglass.href =
        "https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-160/hourglass.svg";
      hourglass.align = "center";
      hourglass.valign = "middle";
      hourglass.horizontalCenter = "middle";
      hourglass.verticalCenter = "middle";
      hourglass.scale = 0.7;

      setInterval(function() {
        hourglass.animate(
          [
            {
              from: 0,
              to: 360,
              property: "rotation"
            }
          ],
          2000
        );
      }, 1000);
    }
  },
  async mounted() {
    this.setupChart();
  }
};
</script>
<style scoped>
.hello {
  width: 100%;
  height: 500px;
}
</style>
