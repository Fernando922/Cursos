import React, { Component } from 'react';
import {
  StyleSheet,
  View,
  Image,
  TouchableOpacity,
  TextInput,
} from 'react-native';

export default class inputComentario extends Component {

  constructor(){
    super()
    this.state = { 
      valorComentario: ''
    }
  }

  render() {
    return (
      <View style={styles.container}>
        <TextInput
          style={styles.input}
          placeholder={'Adicione um comentário'}
          ref={input => this.inputComentario = input}
          onChangeText={texto => this.setState({ valorComentario: texto })}
        />

        <TouchableOpacity
          onPress={() => {
            this.props.comentarioCallback(this.state.valorComentario, this.inputComentario)
            this.setState({valorComentario: ''})
          }}
        >
          <Image source={require('../../resources/img/send.png')} style={styles.icone} />
        </TouchableOpacity>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  input: {
    flex: 1,
    height: 40,
  },

  icone: {
    width: 30,
    height: 30,
  },

  container:{
    flexDirection: 'row',
    alignItems: 'center',
    borderBottomWidth: 1,
    borderBottomColor: '#ddd'
  }
})