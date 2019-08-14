import React, { Component } from 'react'
import { View, Text, TextInput, Button, StyleSheet } from 'react-native'
import Colors from '../Utils/Colors'
import { connect } from 'react-redux'
import { modificaAdicionaContatoEmail, adicionaContato } from '../actions/AppActions'

class AdicionarContato extends Component {
  renderAdicionaContato() {
    if (!this.props.cadastro_resultado_inclusao) {
      return (
        <View style={{flex: 1}}>
          <View style={styles.containerInput}>
            <TextInput
              placeholder='E-mail'
              style={styles.input}
              onChangeText={(text) => this.props.modificaAdicionaContatoEmail(text)}
              value={this.props.adiciona_contato_email}
            />
          </View>
          <View style={styles.containerBotao}>
            <Button
              title='Adicionar'
              color={Colors.primary}
              onPress={() => this.props.adicionaContato(this.props.adiciona_contato_email)}
            />
            <Text style={styles.erro}>
              {this.props.cadastro_resultado_txt_erro}
            </Text>
          </View>
        </View>
      )
    }else {
      return(
        <View>
          <Text style={styles.txtSucesso}>Cadastro executado com sucesso!</Text>
        </View>
      )
    }
  }
  render() {
    return (
      <View style={styles.container}>
        {this.renderAdicionaContato()}
      </View>
    )
  }
}

const mapStateToProps = state => (
  {
    adiciona_contato_email: state.AppReducer.adiciona_contato_email,
    cadastro_resultado_txt_erro: state.AppReducer.cadastro_resultado_txt_erro,
    cadastro_resultado_inclusao: state.AppReducer.cadastro_resultado_inclusao
  }
)

export default connect(mapStateToProps, { modificaAdicionaContatoEmail, adicionaContato })(AdicionarContato)

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    padding: 20
  },

  containerInput: {
    flex: 1,
    justifyContent: 'center',
  },

  input: {
    fontSize: 20,
    height: 45,
    borderBottomColor: Colors.primary,
    borderBottomWidth: 1
  },

  containerBotao: {
    flex: 1,
  },

  erro: {
    fontSize: 20,
    color: Colors.red
  },

  txtSucesso: {
    fontSize: 20
  }
})