<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div class="about">
    <v-card>
      <v-card-title>
        Furnizori
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="suppliers"
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
          <span>{{ item.totalContractsValue | formatCurrency }}</span>
        </template>
        <template #footer.page-text="props">
          {{ props.pageStart }}-{{ props.pageStop }} din {{ props.itemsLength }}
        </template>
      </v-data-table>
    </v-card>
  </div>
</template>

<script>
import api from "@/api";
import debounce from "lodash-es/debounce";
import { router } from "@/router";
export default {
  name: "furnizori",
  data() {
    return {
      totalCount: 0,
      suppliers: [],
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
        { text: "Valoare contracte (RON)", value: "totalContractsValue" },
        { text: "Număr contracte", value: "totalContractsCount" },
        {
          text: "Număr de angajați (medie anul trecut)",
          value: "averageNumberOfEmployeesLastYear"
        },
        {
          text: "Câștig mediu per angajat de la stat",
          value: "averageRevenueFromPublicInstitutionsPerEmployeeLastYear"
        },
        {
          text: "Câștig mediu per angajat de la stat (EUR)",
          value:
            "averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency"
        }
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
      this.pagination.searchTerm = field;
    }, 500)
  },
  methods: {
    loadData() {
      this.loading = true;
      api.suppliers.list(this.pagination).then(data => {
        this.suppliers = data.content;
        this.totalCount = data.totalElements;
        this.loading = false;
      });
    },
    details(supplier) {
      router.push({
        name: "supplierDetails",
        params: { id: supplier.id }
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
