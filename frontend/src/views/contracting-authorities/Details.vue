<template>
  <v-container>
    <h1>{{ details.name }}</h1>
    <TreeMap entity="contractingAuthority" :id="id"></TreeMap>
    <br />
    <br />
    <v-card class="mx-auto">
      <v-card-text>
        <div>CUI: {{ details.cui }}</div>
        <p class="display-1 text--primary">
          {{ name }}
        </p>
        <p>Reprezentant: {{ representative }}</p>
        <div class="text--primary">
          Număr de contracte: {{ details.totalContractsCount }}<br />
          Valoare contracte (RON): {{ value }}
        </div>
      </v-card-text>
      <v-card-actions>
        <v-btn text color="deep-purple accent-4">
          Learn More
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
import TreeMap from "@/components/shared/TreeMap";
import api from "@/api";
import { titleCase } from "@/utils/strings";

export default {
  name: "contractingAuthorityDetails",
  components: { TreeMap },
  data: function() {
    return {
      id: parseInt(this.$route.params.id),
      details: {}
    };
  },
  async mounted() {
    this.loadDetails();
  },
  methods: {
    async loadDetails() {
      this.details = await api.contractingAuthorities.details(this.id);
      console.log(this.details);
    }
  },
  computed: {
    representative() {
      return titleCase(this.details.legalRepresentative);
    },
    name() {
      return titleCase(this.details.name);
    },
    value() {
      return this.$options.filters.formatCurrency(this.details.totalContractsValue);
    }
  },
  beforeDestroy() {
    if (this.chart) {
      this.chart.dispose();
    }
  }
};
</script>
