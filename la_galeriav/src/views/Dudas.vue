<template>
  <div id="containerForo" class="container">
    <h2 class="mb-4">Dudas</h2>
    <p class="lead mb-4">¡Bienvenido a La Galería! Entendemos que al visitar nuestra página web, puedan surgir algunas preguntas. ¡No te preocupes, estamos aquí para ayudarte! Hemos recopilado algunas de las dudas más comunes para que puedas navegar por nuestra página con confianza:</p>
    <div class="row">
      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Cómo funciona nuestra aplicación?</h2>
          <p class="respuesta">La aplicación ofrece dos opciones: "Solicitar un cóctel", donde se elige uno predefinido y se envía al cliente, y "Personalizar un Cóctel", que permite al cliente elegir el cóctel y la cristalería, la cual puede conservar para futuros pedidos.</p>
          <div ref="containerImagen1" class="containerImagen"></div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Hasta dónde llegan nuestros servicios?</h2>
          <p class="respuesta">Nuestros servicios por ahora solo abarcan toda Salamanca, pero pretendemos extender este servicio a nivel nacional.</p>
          <div ref="containerImagen2" class="containerImagen"></div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Hasta qué horario está abierta la entrega de cócteles los fines de semana?</h2>
          <p class="respuesta">Al ser un servicio pensado para previas, el horario de servicio es de 22:30 hasta las 4:30 de viernes a domingo.</p>
          <div ref="containerImagen3" class="containerImagen"></div>
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
    traerImagen(container) {
      fetch("http://localhost:8080/galeria/v1/imagenes/7", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen, container));
    },
    anadeImg(base64, container) {
      var img = document.createElement('img');
      img.src = 'data:image/jpeg;base64,' + base64;
      container.appendChild(img);
    },
  },
  mounted() {
    this.traerImagen(this.$refs.containerImagen1);
    this.traerImagen(this.$refs.containerImagen2);
    this.traerImagen(this.$refs.containerImagen3);
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
.row {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: stretch;
}
.caja {
  border: 2px solid #ccc;
  border-radius: 10px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  min-height: 500px; /* Ajusta este valor según tus necesidades */
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
  display: flex;
  justify-content: center;
}
</style>
