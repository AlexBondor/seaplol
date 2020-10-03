<template>
  <v-data-table
    :headers="headers"
    :items="contracts"
    :options.sync="pagination"
    :server-items-length="totalCount"
    must-sort
    :loading="loading"
    loading-text="Se încarcă..."
    no-data-text="Nu sunt date"
    :footer-props="{
      showFirstLastPage: true,
      'items-per-page-text': 'Rânduri pe pagină',
      'items-per-page-options': [5, 10, 25, 50, 100]
    }"
    @click:row="details"
    class="elevation-1 row-pointer"
  >
    <template v-slot:item.closingValue="{ item }">
      <CurrencyTooltip
        :ron="item.closingValue"
        :eur="item.closingValueSecondCurrency"
      ></CurrencyTooltip>
    </template>
    <template #footer.page-text="props">
      {{ props.pageStart }}-{{ props.pageStop }} din {{ props.itemsLength }}
    </template>
  </v-data-table>
</template>

<script>
import CurrencyTooltip from "@/components/shared/CurrencyTooltip";
import debounce from "lodash-es/debounce";
import api from "@/api";

export default {
  name: "ContractsTable",
  components: { CurrencyTooltip },
  props: {
    entity: String,
    entityId: Number
  },
  data() {
    return {
      totalCount: 0,
      contracts: [],
      loading: true,
      pagination: {
        searchTerm: "",
        page: 0,
        itemsPerPage: 10,
        sort: ["asc"],
        sortBy: ["name"]
      },
      headers: [
        { text: "Denumire", value: "name" },
        { text: "Valoare închidere", value: "closingValue" },
        { text: "Dată finalizare", value: "finalizationDate" }
      ],
      search: ""
    };
  },
  methods: {
    loadData() {
      this.loading = true;
      var fetchFunction;
      if (this.entity === "supplier") {
        fetchFunction = api.directAcquisitionContracts.getAllForSupplier;
      } else {
        fetchFunction =
          api.directAcquisitionContracts.getAllForContractingAuthority;
      }
      fetchFunction(this.entityId, this.pagination).then(data => {
        this.contracts = data.content;
        this.totalCount = data.totalElements;
        this.loading = false;
      });
    },
    details(item) {
      console.log(item);
    }
  },
  mounted() {
    this.loadData();
  },
  watch: {
    pagination: {
      handler: function() {
        this.loadData();
      },
      deep: true,
      immediate: true
    },
    search: debounce(async function(field) {
      this.pagination.searchTerm = field;
    }, 500)
  }
};
</script>

<style scoped></style>
