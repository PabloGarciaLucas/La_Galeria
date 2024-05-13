<template>
  <div id="coctelContainer">
    <div v-for="coctel in cocteles" :key="coctel.id" class="container"
      @click="seleccionarCoctelYGenerarFactura(coctel.nombre, coctel.precio)">
      <div :id="'container-' + coctel.id" class="container"></div>
      <span class="nombre">{{ coctel.nombre }}</span>
    </div>
  </div>
</template>

<script>
import { jsPDF } from 'jspdf';

export default {
  data() {
    return {
      cocteles: [],
      coctelSeleccionado: null
    }
  },
  methods: {
    async fetchCocteles() {
      try {
        const response = await fetch('http://localhost:8080/galeria/v1/productos');
        let data = await response.json();

        if (data.length > 3) {
          data = data.slice(0, 3);
        }
        this.cocteles = data;
        this.cocteles.forEach(coctel => {
          this.traerImagen(coctel.id);
        });
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
    async obtenerUltimoUsuario() {
      try {
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
      } catch (error) {
        console.error('Error al recuperar el último usuario:', error);
        return null;
      }
    },


    async insertarPedido(nombreCoctel, precioCoctel) {
      try {
        const usuario = await this.obtenerUltimoUsuario();
        if (!usuario) {
          throw new Error('No se pudo obtener el último usuario');
        }
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
    this.fetchCocteles();
  }
}
</script>

<style scoped>
#coctelContainer {
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