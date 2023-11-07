import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useTodosStore = defineStore(
  "todos",
  () => {
    let id = 0;

    // state
    const todos = ref([
      { id: id++, text: "수업듣기", isDone: false },
      { id: id++, text: "점심먹기", isDone: false },
      { id: id++, text: "춤추기", isDone: false },
      { id: id++, text: "영화보기", isDone: false },
    ]);

    // actions
    const addTodo = function (text) {
      todos.value.push({
        id: id++,
        text, // text: text와 같은 코드
        isDone: false,
      });
    };

    const deleteTodo = function (id) {
      // findIndex: Index 찾아주는 메소드, 없음 -1 있음 인덱스 반환
      const index = todos.value.findIndex((todo) => {
        return todo.id === id;
      });

      todos.value.splice(index, 1);
    };

    const updateTodo = function (id) {
      // map : 각 요소에 대해 함수를 실행하고 그 결과로 새로운 배열을 만듬
      todos.value = todos.value.map((todo) => {
        if (todo.id === id) {
          todo.isDone = !todo.isDone;
        }
        return todo;
      });
      // for문으로도 가능
    };

    const doneTodoCount = computed(() => {
      return todos.value.filter((todo) => todo.isDone).length;
    });

    return { todos, addTodo, deleteTodo, updateTodo, doneTodoCount };
  },
  { persist: true } // 새로고침을 해도 남아있게 한다
);
