<template>
  <div class="container">
    <header class="text-center">
      <h1 class="mb-4 header-title">La Galería</h1>  
    </header>
    <main>
      <section class="contenido row align-items-stretch">
        <div class="col-md-12">
          <div class="row">
            <div class="col-md-6">
              <div class="descripcion-box">
                <p class="descripcion">La Galería es una aplicación web pensada para los jóvenes fiesteros fanáticos de la fiesta y sobretodo las previas.</p>
              </div>
            </div>
            <div class="col-md-6">
              <div class="descripcion-box">
                <p class="descripcion">Nuestra aplicación está pensada para que los jóvenes puedan pedir sus cócteles favoritos y que estos puedan llegar a su propia casa frescos como si estuvieran recién hechos y, además, con la posibilidad de personalizar su propio vaso.</p>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="descripcion-box" id="gale">
                <p class="descripcion">En La Galería, la música y el buen ambiente son nuestra especialidad. Con nuestras jam sessions llenas de talento y pasión, cada visita es una experiencia única. Y ahora, con nuestro conveniente servicio de entrega de alcohol a domicilio, puedes recrear la atmósfera de La Galería en la intimidad de tu hogar. ¿Qué estás esperando? ¡Haz tu pedido y comienza la fiesta!</p>
              </div>
            </div>
          </div>
          <div class="mapa">
            <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12049.919065005864!2d-5.6693859!3d40.9709742!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd3f2622d597a589%3A0xdbc39ae397cd5287!2sLa%20Galer%C3%ADa!5e0!3m2!1ses!2ses!4v1712484005499!5m2!1ses!2ses" width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.min.css';
export default {
  name: 'Inicio',
}
</script>

<style scoped>
  .container {
    padding: 20px;
    margin-top: 50px;
    width: 100%;
    height: 1100px;
    font-family: Arial, sans-serif;
  }

  .header-title {
    font-size: 2.5rem;
    margin-bottom: 20px;
    color: #ffffff; 
    font-weight: bold;
    background-image: url('https://www.shutterstock.com/image-photo/manila-philippines-april-2019-banner-260nw-2130733910.jpg'); 
    opacity: 0.8;
    width: 100%;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    background-size: cover;
    background-position: center;
    padding: 20px;
    border-radius: 10px; 
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  }

  .descripcion-box {
    background-color: #f2f2f2;
    border-radius: 10px;
    padding: 20px;
    margin-bottom: 20px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    height: 100%; 
  }

  #gale{
    margin-top: 20px;
  }

  .descripcion{
    text-align: center;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  }
  .contenido {
    max-width: 800px;
    margin: 0 auto;
    text-align: center;
  }

  .mapa {
    margin-top: 50px;
  }

  iframe {
    width: 100%;
    height: 280px;
  }

</style>
