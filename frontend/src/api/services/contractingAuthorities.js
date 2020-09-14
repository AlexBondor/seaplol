import { HTTP, BASE_URL, encodeParams } from "@/api/http";

export const CONTRACTING_AUTHORITY_TYPE = "contractingAuthority";

export default {
  async list(pagination) {
    let res = await HTTP.get(BASE_URL + "api/contracting_authorities", {
      params: { ...encodeParams(pagination) }
    });
    return res.data;
  },
  async getTreeMapForContractingAuthority(id) {
    let res = await HTTP.get(
      BASE_URL + "api/contracting_authorities/treeMap/" + id
    );
    return res.data;
  },
  async details(id) {
    let res = await HTTP.get(BASE_URL + "api/contracting_authorities/" + id);
    return res.data;
  }
};
