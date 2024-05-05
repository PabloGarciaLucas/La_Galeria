<template>
  <div id="containerForo" class="container">
    <div class="row">
      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Cómo funciona nuestra aplicación?</h2>
          <p class="respuesta">El funcionamiento de nuestra aplicación es simple. El cliente cuenta con dos opciones: "Solicitar un cóctel", en la que el cliente solicita un cóctel ya predefinido el cual será enviado a su ubicación, y "Personalizar un Cóctel", en la que permitimos a nuestro cliente, además de escoger su cóctel, escoger la cristalería que desea que tenga su vaso además de poder quedársela para que pueda disfrutar de otros cócteles futuros.</p>
          <div @load="traerImagen()" class="container"></div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Hasta dónde llegan nuestros servicios?</h2>
          <p class="respuesta">Nuestros servicios por ahora solo abarcan toda Salamanca, pero pretendemos extender este servicio a nivel nacional.</p>
          <div @load="traerImagen2()" class="container"></div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 mb-3">
        <div class="caja">
          <h2 class="tituloPregunta">¿Hasta qué horario está abierta la entrega de cócteles los fines de semana?</h2>
          <p class="respuesta">Al ser un servicio pensado para previas, el horario de servicio es de 22:30 hasta las 4:30 de viernes a domingo.</p>
          <div @load="traerImagen3()" class="container"></div>
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
      fetch("http://localhost:8080/galeria/v1/imagenes/1", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen));
    },
    traerImagen2() {
      fetch("http://localhost:8080/galeria/v1/imagenes/1", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen));
    },
    traerImagen3() {
      fetch("http://localhost:8080/galeria/v1/imagenes/1", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen));
    },
    anadeImg(base64) {
      var img = document.createElement('img');
      img.src = 'data:image/jpeg;base64,' + base64;
      document.querySelector('.container:last-child').appendChild(img);
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
  height: 100vh;
  background-color: #f0f0f0;
}

.caja {
  border: 2px solid #ccc;
  border-radius: 10px;
  padding: 20px;
  height: 350px;
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
</style>
