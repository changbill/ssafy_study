import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import AboutView from "../views/AboutView.vue";
import UserView from "../views/UserView.vue";
import LoginView from "../views/LoginView.vue";
import BoardCreate from "../components/board/BoardCreate.vue";
import BoardList from "../components/board/BoardList.vue";
import BoardView from "../views/BoardView.vue";

const isAuth = true; // 로그인 하면 true, 아니면 false

const router = createRouter({
  // 이전 기록이 남아서 뒤로가기 할 수 있다
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/about",
      name: "about",
      component: AboutView,
    },
    {
      path: "/user/:id",
      name: "user",
      component: UserView,
    },
    {
      path: "/board",
      name: "board",
      component: BoardView,
      children: [
        {
          path: "",
          component: BoardList,
        },
        {
          path: "create",
          component: BoardCreate,
        },
      ],
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
      beforeEnter: (to, from) => {
        if (isAuth) {
          console.log("이미 로그인 상태");
          return { name: "home" };
        }
      },
    },
  ],
});

router.beforeEach((to, from) => {
  console.log(to);
  console.log(from);
  if (!isAuth && to.name != "login") {
    console.log("로그인이 필요합니다");
    return { name: "login" };
  }
});

export default router;
