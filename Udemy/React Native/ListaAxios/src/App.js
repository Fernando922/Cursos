import React, { Component } from 'react'
import { ScrollView } from 'react-native'
import Items from '../src/components/Items'
import axios from 'axios'

export default class App extends Component {

  constructor(props) {
    super(props)
    this.state = {
      listaItens: []
    }
  }

  componentWillMount() {
    //requisição http
    axios.get('http://faus.com.br/recursos/c/dmairr/api/itens.html')
      .then(
        response => {
          this.setState({
            listaItens: response.data
          })
        }
      )
      .catch(() => { console.warn('erro ao recuperar os dados') })
  }

  render() {
    return (
      <ScrollView style={{backgroundColor: '#DDD'}}>
        {
          this.state.listaItens.map(item => {
            return (
              <Items
                key={item.titulo}
                item={item}
              />
            )
          })
        }
      </ScrollView>
    )
  }
}
