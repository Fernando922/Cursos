import React, { Component } from 'react'
import { View, StyleSheet, Image, TouchableOpacity } from 'react-native'
import { Actions } from 'react-native-router-flux'

export default class Principal extends Component {
  render() {
    const logo = require('../imgs/logo.png')
    const jogar = require('../imgs/botao_jogar.png')
    const sobre = require('../imgs/sobre_jogo.png')
    const outrosJogos = require('../imgs/outros_jogos.png')

    return (
      <View style={styles.container}>
        <View style={styles.principal}>
          <Image source={logo} />
          <TouchableOpacity
            onPress={() => Actions.push('Resultado')}
          >
            <Image source={jogar} />
          </TouchableOpacity>
        </View>
        <View style={styles.containerBotoes}>
          <TouchableOpacity
            onPress={() => Actions.push('SobreJogo')}
          >
            <Image source={sobre} />
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() => Actions.push('OutrosJogos')}
          >
            <Image source={outrosJogos} />
          </TouchableOpacity>
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#61bd8c',
  },

  principal: {
    flex: 10,
    alignItems: 'center',
    justifyContent: 'center'
  },

  containerBotoes: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'space-between'
  }
})
