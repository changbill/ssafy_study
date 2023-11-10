<template>
  <div class="container">
    <h2>리뷰 목록</h2>
    <h4>등록된 리뷰 수 : {{ reviewCnt }}</h4>
    <hr />
    <div v-if="reviewList.length">
      <table class="review-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 15%" />
          <col style="width: 40%" />
        </colgroup>
        <thead>
          <tr>
            <th>제목</th>
            <th>작성자</th>
            <th>내용</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(review, index) in reviewList" :key="index">
            <td>{{ review.id }}</td>
            <!-- 클릭시 상세정보로 이동할 수 있게 바인딩하여 링크생성 -->
            <td>
              <RouterLink :to="`/board/${review.id}`">{{
                review.title
              }}</RouterLink>
            </td>
            <td>{{ review.writer }}</td>
            <td>{{ review.content }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div v-else>등록된 영화가 없습니다.</div>
  </div>
</template>
<script setup>
import { onMounted, computed } from "vue";
import { useReviewStore } from "@/stores/reviewStore";
import { useVideoStore } from "@/stores/videoStore";

const reviewStore = useReviewStore();
const videoStore = useVideoStore();
// const video = videoStore.

let reviewList = reviewStore.reviewList;
let reviewCnt = computed(() => reviewStore.reviewCnt);

onMounted(() => {
  reviewStore.fetchReviewList();
});
</script>
<style scoped>
header {
  height: 70px;
  background-color: skyblue;
  line-height: 70px;
  padding: 0px 30px;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

header a:not(.logo) {
  margin-right: 10px;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}
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

label {
  display: inline-block;
  width: 80px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px 0;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

/* 테이블 CSS */
.review-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.review-list td,
.review-list th {
  border: 1px solid black;
}

.detail-content {
  padding: 10px 30px;
}
</style>
