<template>
  <div>
    <span
      class="click-cursor"
      :class="{ 'is-done': todo.isDone }"
      @click="store.updateTodo(todo.id)"
      >{{ todo.text }}</span
    >
    <!-- span태그는 텍스트를 그룹하거나 스타일 적용하기 위해 사용 -->
    <button @click="store.deleteTodo(todo.id)">X</button>
  </div>
</template>

<script setup>
import { useTodosStore } from "../stores/todos";

const store = useTodosStore();

defineProps({
  todo: Object,
});
</script>

<style scoped>
.is-done {
  text-decoration: line-through;
}

.click-cursor {
  cursor: pointer;
}
</style>
