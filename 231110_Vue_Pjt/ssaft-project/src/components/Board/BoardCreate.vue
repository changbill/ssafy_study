<template>
  <div class="container">
    <h2>리뷰 등록</h2>
    <fieldset class="text-center">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" class="view" /><br />
      <label for="writer">작성자</label>
      <input type="text" id="writer" v-model="writer" class="view" /><br />
      <label for="content">리뷰</label>
      <textarea type="text" id="content" v-model="content" class="view" /><br />
      <button class="btn" @click="createReview">등록</button>
    </fieldset>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useReviewStore } from "@/stores/reviewStore";
const reviewStore = useReviewStore();

const id = ref("");      // id는 auto_increment로 자동으로 올라가게끔 할것임
const video_id = ref(""); // video_id는 요청받을 때 받아올 것임
const writer = ref("");
const title = ref("");
const content = ref("");
const reg_date = ref(""); // date_now로 받아올 것임
const view_cnt = ref(""); // 조회수 받아올 것임

const createReview = () => {
  const newReview = {
    id: id.value,
    video_id: video_id.value,
    writer: writer.value,
    title: title.value,
    content: content.value,
    reg_date: reg_date.value,
    view_cnt:view_cnt.value,
  };

  reviewStore.createReview(newReview);
};
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
.movie-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.movie-list td,
.movie-list th {
  border: 1px solid black;
}

.detail-content {
  padding: 10px 30px;
}
</style>
