import { BASE_URL, HTTP } from "@/api/http";

export default {
  async cpvData() {
    let res = await HTTP.get(BASE_URL + "api/national");
    return res.data;
  },
  async getChildrenOf(cpvCode) {
    let res = await HTTP.get(
      BASE_URL + "api/national/cpvChildrenOf/" + cpvCode
    );
    return res.data;
  }
};
