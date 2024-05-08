<template>
  <div class="container">
    <header class="text-center">
      <h1 class="mb-4 header-title">La Galería</h1> 
      <nav>
        <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
          <ol class="carousel-indicators">
            <li v-for="(imagen, index) in imagenes" :data-bs-target="'#carouselExample'" :data-bs-slide-to="index" :class="{ active: index === 0 }"></li>
          </ol>
          <div class="carousel-inner">
            <div v-for="(imagen, index) in imagenes" :class="{ 'carousel-item': true, active: index === 0 }">
              <img :src="imagen" class="d-block w-100" alt="Imagen de la galería">
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
        <div class="col-md-12">
          <p class="descripcion">La Galería es una aplicación web pensada para los jóvenes fiesteros fanáticos de la fiesta y sobretodo las previas.</p>
          <p class="descripcion">Nuestra aplicación está pensada para que los jóvenes puedan pedir sus cócteles favoritos y que estos puedan llegar a su propia casa frescos como si estuvieran recién hechos y, además, con la posibilidad de personalizar su propio vaso.</p>
          <p class="descripcion">En La Galería, la música y el buen ambiente son nuestra especialidad. Con nuestras jam sessions llenas de talento y pasión, cada visita es una experiencia única. Y ahora, con nuestro conveniente servicio de entrega de alcohol a domicilio, puedes recrear la atmósfera de La Galería en la intimidad de tu hogar. ¿Qué estás esperando? ¡Haz tu pedido y comienza la fiesta!</p>
          <div class="mapa">
            <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12049.919065005864!2d-5.6693859!3d40.9709742!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd3f2622d597a589%3A0xdbc39ae397cd5287!2sLa%20Galer%C3%ADa!5e0!3m2!1ses!2ses!4v1712484005499!5m2!1ses!2ses" width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
          </div>
        </div>
      </section>
    </main>
    <footer class="text-center mt-5">
      <div class="enlaces">
        <a href="#"><i class="fab fa-facebook"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
      </div>
    </footer>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css';
import { Carousel } from 'bootstrap';

export default {
  name: 'Inicio',
  data() {
    return {
      imagenes: []
    }
  },
  mounted() {
    this.traerImagenes();
  },
  methods: {
    traerImagenes() {
      fetch("http://localhost:8080/galeria/v1/imagenes", {})
        .then(response => response.json())
        .then(data => {
          this.imagenes = data.map(imagen => 'data:image/jpeg;base64,' + imagen.base64);
          this.$nextTick(() => {
            var myCarousel = document.querySelector('#carouselExample');
            var carousel = new Carousel(myCarousel, {
              interval: 2000, // Aquí ajustamos el intervalo a 2 segundos
              wrap: true
            });
          });
        })
        .catch(error => console.error('Error al traer imágenes:', error));
    }
  }
}
</script>

<style scoped>
  .container {
    padding: 20px;
    margin-top: 100px;
    font-family: Arial, sans-serif;
  }

  .header-title {
    font-size: 2.5rem;
    margin-bottom: 20px;
    color: #ffffff; /* Color del texto */
    background-image: url('https://www.shutterstock.com/image-photo/manila-philippines-april-2019-banner-260nw-2130733910.jpg'); 
    opacity: 0.8;
    width: 100%;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    background-size: cover;
    background-position: center;
    padding: 20px; /* Espaciado alrededor del texto */
    border-radius: 10px; /* Borde redondeado */
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Sombra */
  }

  .description{
    text-align: center;
  }
  .contenido {
    max-width: 800px;
    margin: 0 auto;
    text-align: center;
  }

  .mapa {
    margin-top: 10px;
  }

  iframe {
    width: 100%;
    height: 350px;
  }

  .iconos a {
    color: #c3c3c3;
  }

  .iconos a:hover {
    color: #6bc4fe;
  }

  .carousel-item img {
    width: 100%;
    height: auto;
  }
</style>
