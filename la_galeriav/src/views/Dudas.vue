<template>
    <div id="containerForo" >
      <div class="caja">
        <h2 class="tituloPregunta">¿Cómo funciona nuestra aplicación?</h2>
        <p class="respuesta">El funcionamiento de nuestra aplicación es simple. El cliente cuenta con dos opciones: "Solicitar un cóctel", en la que el cliente solicita un cóctel ya predefinido el cual será enviado a su ubicación, y "Personalizar un Cóctel", en la que permitimos a nuestro cliente, además de escoger su cóctel, escoger la cristalería que desea que tenga su vaso además de poder quedársela para que pueda disfrutar de otros cócteles futuros.</p>
        <div @load="traerImagen()" id="container"></div>
      </div>
      <div class="caja">
        <h2 class="tituloPregunta">¿Hasta dónde llegan nuestros servicios?</h2>
        <p class="respuesta">Nuestros servicios por ahora solo abarcan toda Salamanca, pero pretendemos extender este servicio a nivel nacional.</p>
        <div @load="traerImagen()" id="container"></div>
      </div>
      <div class="caja">
        <h2 class="tituloPregunta">¿Hasta qué horario está abierta la entrega de cócteles los fines de semana?</h2>
        <p class="respuesta">Al ser un servicio pensado para previas, el horario de servicio es de 22:30 hasta las 4:30 de viernes a domingo.</p>
        <div @load="traerImagen()" id="container"></div>
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
    },
    traerImagen() {
      fetch("http://localhost:8081/galeria/v1/imagenes/1", {
        mode: "cors"
      })
      .then(response => response.blob()) // Convertir la respuesta a un Blob
      .then(blob => {
        this.blobToBase64(blob); // Llamar a la función para convertir Blob a base64
      })
      .catch(error => {
        console.error('Error al cargar la imagen:', error);
      });
    },
    blobToBase64(blob) {
      const reader = new FileReader();
      reader.readAsDataURL(blob); // Leer el blob como una cadena base64
      reader.onloadend = () => {
        const base64data = reader.result.split(',')[1]; // Obtener solo los datos base64
        this.anadeImg(base64data); // Llamar a la función para agregar la imagen
      };
    }
  },
  mounted() {
    this.traerImagen();
  }
}

</script>
