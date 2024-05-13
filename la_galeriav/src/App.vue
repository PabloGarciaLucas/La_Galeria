<template>
  <div id="pagina">
    <nav id="app">
      <router-link to="/" class="nav-link">Inicio</router-link>
      <router-link to="/solicitarProducto" class="nav-link">Solicitar un Producto</router-link>
      <router-link to="/dudas" class="nav-link">Dudas</router-link>
      <router-link to="/login" class="nav-link">Log In</router-link>
    </nav>
    
    <footer class="footer">
      <p>Barrio del oeste</p>
      <p>Calle Dr. Jaime Vera, 19, 15, 37007 Salamanca.</p>
      <i class="fab fa-instagram"></i>
      <i class="fab fa-facebook"></i>
      <i class="fab fa-twitter"></i>
    </footer>
    
    <router-view/>
  </div>
</template>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  background-color: #2c3e50;
  padding: 20px 0;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 100;
  display: flex;
  justify-content: center;
}

#pagina{
  height:1000px;
  width: 100%;
}
.nav-link {
  font-weight: bold;
  color: #fff;
  text-decoration: none;
  margin: 0 10px;
}

.nav-link:hover {
  color: #b1a6a6;
}

.nav-link.router-link-exact-active {
  color: #fff; 
}

.footer {
  text-decoration: none;
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 120px;
  z-index: 100;
  background-color: #949697;
  color: #fff;
  padding: 20px 0;
  text-align: center;
}
i{
  padding-right: 10px;
}

</style>

<script>
export default {
  methods: {
   
  },
}
</script>
