import Vue from "vue";
import moment from "moment";

Vue.prototype.$filters = Vue.options.filters;

Vue.filter("formatCurrency", function(value) {
  if (value === null || value === undefined) return "";
  return new Intl.NumberFormat("ro-RO", {
    style: "currency",
    currency: "RON"
  }).format(value);
});
Vue.filter("formatCurrencyEur", function(value) {
  if (value === null || value === undefined) return "";
  return new Intl.NumberFormat("eu-EU", {
    style: "currency",
    currency: "EUR"
  }).format(value);
});
Vue.filter("formatDate", function(value) {
  if (value === null || value === undefined) return "";
  return moment(value).format("D/MM/y");
});
