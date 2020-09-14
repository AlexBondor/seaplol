import { HTTP, BASE_URL, encodeParams } from "@/api/http";

export const SUPPLIER_TYPE = "supplier";

export default {
  async list(pagination) {
    let res = await HTTP.get(BASE_URL + "api/suppliers", {
      params: { ...encodeParams(pagination) }
    });
    return res.data;
  },
  async getTreeMapForSupplier(id) {
    let res = await HTTP.get(BASE_URL + "api/suppliers/treeMap/" + id);
    return res.data;
  }
};
