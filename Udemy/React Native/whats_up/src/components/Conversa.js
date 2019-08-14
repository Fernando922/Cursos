import React, { Component } from 'react'
import { View, Text, StyleSheet, TextInput, TouchableOpacity, Image, ListView } from 'react-native'
import { connect } from 'react-redux'
import Colors from '../Utils/Colors'
import _ from 'lodash'
import { modificaMensagem, enviaMensagem, conversaUsuarioFetch } from '../actions/AppActions'

class Conversa extends Component {

  componentWillMount() {
    this.props.conversaUsuarioFetch(this.props.contatoEmail)
    this.criaFonteDeDados(this.props.conversa)
  }

  componentWillReceiveProps(nextProps) {
    if(this.props.contatoEmail !== nextProps.contatoEmail){
      this.props.conversaUsuarioFetch(nextProps.contatoEmail)
    }
    this.criaFonteDeDados(nextProps.conversa)
  }

  criaFonteDeDados(conversa) {
    const ds = new ListView.DataSource({ rowHasChanged: (r1, r2) => r1 !== r2 })
    this.dataSource = ds.cloneWithRows(conversa)
  }

  _enviaMensagem() {
    const { mensagem, contatoNome, contatoEmail } = this.props
    this.props.enviaMensagem(mensagem, contatoNome, contatoEmail)
  }

  renderRow(texto) {
    if (texto.tipo === 'e') {
      return (
        <View style={{ alignItems: 'flex-end', marginTop: 5, marginBottom: 5, marginLeft: 40 }}>
          <Text style={{
            fontSize: 18,
            color: Colors.black,
            padding: 10,
            backgroundColor: Colors.mensagemEnviada,
            elevation: 1
          }}
          >{texto.mensagem}</Text>
        </View>
      )
    }

    return (
      <View style={{ alignItems: 'flex-start', marginTop: 5, marginBottom: 5, marginRight: 40 }}>
          <Text style={{
            fontSize: 18,
            color: Colors.black,
            padding: 10,
            backgroundColor: Colors.mensagemRecebida,
            elevation: 1
          }}
          >{texto.mensagem}</Text>
        </View>
    )
  }

  render() {
    return (
      <View style={styles.container}>
        <View style={styles.containerMensagens}>

          <ListView
            enableEmptySections
            dataSource={this.dataSource}
            renderRow={this.renderRow}
          />
        </View>
        <View style={styles.containerInput}>
          <TextInput
            style={styles.input}
            value={this.props.mensagem}
            onChangeText={(text) => this.props.modificaMensagem(text)}
          />
          <TouchableOpacity
            onPress={this._enviaMensagem.bind(this)}
            style={styles.botao}
          >
            <Image source={require('../assets/img/enviar.png')} style={styles.imagem} />
          </TouchableOpacity>
        </View>
      </View>
    )
  }
}

const mapStateToProps = state => {  //converte objeto para array
  const conversa = _.map(state.ListaConversaReducer, (val, uid) => {
    return { ...val, uid }
  })

  return ({
    conversa,
    mensagem: state.AppReducer.mensagem
  })
}

export default connect(mapStateToProps, { modificaMensagem, enviaMensagem, conversaUsuarioFetch })(Conversa)


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: Colors.beije,
  },

  containerMensagens: {
    flex: 1,
    paddingBottom: 20
  },

  containerInput: {
    height: 60,
    flexDirection: 'row',
    paddingBottom: 5,
    paddingHorizontal: 15,
    backgroundColor: Colors.white,
    borderRadius: 30,
    alignItems: 'center',
    margin: 5
  },

  input: {
    flex: 4,
    fontSize: 18,
  },

  botao: {
    flex: 1
  },

  imagem: {
    flex: 1,
    resizeMode: 'contain',
    width: null,
    height: null
  }
})
