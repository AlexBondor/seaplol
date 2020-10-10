<template>
  <v-layout class="row" xs12 align-center>
    <span v-for="item in details" :key="item.description">
      <span class="description">
        {{ item.description }}
      </span>
      &nbsp; &nbsp; |
      <span class="description"> Cost mediu: {{ item.itemAverageCost }} </span>
      &nbsp; &nbsp; |
      <span class="description">
        UM: {{ item.measurementUnit }}
        <MeasurementsUnitTooltip
          :items="item.measurementBucketExamples"
          :bucket="item.measurementBucket"
        ></MeasurementsUnitTooltip>
      </span>
      &nbsp; &nbsp; |
      <span class="description">
        Cost mediu national: {{ item.nationalAverageCost }}
      </span>
      &nbsp; &nbsp; |
      <span class="description">
        Număr de bucăți: {{ item.numberOfItems }}
      </span>
      &nbsp; &nbsp; |
      <span class="description">
        Deviație față de medie: {{ item.priceDeviationPercentage }} %
      </span>
      <v-icon v-if="item.priceDeviationPercentage > 100" color="red">
        trending_up
      </v-icon>
      <v-icon v-else color="green">
        trending_down
      </v-icon>
    </span>
  </v-layout>
</template>

<script>
import MeasurementsUnitTooltip from "@/components/shared/MeasurementsUnitTooltip";
export default {
  name: "ContractItemDetails",
  components: { MeasurementsUnitTooltip },
  props: {
    details: Array
  }
};
</script>

<style scoped>
.row {
  padding-left: 25px;
  width: max-content;
  height: 100%;
}
.description {
  font-size: 11px;
}
</style>
