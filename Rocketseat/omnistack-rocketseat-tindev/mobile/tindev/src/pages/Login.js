import React, { useState } from 'react'
import { View, StyleSheet, Image, TextInput, TouchableOpacity, Text, KeyboardAvoidingView, Platform } from 'react-native'
import logo from '../assets/logo.png'
import api from '../services/api'

export default function Login({ navigation }) {

  const [user, setUser ] = useState('')

  async function handleLogin() {

    const response = await api.post('/devs', {
      username: user
    })

    const {_id } = response.data
    navigation.navigate('Main', {_id})

    console.warn(_id)
  }

  return (
    <KeyboardAvoidingView
      behavior="padding"
      enabled={Platform.OS === 'ios'}
      style={styles.container}
    >
      <Image source={logo} />
      <TextInput
        style={styles.input}
        placeholder='Digite seu usuário no Github'
        autoCapitalize='none'
        autoCorrect={false}
        value={user}
        onChangeText={setUser}
        placeholderTextColor='#999' />
      <TouchableOpacity
        onPress={handleLogin}
        style={styles.button}>
        <Text style={styles.buttonText}>Entrar</Text>
      </TouchableOpacity>
    </KeyboardAvoidingView>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f5f5f5',
    justifyContent: 'center',
    alignItems: 'center',
    padding: 30
  },

  input: {
    height: 46,
    alignSelf: 'stretch',
    backgroundColor: '#fff',
    borderWidth: 1,
    borderColor: '#ddd',
    borderRadius: 4,
    marginTop: 20,
    paddingHorizontal: 15
  },

  button: {
    height: 46,
    alignSelf: 'stretch',
    backgroundColor: '#df4723',
    borderRadius: 4,
    marginTop: 10,
    justifyContent: 'center',
    alignItems: 'center'
  },

  buttonText: {
    color: '#fff',
    fontWeight: 'bold',
    fontSize: 16
  }
})