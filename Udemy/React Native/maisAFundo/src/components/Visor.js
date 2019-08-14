import React, { Component } from 'react'
import { View, StyleSheet, TextInput } from 'react-native'

export default class Visor extends Component {
  render() {
    return (
      <View>
        <TextInput
          placeholder={this.props.resultado}
          style={styles.input}
          editable={false}
        />
      </View>
    )
  }
}


const styles = StyleSheet.create({

  input: {
    fontSize: 30,
    height: 100
  }


})


