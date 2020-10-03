import { BASE_URL, encodeParams, HTTP } from "@/api/http";

export default {
  async getAllForSupplier(supplierId, pagination) {
    let res = await HTTP.get(
      BASE_URL + "api/directContracts/supplier/" + supplierId,
      {
        params: { ...encodeParams(pagination) }
      }
    );
    return res.data;
  }
};
