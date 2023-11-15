<template>
  <div>
    <div class="row">
      <div
        class="card my-2 col-12 col-sm-6 col-md-3"
        v-for="(movie, index) in movieList"
        :key="movie.id"
      >
        <img
          :src="`https://image.tmdb.org/t/p/original/${movie.poster_path}`"
          class="card-img-top"
          alt="..."
        />
        <div class="card-body">
          <h5 class="card-title text-truncate">{{ movie.title }}</h5>
          <p class="card-text text-truncate">
            {{ movie.overview }}
          </p>
          <div class="card">
            <ul class="list-group list-group-flush">
              <li class="list-group-item">등수 : {{ index + 1 }}</li>
              <li class="list-group-item">
                언어 : {{ movie.original_language }}
              </li>
              <li class="list-group-item">
                개봉일자 : {{ movie.release_date }}
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <table>
      <thead>
        <tr>
          <th>순위</th>
          <th>포스터</th>
          <th>제목</th>
          <th>줄거리</th>
          <th>언어</th>
          <th>개봉일</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(movie, index) in movieList" :key="movie.id">
          <td>{{ index + 1 }}</td>
          <td>
            <img
              :src="`https://image.tmdb.org/t/p/original/${movie.poster_path}`"
              style="height: 100px"
            />
          </td>
          <td>{{ movie.title }}</td>
          <td>{{ movie.overview }}</td>
          <td>{{ movie.original_language }}</td>
          <td>{{ movie.release_date }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";
const movieList = ref([]);

onMounted(() => {
  const api_key = import.meta.env.VITE_TMDB_API_KEY;
  const url = `https://api.themoviedb.org/3/movie/popular`;
  const params = {
    api_key,
    language: "ko",
    region: "KR",
  };

  axios({
    url,
    method: "GET",
    params,
  }).then((resopnse) => {
    movieList.value = resopnse.data.results;
  });
});
</script>

<style scoped></style>
