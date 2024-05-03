<template>
  <div id="cristaleriaContainer">
    <!-- Añadido v-for para iterar sobre la cristalería y @click para seleccionar un artículo -->
    <div v-for="(articulo, index) in cristalerias" :key="'cristaleria-' + index" @click="seleccionarCristaleria(articulo)" class="caja">
      <img :src="articulo.strDrinkThumb" class="cristaleriaImage" />
      <p>{{ articulo.strCategory }}</p>
    </div>
  </div>

  <hr>

  <div id="coctelContainer">
    <!-- Añadido v-for para iterar sobre los cócteles y @click para seleccionar un cóctel -->
    <div v-for="(coctel, index) in cocteles" :key="'coctel-' + index" @click="seleccionarCoctel(coctel)" class="caja">
      <img :src="coctel.strDrinkThumb" class="coctelImage" />
      <p>{{ coctel.strDrink }}</p>
    </div>
  </div>

  <button @click="generarFactura">Solicitar Pedido</button>
</template>

<style scoped>
/* Estilos actualizados para cristalería y cócteles */
#coctelContainer, #cristaleriaContainer {
  display: flex;
  justify-content: center;
  align-items: center;
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

.cristaleriaImage, .coctelImage {
  max-width: 100px;
}
</style>

<script>
import { jsPDF } from 'jspdf';

export default {
  data() {
    return {
      cristalerias: [], // Añadido para almacenar la cristalería
      cocteles: [],
      cristaleriaSeleccionada: null, // Añadido para almacenar la cristalería seleccionada
      coctelSeleccionado: null // Añadido para almacenar el cóctel seleccionado
    }
  },
  mounted() {
    this.fetchCristalerias(); // Añadido para obtener la cristalería
    this.fetchCocteles();
  },
  methods: {
    async fetchCristalerias() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/categorias');
        const data = await response.json();
        this.cristalerias = data.categories;
      } catch (error) {
        console.error("Se ha producido un error: " + error);
      }
    },
    async fetchCocteles() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/productos');
        const data = await response.json();
        this.cocteles = data.drinks;
      } catch (error) {
        console.error("Se ha producido un error: " + error);
      }
    },
    seleccionarCristaleria(articulo) {
      this.cristaleriaSeleccionada = articulo; // Almacena el artículo de cristalería seleccionado
    },
    seleccionarCoctel(coctel) {
      this.coctelSeleccionado = coctel; // Almacena el cóctel seleccionado
    },
    async generarFactura() {
      if (this.cristaleriaSeleccionada && this.coctelSeleccionado) {
        const doc = new jsPDF();
        doc.text(`Cristalería Solicitada: ${this.cristaleriaSeleccionada.strCategory}`, 20, 30);
        doc.text(`Cóctel Solicitado: ${this.coctelSeleccionado.strDrink}`, 20, 40);
        doc.save('factura.pdf');
      } else {
        alert('Por favor, selecciona un artículo de cristalería y un cóctel antes de generar la factura.');
      }
    }
  },
}
</script>
