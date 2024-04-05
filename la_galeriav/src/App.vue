<template>
  <nav id="app" @click="toggleFade">
    <router-link to="/">Inicio</router-link> |
    <router-link to="/solicitarProducto">Solicitar un Producto</router-link> |
    <router-link to="/dudas">Dudas</router-link> |
    <router-link to="/login">Log In</router-link>
  </nav>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  background-color: blue;
  border-color: black;
  position: fixed;
  top: 0;
  left: 0;
  padding: 20px;
  z-index: 100;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
  transition: opacity .5s ease-out .25s;
}

nav a.fade-out {
  opacity: 0;
  transition: opacity 0.5s ease-out;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script>
  export default {
    methods: {
      toggleFade() {
        const link = event.target;
        link.classList.toggle("fade-out");
      }
    },
  }
</script>