import Vue from "vue";
import VueRouter from "vue-router";
import Acasa from "@/views/Acasa.vue";
import Institutii from "@/views/Institutii.vue";
import ContractingAuthorityDetails from "@/views/contracting-authorities/Details.vue";
import SupplierDetails from "@/views/suppliers/Details.vue";
import Servicii from "@/views/Bunuri.vue";
import Furnizori from "@/views/Furnizori.vue";
import Jurnalism from "@/views/Jurnalism.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "acasa",
    component: Acasa
  },
  {
    path: "/institutii",
    name: "institutii",
    component: Institutii
  },
  {
    path: "/institutii/:id",
    component: ContractingAuthorityDetails,
    name: "contractingAuthorityDetails"
  },
  {
    path: "/furnizori",
    name: "furnizori",
    component: Furnizori
  },
  {
    path: "/furnizori/:id",
    component: SupplierDetails,
    name: "supplierDetails"
  },
  {
    path: "/bunuri",
    name: "bunuri",
    component: Servicii
  },
  {
    path: "/jurnalism",
    name: "jurnalism",
    component: Jurnalism
  },
  {
    path: "*", // lowest priority, in case nothing else was found
    name: "not-found",
    redirect: "/acasa"
  }
];

export const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
