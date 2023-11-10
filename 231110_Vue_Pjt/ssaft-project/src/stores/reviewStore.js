import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "@/util/http-common";

const API_URL = `api-board/board`;

export const useReviewStore = defineStore("review", () => {
  const reviewList = ref([]);
  const fetchReviewList = function (video_id) {
    console.log("전");
    axios.get(`API_URL/${video_id}`).then((response) => {
      console.log("후");
      console.log(response.value);
      reviewList.value = response.data;
    });
  };

  const review = ref({});
  const fetchReview = function (video_id, id) {
    axios.get(`${API_URL}/${video_id}/${id}`).then((response) => {
      review.value = response.data;
    });
  };

  const deleteReview = function (video_id, id) {
    axios.delete(`${API_URL}/${video_id}/${id}`).then((response) => {
      router.push({ name: "reviewList" });
    });
  };

  const createReview = function (video_id, review) {
    axios({
      url: `API_URL/${video_id}`,
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      data: review,
    }).then(() => {
      router.push({ name: "reviewList" });
    });
  };

  const reviewCnt = computed(() => review.value.length);

  const updateReview = function (video_id) {
    axios({
      url: `API_URL/${video_id}`,
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      data: review,
    }).then(() => {
      router.push({ name: "reviewList" });
    });
  };

  return {
    deleteReview,
    fetchReview,
    fetchReviewList,
    review,
    reviewList,
    reviewCnt,
    createReview,
    updateReview,
  };
});
