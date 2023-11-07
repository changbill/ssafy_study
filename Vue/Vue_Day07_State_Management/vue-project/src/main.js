import { createApp } from "vue";
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";
// 새로고침을 해도 남아있게 하고 싶다.
// piniaPluginPersistedstate에 이 기능 구현
import App from "./App.vue";

const app = createApp(App);

const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

app.use(pinia);

app.mount("#app");
