<template>
  <div class="home">
    <v-layout column align-center>
      <h1>Explorează unde se duc banii staului</h1>

      <v-row>
        <v-card
          style="background:dimgrey; width: 350px; opacity: 75%; max-height: 375px; margin-right: 20px"
        >
          <v-card-title class="justify-center">
            <v-icon color="blue-grey lighten-5" size="75px">mdi-domain</v-icon>
          </v-card-title>
          <v-card-text>
            <p class="card-title">
              Instituții
            </p>
          </v-card-text>
          <v-card-subtitle>
            <p class="card-subtitle">
              Explorează instituțiile statului
            </p>
          </v-card-subtitle>
          <v-card-actions class="justify-center">
            <v-btn raised elevation="24" color="primary" router to="/institutii"
              >Exploreaza</v-btn
            >
          </v-card-actions>
        </v-card>

        <v-card
          style="background:dimgrey; width: 350px; opacity: 75%; max-height: 375px; margin-right: 20px"
        >
          <v-card-title class="justify-center">
            <v-icon color="blue-grey lighten-5" size="75px">mdi-sitemap</v-icon>
          </v-card-title>
          <v-card-text>
            <p class="card-title">
              Furnizori
            </p>
          </v-card-text>
          <v-card-subtitle>
            <p class="card-subtitle">
              Explorează furnizorii
            </p>
          </v-card-subtitle>
          <v-card-actions class="justify-center">
            <v-btn raised elevation="24" color="primary" router to="/furnizori"
              >Exploreaza</v-btn
            >
          </v-card-actions>
        </v-card>

        <v-card
          style="background:dimgrey; width: 350px; opacity: 75%; max-height: 375px; margin-right: 20px"
        >
          <v-card-title class="justify-center">
            <v-icon color="blue-grey lighten-5" size="75px"
              >mdi-cash-multiple</v-icon
            >
          </v-card-title>
          <v-card-text>
            <p class="card-title">
              Bunuri
            </p>
          </v-card-text>
          <v-card-subtitle>
            <p class="card-subtitle">
              Explorează bunurile
            </p>
          </v-card-subtitle>
          <v-card-actions class="justify-center">
            <v-btn raised elevation="24" color="primary" router to="/bunuri"
              >Exploreaza</v-btn
            >
          </v-card-actions>
        </v-card>
      </v-row>
    </v-layout>
  </div>
</template>

<script>
// @ is an alias to /src
import api from "@/api";

export default {
  name: "acasa",
  components: {},
  methods: {
    buttonPress() {
      api.test.test();
    }
  }
};
</script>

<style lang="scss">
.card-title {
  color: white;
  margin: 0;
  font-weight: 100;
  font-size: 3rem;
  line-height: 4.4rem;
}
.card-subtitle {
  color: white;
  margin: 0;
  font-weight: 100;
  font-size: 1.5rem;
  line-height: 2.4rem;
}
</style>
