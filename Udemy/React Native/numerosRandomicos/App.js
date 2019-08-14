import React, { Component } from 'react'
import { View, Text, Button } from 'react-native'


export default class App extends Component {

  geraNumeroAleatorio(){
    var numero_aleatorio = Math.random()
    numero_aleatorio = Math.floor(numero_aleatorio*60)
    alert(numero_aleatorio)
  }

  render() {
    return (
      <View>
        <Text>Gerador de número aleatório</Text>
        <Button
          title="Gerar um número randômico"
          onPress={() => this.geraNumeroAleatorio()}
        />
      </View>
    )
  }
}