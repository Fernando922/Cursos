import React from 'react'
import { View, Text, StyleSheet} from 'react-native'
import Visor from './Visor'

const Resultado = props => (
  <View style={styles.container}>
    <Visor resultado={props.resultado}/>
  </View>
)

const styles = StyleSheet.create({
 
})

export { Resultado }

