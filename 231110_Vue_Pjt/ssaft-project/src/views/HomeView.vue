<template>
  <div>
    <router-view></router-view>
    <VideoList />
  </div>
</template>

<script setup>
import VideoList from "@/components/Video/VideoList.vue";
</script>

<style scoped></style>
