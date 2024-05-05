<template>
    <div id="solicitarProducto">
        <div class="caja">
            <router-link to="/solicitarCoctel" class="enlace">
                <img src="solicitarCoctel.png"  class="imagenes">
                <span class="titulo">Solicitar Cóctel</span>
                <div @load="traerImagenA()" id="container">
        
                </div>
            </router-link>
        </div>
        <div class="caja">
            <router-link to="/personalizarCoctel" class="enlace">
                <img src="personalizarCoctel.png"  class="imagenes">
                <span class="titulo">Personalizar Cóctel</span>
                <div @load="traerImagenB()" id="container">
        
                </div>
            </router-link>
        </div>
    </div>
</template>

<style>
#solicitarProducto {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #F0F0F0;
}

.caja {
    border: 3px solid lightgray;
    border-radius: 10px;
    padding: 20px;
    width: 200px; /* Tamaño uniforme */
    margin: 0 20px; /* Espacio entre las cajas */
    text-align: center; /* Centrar texto */
}

.imagenes {
    max-width: 100px; /* Tamaño uniforme */
    margin-bottom: 10px; /* Espacio entre la imagen y el título */
}

.titulo {
    font-size: 1.2rem;
}

.enlace {
    text-decoration: none; /* Quitar subrayado de los enlaces */
    color: inherit; /* Heredar color del texto */
}

.enlace:hover .imagenes {
    transform: scale(1.1); /* Aumentar tamaño de la imagen al pasar el ratón */
}

.enlace:hover .titulo {
    color: blue; /* Cambiar color del texto al pasar el ratón */
}
</style>

<script>
export default {
  name: 'solicitarProducto',
  data() {
    return {
      imagenes: []
    }
  },
  methods: {
    traerImagenA() {
      fetch("http://localhost:8080/galeria/v1/imagenes/2", {
      })
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen)); 
      
    },
    traerImagenB() {
      fetch("http://localhost:8080/galeria/v1/imagenes/3", {
      })
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen)); 
      
    },
    anadeImg(base64) {
      var img = document.createElement('img');
      img.src = 'data:image/jpeg;base64,'+base64;
      document.getElementById('container').appendChild(img);
      },
    },
  mounted() {
    this.traerImagenA();
    this.traerImagenB();
  }
}

</script>