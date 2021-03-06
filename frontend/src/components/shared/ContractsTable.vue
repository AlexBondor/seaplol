<template>
  <v-card>
    <v-card-title>
      Contracte
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
      :headers="computedHeaders"
      :items="contracts"
      :options.sync="pagination"
      :server-items-length="totalCount"
      must-sort
      :loading="loading"
      loading-text="Se încarcă..."
      no-data-text="Nu sunt date"
      :single-expand="false"
      :expanded.sync="expanded"
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
      <template v-slot:item.finalizationDate="{ item }">
        {{ item.finalizationDate | formatDate }}
      </template>
      <template v-slot:item.problemsCount="{ item }">
        <ProblemListIndicator :problems="item.problems"></ProblemListIndicator>
      </template>
      <template v-slot:item.contractingAuthority="{ item }">
        <ParticipantLink
          :participant="item.contractingAuthority"
        ></ParticipantLink>
      </template>
      <template v-slot:item.supplier="{ item }">
        <ParticipantLink :participant="item.supplier"></ParticipantLink>
      </template>
      <template v-slot:item.id="{ item }">
        <LinkToSeap :id="item.id" type="CONTRACT"></LinkToSeap>
      </template>

      <template #footer.page-text="props">
        {{ props.pageStart }}-{{ props.pageStop }} din {{ props.itemsLength }}
      </template>

      <template v-slot:expanded-item="{ headers, item }">
        <td :colspan="headers.length">
          <ContractItemDetails :details="item.details"></ContractItemDetails>
        </td>
      </template>
    </v-data-table>
  </v-card>
</template>

<script>
import CurrencyTooltip from "@/components/shared/CurrencyTooltip";
import debounce from "lodash-es/debounce";
import api from "@/api";
import ParticipantLink from "@/components/shared/ParticipantLink";
import LinkToSeap from "@/components/shared/LinkToSeap";
import ContractItemDetails from "@/components/shared/ContractItemDetails";
import ProblemListIndicator from "@/components/shared/ProblemListIndicator";

export default {
  name: "ContractsTable",
  components: {
    ProblemListIndicator,
    ContractItemDetails,
    LinkToSeap,
    ParticipantLink,
    CurrencyTooltip
  },
  props: {
    entity: String,
    entityId: Number,
    showContractingAuthority: Boolean,
    showSupplier: Boolean,
    contractIds: Array
  },
  data() {
    return {
      totalCount: 0,
      contracts: [],
      expanded: [],
      loading: true,
      pagination: {
        searchTerm: "",
        page: 1,
        itemsPerPage: 10,
        sort: ["asc"],
        sortBy: ["name"]
      },
      headers: [
        { text: "Denumire", value: "name", width: "40%", show: true },
        {
          text: "Valoare închidere",
          value: "closingValue",
          width: "10%",
          show: true
        },
        {
          text: "Dată finalizare",
          value: "finalizationDate",
          width: "5%",
          show: true
        },
        {
          text: "Probleme",
          value: "problemsCount",
          width: "5%",
          show: true
        },
        {
          text: "Autoritate contractantă",
          value: "contractingAuthority",
          width: "20%",
          show: this.showContractingAuthority
        },
        {
          text: "Furnizor",
          value: "supplier",
          width: "20%",
          show: this.showSupplier
        },
        {
          text: "",
          value: "id",
          sortable: false,
          width: "5%",
          show: true
        }
      ],
      search: ""
    };
  },
  methods: {
    loadData() {
      this.loading = true;
      if (
        this.entity === "directAcquisitionContract" &&
        this.contractIds &&
        this.contractIds.length !== 0
      ) {
        api.directAcquisitionContracts
          .getAll(this.pagination, this.contractIds)
          .then(data => {
            this.contracts = data.content;
            this.totalCount = data.totalElements;
            this.loading = false;
          });
      } else if (["supplier", "contractingAuthority"].includes(this.entity)) {
        var fetchFunction;
        if (this.entity === "supplier") {
          fetchFunction = api.directAcquisitionContracts.getAllForSupplier;
        } else if (this.entity === "contractingAuthority") {
          fetchFunction =
            api.directAcquisitionContracts.getAllForContractingAuthority;
        }
        fetchFunction(this.entityId, this.pagination).then(data => {
          this.contracts = data.content;
          this.totalCount = data.totalElements;
          this.loading = false;
        });
      } else {
        this.loading = false;
      }
    },
    async details(item) {
      const index = this.expanded.indexOf(item);
      if (index === -1) {
        item.details = await api.directAcquisitionContracts.getContractDetailsForExpandedRow(
          item.id
        );
        this.expanded.push(item);
      } else {
        this.expanded.splice(index, 1);
      }
    }
  },
  watch: {
    pagination: {
      handler: function() {
        this.loadData();
        //TODO: known issue, triggers twice when pagination.searchTerm changes. Fix would be to take searchTerm out of pagination object. Woudl do so in tandem with backend as well not artificially
      },
      deep: true
    },
    search: debounce(async function(field) {
      this.pagination.searchTerm = field ? field : "";
    }, 500)
  },
  computed: {
    computedHeaders() {
      return this.headers.filter(header => header.show);
    }
  }
};
</script>

<style scoped>
.row-pointer >>> tbody tr :hover {
  cursor: pointer;
}
</style>
