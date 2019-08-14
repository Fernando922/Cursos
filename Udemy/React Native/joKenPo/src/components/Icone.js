import React, { Component } from 'react'
import { View, Text, StyleSheet, Image } from 'react-native'

const imgPedra = require('../img/pedra.png')
const imgPapel = require('../img/papel.png')
const imgTesoura = require('../img/tesoura.png')

export default class Icone extends Component {
  render() {
    if (this.props.escolha === 'pedra') {
      return (
        <View style={styles.icone}>
          <Text style={styles.txtJogador}>{this.props.jogador}</Text>
          <Image source={imgPedra} />
        </View>
      )
    } else if (this.props.escolha === 'papel') {
      return (
        <View style={styles.icone}>
          <Text style={styles.txtJogador}>{this.props.jogador}</Text>
          <Image source={imgPapel} />
        </View>
      )
    } else if (this.props.escolha === 'tesoura') {
      return (
        <View style={styles.icone}>
          <Text style={styles.txtJogador}>{this.props.jogador}</Text>
          <Image source={imgTesoura} />
        </View>
      )
    }
    return false
  }
}

const styles = StyleSheet.create({
  icone: {
    alignItems: 'center',
    marginBottom: 20
  },

  txtJogador: {
    fontSize: 18
  }
})