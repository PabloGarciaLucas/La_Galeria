<template>
  <div id="coctelContainer">
    <div v-for="coctel in cocteles" :key="coctel.id" class="container" @click="seleccionarCoctelYGenerarFactura(coctel.nombre, coctel.precio)">
      <!-- La imagen se añadirá aquí -->
      <span class="nombre">{{ coctel.nombre }}</span>
    </div>
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
  methods: {
    async fetchCocteles() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/productos');
        let data = await response.json();
        // Limita el número de cócteles a tres
        if (data.length > 3) {
          data = data.slice(0, 3);
        }
        this.cocteles = data; // Asegúrate de que esto coincida con la estructura de tu respuesta de la API
      } catch (error) {
        console.error("Se ha producido un error: " + error);
      }
    },
    async seleccionarCoctelYGenerarFactura(nombreCoctel, precioCoctel) {
      try {
        this.coctelSeleccionado = { nombre: nombreCoctel, precio: precioCoctel };
        await this.insertarPedido(nombreCoctel, precioCoctel);
        this.generarFactura();
      } catch (error) {
        console.error("Se ha producido un error al seleccionar el cóctel: " + error);
        alert('Error al seleccionar el cóctel.');
      }
    },
    async insertarPedido(nombreCoctel, precioCoctel) {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/pedidos', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            nombreCoctel,
            precioCoctel
          })
        });
        if (response.ok) {
          console.log('Pedido insertado correctamente.');
        } else {
          console.error('Error al insertar el pedido.');
        }
      } catch (error) {
        console.error("Se ha producido un error al insertar el pedido: " + error);
        throw error;
      }
    },
    async recuperarNombreYPrecioCoctelDesdeBD(idCoctel) {
      try {
        const response = await fetch(`http://localhost:8080/galeria/v1/productos/${idCoctel}`);
        const data = await response.json();
        const nombreCoctel = data.nombre;
        const precioCoctel = data.precio;
        return { nombreCoctel, precioCoctel };
      } catch (error) {
        console.error("Se ha producido un error al recuperar el nombre y el precio del cóctel: " + error);
        throw error;
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
  },
  mounted() {
    this.fetchCocteles();
  }
}
</script>
