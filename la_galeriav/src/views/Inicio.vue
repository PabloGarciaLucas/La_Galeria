<template>
    <div id="container">
        <header>
            <h1>La Galería</h1>
            <nav>
                <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-bs-target="#carouselExample" data-bs-slide-to="0" class="active"></li>
                        <li data-bs-target="#carouselExample" data-bs-slide-to="1"></li>
                        <li data-bs-target="#carouselExample" data-bs-slide-to="2"></li>
                    </ol>

                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://vie.placeholder.com/800x400?text=Imagen+1" class="d-block w-100">
                        </div>
                        <div class="carousel-item">
                            <img src="https://vie.placeholder.com/800x400?text=Imagen+2" class="d-block w-100">
                        </div>
                        <div class="carousel-item">
                            <img src="https://vie.placeholder.com/800x400?text=Imagen+3" class="d-block w-100">
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
            <section>
                <p class="descripcion">La Galería es una aplicación web pensada para los jóvenes fiesteros fanáticos de la fiesta y sobretodo las previas</p>
                <p class="descripcion">Nuestra aplicación esta pensada para que los jóvenes puedan pedir sus cócteles favoritos y que estos puedan llegar a su 
                propia casa fresco como si estuvieran recién hechos y, además, con la posibilidad de personalizar su propio vaso</p>
                <p class="descripcion">Nos encontramos en Calle Dr. Jaime Vera, 19, 15, 37007 Salamanca</p>
                <p class="descripcion"><iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12049.919065005864!2d-5.6693859!3d40.9709742!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd3f2622d597a589%3A0xdbc39ae397cd5287!2sLa%20Galer%C3%ADa!5e0!3m2!1ses!2ses!4v1712484005499!5m2!1ses!2ses" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe></p>
            </section>
        </main>
        
        <footer>
            <div class="iconos">
                <a href="#"><i class="fab fa-facebook"></i></a>
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
            </div>
        </footer>
    </div>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</template>

<style scoped>
  #container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    padding: 20px;
    font-family: Arial, sans-serif; 
  }

  .center-content {
    text-align: center;
  }

  p {
    font-size: 1.2rem; 
    margin-bottom: 20px;
  }

  .descripcion {
    max-width: 600px; 
    text-align: justify; 
  }

  .descripcion:nth-child(even) {
    text-align: justify; 
  }
</style>


<script>
export default {
    name: 'Inicio',
}
</script>