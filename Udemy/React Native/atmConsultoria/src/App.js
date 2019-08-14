import React, { Component } from 'react'
import CenaClientes from './components/CenaClientes'
import CenaPrincipal from './components/CenaPrincipal'
import { Navigator } from 'react-native-deprecated-custom-components'
import CenaContatos from './components/CenaContatos'
import CenaEmpresa from './components/CenaEmpresa'
import CenaServicos from './components/CenasServicos'

export default class App extends Component {
  render() {
    return (
      <Navigator
        initialRoute={{ id: 'Home' }}
        renderScene={(route, navigator) => {
          switch (route.id) {
          case 'Home':
            return (<CenaPrincipal navigator={navigator} />)
          case 'Clientes':
            return (<CenaClientes navigator={navigator} />)
          case 'Contatos':
            return (<CenaContatos navigator={navigator} />)
          case 'Empresa':
            return (<CenaEmpresa navigator={navigator} />)
          case 'Servicos':
            return (<CenaServicos navigator={navigator} />)
          default: 
            return false
          }
        }}
      />
    )
  }
}
