import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useYoutubeStore = defineStore("youtube", () => {
  const videos = ref([]);
  const selectedVideo = ref("");
  const youtubeSearch = function (keyword) {
    const URL = "https://www.googleapis.com/youtube/v3/search";
    const API_KEY = "AIzaSyBnm2XG3-6j7LhySuAFX3FvVbxPKHwZaMs";

    axios({
      url: URL,
      method: "GET",
      params: {
        key: API_KEY,
        part: "snippet",
        q: keyword,
        type: "video",
        maxResults: 10,
      },
    })
      .then((response) => {
        videos.value = response.data.items;
      })
      .catch(() => {});
  };

  const clickVideo = function (video) {
    console.log(video);
    selectedVideo.value = video;
  };

  return { youtubeSearch, videos, clickVideo, selectedVideo };
});
