import React from 'react'
import { View, Text, StatusBar, StyleSheet, Image, TouchableHighlight } from 'react-native'
import { TabBar } from 'react-native-tab-view'
import Colors from '../Utils/Colors'
import { Actions } from 'react-native-router-flux'
import { habilitaInclusaoContato } from '../actions/AppActions'
import { connect } from 'react-redux'
import firebase from 'firebase'

const TabBarMenu = props => {
  return (
    <View style={styles.container}>
      <StatusBar backgroundColor={Colors.primary} />

      <View style={styles.containerOpcoes}>
        <View style={styles.containerText}>
          <Text style={styles.titulo}>WhatsApp Clone</Text>
        </View>

        <View style={styles.containerBotoes}>
          <View style={styles.imagem}>
            <TouchableHighlight
              onPress={() => [Actions.adicionarContato(), props.habilitaInclusaoContato()]}
              underlayColor={Colors.primary}
            >
              <Image source={require('../assets/img/adicionar-contato.png')} />
            </TouchableHighlight>
          </View>
        
          <View style={styles.containerTexto}>
            <TouchableHighlight
              onPress={() => firebase.auth().signOut().then(() => Actions.Login())}
            >
              <Text style={styles.textoSair}>Sair</Text>
            </TouchableHighlight>
          </View>
        </View>
      </View>
      <TabBar {...props} style={styles.tabBar} />
    </View>
  );
}

export default connect(null, {habilitaInclusaoContato})(TabBarMenu)

const styles = StyleSheet.create({
  container: {
    backgroundColor: Colors.primary,
    elevation: 4,
    marginBottom: 6
  },

  containerOpcoes: {
    flexDirection: 'row',
    justifyContent: 'space-between'
  },

  containerText: {
    height: 100,
    justifyContent: 'center'
  },

  titulo: {
    color: Colors.white,
    fontSize: 20,
    marginLeft: 20
  },

  containerBotoes: {
    flexDirection: 'row',
    marginRight: 20
  },

  imagem: {
    width: 50,
    justifyContent: 'center',
    alignItems: 'center'
  },

  containerText: {
    justifyContent: 'center'
  },

  textoSair: {
    fontSize: 20,
    color: Colors.white
  },

  tabBar: {
    backgroundColor: Colors.primary,
    elevation: 0
  }
})



