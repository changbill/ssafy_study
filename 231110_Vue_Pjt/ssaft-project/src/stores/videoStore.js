import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "@/util/http-common";

const VIDEO_API = "api-video";

export const useVideoStore = defineStore("video", () => {
  const videoList = ref([]);
  const fetchVideoList = function () {
    axios.get(`${VIDEO_API}`).then((response) => {
      videoList.value = response.data;
    });
  };

  const sortList = ref([]);
  const videoSort = function () {
    axios.get(`${VIDEO_API}/count`).then((response) => {
      sortList.value = response.data;
    });
  };

  const partList = ref([]);
  const partVideo = function (part) {
    axios.get(`${VIDEO_API}/${part}`).then((response) => {
      partList.value = response.data;
    });
  };

  return { partVideo, videoSort, fetchVideoList };
});
