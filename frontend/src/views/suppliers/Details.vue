<template>
  <v-container>
    DETAILS SUPPLIER {{ id }}
    <TreeMap entity="supplier" :id="id"></TreeMap>
  </v-container>
</template>

<script>
import TreeMap from "@/components/shared/TreeMap";

export default {
  name: "supplierDetails",
  components: { TreeMap },
  data: function() {
    return {
      id: parseInt(this.$route.params.id)
    };
  },
  async mounted() {},
  methods: {},
  beforeDestroy() {
    if (this.chart) {
      this.chart.dispose();
    }
  }
};
</script>
