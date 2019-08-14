import React from 'react'
import { StyleSheet } from 'react-native'
import { Router, Scene } from 'react-native-router-flux'

import Principal from './components/Principal'
import SobreJogo from './components/SobreJogo'
import OutrosJogos from './components/OutrosJogos'
import Resultado from './components/Resultado'

const Rotas = () => {
  return (
    <Router>
      <Scene>
        <Scene
          key='Principal'
          component={Principal}
          initial title='Cara ou Coroa'
          titleStyle={styles.titulo}
        />
        <Scene
          key='SobreJogo'
          component={SobreJogo}
          title='Sobre o Jogo'
          titleStyle={styles.titulo}
          backButtonTextStyle={styles.titulo}
        />
        <Scene
          key='OutrosJogos'
          component={OutrosJogos}
          title='Outros Jogos'
          titleStyle={styles.titulo}
          backButtonTintColor={'#61bd8c'}
        />
        <Scene
          key='Resultado'
          component={Resultado}
          title='Resultado'
          titleStyle={styles.titulo}
          backButtonTintColor={'#61bd8c'}
        />
      </Scene>
    </Router>
  )
}

const styles = StyleSheet.create({
  titulo:{
    color: '#61bd8c',
  }
})

export default Rotas

