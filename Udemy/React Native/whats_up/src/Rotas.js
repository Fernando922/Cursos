import React from 'react'
import { StyleSheet } from 'react-native'
import { Router, Scene } from 'react-native-router-flux'
import Colors from './Utils/Colors'
import FormLogin from './components/FormLogin'
import FormCadastro from './components/FormCadastro'
import BoasVindas from './components/BoasVindas'
import Principal from './components/Principal'
import AdicionarContato from './components/AdicionaContato'
import Conversa from './components/Conversa'

const Rotas = () => {
  return (
    <Router navigationBarStyle={{backgroundColor: '#115E54'}} titleStyle={{color: '#fff'}}>
      <Scene>
        <Scene
          key='Login'
          component={FormLogin}
          initial title='Login'
          hideNavBar={true}
        />
        <Scene
          key='Cadastro'
          component={FormCadastro}
          title='Cadastro'
          hideNavBar={false}
        />
        <Scene
          key='boasVindas'
          component={BoasVindas}
          title='Cadastro'
          hideNavBar={true}
        />
        <Scene
          key='principal'
          component={Principal}
          title='Cadastro'
          hideNavBar={true}
        />
        <Scene
          key='adicionarContato'
          component={AdicionarContato}
          title='Adicionar Contato'
          hideNavBar={false}
        />
        <Scene
          key='conversa'
          component={Conversa}
          title='Conversa'
          hideNavBar={false}
        />
      </Scene>
    </Router>
  )
}

const styles = StyleSheet.create({
  titulo:{
    color: Colors.primary,
  }
})

export default Rotas

