<template>
  <div class="container">
    <h1>리뷰 상세 정보</h1>
    <fieldset class="detail-content">
      <label for="title">제목</label>
      <div class="view">{{ review.title }}</div>
      <label for="writer">작성자</label>
      <div class="view">{{ review.writer }}</div>
      <label for="content">내용</label>
      <div class="view">{{ review.content }}</div>
      <button class="btn" @click="editReview">수정</button>
      <button class="btn" @click="deleteReview">삭제</button>
    </fieldset>
  </div>
</template>

<script setup>
import { computed, onBeforeMount } from "vue";
import { useRoute } from "vue-router";
import { useReviewStore } from "@/stores/reviewStore";
import router from "@/router";

const reviewStore = useReviewStore();

const route = useRoute();
const reviewId = route.params.reviewId;

let review = reviewStore.review;

onBeforeMount(() => {
  const reviewId = route.params.reviewId;
  reviewStore.fetchReview(reviewId);
});

const editReview = () => {
  router.push(`/review/${reviewId}/update`);
};

const deleteReview = (reviewId) => {
  router.push(`/review/${reviewId}/delete`);
};
</script>

<style scoped>
.container {
  margin: 0px 30px;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

.detail-content {
  padding: 10px 30px;
}
</style>
