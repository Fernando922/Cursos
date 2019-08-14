import React, {Component} from 'react';
import {
  StyleSheet, 
  FlatList,
  Platform
} from 'react-native';
import Post from './src/components/Post'  //pode-se escolher o nome aqui

export default class App extends Component {

  constructor() {
    super()
    this.state ={
      fotos: []
    }
  }

  componentDidMount(){
    fetch('https://instalura-api.herokuapp.com/api/public/fotos/rafael')
      .then(resposta => resposta.json())
      .then(json => this.setState({fotos: json}))
  }

  render() {
    return (
      <FlatList style={styles.container}
        data={this.state.fotos}
        keyExtractor={item => String(item.id)}
        renderItem={({item}) =>
          <Post 
            foto={item}
          />
        }
      />
    );
  }
}

const margem = Platform.OS === 'ios' ? 20 : 0
const styles = StyleSheet.create({
  container:{
    backgroundColor: '#FFF',
    marginTop: margem
  },
})