<template>
  <div>
    <HeaderNav />
    <RouterView />
  </div>
</template>

<script setup>
import HeaderNav from "@/components/common/HeaderNav.vue";
import { RouterView } from "vue-router";
</script>

<style></style>
