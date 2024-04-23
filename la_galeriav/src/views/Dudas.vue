<template>
    <div id="containerForo" >
      <div class="caja">
        <h2 class="tituloPregunta">¿Cómo funciona nuestra aplicación?</h2>
        <p class="respuesta">El funcionamiento de nuestra aplicación es simple. El cliente cuenta con dos opciones: "Solicitar un cóctel", en la que el cliente solicita un cóctel ya predefinido el cual será enviado a su ubicación, y "Personalizar un Cóctel", en la que permitimos a nuestro cliente, además de escoger su cóctel, escoger la cristalería que desea que tenga su vaso además de poder quedársela para que pueda disfrutar de otros cócteles futuros.</p>
        <img load="traerImagen()" src="interrogacion.png" alt="¿Cómo funciona nuestra aplicación?" class="interrogacionImagen">
        <button onclick="traerImagen()">Traer imagen</button>
        <div id="container"></div>
      </div>
      <div class="caja">
        <h2 class="tituloPregunta">¿Hasta dónde llegan nuestros servicios?</h2>
        <p class="respuesta">Nuestros servicios por ahora solo abarcan toda Salamanca, pero pretendemos extender este servicio a nivel nacional.</p>
        <img load="traerImagen()" src="interrogacion.png" alt="¿Hasta dónde llegan nuestros servicios?" class="interrogacionImagen">
      </div>
      <div class="caja">
        <h2 class="tituloPregunta">¿Hasta qué horario está abierta la entrega de cócteles los fines de semana?</h2>
        <p class="respuesta">Al ser un servicio pensado para previas, el horario de servicio es de 22:30 hasta las 4:30 de viernes a domingo.</p>
        <img load="traerImagen()" src="interrogacion.png" alt="¿Cómo funciona nuestra aplicación?" class="interrogacionImagen">
      </div>
    </div>
  </template>
  
  <style scoped>
  #containerForo {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f0f0f0;
  }
  
  .caja {
    border: 2px solid #ccc;
    border-radius: 10px;
    padding: 20px;
    max-width: 500px;
    width: 100%;
    height: 350px; 
    margin: 20px; 
    display: flex;
    flex-direction: column;
    transition: box-shadow 0.3s ease;
  }
  
  .caja:hover {
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
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
  
  .interrogacionImagen {
    align-self: flex-end;
    max-width: 50px;
  }
</style>
  
<script>
export default {
  name: 'Dudas',
  data() {
    return {
      imagenes: []
    }
  },
  methods: {
    anadeImg(base64) {
      var img = document.createElement('img');
      img.src = 'data:image/jpeg;base64,'+base64;
      document.getElementById('container').appendChild(img);
    }
  },
  mounted() {
    fetch("http://localhost:8080/galeria/v1/imagenes", {
      mode: "cors"
    })
    .then(response => response.json())
    .then(data => {
      this.imagenes = data;
      this.imagenes.forEach(imagen => {
        this.anadeImg(imagen);
      });
    });
  }
}
</script>