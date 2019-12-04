import {createAppContainer, createSwitchNavigator} from 'react-navigation'

import Login from './pages/Login'
import Main from './pages/Main'

export default createAppContainer(  //deve ficar por volta
  createSwitchNavigator({  //troca de tela sem animação, sem feedback e nao permite retorno
    Login,
    Main
  })
)