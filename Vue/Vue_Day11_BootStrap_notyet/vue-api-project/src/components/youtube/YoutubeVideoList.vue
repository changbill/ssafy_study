<template>
  <div class="container">
    <h4 class="text-center" v-if="store.videos == null">
      아직 검색 결과가 없습니다
    </h4>
    <ul>
      <YoutubeVideoListItem
        v-for="video in store.videos"
        :key="video.id.videoId"
        :video="video"
      />
    </ul>
  </div>
</template>

<script setup>
import { useYoutubeStore } from "@/stores/youtube";
import YoutubeVideoListItem from "./YoutubeVideoListItem.vue";

const store = useYoutubeStore();
</script>

<style scoped></style>
