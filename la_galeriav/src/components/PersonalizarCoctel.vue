<template>
  <div id="vasoContainer">
    <div class="container container-VasoA" @click="seleccionarVasoYGenerarFactura('Vaso con Ondas', 2.50)">
      <!-- La imagen del vaso se añadirá aquí -->
    </div>
    <span class="nombre">Vaso con Ondas</span>
    <div class="container container-VasoB" @click="seleccionarVasoYGenerarFactura('Vaso Mini', 3.50)">
      <!-- La imagen del vaso se añadirá aquí -->
    </div>
    <span class="nombre">Vaso Mini</span>
    <div class="container container-VasoC" @click="seleccionarVasoYGenerarFactura('Vaso Redondeado', 5.50)">
      <!-- La imagen del vaso se añadirá aquí -->
    </div>
    <span class="nombre">Vaso Redondeado</span>
    <!-- Asegúrate de que los contenedores para D, E y F existan -->
    <div class="container container-VasoD"></div>
    <div class="container container-VasoE"></div>
    <div class="container container-VasoF"></div>
  </div>

  <hr>

  <div id="coctelContainer">
    <div class="container container-A" @click="seleccionarCoctelYGenerarFactura('Jägermeister Mojito', 7.50)">
      <!-- La imagen del cóctel se añadirá aquí -->
    </div>
    <span class="nombre">Jägermeister Mojito</span>

    <div class="container container-B" @click="seleccionarCoctelYGenerarFactura('Sweet Star Martini', 8.00)">
      <!-- La imagen del cóctel se añadirá aquí -->
    </div>
    <span class="nombre">Sweet Star Martini</span>

    <div class="container container-C" @click="seleccionarCoctelYGenerarFactura('Cerveza Rubia Belga Fuerte', 6.00)">
      <!-- La imagen del cóctel se añadirá aquí -->
    </div>
    <span class="nombre">Cerveza Rubia Belga Fuerte</span>
  </div>
</template>

<style scoped>
#vasoContainer, #coctelContainer {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #F0F0F0;
}

.container {
  border: 1px solid #ccc;
  border-radius: 10px;
  padding: 20px;
  max-width: 400px;
  margin: 0 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  cursor: pointer;
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
      coctelSeleccionado: null,
      vasoSeleccionado: null
    }
  },
  methods: {
    async fetchCocteles() {
      const response = await fetch('http://localhost:8080/galeria/v1/productos');
      const data = await response.json();
      this.cocteles = data.drinks;
    },
    seleccionarCoctelYGenerarFactura(nombreCoctel, precio) {
      this.coctelSeleccionado = { nombre: nombreCoctel, precio: precio };
      this.generarFactura();
    },
    seleccionarVasoYGenerarFactura(nombreVaso, precio) {
      this.vasoSeleccionado = { nombre: nombreVaso, precio: precio };
      this.generarFactura();
    },
    generarFactura() {
      if (this.coctelSeleccionado && this.coctelSeleccionado.nombre && this.vasoSeleccionado && this.vasoSeleccionado.nombre) {
        const doc = new jsPDF();
        doc.text(`Cóctel Solicitado: ${this.coctelSeleccionado.nombre}`, 20, 20);
        doc.text(`Precio Cóctel: ${this.coctelSeleccionado.precio.toFixed(2)}€`, 20, 30);
        doc.text(`Vaso Seleccionado: ${this.vasoSeleccionado.nombre}`, 20, 40);
        doc.text(`Precio Vaso: ${this.vasoSeleccionado.precio.toFixed(2)}€`, 20, 50);
        doc.save('factura.pdf');
      } else {
        alert('Por favor, selecciona un cóctel y un vaso antes de generar la factura.');
      }
    },
    traerImagenA() {
      fetch("http://localhost:8080/galeria/v1/imagenes/4")
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'A'));
      
    },
    traerImagenB() {
      fetch("http://localhost:8080/galeria/v1/imagenes/5")
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'B'));
      
    },
    traerImagenC() {
      fetch("http://localhost:8080/galeria/v1/imagenes/6")
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'C'));
      
    },
    traerImagenD() {
      fetch("http://localhost:8080/galeria/v1/imagenes/7")
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'D'));
      
    },
    traerImagenE() {
      fetch("http://localhost:8080/galeria/v1/imagenes/8")
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'E'));
      
    },
    traerImagenF() {
      fetch("http://localhost:8080/galeria/v1/imagenes/9")
      .then(response => response.json()) 
      .then(data => this.anadeImg(data.imagen, 'F'));
      
    },
    anadeImg(base64, tipo) {
      var container = document.querySelector(`.container-${tipo}`);
      if (container) {
        var img = document.createElement('img');
        img.onload = function() {
          console.log('Imagen cargada con éxito');
        };
        img.onerror = function() {
          console.error('Error al cargar la imagen');
        };
        img.src = 'data:image/jpeg;base64,' + base64;
        img.classList.add('coctelImage');
        container.innerHTML = '';
        container.appendChild(img);
      } else {
        console.error(`El contenedor para el tipo ${tipo} no existe.`);
      }
    },
  },
  mounted() {
    this.traerImagenA();
    this.traerImagenB();
    this.traerImagenC();
    this.traerImagenD();
    this.traerImagenE();
    this.traerImagenF();
  }
}
</script>
