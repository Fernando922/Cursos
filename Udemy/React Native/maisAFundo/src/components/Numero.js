import React from 'react'
import { StyleSheet, TextInput } from 'react-native'

export default props => (
  <TextInput
    style={styles.numero}
    value={props.num}
    keyboardType={'numeric'}
    onChangeText={text => props.atualizaValor(props.nome, text)}
  />
)

const styles = StyleSheet.create({
  numero: {
    width: 140,
    height: 80,
    fontSize: 20,
    borderBottomWidth: 0.5,
    borderBottomColor: 'grey'
  }

})


