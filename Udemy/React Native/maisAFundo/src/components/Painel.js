import React, { Component } from 'react'
import { View } from 'react-native'
import Entrada from './Entrada'
import Operacao from './Operacao'
import Comando from './Comando'

class Painel extends Component {
  

  render() {
    const { state } = this.props
    return (
      <View>
        <Entrada num1={state.num1} num2={state.num2} atualizaValor={this.props.atualizaValor} />
        <Operacao operacao={state.operacao} atualizaOperacao={this.props.atualizaOperacao} />
        <Comando acao={this.props.calcular} />
      </View>
    )
  }
}

export { Painel }

