<template>
  <v-navigation-drawer
    :floating="primaryDrawer.floating"
    :clipped="primaryDrawer.clipped"
    :mini-variant="!primaryDrawer.mini"
    app
    overflow
  >
    <v-list dense nav class="py-0">
      <v-list-item two-line class="px-0" router to="/">
        <v-list-item-avatar>
          <v-icon>mdi-eye-check</v-icon>
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title>Cine se uita?</v-list-item-title>
          <v-list-item-subtitle> ...</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list-item
        v-for="item in items"
        :key="item.title"
        link
        router
        v-bind:to="item.href"
      >
        <v-list-item-icon>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>
<script>
export default {
  href: "Sidebar",
  data: () => ({
    items: [
      { title: "Instituții", icon: "mdi-domain", href: "/institutii" },
      { title: "Furnizori", icon: "mdi-sitemap", href: "/furnizori" },
      {
        title: "Bunuri și servicii",
        icon: "mdi-cash-multiple",
        href: "/bunuri"
      },
      {
        title: "Jurnaliști și investigații",
        icon: "mdi-shield-search",
        href: "/jurnalism"
      }
    ]
  }),
  props: {
    primaryDrawer: {}
  },
  methods: {}
};
</script>
