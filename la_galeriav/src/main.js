import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
//import { library } from '@fontawesome/fontawesome-svg-core'
//import { FontAwesomeIcon} from '@fontawesome/vue-fontawesome'
//import { faFacebook, faTwitter, faInstagram} from '@fontawesome/free-brands-svg-icons'

//library.add(faFacebook,faTwitter,faInstagram);

//createApp(App).use(router).component('font-awesome-icon',FontAwesomeIcon).mount('#app')
createApp(App).use(router).mount('#app')
