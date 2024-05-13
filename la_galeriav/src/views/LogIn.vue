<template>
  <div id="containerLogIn" class="container">
    <h1 class="tituloLogIn">Log In</h1>
    <form class="formularioLogIn" @submit.prevent="logIn">
      <div class="form-group">
        <input type="text" v-model="username" class="form-control rounded" placeholder="Username" required :disabled="isLoggedIn">
      </div>
      <div class="form-group">
        <input type="password" v-model="password" class="form-control rounded" placeholder="Password" required :disabled="isLoggedIn">
      </div>
      <button type="submit" class="btn btn-primary btn-block" :disabled="isLoggedIn">Log In</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      users: [],
      isLoggedIn: false // Bandera para indicar si el usuario está autenticado
    }
  },
  methods: {
    async logIn() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/usuarios');
        if (response.ok) {
          this.users = await response.json();
          
          const userMatch = this.users.find(user => user.userName === this.username && user.userPasswd === this.password);
          
          if (userMatch) {
            console.log('Usuario autenticado exitosamente.');
            alert('¡Bienvenido de nuevo!');
            this.isLoggedIn = true; // Marcar al usuario como autenticado
            this.clearForm(); // Limpiar el formulario
            // Aquí puedes redirigir al usuario a la página principal o a donde desees
          } else {
            console.error('Usuario o contraseña incorrectos.');
            alert('Usuario o contraseña incorrectos. Por favor, inténtalo de nuevo.');
          }
        } else {
          console.error('Error al obtener usuarios:', response.statusText);
          alert('Error al obtener usuarios. Por favor, inténtalo de nuevo.');
        }
      } catch (error) {
        console.error('Error al autenticar usuario:', error);
        alert('Error al autenticar usuario. Por favor, inténtalo de nuevo.');
      }
    },
    clearForm() {
      // Limpiar los campos de usuario y contraseña
      this.username = '';
      this.password = '';
    }
  }
}
</script>

<style scoped>
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
  max-width: 400px;
  width: 100%;
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
