<template>
  <div id="containerLogIn" class="container">
    <h1 class="tituloLogIn">Log In</h1>
    <form class="formularioLogIn">
      <div class="form-group">
        <input type="email" class="form-control rounded" placeholder="Email">
      </div>
      <div class="form-group">
        <input type="text" class="form-control rounded" placeholder="Username">
      </div>
      <div class="form-group">
        <input type="password" class="form-control rounded" placeholder="Password">
      </div>
      <button class="btn btn-primary btn-block">Log In</button>
    </form>
  </div>
</template>

<style>
body {
  background-color: #F0F0F0;
}

#containerLogIn {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.tituloLogIn {
  color: blue;
}

.formularioLogIn {
  max-width: 400px; /* Añade un ancho máximo */
  width: 100%; /* Hace que el formulario ocupe todo el ancho disponible */
}

.rounded {
  border-radius: 10px;
  padding: 10px;
  margin-bottom: 10px;
}

.login {
  border-radius: 10px;
  padding: 10px 20px;
  cursor: pointer;
}
</style>
