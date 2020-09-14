import Vue from "vue";

Vue.prototype.$filters = Vue.options.filters;

Vue.filter("formatCurrency", function(value) {
  if (value === null || value === undefined) return "";
  return new Intl.NumberFormat("ro-RO", {
    style: "currency",
    currency: "RON"
  }).format(value);
});
