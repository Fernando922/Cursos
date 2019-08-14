import React, { Component } from 'react'
import { Image, View, StyleSheet } from 'react-native'

export default class Resultado extends Component {

  constructor(props) {
    super(props)
    this.state = {
      resultado: 0
    }
  }

  componentWillMount(){
    this.obterResultado()
  }

  obterResultado() {
    let random = Math.round(Math.random() * 1)
    this.setState({
      resultado: random
    })
  }

  render() {
    const cara = require('../imgs/moeda_cara.png')
    const coroa = require('../imgs/moeda_coroa.png')
    return (
      <View style={styles.container}>
        {
          this.state.resultado === 1 ?
            <Image source={cara} /> :
            <Image source={coroa} />
        }
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#61bd8c',
  }
})