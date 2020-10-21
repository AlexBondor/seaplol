<template>
  <v-container>
    <h1>{{ details.name }}</h1>
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
          Valoare contracte:
          <CurrencyTooltip
            :ron="details.totalContractsValue"
            :eur="details.totalContractsValueSecondCurrency"
          ></CurrencyTooltip>
        </div>
      </v-card-text>
      <v-card-actions>
        <v-btn text color="deep-purple accent-4">
          Learn More
        </v-btn>
      </v-card-actions>
    </v-card>
    <br />
    <br />
    <ContractsTable
      entity="contractingAuthority"
      :entity-id="id"
      :show-supplier="true"
    ></ContractsTable>
    <br />
    <br />
    <DedicatedSuppliersSection
      :dedicated-suppliers="details.dedicatedSuppliers"
    ></DedicatedSuppliersSection>
  </v-container>
</template>

<script>
import api from "@/api";
import { titleCase } from "@/utils/strings";
import ContractsTable from "@/components/shared/ContractsTable";
import CurrencyTooltip from "@/components/shared/CurrencyTooltip";
import DedicatedSuppliersSection from "@/components/contracting-authority/DedicatedSuppliersSection";

export default {
  name: "contractingAuthorityDetails",
  components: { DedicatedSuppliersSection, ContractsTable, CurrencyTooltip },
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
    }
  },
  beforeDestroy() {
    if (this.chart) {
      this.chart.dispose();
    }
  }
};
</script>
