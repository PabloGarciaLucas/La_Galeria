<template>
    <div id="solicitarProducto">
        <div class="caja">
            <router-link to="/solicitarCoctel"><img src="solicitarCoctel.png" alt="Solicitar Cóctel" class="imagenes"></router-link> 
        </div>
        <div class="caja">
            <router-link to="/personalizarCoctel"><img src="personalizarCoctel.png" alt="Personalizar Cóctel"></router-link> 
        </div>
    </div>
</template>

<style>
    #solicitarProducto {
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

    .imagenes {
        align-self: flex-end;
        max-width: 50px;
    }
</style>