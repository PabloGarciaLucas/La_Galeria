<template>
  <div id="containerForo" class="container">
    <h2 class="mb-4">Dudas</h2>
    <p class="lead mb-4">¡Bienvenido a La Galería! Entendemos que al visitar nuestra página web, puedan surgir algunas preguntas. ¡No te preocupes, estamos aquí para ayudarte! Hemos recopilado algunas de las dudas más comunes para que puedas navegar por nuestra página con confianza:</p>
    <div class="row">
      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Cómo funciona nuestra aplicación?</h2>
          <p class="respuesta">La aplicación ofrece dos opciones: "Solicitar un cóctel", donde se elige uno predefinido y se envía al cliente, y "Personalizar un Cóctel", que permite al cliente elegir el cóctel y la cristalería, la cual puede conservar para futuros pedidos.</p>
          <div @load="traerImagen()" class="containerImagen"></div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Hasta dónde llegan nuestros servicios?</h2>
          <p class="respuesta">Nuestros servicios por ahora solo abarcan toda Salamanca, pero pretendemos extender este servicio a nivel nacional.</p>
          <div @load="traerImagen2()" class="containerImagen"></div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Hasta qué horario está abierta la entrega de cócteles los fines de semana?</h2>
          <p class="respuesta">Al ser un servicio pensado para previas, el horario de servicio es de 22:30 hasta las 4:30 de viernes a domingo.</p>
          <div @load="traerImagen3()" class="containerImagen"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Dudas',
  data() {
    return {
      imagenes: []
    }
  },
  methods: {
    traerImagen() {
      fetch("http://localhost:8080/galeria/v1/imagenes/7", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen));
    },
    traerImagen2() {
      fetch("http://localhost:8080/galeria/v1/imagenes/7", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen));
    },
    traerImagen3() {
      fetch("http://localhost:8080/galeria/v1/imagenes/7", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen));
    },
    anadeImg(base64) {
      var img = document.createElement('img');
      img.src = 'data:image/jpeg;base64,' + base64;
      document.querySelector('.containerImagen:last-child').appendChild(img);
    },
  },
  mounted() {
    this.traerImagen();
    this.traerImagen2();
    this.traerImagen3();
  }
}
</script>

<style scoped>
#containerForo {
  margin-top: 100px;
  min-height: 100vh;
  background-color: #f0f0f0;
}
h2{
  text-align: center;
}
.caja {
  border: 2px solid #ccc;
  border-radius: 10px;
  padding: 20px;
  min-height: 350px;
}

.tituloPregunta {
  font-size: 1.5rem;
  margin-bottom: 20px;
}

.respuesta {
  font-size: 1.2rem;
  line-height: 1.6;
  margin-bottom: 20px;
}

.containerImagen {
  min-height: 100px; /* Asegura que todos los contenedores de imagen tengan la misma altura */
}
</style>
