<template>
  <div>
    <h4>TodoForm</h4>
    <input type="text" v-model.trim="todoText" @keyup.enter="createTodo" />
    <!--trim: 공백 제거-->
    <button @click="createTodo">등록</button>
  </div>
</template>

<script setup>
import { useTodosStore } from "@/stores/todos";
import { ref } from "vue";

const store = useTodosStore();

const todoText = ref("");

const createTodo = function () {
  if (todoText.value) {
    // JS는 빈 String도 false로 받아들임
    store.addTodo(todoText.value);
    // add하고 다시 빈 String으로 되돌려놓기
    todoText.value = "";
    // 따라서 비어있을 때는 addTodo func이 실행되지 않도록 함
  } else alert("공백은 안돼");
};
</script>

<style scoped></style>
