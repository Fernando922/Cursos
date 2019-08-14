import React, { Component } from "react";
import { View, Text, StyleSheet } from 'react-native'
import Topo from './src/components/Topo'
import Icone from './src/components/Icone'
import PainelAcoes from './src/components/PainelAcoes'

export default class App extends Component {

  constructor(props) {
    super(props)
    this.state = {
      escolhaUsuario: '',
      escolhaComputador: '',
      resultado: ''
    }
  }

  jokenpo = (escolhaUsuario) => {
    let numAleatorio = Math.floor(Math.random() * 3)
    let escolhaComputador = ''

    switch (numAleatorio) {
    case 0: escolhaComputador = 'pedra'; break;
    case 1: escolhaComputador = 'papel'; break;
    case 2: escolhaComputador = 'tesoura'; break;
    }

    let resultado = ''

    if (escolhaComputador === 'pedra') {
      if (escolhaUsuario === 'pedra') {
        resultado = 'Empate'
      }
      if (escolhaUsuario === 'papel') {
        resultado = 'Você ganhou!'
      }
      if (escolhaUsuario === 'tesoura') {
        resultado = 'Você perdeu!'
      }
    }

    if (escolhaComputador === 'papel') {
      if (escolhaUsuario === 'papel') {
        resultado = 'Empate'
      }

      if (escolhaUsuario === 'tesoura') {
        resultado = 'Você ganhou!'
      }

      if (escolhaUsuario === 'pedra') {
        resultado = 'Você perdeu!'
      }
    }

    if (escolhaComputador === 'tesoura') {
      if (escolhaUsuario === 'tesoura') {
        resultado = 'Empate'
      }

      if (escolhaUsuario === 'pedra') {
        resultado = 'Você ganhou!'
      }

      if (escolhaUsuario === 'papel') {
        resultado = 'Você perdeu!'
      }
    }
    this.setState({ escolhaUsuario, escolhaComputador, resultado })
  }

  render() {
    return (
      <View style={styles.container}>
            <Topo />
               <PainelAcoes jokenpo={this.jokenpo} />
            <View style={styles.palco}>
              <Text style={styles.txtResultado}>{this.state.resultado}</Text>
              <Icone escolha={this.state.escolhaUsuario} jogador='Você' />
          <Icone escolha={this.state.escolhaComputador} jogador='Computador' />
              </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff'
  },

  palco: {
    alignItems: 'center',
    marginTop: 10
  },

  txtResultado: {
    fontSize: 25,
    height: 60,
    fontWeight: 'bold',
    color: 'red'
  },

})




