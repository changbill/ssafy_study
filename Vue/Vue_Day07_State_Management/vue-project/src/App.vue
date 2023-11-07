<template>
  <div>
    <h2>Todo PJT</h2>
    <p>완료 Todo 개수 : {{ store.doneTodoCount }}</p>
    <TodoForm />
    <TodoList />

    <!-- 
      이렇게 가져올 수 있는 이유는 경로를 @/stores/counter
      이런식으로 써놨기 때문
    -->
    <StoreTest />
  </div>
</template>

<script setup>
import { useTodosStore } from "@/stores/todos";
import TodoForm from "./components/TodoForm.vue";
import TodoList from "./components/TodoList.vue";
import StoreTest from "./components/StoreTest.vue";

const store = useTodosStore();
</script>

<style scoped></style>
