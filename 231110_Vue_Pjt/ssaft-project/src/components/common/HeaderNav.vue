<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/"
          ><i class="bi bi-house-door-fill fs-1">SSAFIT</i></RouterLink
        >
      </div>
      <div>
        <RouterLink to="/board"
          ><i class="bi bi-search fs-1"></i>게시판</RouterLink
        >
        <RouterLink to="/user/register"
          ><i class="bi bi-person-circle fs-1">회원가입</i></RouterLink
        >
        <RouterLink to="/user/login"
          ><i class="bi bi-box-arrow-in-right fs-1">로그인</i></RouterLink
        >
      </div>
    </nav>
  </header>
</template>

<script setup></script>

<style>
/* header 태그 안에 CSS 속성 */
header {
  height: 70px;
  background-color: skyblue;
  line-height: 70px;
  padding: 0px 30px;
}

header a {
  text-decoration: none;
  color: white;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
}

.nabMenu {
  margin: 10px;
}
</style>
