import React, { Component } from 'react'
import { View, StyleSheet, Image } from 'react-native'

const imagem = require('../img/jokenpo.png')

export default class Topo extends Component {
  render() {
    return (
      <View style={styles.topo}>
        <Image source={imagem}/>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  topo: {
    width: '100%',
    alignItems: 'center'
  },
})