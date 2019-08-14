import React, { Component } from 'react'
import { View, StyleSheet } from 'react-native'
import { Topo as Titulo, Resultado, Painel } from './components/'

export default class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      num1: '',
      num2: '',
      operacao: 'soma',
      resultado: 'Resultado'
    }
    this.calcular = this.calcular.bind(this)
    this.atualizaValor = this.atualizaValor.bind(this)
    this.atualizaOperacao = this.atualizaOperacao.bind(this)
  }

  calcular() {
    let resultado = 0
    switch (this.state.operacao) {
      case 'soma':
        resultado = parseFloat(this.state.num1) + parseFloat(this.state.num2)
        break
      case 'subtracao':
        resultado = parseFloat(this.state.num1) - parseFloat(this.state.num2)
        break
      default:
        resultado = 0
    }
    this.setState({
      resultado: resultado.toString()
    })
  }

  atualizaValor(nomeCampo, valor) {
    const obj = {}
    obj[nomeCampo] = valor
    this.setState(obj)
  }

  atualizaOperacao(operacao) {
    this.setState({ operacao })
  }

  render() {
    return (
      <View style={styles.container}>
        <Titulo />
        <Resultado 
          resultado={this.state.resultado}
        />
        <Painel 
          calcular={this.calcular}
          atualizaValor={this.atualizaValor}
          atualizaOperacao={this.atualizaOperacao}
          state={this.state}
        />
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
  }
})