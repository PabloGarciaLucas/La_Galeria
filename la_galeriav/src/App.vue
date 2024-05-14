<template>
  <div id="pagina">
    <nav id="app">
      <router-link to="/" class="nav-link">Inicio</router-link>
      <router-link to="/solicitarProducto" class="nav-link">Solicitar un Producto</router-link>
      <router-link to="/dudas" class="nav-link">Dudas</router-link>
      <router-link to="/signin" class="nav-link">Sign In</router-link>
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
  color: #7baad8;
  background-color: #4f6f8f;
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
  color: #d1d1d1;
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
  height: 130px;
  z-index: 100;
  background: rgb(20,20,255);
background: linear-gradient(90deg, rgba(20,20,255,1) 0%, rgba(101,101,101,1) 47%, rgba(104,228,255,1) 100%);
  color: #fff;
  padding: 20px 0;
  text-align: center;
}
p{
  font-weight: bold;
  color: rgb(255, 255, 255);
}
i{
  font-size: x-large;
  padding-right: 10px;
}

</style>

<script>
export default {
  methods: {
   
  },
}
</script>
