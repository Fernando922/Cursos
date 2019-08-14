import React, { Component } from 'react'
import { View, Text, StyleSheet, TouchableHighlight, Image } from 'react-native'

const iconeVoltar = require('../assets/img/btn_voltar.png')

export default class BarraNavegacao extends Component {
  render() {
    return (
      <View style={[styles.barraTitulo, { backgroundColor: this.props.cor }]}>
        {
          this.props.voltar ?
            <TouchableHighlight
              underlayColor={this.props.cor}
              activeOpacity={0.3}
              onPress={() => this.props.navigator.pop()}
              style={styles.icone}
            >
              <Image source={iconeVoltar} />
            </TouchableHighlight> : null
        }
        <Text style={styles.titulo}>ATM Consultoria</Text>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  barraTitulo: {
    padding: 10,
    height: 60,
    alignItems: 'center',
    justifyContent: 'center'
  },

  icone: {
    position: 'absolute',
    left: 10
  },

  titulo: {
    fontSize: 18,
    color: '#000',
    textAlign: 'center'
  }
})
