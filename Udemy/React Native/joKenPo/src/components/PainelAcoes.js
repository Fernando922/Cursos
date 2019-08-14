import React, { Component } from 'react'
import { View, StyleSheet, Button } from 'react-native'

export default class PainelAcoes extends Component {
  render() {
    return (
      <View style={styles.painelAcoes}>
        <View style={styles.btnEscolha}>
          <Button title='pedra' onPress={() => this.props.jokenpo('pedra')} />
        </View>
        <View style={styles.btnEscolha}>
          <Button title='papel' onPress={() => this.props.jokenpo('papel')} />
        </View>
        <View style={styles.btnEscolha}>
          <Button title='tesoura' onPress={() => this.props.jokenpo('tesoura')} />
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  btnEscolha: {
    width: 90
  },

  painelAcoes: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginTop: 10
  },
})

