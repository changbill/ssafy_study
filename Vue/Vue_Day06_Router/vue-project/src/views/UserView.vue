<template>
  <div>
    <h1>UserView</h1>
    <!-- 아래와 같이 접근 가능하지만 권장 X -->
    <p>{{ $route.params.id }}</p>
    <p>{{ userId }}</p>
    <p>{{ userId2 }}</p>
  </div>
  <button @click="goHome">홈으로</button>
</template>

<script setup>
import { ref, watch } from "vue";
import {
  useRoute,
  useRouter,
  onBeforeRouteLeave,
  onBeforeRouteUpdate,
} from "vue-router";

const route = useRoute();
const userId = ref(route.params.id);
const userId2 = ref(route.params.id);
const router = useRouter();

const goHome = function () {
  // 경로를 직접 작성하는 방법
  // router.push('/');

  // 이름으로 작성하는 방법
  router.replace({ name: "home" });
};

// 앞에는 감시하고 싶은 객체 넣고,
watch(
  () => route.params.id,
  (newId) => {
    userId2.value = newId;
  }
);

onBeforeRouteLeave(() => {
  const answer = confirm("정말로 떠나실건가요?");
  if (!answer) return false;
  // false(취소) 선택시 from으로 되돌아감
});

// 업데이트 할때마다 id가 업데이트 된다
onBeforeRouteUpdate((to) => {
  userId.value = to.params.id;
});
</script>

<style scoped></style>
