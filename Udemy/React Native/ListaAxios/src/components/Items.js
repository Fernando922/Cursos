import React, { Component } from 'react'
import { Text, View, Image, StyleSheet } from 'react-native'

export default class Items extends Component {
  render() {
    return (
      <View style={styles.item}>
        <View style={styles.containerImagem}>
          <Image source={{ uri: this.props.item.foto }} style={styles.imagem} />
        </View>
        <View style={styles.detalheItems}>
          <Text style={styles.txtTitulo}>{this.props.item.titulo}</Text>
          <Text style={styles.txtValor}>R$ {this.props.item.valor}</Text>
          <Text style={styles.txtDetalhes}>Local: {this.props.item.local_anuncio}</Text>
          <Text style={styles.txtDetalhes}>Dt publicação: {this.props.item.data_publicacao}</Text>
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({

  item: {
    borderWidth: 0.5,
    borderColor: '#999',
    margin: 10,
    padding: 10,
    flexDirection: 'row',
    backgroundColor: '#FFF'
  },

  containerImagem: {
    width: 102,
    height: 102
  },

  imagem: {
    width: 100,
    height: 100
  },

  detalheItems: {
    marginLeft: 20,
    flex: 1
  },

  txtTitulo: {
    fontSize: 18,
    color: 'blue',
    marginBottom: 5
  },
  
  txtValor:{
    fontSize: 16,
    fontWeight: 'bold'
  },

  txtDetalhes:{
    fontSize: 16
  }
})