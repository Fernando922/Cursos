import React, { Component } from 'react'
import { View, StatusBar, Image, StyleSheet, Text } from 'react-native'
import BarraNavegacao from './BarraNavegacao'

const detalheServicos = require('../assets/img/detalhe_servico.png')


export default class CenaServicos extends Component {
  render() {
    return (
      <View style={{flex: 1, backgroundColor: 'white'}}>
        <StatusBar
          hidden
          backgroundColor='#CCC'
        />

        <BarraNavegacao
          cor={'#19d1c8'}
          voltar
          navigator={this.props.navigator}
        />

        <View style={styles.containerTitulo}>
          <Image source={detalheServicos} />
          <Text style={styles.txtTitulo}>Nossos Serviços</Text>
        </View>

        <View style={styles.conteudo}>
          <Text style={styles.txtValores}>Consultoria</Text>
          <Text style={styles.txtValores}>Processos</Text>
          <Text style={styles.txtValores}>Acompanhamento de Projetos</Text>
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
    color: '#19d1c8',
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
