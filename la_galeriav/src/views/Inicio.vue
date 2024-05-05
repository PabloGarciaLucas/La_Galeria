<template>
  <div class="container">
    <header class="text-center">
      <h1 class="mb-4">La Galería</h1>
      <nav>
        <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
          <ol class="carousel-indicators">
            <li v-for="(imagen, index) in imagenes" :data-bs-target="'#carouselExample'" :data-bs-slide-to="index" :class="{ active: index === 0 }"></li>
          </ol>
          <div class="carousel-inner">
            <div v-for="(imagen, index) in imagenes" :class="{ 'carousel-item': true, active: index === 0 }">
              <img :src="imagen" class="d-block w-100">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExample" role="button" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Anterior</span>
          </a>
          <a class="carousel-control-next" href="#carouselExample" role="button" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Siguiente</span>
          </a>
        </div>
      </nav>
    </header>
    <main>
      <section class="contenido row">
        <div class="col-md-6">
          <p class="descripcion">La Galería es una aplicación web pensada para los jóvenes fiesteros fanáticos de la fiesta y sobretodo las previas.</p>
          <p class="descripcion">Nuestra aplicación está pensada para que los jóvenes puedan pedir sus cócteles favoritos y que estos puedan llegar a su propia casa frescos como si estuvieran recién hechos y, además, con la posibilidad de personalizar su propio vaso.</p>
        </div>
        <div class="col-md-6">
          <p class="descripcion">Nos encontramos en Calle Dr. Jaime Vera, 19, 15, 37007 Salamanca.</p>
          <div class="mapa">
            <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12049.919065005864!2d-5.6693859!3d40.9709742!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd3f2622d597a589%3A0xdbc39ae397cd5287!2sLa%20Galer%C3%ADa!5e0!3m2!1ses!2ses!4v1712484005499!5m2!1ses!2ses" width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
          </div>
        </div>
      </section>
    </main>
    <footer class="text-center mt-5">
      <div class="iconos">
        <a href="#"><i class="fab fa-facebook"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
      </div>
    </footer>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';

export default {
  name: 'Inicio',
  data() {
    return {
      imagenes: []
    }
  },
  methods: {
    traerImagenes() {
      fetch("http://localhost:8080/galeria/v1/imagenes", {})
        .then(response => response.json()) 
        .then(data => {
          this.imagenes = data.map(imagen => 'data:image/jpeg;base64,' + imagen.base64);
          this.$nextTick(() => {
            var myCarousel = document.querySelector('#carouselExample');
            var carousel = new bootstrap.Carousel(myCarousel, {
              interval: 2000,
              wrap: true
            });
          });
        })
        .catch(error => console.error('Error al traer imágenes:', error));
    }
  },
  mounted() {
    this.traerImagenes();
  }
}
</script>

<style scoped>
  .container {
    padding: 20px;
    font-family: Arial, sans-serif;
  }

  h1 {
    font-size: 2.5rem;
    margin-bottom: 20px;
  }

  .contenido {
    max-width: 800px;
    margin: 0 auto;
    text-align: center;
  }

  .descripcion {
    font-size: 1.2rem;
    margin-bottom: 20px;
    line-height: 1.5;
  }

  .mapa {
    margin-top: 20px;
  }

  iframe {
    width: 100%;
    height: 450px;
  }

  .iconos {
    display: flex;
    gap: 10px;
    justify-content: center;
  }

  .iconos a {
    color: #333;
  }

  .iconos a:hover {
    color: #555;
  }
</style>

