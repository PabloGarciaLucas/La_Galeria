import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

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
