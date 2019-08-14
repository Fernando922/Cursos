import React, { Component } from 'react'
import { View, StatusBar, Image, StyleSheet, TouchableHighlight } from 'react-native'
import BarraNavegacao from './BarraNavegacao'
import { Navigator } from 'react-native-deprecated-custom-components'

const logo = require('../assets/img/logo.png')
const menuCliente = require('../assets/img/menu_cliente.png')
const menuContato = require('../assets/img/menu_contato.png')
const menuEmpresa = require('../assets/img/menu_empresa.png')
const menuServicos = require('../assets/img/menu_servico.png')

export default class CenaPrincipal extends Component {
  render() {
    return (
      <View>
        <StatusBar
          hidden
          backgroundColor='#CCC'
        />
        <BarraNavegacao
          cor={'#CCC'}
        />
        <View style={styles.logo}>
          <Image source={logo} />
        </View>
        <View style={styles.menu}>
          <View style={styles.menuGrupo}>
            <TouchableHighlight
              underlayColor={'#b9c941'}
              activeOpacity={0.3}
              onPress={() => this.props.navigator.push({ id: 'Clientes' })}>
              <Image source={menuCliente} style={styles.imgMenu} />
            </TouchableHighlight>

            <TouchableHighlight
              underlayColor={'#61bd8c'}
              activeOpacity={0.3}
              onPress={() => this.props.navigator.push({ id: 'Contatos' })}
            >
              <Image source={menuContato} style={styles.imgMenu} />
            </TouchableHighlight>
          </View>

          <View style={styles.menuGrupo}>
            <TouchableHighlight
              underlayColor={'#ec7148'}
              activeOpacity={0.3}
              onPress={() => this.props.navigator.push({ id: 'Empresa' })}>
              <Image source={menuEmpresa} style={styles.imgMenu} />
            </TouchableHighlight>

            <TouchableHighlight
              underlayColor={'#19d1c8'}
              activeOpacity={0.3}
              onPress={() => this.props.navigator.push({ id: 'Servicos' })}>
              <Image source={menuServicos} style={styles.imgMenu} />
            </TouchableHighlight>
          </View>
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({

  logo: {
    marginTop: 30,
    alignItems: 'center'
  },

  menu: {
    alignItems: 'center'
  },

  menuGrupo: {
    flexDirection: 'row'
  },

  imgMenu: {
    margin: 15
  }


})
