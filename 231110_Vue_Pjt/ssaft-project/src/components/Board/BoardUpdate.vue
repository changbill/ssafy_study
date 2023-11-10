<template>
  <div class="container">
    <h2>ㄹ 상세 정보</h2>
    <fieldset class="detail-content">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="review.title" class="view" /><br />
      <label for="writer">작성자</label>
      <input
        type="text"
        id="writer"
        v-model="review.writer"
        class="view"
      /><br />

      <button class="btn" @click="updateReview">완료</button>
      <button class="btn" @click="deleteReview">삭제</button>
    </fieldset>
  </div>
</template>

<script setup>
import { computed, onBeforeMount } from "vue";
import { useRoute } from "vue-router";
import { useReviewStore } from "@/stores/reviewStore";

const reviewStore = useReviewStore();
const route = useRoute();

let review = reviewStore.review;

onBeforeMount(() => {
  const reviewId = route.params.reviewId;
  reviewStore.fetchReview(reviewId);
});

const updateReview = () => {
  const reviewId = route.params.reviewId;
  reviewStore.updateReview(review.value, reviewId);
};

const deleteReview = () => {
  router.push(`/review/${reviewId}/delete`);
};
</script>

<style scoped>
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
