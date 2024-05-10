<template>
  <div id="solicitarProducto" class="container">
    <div class="row">
      <!-- Nuevo div para texto informativo -->
      <div class="col-md-12 mb-3">
        <div class="informacion-cocteles">
          <h2 class="mb-4">¡Descubre nuestros deliciosos cócteles!</h2>
          <p class="lead mb-4">Explora nuestra selección de cócteles y elige tu favorito para disfrutar de una experiencia única.</p>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="caja mb-3 col-md-6">
        <router-link to="/solicitarCoctel" class="enlace text-decoration-none">
          <img src="solicitarCoctel.png" class="imagenes img-fluid mb-3">
          <h3 class="titulo mb-2">Solicitar Cóctel</h3>
          <p>¡Elige un cóctel de nuestra lista y te lo prepararemos con los mejores ingredientes!</p>
        </router-link>
      </div>
      <div class="caja mb-3 col-md-6">
        <router-link to="/personalizarCoctel" class="enlace text-decoration-none">
          <img src="personalizarCoctel.png" class="imagenes img-fluid mb-3">
          <h3 class="titulo mb-2">Personalizar Cóctel</h3>
          <p>¡Crea tu propio cóctel personalizado eligiendo los ingredientes que más te gusten!</p>
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
  background-color: #F0F0F0;
  padding-top: 80px; /* Añade espacio en la parte superior */
  padding-bottom: 50px; /* Añade espacio en la parte inferior */
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
  margin-bottom: 40px; /* Aumenta el espacio en la parte inferior */
}

.informacion-cocteles h2 {
  font-size: 2.5rem; /* Aumenta el tamaño del título */
  margin-bottom: 20px; /* Aumenta el espacio entre el título y el párrafo */
}

.informacion-cocteles p {
  font-size: 1.2rem; /* Aumenta el tamaño del párrafo */
}
</style>
