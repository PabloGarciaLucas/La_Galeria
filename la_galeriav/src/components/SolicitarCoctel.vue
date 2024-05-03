<template>
  <div id="coctelContainer">
    <!-- Añadido v-for para iterar sobre los cócteles y @click para seleccionar un cóctel -->
    <div v-for="(coctel, index) in cocteles" :key="index" @click="seleccionarCoctel(coctel)" class="caja">
      <img :src="coctel.strDrinkThumb" class="coctelImage" />
      <p>{{ coctel.strDrink }}</p>
    </div>
  </div>

  <button @click="generarFactura">Solicitar Pedido</button>
</template>

<style scoped>
/* Estilos actualizados */
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
  cursor: pointer; /* Estilo para indicar que es seleccionable */
}

.coctelImage {
  max-width: 100px;
}
</style>

<script>
import { jsPDF } from 'jspdf';

export default {
  data() {
    return {
      cocteles: [],
      coctelSeleccionado: null // Añadido para almacenar el cóctel seleccionado
    }
  },
  mounted() {
    this.fetchCocteles();
  },
  methods: {
    async fetchCocteles() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/productos');
        const data = await response.json();
        this.cocteles = data.drinks;
      } catch (error) {
        console.error("Se ha producido un error: " + error);
      }
    },
    seleccionarCoctel(coctel) {
      this.coctelSeleccionado = coctel; // Almacena el cóctel seleccionado
    },
    async generarFactura() {
      if (this.coctelSeleccionado) {
        const doc = new jsPDF();
        doc.text(`Cóctel Solicitado: ${this.coctelSeleccionado.strDrink}`, 20, 20);
        doc.save('factura.pdf');
      } else {
        alert('Por favor, selecciona un cóctel antes de generar la factura.');
      }
    }
  },
}
</script>
