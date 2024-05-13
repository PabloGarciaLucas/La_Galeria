import { createRouter, createWebHashHistory } from 'vue-router'
import Inicio from '../views/Inicio.vue'
import LogIn from '../views/LogIn.vue'
import SignIn from '../views/SignIn.vue'
import Dudas from '../views/Dudas.vue'
import SolicitarProducto from '../views/SolicitarProducto.vue'
import PersonalizarCoctel from '../components/PersonalizarCoctel.vue'
import SolicitarCoctel from '../components/SolicitarCoctel.vue'

const routes = [
  {
    path: '/',
    name: 'inicio',
    component: Inicio
  },
  {
    path: '/solicitarProducto',
    name: 'solicitarProducto',
    component: SolicitarProducto
  },
  {
    path: '/dudas',
    name: 'dudas',
    component: Dudas
  },
  {
    path: '/login',
    name: 'login',
    component: LogIn
  },
  {
    path: '/signin',
    name: 'signin',
    component: SignIn
  },
  {
    path: '/solicitarCoctel',
    name: 'solicitarCoctel',
    component: SolicitarCoctel
  },
  {
    path: '/personalizarCoctel',
    name: 'personalizarCoctel',
    component: PersonalizarCoctel
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
