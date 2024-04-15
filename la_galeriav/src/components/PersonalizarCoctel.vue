<template>
    <div id="cristaleriaContainer">
        <div v-for="(cristaleria, index) in cristalerias" :key="index" class="caja">
            <img src="cristaleria.strDrinkThumb" alt="cristaleria.strDrink" class="cristaleriaImage">
        </div>
    </div>

    <hr>

    <div id="coctelContainer">
        <div v-for="(coctel, index) in cocteles" :key="index" class="caja">
            <img src="coctel.strDrinkThumb" alt="coctel.strDrink" class="coctelImage">
        </div>
        <button @click="generarFactura">Solicitar Pedido</button>
    </div>
</template>

<style scoped>
    #cristaleriaContainer {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #F0F0F0;
    }

    .caja {
        border: 1px solid #ccc;
        border-radius: 10px;
        padding: 20px;
        max-width: 400px;
        margin: 0 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .cristaleriaImage {
        max-width: 100px;
    }

    #coctelContainer {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #F0F0F0;
    }

    .caja {
        border: 1px solid #ccc;
        border-radius: 10px;
        padding: 20px;
        max-width: 400px;
        margin: 0 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .coctelImage {
        max-width: 100px;
    }
</style>

<script>
//import { jsPDF} from 'jspdf'

export default {
    data() {
        return {
            cocteles: []
        }
    },
    mounted() {
        this.fetchCocteles(); //Realizar peticion REST
    },
    methods: {
        async fetchCocteles() {
            try {
                //const respuesta = await fetch(http://localhost:8080/galeria/v1/productos);
                const data = await response.json();
                this.respuesta = data.drinks;
            } catch (error) {
                console.error("Se ha producido un error: " + error);
            }
        },
        async generarFactura() {
            const cristaleriaSeleccionada = this.cristalerias[0];
            const coctelSeleccionado = this.cocteles[0];

            const doc = new jsPDF();
            doc.text("Cristalería Solicitada: $(cristaleriaSeleccionada.strDrink)", 20, 20);
            doc.text("Cóctel Solicitado: $(coctelSeleccionado.strDrink)", 20, 20);

            doc.save(factura.pdf);
        }
    },
}
</script>