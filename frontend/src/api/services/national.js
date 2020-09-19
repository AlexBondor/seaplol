import { BASE_URL, HTTP } from "@/api/http";

export default {
  async cpvData() {
    let res = await HTTP.get(BASE_URL + "api/national");
    return res.data;
  }
};
