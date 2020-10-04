<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div class="about">
    <v-card>
      <v-card-title>
        Instituții
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
          clearable
        ></v-text-field>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="contractingAuthorities"
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
        <template v-slot:item.totalContractsValue="{ item }">
          <CurrencyTooltip
            :ron="item.totalContractsValue"
            :eur="item.totalContractsValueSecondCurrency"
          ></CurrencyTooltip>
        </template>

        <template v-slot:item.id="{ item }">
          <LinkToSeap :id="item.id" type="CONTRACTING_AUTHORITY"></LinkToSeap>
        </template>

        <template #footer.page-text="props">
          {{ props.pageStart }}-{{ props.pageStop }} din {{ props.itemsLength }}
        </template>
      </v-data-table>
    </v-card>
  </div>
</template>

<script>
import { router } from "@/router";
import api from "@/api";
import debounce from "lodash-es/debounce";
import CurrencyTooltip from "@/components/shared/CurrencyTooltip";
import LinkToSeap from "@/components/shared/LinkToSeap";

export default {
  name: "institutii",
  components: { CurrencyTooltip, LinkToSeap },
  data() {
    return {
      totalCount: 0,
      contractingAuthorities: [],
      loading: true,
      pagination: {
        searchTerm: "",
        page: 0,
        itemsPerPage: 10,
        sort: ["asc"],
        sortBy: ["name"]
      },
      headers: [
        { text: "Denumire", value: "name", width: "60%" },
        {
          text: "Valoare contracte (RON)",
          value: "totalContractsValue",
          width: "25%"
        },
        { text: "Număr contracte", value: "totalContractsCount", width: "10%" },
        { text: "", value: "id", sortable: false, width: "5%" }
      ],
      search: ""
    };
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
      this.pagination.searchTerm = field ? field : "";
    }, 500)
  },
  methods: {
    loadData() {
      this.loading = true;
      api.contractingAuthorities.list(this.pagination).then(data => {
        this.contractingAuthorities = data.content;
        this.totalCount = data.totalElements;
        this.loading = false;
      });
    },
    details(contractingAuthority) {
      router.push({
        name: "contractingAuthorityDetails",
        params: { id: contractingAuthority.id }
      });
    }
  }
};
</script>

<style lang="css" scoped>
.row-pointer >>> tbody tr :hover {
  cursor: pointer;
}
</style>
