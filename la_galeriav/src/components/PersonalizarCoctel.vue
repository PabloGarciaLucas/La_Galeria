<template>
  <div id="coctelContainer">
    <div class="container container-VasoD" @click="seleccionarCoctelYGenerarFactura('Jägermeister Mojito', 7.50)"></div>
    <span class="nombre">Jägermeister Mojito</span>

    <div class="container container-VasoE" @click="seleccionarCoctelYGenerarFactura('Sweet Star Martini', 8.00)"></div>
    <span class="nombre">Sweet Star Martini</span>

    <div class="container container-VasoF" @click="seleccionarCoctelYGenerarFactura('Cerveza Rubia Belga Fuerte', 6.00)"></div>
    <span class="nombre">Cerveza Rubia Belga Fuerte</span>
  </div>

  <hr>

  <div id="vasoContainer">
    <div class="container container-VasoA" @click="seleccionarVasoYGenerarFactura('Vaso con Ondas', 2.50)"></div>
    <span class="nombre">Vaso con Ondas</span>

    <div class="container container-VasoB" @click="seleccionarVasoYGenerarFactura('Vaso Mini', 3.50)"></div>
    <span class="nombre">Vaso Mini</span>

    <div class="container container-VasoC" @click="seleccionarVasoYGenerarFactura('Vaso Redondeado', 5.50)"></div>
    <span class="nombre">Vaso Redondeado</span>
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
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/productos');
        if (!response.ok) {
          throw new Error('Error al cargar los cócteles');
        }
        const data = await response.json();
        this.cocteles = data.drinks;
      } catch (error) {
        console.error(error);
      }
    },
    seleccionarCoctelYGenerarFactura(nombreCoctel, precio) {
      this.coctelSeleccionado = { nombre: nombreCoctel, precio: precio };
      this.verificarSeleccionYGenerarFactura();
    },
    seleccionarVasoYGenerarFactura(nombreVaso, precio) {
      this.vasoSeleccionado = { nombre: nombreVaso, precio: precio };
      this.verificarSeleccionYGenerarFactura();
    },
    verificarSeleccionYGenerarFactura() {
      if (this.coctelSeleccionado && this.vasoSeleccionado) {
        this.generarFactura();
      } else {
        alert('Por favor, selecciona un cóctel y un vaso antes de generar la factura.');
      }
    },
    generarFactura() {
      const doc = new jsPDF();
      doc.text(`Cóctel Solicitado: ${this.coctelSeleccionado.nombre}`, 20, 20);
      doc.text(`Precio Cóctel: ${this.coctelSeleccionado.precio.toFixed(2)}€`, 20, 30);
      doc.text(`Vaso Seleccionado: ${this.vasoSeleccionado.nombre}`, 20, 40);
      doc.text(`Precio Vaso: ${this.vasoSeleccionado.precio.toFixed(2)}€`, 20, 50);
      doc.save('factura.pdf');
    },
    traerImagen(id) {
      fetch(`http://localhost:8080/galeria/v1/imagenes/${id}`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Error al cargar la imagen');
        }
        return response.json();
      })
      .then(data => this.anadeImg(data.imagen, id))
      .catch(error => console.error(error));
    },
    anadeImg(base64, id) {
      const tipo = String.fromCharCode(64 + parseInt(id)); // Convierte el id numérico a letra
      const container = document.querySelector(`.container-Vaso${tipo}`);
      if (container) {
        const img = new Image();
        img.onload = () => console.log('Imagen cargada con éxito');
        img.onerror = () => console.error('Error al cargar la imagen');
        img.src = `data:image/jpeg;base64,${base64}`;
        img.classList.add('coctelImage');
        container.innerHTML = '';
        container.appendChild(img);
      } else {
        console.error(`El contenedor para el tipo Vaso${tipo} no existe.`);
      }
    },
  },
  mounted() {
    this.fetchCocteles();
    for (let i = 1; i <= 6; i++) {
      this.traerImagen(i);
    }
  }
}
</script>