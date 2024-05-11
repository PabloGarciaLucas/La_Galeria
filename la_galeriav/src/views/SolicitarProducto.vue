<template>
  <div id="solicitarProducto" class="container">
    <div class="row">
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
          <h3 class="titulo mb-2">Solicitar Cóctel</h3>
          <p>¡Elige un cóctel de nuestra lista y te lo prepararemos con los mejores ingredientes!</p>
          <div id="imagenCoctelA"></div>
        </router-link>
      </div>
      <div class="caja mb-3 col-md-6">
        <router-link to="/personalizarCoctel" class="enlace text-decoration-none">
          <h3 class="titulo mb-2">Personalizar Cóctel</h3>
          <p>¡Crea tu propio cóctel personalizado eligiendo los ingredientes que más te gusten!</p>
          <div id="imagenCoctelB"></div>
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
        .then(data => this.anadeImg(data.imagen, 'imagenCoctelA'));
    },
    traerImagenB() {
      fetch("http://localhost:8080/galeria/v1/imagenes/3", {})
        .then(response => response.json())
        .then(data => this.anadeImg(data.imagen, 'imagenCoctelB'));
    },
    anadeImg(base64, id) {
      var img = document.createElement('img');
      img.src = 'data:image/jpeg;base64,' + base64;
      document.getElementById(id).appendChild(img);
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
  padding-top: 80px;
  padding-bottom: 50px;
}

.caja {
  border: 3px solid lightgray;
  border-radius: 10px;
  padding: 20px;
  text-align: center;
}

.titulo {
  font-size: 1.2rem;
}

.enlace:hover .titulo {
  color: blue;
}

.informacion-cocteles {
  text-align: center;
  margin-bottom: 40px;
}

.informacion-cocteles h2 {
  font-size: 2.5rem;
  margin-bottom: 20px;
}

.informacion-cocteles p {
  font-size: 1.2rem;
}
</style>
