<template>
  <v-container class="row">
    <v-row
      v-for="item in details"
      :key="item.description"
      no-gutters
      style="width: max-content"
    >
      <v-col cols="3">
        <TextTruncator :text="item.description" :size="75" :font-size="11">
        </TextTruncator>
      </v-col>
      <v-col cols="1">
        <CpvCodeTooltip :cpv-data="item.cpvData" :font-size="11"></CpvCodeTooltip>
      </v-col>
      <v-col class="small-text" cols="1">
        Cost mediu:
        <CurrencyTooltip :ron="item.itemAverageCost"></CurrencyTooltip>
      </v-col>
      <v-col class="small-text" cols="2">
        Cost mediu national:
        <CurrencyTooltip :ron="item.nationalAverageCost"></CurrencyTooltip>
      </v-col>
      <v-col class="small-text" cols="1">
        UM: {{ item.measurementUnit }}
        <MeasurementsUnitTooltip
          :items="item.measurementBucketExamples"
          :bucket="item.measurementBucket"
        ></MeasurementsUnitTooltip>
      </v-col>
      <v-col class="small-text" cols="1">
        Număr de bucăți: {{ item.numberOfItems }}
      </v-col>
      <v-col class="small-text" cols="2">
        Deviație față de medie:
        {{ item.priceDeviationPercentage | formatPercentage }}
        <v-icon v-if="item.priceDeviationPercentage > 100" color="red">
          trending_up
        </v-icon>
        <v-icon v-else color="green">
          trending_down
        </v-icon>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MeasurementsUnitTooltip from "@/components/shared/MeasurementsUnitTooltip";
import TextTruncator from "@/components/shared/TextTruncator";
import CurrencyTooltip from "@/components/shared/CurrencyTooltip";
import CpvCodeTooltip from "@/components/shared/CpvCodeTooltip";
export default {
  name: "ContractItemDetails",
  components: {CpvCodeTooltip, CurrencyTooltip, TextTruncator, MeasurementsUnitTooltip },
  props: {
    details: Array
  }
};
</script>

<style scoped>
.row {
  width: auto;
}
.small-text {
  font-size: 11px;
}
</style>
