<template>
    <div id="containerForo">
        <div class="caja">
            <h2 class="tituloPregunta">¿Cómo funciona nuestra aplicación?</h2>
            <p class="respuesta">El funcionamiento de nuestra aplicación es simple, el cliente cuenta con dos opciones: "Solicitar un cóctel" en la que el cliente solicita un cóctel 
            ya predefinido el cuál será enviado a su ubicación, y "Personalizar un Cóctel", en la que permitimos a nuestro cliente, además de escoger su cóctel, escoger la 
            cristalería que desea que tenga su vaso además de poder quedarsela para que pueda disfrutar de otros cócteles futuros</p>
            <img src="interrogacion.png" alt="¿Cómo funciona nuestra aplicación?" class="interrogacionImagen">
        </div>
        <div class="caja">
            <h2 class="tituloPregunta">¿Hasta dónde llegan nuestros servicios?</h2>
            <p class="respuesta">Nuestros servicios por ahora solo abarcan toda Salamanca, pero pretendemos extender este servicio a nivel nacional</p>
            <img src="interrogacion.png" alt="¿Hasta dónde llegan nuestros servicios?" class="interrogacionImagen">
        </div>
        <div class="caja">
            <h2 class="tituloPregunta">¿Hasta que horario esta abierta el envío de cócteles los fines de semana?</h2>
            <p class="respuesta">Al ser un servicio pensado para previas el horario de servicio es de 22:30 hasta las 4:30 de viernes hasta domingo</p>
            <img src="interrogacion.png" alt="¿Cómo funciona nuestra aplicación?" class="interrogacionImagen">
        </div>
    </div>
</template>

<style>
    #containerForo {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #F0F0F0
    }

    .caja {
        border: 3px solid lightgray;
        border-radius: 10px;
        padding: 20px;
        max-width: 500px;
        margin: 0 auto;
        display: flex;
        flex-direction: column;
    }

    .tituloPregunta {
        font-size: 1.5rem;
        margin-bottom: 20px;
    }

    .interrogacionImagen {
        align-self: flex-end;
        max-width: 50px;
    }
</style>