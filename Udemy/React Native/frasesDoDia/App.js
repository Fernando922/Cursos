import React from 'react'
import { View, Text, StyleSheet, TouchableOpacity, Image, Alert } from 'react-native'

const botaoPressionado = () => {
  let numero = Math.floor(Math.random()*10);

  let frases = [
    'Não procure ser o melhor, mas sim o mais simples. Porque até a maior árvore da floresta começa do chão.',
    'Se você cansar, aprenda a descansar e não a desistir.',
    'Toda mente é um cofre. Não existem mentes impenetráveis, apenas chaves erradas',
    'Não adianta encher de perfume se o que falta é a essência.',
    'Troque suas folhas, mas não perca suas raízes. Mude suas opiniões, mas não perca seus princípios.e',
    'Ignorar é a forma mais elegante de se defender da maldade.',
    'Não faça da sua vida um rascunho, poderá não ter tempo de passá-la a limpo.',
    'A paciência é a chave para todos os problemas que não dependem de você.',
    'Não haverá borboletas se a vida não passar por longas e silenciosas metamorfoses.',
    'Reaja com inteligência mesmo quando for tratado com ignorância.',
  ]

  var fraseEscolhida = frases[numero]
  Alert.alert('',fraseEscolhida)
}

const App = () => {
  return (
    <View style={styles.principal}>
      <Image source={require('./src/logo.png')} />
      <TouchableOpacity
        onPress={botaoPressionado}
        style={styles.botao}>
        <Text style={styles.textoBotao}>Nova Frase</Text>
      </TouchableOpacity>
    </View>
  )
}

const styles = StyleSheet.create({
  principal: {
    flex: 1,
    backgroundColor: '#fff',
    justifyContent: 'center',
    alignItems: 'center'
  },

  botao: {
    backgroundColor: '#538530',
    paddingVertical: 10,
    paddingHorizontal: 40,
    marginTop: 20
  },

  textoBotao: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold'
  }

})

export default App