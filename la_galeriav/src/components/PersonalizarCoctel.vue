<template>
  <div>
    <h3 id="titulo">¡Seleccione el cóctel que mas le guste!</h3>
    <div id="coctelContainer">
      <div v-for="coctel in cocteles" :key="coctel.id" class="container" @click="seleccionarCoctel(coctel.nombre, coctel.precio)">
        <div :id="'container-' + coctel.id" class="container"></div>
        <span class="nombre">{{ coctel.nombre }}</span>
      </div>
    </div>
    <hr>
    <h3>¡Eliga uno de nuestros vasos para su coctel!</h3>
    <div id="vasoContainer">
      <div v-for="vaso in vasos" :key="vaso.id" class="container" @click="seleccionarVaso(vaso.nombre, vaso.precio)">
        <div :id="'container-' + vaso.id" class="container"></div>
        <span class="nombre">{{ vaso.nombre }}</span>
      </div>
    </div>
  </div>
</template>

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
      
        const response = await fetch('http://localhost:8080/galeria/v1/productos');
        if (!response.ok) {
          throw new Error('Error al cargar los items');
        }
        const data = await response.json();
        this.cocteles = data.filter(item => item.id <= 3);
        this.vasos = data.filter(item => item.id > 3);
   
    },
    seleccionarCoctel(nombreCoctel, precio) {
      alert('Selecciona ahora un vaso para completar tu pedido.');
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
    async generarFactura() {
      const doc = new jsPDF();
      doc.text(`Cóctel Solicitado: ${this.coctelSeleccionado.nombre}`, 20, 20);
      doc.text(`Precio Cóctel: ${this.coctelSeleccionado.precio.toFixed(2)}€`, 20, 30);
      doc.text(`Vaso Seleccionado: ${this.vasoSeleccionado.nombre}`, 20, 40);
      doc.text(`Precio Vaso: ${this.vasoSeleccionado.precio.toFixed(2)}€`, 20, 50);
      const precioTotal = this.coctelSeleccionado.precio + this.vasoSeleccionado.precio;
      doc.text(`Precio Total: ${precioTotal.toFixed(2)}€`, 20, 60);
      doc.save('factura.pdf');
      
      await this.insertarPedido(this.coctelSeleccionado.nombre, this.coctelSeleccionado.precio);
    },
    async obtenerUltimoUsuario() {
        const response = await fetch('http://localhost:8080/galeria/v1/usuarios');
        if (response.ok) {
          const usuarios = await response.json();
          if (usuarios.length > 0) {
            usuarios.sort((a, b) => b.userID - a.userID);
            const ultimoUsuario = usuarios[0];
            return ultimoUsuario;
          } else {
            console.warn('No se encontraron usuarios en la base de datos.');
            return null;
          }
        } else {
          console.error('Error al obtener la lista de usuarios:', response.statusText);
          return null;
        }
    },
    async insertarPedido(nombreCoctel, precioCoctel) {
        const usuario = await this.obtenerUltimoUsuario();
        const fecha = new Date();
        const fechaPedido = `${fecha.getFullYear()}-${(fecha.getMonth() + 1).toString().padStart(2, '0')}-${fecha.getDate().toString().padStart(2, '0')} ${fecha.getHours().toString().padStart(2, '0')}:${fecha.getMinutes().toString().padStart(2, '0')}:${fecha.getSeconds().toString().padStart(2, '0')}`;
        const response = await fetch('http://localhost:8080/galeria/v1/pedidos', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            usuario: usuario,
            fechaPedido: fechaPedido,
            nombreCoctel: nombreCoctel,
            precioCoctel: precioCoctel
          })
        });
        if (response.ok) {
          console.log('Pedido insertado correctamente.');
        } else {
          console.error('Error al insertar el pedido.');
       } 
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
        const img = new Image();
        img.onload = () => console.log('Imagen cargada con éxito');
        img.onerror = () => console.error('Error al cargar la imagen');
        img.src = `data:image/jpeg;base64,${base64}`;
        img.classList.add('coctelImage');
        container.innerHTML = '';
        container.appendChild(img);
    },
  },
  async mounted() {
    await this.fetchItems(); 
    const promises = []; 
    for (let i = 1; i <= 6; i++) {
      promises.push(this.traerImagen(i));
    }
    await Promise.all(promises);
}
}
</script>

<style scoped>

#titulo{
  margin-top: 150px;
}
h3, #titulo{
  text-align: center;
}
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
