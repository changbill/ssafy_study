<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <div>
    <h1>AppVue</h1>
    <header>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink :to="{ name: 'home' }">HomeName</RouterLink>
      <RouterLink to="/about">About</RouterLink>
      <RouterLink :to="{ name: 'about' }">AboutName</RouterLink>
      <RouterLink :to="{ name: 'user', params: { id: 'asdf' } }"
        >asdf</RouterLink
      >
      <RouterLink :to="{ name: 'user', params: { id: 'qwert' } }"
        >qwert</RouterLink
      >
      <RouterLink :to="{ name: 'login' }">login</RouterLink>
      <RouterLink to="/board">board</RouterLink>
    </header>

    <RouterView />
  </div>
</template>

<style scoped>
header {
  display: flex;
  justify-content: space-around;
}
</style>
