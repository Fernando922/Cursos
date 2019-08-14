import React, { Component } from 'react'
import { View, StatusBar, Image, StyleSheet, Text } from 'react-native'
import BarraNavegacao from './BarraNavegacao'

const detalheClientes = require('../assets/img/detalhe_cliente.png')
const cliente1 = require('../assets/img/cliente1.png')
const cliente2 = require('../assets/img/cliente2.png')

export default class CenaClientes extends Component {
  render() {
    return (
      <View style={{flex: 1, backgroundColor: 'white'}}>
        <StatusBar
          hidden
          backgroundColor='#CCC'
        />

        <BarraNavegacao
          cor={'#b9c941'}
          voltar
          navigator={this.props.navigator}
        />
        <View style={styles.containerTitulo}>
          <Image source={detalheClientes} />
          <Text style={styles.titulo}>Nossos Clientes</Text>
        </View>

        <View style={styles.containerCliente}>
          <Image source={cliente1} />
          <Text style={styles.txtNomeEmpresa}>lorem ipsun dolores</Text>
        </View>
        <View style={styles.containerCliente}>
          <Image source={cliente2} />
          <Text style={styles.txtNomeEmpresa}>lorem ipsun dolores</Text>
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  containerTitulo: {
    flexDirection: 'row',
    alignItems: 'center',
    marginTop: 20
  },

  titulo: {
    fontSize: 25,
    color: '#b9c941',
    marginLeft: 20
  },

  containerCliente:{
    margin: 20
  },

  txtNomeEmpresa:{
    fontSize: 15,
    marginLeft: 20
  }




})
