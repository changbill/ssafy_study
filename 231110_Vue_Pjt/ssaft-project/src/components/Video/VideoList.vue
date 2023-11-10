<template>
  <div>
    <h2>영상 목록</h2>
    <ul>
      <VideoListItem
        v-for="video in videoStore.videoList"
        :key="video.video_id"
        :video="video"
      />
    </ul>
    <!-- <div v-for="(video, index) in videoList" :key="index">
    </div> -->
    <VideoDetail />
  </div>
</template>

<script setup>
import { onMounted, computed } from "vue";
import { useVideoStore } from "@/stores/videoStore";
import VideoDetail from "./VideoDetail.vue";
import VideoListItem from "./VideoListItem.vue";

const videoStore = useVideoStore();

// onMounted(() => {
//   videoStore.fetchVideoList();
// });
</script>

<style scoped></style>
