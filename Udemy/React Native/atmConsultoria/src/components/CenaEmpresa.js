import React, { Component } from 'react'
import { View, StatusBar, Image, StyleSheet, Text } from 'react-native'
import BarraNavegacao from './BarraNavegacao'

const detalheEmpresa = require('../assets/img/detalhe_empresa.png')


export default class CenaEmpresa extends Component {
  render() {
    return (
      <View style={{flex: 1, backgroundColor: 'white'}}>
        <StatusBar
          hidden
          backgroundColor='#CCC'
        />

        <BarraNavegacao
          cor={'#ec7148'}
          voltar
          navigator={this.props.navigator}
        />

        <View style={styles.containerTitulo}>
          <Image source={detalheEmpresa} />
          <Text style={styles.txtTitulo}>A Empresa</Text>
        </View>

        <View style={styles.conteudo}>
          <Text style={styles.txtValores}>A empresa tem mais de 5000 anos de experiência no mercado e está perfeitamente em perfeito estado.</Text>
        </View>

      </View>
    )
  }
}

const styles = StyleSheet.create({
  containerTitulo: {
    flexDirection: 'row',
    alignItems: 'center'
  },

  txtTitulo:{
    fontSize: 25,
    color: '#ec7148',
    marginLeft: 20
  },

  conteudo:{
    paddingLeft: 20,
    marginTop: 20
  },

  txtValores:{
    fontSize: 15
  }

})
