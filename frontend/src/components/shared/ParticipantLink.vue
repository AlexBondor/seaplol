<template>
  <div @click="open" style="cursor: pointer">{{ participant.name }}</div>
</template>

<script>
import { router } from "@/router";

export default {
  name: "ParticipantLink",
  props: {
    participant: Object
  },
  methods: {
    open() {
      if (this.participant.type === "SUPPLIER") {
        router.push({
          name: "supplierDetails",
          params: { id: this.participant.id }
        });
      } else if (this.participant.type === "CONTRACTING_AUTHORITY") {
        router.push({
          name: "contractingAuthorityDetails",
          params: { id: this.participant.id }
        });
      }
    }
  }
};
</script>

<style scoped></style>
