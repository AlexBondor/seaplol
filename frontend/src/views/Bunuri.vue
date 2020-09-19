<template>
  <div class="about">
    <h1>Bunuri</h1>

    <div class="hello" ref="chartdiv"></div>
  </div>
</template>

<script>
import api from "@/api";
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";

export default {
  name: "bunuri",
  components: {},
  data: function() {
    return {
      loadingIndicator: {},
      data: {},
      maxLevel: 2,
      path: []
    };
  },
  methods: {
    loadData: async function() {
      let res = await api.national.cpvData();
      this.markDataAsLoaded(res);
      this.data = res;
      console.log(res);
      return res;
    },
    setupChart() {
      this.setupChartBasics();
      this.setupLoadingIndicator();
      this.showLoadingIndicator();
      this.loadData().then(data => {
        this.setupChartData(data);
        this.setupChartVisuals();
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
      this.chart.dataFields.value = "total";
      this.chart.dataFields.name = "description";
      this.chart.dataFields.cpvCode = "cpvCode";
      this.chart.dataFields.children = "children";
      this.chart.dataFields.childrenLoaded = "childrenLoaded";
      this.chart.dataFields.parent = "parent";
    },
    setupChartVisuals() {
      let chart = this.chart;
      chart.hiddenState.properties.opacity = 0; // this makes initial fade in effect
      chart.maxLevels = 1; // only one level visible initially
      chart.navigationBar = new am4charts.NavigationBar();
      var level0 = chart.seriesTemplates.create("0");
      level0.strokeWidth = 2;
      var hoverState = level0.columns.template.states.create("hover");
      // darken
      hoverState.adapter.add("fill", fill => {
        return am4core.color(am4core.colors.brighten(fill.rgb, -0.2));
      });
    },
    setupChartClickEvents() {
      let self = this;
      this.chart.zoomOutButton.events.on("hit", function() {
        self.resetPath();
      });

      // adding click detection (separate for each level)
      for (var i = 0; i < this.maxLevel; i++) {
        const series = this.chart.seriesTemplates.create(i);
        series.columns.template.events.on("hit", async function(ev) {
          const data = ev.target.dataItem.dataContext;
          self.path.push(data.cpvCode);
          // if (!data.childrenLoaded) {
          //   console.log(self.chart.dataItems);
            let children = await api.national.getChildrenOf(data.cpvCode);
          //   self.addChildrenToCpvCode(children);
          // }
          console.log(ev.target.dataItem);
          ev.target.dataItem.treeMapDataItem.children.values.push(...children);
          self.maxLevels = i + 1;
          self.setupChartLabels();
          data.childrenLoaded = true;
        });
      }
    },
    setupChartLabels() {
      // adding labels (separate for each level)
      for (var i = 0; i < this.maxLevel; i++) {
        let level = this.chart.seriesTemplates.create(i);
        let level_bullet = level.bullets.push(new am4charts.LabelBullet());
        level_bullet.locationY = 0.5;
        level_bullet.locationX = 0.5;
        level_bullet.label.text = "{name}";
        level_bullet.label.fill = am4core.color("#fff");
      }
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
    },
    markDataAsLoaded(data) {
      for (var i = 0; i < data.length; i++) {
        var el = data[i];
        el.childrenLoaded = true;
      }
    },
    addChildrenToCpvCode(children) {
      let tmpPath = JSON.parse(JSON.stringify(this.path));

      var currentLevelNode = this.findFirstLevelNode(tmpPath);

      tmpPath.shift();
      while (tmpPath.length > 0) {
        for (var i = 0; i < currentLevelNode.children.length; i++) {
          if (currentLevelNode.children[i].cpvCode === tmpPath[0]) {
            currentLevelNode = currentLevelNode.children[i];
            tmpPath.shift();
            this.maxLevel++;
          }
        }
      }
      console.log(currentLevelNode);
      currentLevelNode["children"] = children;
      this.chart.invalidateRawData();
      this.setupChartLabels();
    },
    resetPath() {
      this.path = [];
      console.log("oath");
    },
    findFirstLevelNode(path) {
      let data = this.data;
      for (var i = 0; i < data.length; i++) {
        if (data[i].cpvCode === path[0]) {
          return data[i];
        }
      }
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
  height: 800px;
}
</style>
