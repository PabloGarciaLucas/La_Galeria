<template>
  <div>
    <div id="coctelContainer">
      <div v-for="coctel in cocteles" :key="coctel.id" class="container" @click="seleccionarCoctel(coctel.nombre, coctel.precio)">
        <div :id="'container-' + coctel.id" class="container"></div>
        <span class="nombre">{{ coctel.nombre }}</span>
      </div>
    </div>
    <hr>
    <div id="vasoContainer">
      <div v-for="vaso in vasos" :key="vaso.id" class="container" @click="seleccionarVaso(vaso.nombre, vaso.precio)">
        <div :id="'container-' + vaso.id" class="container"></div>
        <span class="nombre">{{ vaso.nombre }}</span>
      </div>
    </div>
  </div>
</template>

<style scoped>
#coctelContainer, #vasoContainer {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #F0F0F0;
  flex-wrap: wrap;
  margin: 100px 0 0 0;
}

#vasoContainer {
  padding: 0 0 200px 0;
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
      vasos: [],
      coctelSeleccionado: null,
      vasoSeleccionado: null
    }
  },
  methods: {
    async fetchItems() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/productos');
        if (!response.ok) {
          throw new Error('Error al cargar los items');
        }
        const data = await response.json();
        this.cocteles = data.filter(item => item.id <= 3);
        this.vasos = data.filter(item => item.id > 3);
      } catch (error) {
        console.error(error);
      }
    },
    seleccionarCoctel(nombreCoctel, precio) {
      this.coctelSeleccionado = { nombre: nombreCoctel, precio: precio };
    },
    seleccionarVaso(nombreVaso, precio) {
      if (!this.coctelSeleccionado) {
        alert('Por favor, selecciona un cóctel antes de seleccionar un vaso.');
        return;
      }
      this.vasoSeleccionado = { nombre: nombreVaso, precio: precio };
      this.verificarSeleccionYGenerarFactura();
    },
    verificarSeleccionYGenerarFactura() {
      if (this.coctelSeleccionado && this.vasoSeleccionado) {
        this.generarFactura();
      }
    },
    generarFactura() {
      const doc = new jsPDF();
      doc.text(`Cóctel Solicitado: ${this.coctelSeleccionado.nombre}`, 20, 20);
      doc.text(`Precio Cóctel: ${this.coctelSeleccionado.precio.toFixed(2)}€`, 20, 30);
      doc.text(`Vaso Seleccionado: ${this.vasoSeleccionado.nombre}`, 20, 40);
      doc.text(`Precio Vaso: ${this.vasoSeleccionado.precio.toFixed(2)}€`, 20, 50);
      const precioTotal = this.coctelSeleccionado.precio + this.vasoSeleccionado.precio;
      doc.text(`Precio Total: ${precioTotal.toFixed(2)}€`, 20, 60);
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
      const container = document.querySelector(`#container-${id}`);
      if (container) {
        const img = new Image();
        img.onload = () => console.log('Imagen cargada con éxito');
        img.onerror = () => console.error('Error al cargar la imagen');
        img.src = `data:image/jpeg;base64,${base64}`;
        img.classList.add('coctelImage');
        container.innerHTML = '';
        container.appendChild(img);
      } else {
        console.error(`El contenedor para el id ${id} no existe.`);
      }
    },
  },
  mounted() {
    this.fetchItems();
    for (let i = 1; i <= 6; i++) {
      this.traerImagen(i);
    }
  }
}
</script>
