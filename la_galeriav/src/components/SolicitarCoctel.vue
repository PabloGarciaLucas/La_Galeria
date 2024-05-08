<template>
  <div id="coctelContainer">
    <div class="container container-A" @click="seleccionarCoctelYGenerarFactura('Jägermeister Mojito', 7.50)">
      <!-- La imagen se añadirá aquí -->
    </div>
    <span class="nombre">Jägermeister Mojito</span>

    <div class="container container-B" @click="seleccionarCoctelYGenerarFactura('Sweet Star Martini', 8.00)">
      <!-- La imagen se añadirá aquí -->
    </div>
    <span class="nombre">Sweet Star Martini</span>

    <div class="container container-C" @click="seleccionarCoctelYGenerarFactura('Cerveza Rubia Belga Fuerte', 6.00)">
      <!-- La imagen se añadirá aquí -->
    </div>
    <span class="nombre">Cerveza Rubia Belga Fuerte</span>
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
  methods: {
    async fetchCocteles() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/productos');
        const data = await response.json();
        this.cocteles = data; // Asegúrate de que esto coincida con la estructura de tu respuesta de la API
      } catch (error) {
        console.error("Se ha producido un error: " + error);
      }
    },
    async seleccionarCoctelYGenerarFactura(nombreCoctel, precioCoctel) {
      try {
        this.coctelSeleccionado = { nombre: nombreCoctel, precio: precioCoctel };
        this.generarFactura();
      } catch (error) {
        console.error("Se ha producido un error al seleccionar el cóctel: " + error);
        alert('Error al seleccionar el cóctel.');
      }
    },
    generarFactura() {
      if (this.coctelSeleccionado && this.coctelSeleccionado.nombre) {
        const doc = new jsPDF();
        doc.text(`Cóctel Solicitado: ${this.coctelSeleccionado.nombre}`, 20, 20);
        doc.text(`Precio: ${this.coctelSeleccionado.precio.toFixed(2)}€`, 20, 30);
        doc.save('factura.pdf');
      } else {
        alert('Por favor, selecciona un cóctel antes de generar la factura.');
      }
    },
    anadeImg(base64, tipo) {
      var img = document.createElement('img');
      img.src = 'data:image/jpeg;base64,' + base64;
      img.classList.add('coctelImage');
      var container = document.querySelector(`.container-${tipo}`);
      container.innerHTML = ''; // Limpia el contenedor antes de añadir la nueva imagen
      container.appendChild(img);
    },
    traerImagenA() {
      fetch("http://localhost:8080/galeria/v1/imagenes/4", {
      })
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'A')); // Se ha añadido un segundo parámetro para diferenciar las imágenes
      
    },
    traerImagenB() {
      fetch("http://localhost:8080/galeria/v1/imagenes/5", {
      })
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'B')); // Se ha añadido un segundo parámetro para diferenciar las imágenes
      
    },
    traerImagenC() {
      fetch("http://localhost:8080/galeria/v1/imagenes/6", {
      })
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'C')); // Se ha añadido un segundo parámetro para diferenciar las imágenes
      
    },
  },
  mounted() {
    this.traerImagenA();
    this.traerImagenB();
    this.traerImagenC();
  }
}
</script>

