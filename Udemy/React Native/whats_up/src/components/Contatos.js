import React, { Component } from 'react'
import { View, Text, ListView, StyleSheet, TouchableHighlight } from 'react-native'
import { connect } from 'react-redux'
import { contatosUsuarioFetch } from '../actions/AppActions'
import _ from 'lodash'
import Colors from '../Utils/Colors';
import { Actions } from 'react-native-router-flux';


class Contatos extends Component {

  constructor(props) {
    super(props)
  }

  componentWillMount() {
    this.props.contatosUsuarioFetch()
    this.criaFonteDeDados(this.props.contatos)
  }

  componentWillReceiveProps(nextProps) {
    this.criaFonteDeDados(nextProps.contatos)
  }

  criaFonteDeDados(contatos) {
    const ds = new ListView.DataSource({
      rowHasChanged: (r1, r2) => r1 !== r2
    })
    this.fonteDeDados = ds.cloneWithRows(contatos)
  }

  renderRow(contato) {
    return (
      <TouchableHighlight
        onPress={() => Actions.conversa({title: contato.nome, contatoNome: contato.nome, contatoEmail: contato.email})}
      >
        <View style={styles.container}>
          <Text style={styles.nome}>{contato.nome}</Text>
          <Text style={styles.email}>{contato.email}</Text>
        </View>
      </TouchableHighlight>
    )
  }

  render() {
    return (
      <ListView
        enableEmptySections
        dataSource={this.fonteDeDados}
        renderRow={this.renderRow} //mesmo que data => this.renderRow()
      />
    )
  }
}

mapStateToProps = state => {
  const contatos = _.map(state.ListaContatosReducer, (val, uid) => {
    return { ...val, uid }
  })
  return {
    contatos
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    borderBottomWidth: 1,
    borderColor: Colors.grey
  },

  nome: {
    fontSize: 25
  },

  email: {
    fontSize: 18
  }
})

export default connect(mapStateToProps, { contatosUsuarioFetch })(Contatos)