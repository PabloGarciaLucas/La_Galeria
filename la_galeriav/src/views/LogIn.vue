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
      <button class="btn btn-primary login">Log In</button>
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
  display: flex;
  flex-direction: column;
  align-items: center;
}

.rounded {
  border: 1px solid #ccc;
  border-radius: 10px;
  padding: 10px;
  margin-bottom: 10px;
  width: 300px;
}

.login {
  background-color: blue;
  color: white;
  border: none;
  border-radius: 10px;
  padding: 10px 20px;
  cursor: pointer;
}
</style>



/*<script>
import { mapActions } from 'vuex'

export default {
  data () {
    return {
      email: '',
      username: '',
      password: ''
    }
  },
  methods: {
    ...mapActions(['login']),
    handleSubmit () {
      fetch("http://localhost:8081/galeria/v1/usuarios", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          email: this.email,
          username: this.username,
          password: this.password
        })
      })
      .then(response => response.json())
      .then(data => {
        if (data && data.token) {
          this.login(data.token)
        } else {
          // Manejar error: el servidor no devolvió un token
        }
      })
      .catch(error => {
        // Manejar error: la petición HTTP falló
      })
    }
  }
}
</script>*/