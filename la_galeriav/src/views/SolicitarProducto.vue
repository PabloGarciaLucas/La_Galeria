<template>
    <div id="solicitarProducto">
        <div class="caja">
            <router-link to="/solicitarCoctel" class="enlace">
                <img src="solicitarCoctel.png"  class="imagenes">
                <span class="titulo">Solicitar Cóctel</span>
            </router-link>
        </div>
        <div class="caja">
            <router-link to="/personalizarCoctel" class="enlace">
                <img src="personalizarCoctel.png"  class="imagenes">
                <span class="titulo">Personalizar Cóctel</span>
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
