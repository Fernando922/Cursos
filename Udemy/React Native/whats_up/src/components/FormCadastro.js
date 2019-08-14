import React, { Component } from 'react'
import { View, TextInput, Button, StyleSheet, ImageBackground, Text, ActivityIndicator } from 'react-native'
import Colors from '../Utils/Colors'
import { connect } from 'react-redux'
import { modificaEmail, modificaSenha, modificaNome, cadastraUsuario } from '../actions/AutenticacaoActions'

class formCadastro extends Component {

  _cadastraUsuario() {
    const { nome, email, senha } = this.props
    this.props.cadastraUsuario({ nome, email, senha })
  }

  renderBtnCadastrar() {
    if (this.props.loading_login) {
      return <ActivityIndicator size="large" />
    }
    return (
      <Button
        title="Cadastrar"
        color={Colors.primary}
        onPress={() => this._cadastraUsuario()}
      />
    )
  }

  render() {
    return (
      <ImageBackground style={{ flex: 1 }} source={require('../assets/img/bg.png')}>
        <View style={styles.container}>
          <View style={styles.divFormCadastro}>
            <TextInput
              placeholder='Nome'
              style={styles.input}
              value={this.props.nome}
              onChangeText={(text) => this.props.modificaNome(text)}
              placeholderTextColor={Colors.white}
            />
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
            <Text style={styles.erro}>{this.props.erro}</Text>
          </View>
          <View style={styles.divBotao}>
            {
              this.renderBtnCadastrar()
            }
          </View>
        </View>
      </ImageBackground>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10
  },

  divFormCadastro: {
    flex: 4,
    justifyContent: 'center'
  },

  input: {
    fontSize: 20,
    height: 45,
    borderBottomWidth: 1,
    borderBottomColor: Colors.lightGrey
  },

  cadastre: {
    fontSize: 20
  },

  erro: {
    fontSize: 18,
    color: Colors.red,
    fontWeight: 'bold'
  },

  divBotao: {
    flex: 1
  }
})

const mapStateToProps = state => ({
  nome: state.AutenticacaoReducer.nome,
  email: state.AutenticacaoReducer.email,
  senha: state.AutenticacaoReducer.senha,
  erro: state.AutenticacaoReducer.erro,
  loading_login: state.AutenticacaoReducer.loading_login
});

export default connect(mapStateToProps, {
  modificaEmail,
  modificaSenha,
  modificaNome,
  cadastraUsuario
})(formCadastro)
