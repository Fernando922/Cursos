import React from 'react'
import { View, Text, Button, Image, StyleSheet, ImageBackground } from 'react-native'
import { Actions } from 'react-native-router-flux'

export default props => (
  <ImageBackground style={{ flex: 1 }} source={require('../assets/img/bg.png')}>
    <View style={styles.container}>
      <View style={styles.topo}>
        <Text style={styles.titulo}>Seja Bem-Vindo</Text>
        <Image source={require('../assets/img/logo.png')} />
      </View>
      <View style={styles.acessar}>
        <Button
          title='Fazer Login'
          onPress={() => Actions.Login()}
          color={Colors.primary} />
      </View>
    </View>
  </ImageBackground>
)

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 15
  },

  topo: {
    flex: 2,
    justifyContent: 'center',
    alignItems: 'center'
  },

  titulo: {
    fontSize: 20,
    color: Colors.white
  },

  acessar: {
    flex: 1
  }
})