<template>
  <li>
    <!-- <iframe
      width="560"
      height="315"
      :src="`${video.youtube}`"
      allowfullscreen
    ></iframe> -->
    <img :src="video.snippet.thumbnails.default.url" />
    <span>{{ video.snippet.title }}</span>
  </li>
</template>

<script setup>
import { useVideoStore } from "@/stores/videoStore";
const store = useVideoStore();

const props = defineProps({
  video: {
    type: Object,
    required: true,
  },
});

// const clickVideo = function () {
//   store.clickVideo(props.video);
// };
</script>

<style scoped></style>
