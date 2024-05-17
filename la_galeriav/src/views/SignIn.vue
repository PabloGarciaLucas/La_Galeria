<template>
  <div id="containerSignIn" class="container">
    <h1 class="tituloRegister">Register</h1>
    <p v-if="registroExitoso" class="registrado">Registro Realizado Correctamente</p>
    <form v-if="!registroExitoso" class="formularioRegister" @submit.prevent="register" :disabled="registroExitoso">
      <div class="form-group">
        <input type="email" v-model="email" class="form-control rounded" placeholder="Email" required>
      </div>
      <div class="form-group">
        <input type="text" v-model="username" class="form-control rounded" placeholder="Username" required>
      </div>
      <div class="form-group">
        <input type="password" v-model="password" class="form-control rounded" placeholder="Password" required>
      </div>
      <button type="submit" class="btn btn-primary btn-block">Register</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: '',
      username: '',
      password: '',
      registroExitoso: JSON.parse(localStorage.getItem('registroExitoso')) || false
    }
  },
  methods: {
    async register() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/usuarios', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            userEmail: this.email,
            userName: this.username,
            userPasswd: this.password,
            user_role: ["Usuario"]
          })
        });

        if (response.ok) {
          alert('Usuario registrado correctamente.');
          this.email = '';
          this.username = '';
          this.password = '';
          this.registroExitoso = true;
          localStorage.setItem('registroExitoso', JSON.stringify(this.registroExitoso));
          this.$router.push('/login'); 
        } else {
          alert('Este usuario ya existe');
        }
      } catch (error) {
        alert(`Error: ${error.message || 'Error desconocido al intentar conectar con el servidor.'}`);
      }
    }
  }
}
</script>

<style scoped>
body {
  background-color: #F0F0F0;
}

#containerSignIn {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.tituloRegister {
  color: blue;
}

.formularioRegister {
  max-width: 400px;
  width: 100%;
}

.rounded {
  border-radius: 10px;
  padding: 10px;
  margin-bottom: 10px;
}

.register {
  border-radius: 10px;
  padding: 10px 20px;
  cursor: pointer;
}

.mensaje {
  margin-top: 20px;
  color: green;
}

.registrado {
  margin-top: 20px;
  color: rgb(61, 61, 61);
}
</style>
