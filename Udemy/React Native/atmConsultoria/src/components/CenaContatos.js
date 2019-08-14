import React, { Component } from 'react'
import { View, StatusBar, Image, StyleSheet, Text } from 'react-native'
import BarraNavegacao from './BarraNavegacao'

const detalheContatos = require('../assets/img/detalhe_contato.png')


export default class CenaContatos extends Component {
  render() {
    return (
      <View style={{flex: 1, backgroundColor: 'white'}}>
        <StatusBar
          hidden
          backgroundColor='#CCC'
        />

        <BarraNavegacao
          cor={'#61bd8c'}
          voltar
          navigator={this.props.navigator}
        />

        <View style={styles.containerTitulo}>
          <Image source={detalheContatos} />
          <Text style={styles.txtTitulo}>Contatos</Text>
        </View>

        <View style={styles.conteudo}>
          <Text style={styles.txtValores}>Tel: (11) 1234-1234</Text>
          <Text style={styles.txtValores}>Cel: (11) 91234-1234</Text>
          <Text style={styles.txtValores}>E-mail: contato@atm.com.br</Text>
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
    color: '#61bd8c',
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
