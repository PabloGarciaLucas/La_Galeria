<template>
  <div id="solicitarProducto" class="d-flex justify-content-center align-items-center flex-wrap">
    <div class="row">
      <!-- Nuevo div para texto informativo -->
      <div class="col-md-12 mb-3">
        <div class="informacion-cocteles">
          <h2>¡Descubre nuestros deliciosos cócteles!</h2>
          <p>Explora nuestra selección de cócteles y elige tu favorito para disfrutar de una experiencia única.</p>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="caja mb-3 col-md-6">
        <router-link to="/solicitarCoctel" class="enlace text-decoration-none">
          <img src="solicitarCoctel.png" class="imagenes img-fluid">
          <span class="titulo">Solicitar Cóctel</span>
          <div @load="traerImagenA()" class="container"></div>
        </router-link>
      </div>
      <div class="caja mb-3 col-md-6">
        <router-link to="/personalizarCoctel" class="enlace text-decoration-none">
          <img src="personalizarCoctel.png" class="imagenes img-fluid">
          <span class="titulo">Personalizar Cóctel</span>
          <div @load="traerImagenB()" class="container"></div>
        </router-link>
      </div>
    </div>
  </div>
</template>

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
      fetch("http://localhost:8080/galeria/v1/imagenes/2", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen));
    },
    traerImagenB() {
      fetch("http://localhost:8080/galeria/v1/imagenes/3", {})
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
    this.traerImagenA();
    this.traerImagenB();
  }
}
</script>

<style scoped>
#solicitarProducto {
  height: 100vh;
  background-color: #F0F0F0;
}

.caja {
  border: 3px solid lightgray;
  border-radius: 10px;
  padding: 20px;
  text-align: center;
}

.imagenes {
  max-width: 100px;
  max-height: 100px; /* Tamaño máximo */
  margin-bottom: 10px;
}

.titulo {
  font-size: 1.2rem;
}

.enlace:hover .imagenes {
  transform: scale(1.1);
}

.enlace:hover .titulo {
  color: blue;
}

/* Estilos para el nuevo div de información */
.informacion-cocteles {
  text-align: center;
  margin-bottom: 20px;
}

.informacion-cocteles h2 {
  font-size: 1.5rem;
  margin-bottom: 10px;
}

.informacion-cocteles p {
  font-size: 1rem;
}
</style>
