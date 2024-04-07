<template>
    <div id="coctelContainer">
        <div v-for="(coctel, index) in cocteles" :key="index" class="caja">
            <img src="coctel.strDrinkThumb" alt:"coctel.strDrink" class="coctelImage">
        </div>
        <button @click="generarFactura">Solicitar Pedido</button>
    </div>
</template>

<style scoped>
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
import { jsPDF} from 'jspdf'

export default {
    data() {
        return {
            cocteles: [];
        }
    },
    mounted() {
        this.fetchCocteles(); //Realizar peticion REST
    },
    methods: {
        async fetchCocteles() {
            try {
                const respuesta = await fetch(http://localhost:8080/galeria/v1/productos);
                const data = await.response.json();
                this.respuesta = data.
            }
        },
        async generarFactura() {
            const coctelSeleccionado = this.cocteles[0];

            const doc = new jsPDF();
            doc.text("Cóctel Solicitado: $(coctelSeleccionado.strDrink)", 20, 20);

            doc.save(factura.pdf);
        }
    },
}
</script>