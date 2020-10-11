<template>
  <v-tooltip bottom>
    <template v-slot:activator="{ on, attrs }">
      <span v-bind="attrs" v-on="on" v-bind:style="{ fontSize: fontSize + 'px' }">
        {{ truncatedText }}
      </span>
    </template>
    <span>
      {{ text }}
    </span>
  </v-tooltip>
</template>

<script>
export default {
  name: "TextTruncator",
  props: {
    text: String,
    size: Number,
    fontSize: Number
  },
  computed: {
    truncatedText() {
      return this.text.length > this.size
        ? this.text.substr(0, this.size) + " ... "
        : this.text;
    }
  }
};
</script>

<style scoped></style>
