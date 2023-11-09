const API_URL = `http://localhost:8080/api/board`;
import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

export const useBoardStore = defineStore("board", () => {
  // 전체 글 조회
  const boardList = ref([]);
  const getBoardList = function () {
    axios.get(API_URL).then((response) => {
      boardList.value = response.data;
    });
  };

  //  게시글 하나
  const board = ref({});
  const getBoard = function (id) {
    axios.get(`${API_URL}/${id}`).then((response) => {
      board.value = response.data;
    });
  };

  // 게시글 등록
  const createBoard = function (board) {
    // axios.post 또는
    axios({
      url: API_URL,
      method: "POST",
      //  아래꺼 없어도 application/json으로 경로 잘 보낸다
      headers: {
        "Content-Type": "application/json",
      },
      data: board,
    })
      .then(() => {
        // response 응답으로 들어온 게시글의 id를 이용하여
        // 상세보기로 가기도 가능
        router.push({ name: "boardList" });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const updateBoard = function () {
    axios.put(API_URL, board.value).then(() => {
      router.push({ name: "boardList" });
    });
  };

  const searchBoardList = function (searchCondition) {
    axios
      .get(API_URL, {
        params: searchCondition,
      })
      .then((res) => {
        boardList.value = res.data;
      });
  };
  return {
    boardList,
    getBoardList,
    board,
    getBoard,
    createBoard,
    updateBoard,
    searchBoardList,
  };
});
