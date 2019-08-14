import React, { Component } from 'react'
import { View, Text, ListView, StyleSheet, TouchableOpacity } from 'react-native'
import { connect } from 'react-redux'
import _ from 'lodash'
import { conversasUsuarioFetch } from '../actions/AppActions'
import Colors from '../Utils/Colors';
import { TouchableHighlight } from 'react-native-gesture-handler';
import { Actions } from 'react-native-router-flux'

class Conversas extends Component {

  componentWillMount() {
    this.props.conversasUsuarioFetch()
    this.criaFonteDeDados(this.props.conversas)
  }

  componentWillReceiveProps(nextProps) {
    this.criaFonteDeDados(nextProps.conversas)
  }

  criaFonteDeDados(conversas) {
    const ds = new ListView.DataSource({ rowHasChanged: (r1, r2) => r1 !== r2 });

    this.dataSource = ds.cloneWithRows(conversas)
  }

  renderRow(conversa) {
    return (
      <TouchableOpacity
        onPress={
          () => Actions.conversa({title: conversa.nome, contatoNome: conversa.nome, contatoEmail: conversa.email})
        }
      >
        <View style={styles.container}>
          <Text style={styles.nome}>{conversa.nome}</Text>
        </View>
      </TouchableOpacity>
    )
  }

  render() {
    return (
      <ListView
        enableEmptySections
        dataSource={this.dataSource}
        renderRow={this.renderRow}
      />
    )
  }
}

mapStateToProps = state => {
  const conversas = _.map(state.ListaConversasReducer, (val, uid) => {
    return { ...val, uid };
  });
  return {
    conversas
  }
}

export default connect(mapStateToProps, { conversasUsuarioFetch })(Conversas)

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    borderBottomWidth: 1,
    borderColor: Colors.grey
  },

  nome: {
    fontSize: 25
  }
})