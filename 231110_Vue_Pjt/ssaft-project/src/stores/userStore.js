import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const USER_API = "http://localhost:8080/api-user/"

export const useUserStore = defineStore("user", () => {
  // 회원가입
  const createUser = function (user) {
    axios.post(`${USER_API}/signup`, user).then(() => {
      router.push("/");
    });
  };

  // 로그인
  const loginUser = ref(null);
  const setLoginUser = function (id2, pass2) {
      axios.post(`${USER_API}/login`, null, { params: { id: id2, pass: pass2 } })
          .then((res) => {
          loginUser.value=res.data
      })
  };

  // 로그아웃
  const setLogout = function () {
    loginUser.value = null;
  };

  return {
    setUsers,
    createUser,
    loginUser,
    setLoginUser,
    setLogout,
  };
});
