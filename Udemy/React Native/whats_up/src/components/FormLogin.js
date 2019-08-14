import React, { Component } from 'react'
import { View, TextInput, Text, Button, StyleSheet, TouchableHighlight, ImageBackground, ActivityIndicator } from 'react-native'
import Colors from '../Utils/Colors'
import { Actions } from 'react-native-router-flux'
import { connect } from 'react-redux'
import { modificaEmail, modificaSenha, autenticarUsuario } from '../actions/AutenticacaoActions'

class formLogin extends Component {

  _autenticarUsuario() {
    const { email, senha } = this.props

    this.props.autenticarUsuario({ email, senha })
  }

  renderBtnAcessar() {

    if (this.props.loading_login) {
      return (
        <ActivityIndicator size="large" />
      )
    }


    return (
      <Button
        title={'Acessar'}
        color={Colors.primary}
        onPress={() => this._autenticarUsuario()}
      />
    )
  }

  render() {
    return (
      <ImageBackground style={{ flex: 1 }} source={require('../assets/img/bg.png')}>
        <View style={styles.container}>
          <View style={styles.topo}>
            <Text style={styles.titulo}>WhatsUp</Text>
          </View>
          <View style={styles.divFormLogin}>
            <TextInput
              placeholder='E-mail'
              style={styles.input}
              value={this.props.email}
              onChangeText={(text) => this.props.modificaEmail(text)}
              placeholderTextColor={Colors.white}
            />
            <TextInput
              placeholder='Senha'
              style={styles.input}
              value={this.props.senha}
              secureTextEntry
              onChangeText={(text) => this.props.modificaSenha(text)}
              placeholderTextColor={Colors.white}
            />
            <Text style={styles.mensagemErro}>
              {this.props.erroLogin}
            </Text>
            <TouchableHighlight
              onPress={() => Actions.Cadastro()}
            >
              <Text style={styles.cadastre}>Ainda não tem cadastro? Cadastre-se</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.divBotao}>
            {this.renderBtnAcessar()}
          </View>
        </View>
      </ImageBackground>
    )
  }
}

const mapStateToProps = state => (
  {
    email: state.AutenticacaoReducer.email,
    senha: state.AutenticacaoReducer.senha,
    erroLogin: state.AutenticacaoReducer.erroLogin,
    loading_login: state.AutenticacaoReducer.loading_login
  }
);

export default connect(mapStateToProps, { modificaEmail, modificaSenha, autenticarUsuario })(formLogin)

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10
  },

  topo: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  },

  titulo: {
    fontSize: 25,
    color: Colors.white
  },

  divFormLogin: {
    flex: 2
  },

  input: {
    fontSize: 20,
    height: 45,
    borderBottomWidth: 1,
    borderBottomColor: Colors.lightGrey
  },

  mensagemErro: {
    color: '#ff0000',
    fontSize: 18,
    fontWeight: 'bold'
  },

  cadastre: {
    fontSize: 20,
    color: Colors.white
  },

  divBotao: {
    flex: 1
  }
})
