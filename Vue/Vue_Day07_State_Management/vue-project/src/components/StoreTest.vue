<template>
  <div>
    <h1>StoreTest</h1>
    <p>state : {{ store.count }}</p>
    <p>getters : {{ store.doubleCount }}</p>
    <button @click="store.increment()">++</button>
    <button @click="increment">증가</button>
  </div>
</template>

<script setup>
import { useCounterStore } from "@/stores/counter";

const store = useCounterStore();
console.log(store.count);
const increment = function () {
  store.increment();
};
</script>

<style scoped></style>
