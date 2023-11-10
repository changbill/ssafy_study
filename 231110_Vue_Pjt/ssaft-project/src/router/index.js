import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import UserView from "@/views/UserView.vue";
import BoardView from "@/views/BoardView.vue";
import Login from "@/components/User/Login.vue";
import Register from "@/components/User/Register.vue";
import BoardList from "@/components/Board/BoardList.vue";
import BoardCreate from "@/components/Board/BoardCreate.vue";
import BoardUpdate from "@/components/Board/BoardUpdate.vue";
import BoardDetail from "@/components/Board/BoardDetail.vue";

const routes = [
  {
    path: "/",
    name: "homeview",
    component: HomeView,
  },
  {
    path: "/user",
    component: UserView,
    children: [
      {
        path: "login",
        name: "/login",
        component: Login,
      },
      {
        path: "register",
        name: "/register",
        component: Register,
      },
    ],
  },
  {
    path: "/board",
    component: BoardView,
    children: [
      {
        path: "",
        name: "boardList",
        component: BoardList,
      },
      {
        path: "create",
        name: "BoardCreate",
        component: BoardCreate,
      },
      {
        path: "update",
        name: "BoardUpdate",
        component: BoardUpdate,
      },
      {
        path: "detail",
        name: "BoardDetail",
        component: BoardDetail,
      },
    ],
    redirect: () => {
      return "/";
    },
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
