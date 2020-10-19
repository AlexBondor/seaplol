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
  return moment(value, "DD/MM/yyyy").format("DD/MM/YYYY");
});
Vue.filter("formatPercentage", function(value) {
  if (!value) {
    value = 0;
  }
  const decimals = 2;

  value = Math.round(value * Math.pow(10, decimals)) / Math.pow(10, decimals);
  value = value + "%";
  return value;
});
