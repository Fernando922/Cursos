import React, {Component} from 'react';
import {
  Image, 
  StyleSheet, 
  Text, 
  View, 
  Dimensions, 
  TouchableOpacity,
  TextInput,
  FlatList
} from 'react-native';
import InputComentario from './InputComentario'

const width = Dimensions.get('screen').width

export default class Post extends Component{

  constructor(props) {
    super(props)
    this.state ={
      foto: this.props.foto,
      valorComentario: ''
    }
  }

  carregaIcone(likeada) {
    return likeada ? require('../../resources/img/s2-checked.png'):
      require('../../resources/img/s2.png')
  }

  exibeLikes(likers){
    if(likers.length <= 0)
      return;

    return(
      <Text style={styles.likes}>
        {likers.length} {likers.length > 1 ? 'curtidas' : 'curtida'}
      </Text>
    )
  }

  exibeLegenda(foto){
    if(foto.comentario === '')
      return

    return(
      <View style={styles.comentario}>
        <Text style={styles.tituloComentario}>Fernando</Text>
        <Text>{foto.comentario}</Text>
      </View>
    )
  }

  like() {
    const { foto } = this.state
    let novaLista = []
    if(!foto.likeada){
      novaLista = [
        ...foto.likers,
        {login: 'Fernando'}
      ]
    } else if(foto) {
      novaLista = foto.likers.filter(liker => {
        return liker.login !== 'Fernando'
      })
    }

    const fotoAtualizada = {
      ...foto,
      likeada: !foto.likeada,
      likers: novaLista
    }

    this.setState({
      foto: fotoAtualizada
    })
  }

  adicionaComentario(valorComentario, inputComentario){
    if(valorComentario === '')
      return

    const novaLista = [
      ...this.state.foto.comentarios, {
        id: valorComentario,
        login: 'Fernando',
        texto: valorComentario
      }
    ]

    const fotoAtualizada = {
      ...this.state.foto,
      comentarios: novaLista
    }

    this.setState({
      foto: fotoAtualizada
    })

    inputComentario.clear();  //ref não é pra manipular, apenas referencia msm
  }

  render() {
    const { foto } = this.state 

    return (
      <View>
        <View style={styles.cabecalho}>
          <Image source={require('../../resources/img/perfil.png')}
            style={styles.foto}
          />
          <Text>Fernando</Text>
        </View>
          <Image source={{uri: foto.urlFoto}}
            style={styles.imagem}
          />
          <View style={styles.rodape}>
            <TouchableOpacity
              onPress={this.like.bind(this)}
            >
              <Image style={styles.botaoLike}
                source={this.carregaIcone(foto.likeada)} 
              />
            </TouchableOpacity>
            {this.exibeLikes(foto.likers)}
            {this.exibeLegenda(foto)}

            <FlatList
              data={foto.comentarios}
              keyExtractor={item => item.id}
              renderItem={ ({item}) => 
                <View style={styles.comentario}>
                  <Text style={styles.tituloComentario}>{item.login}</Text>
                  <Text>{item.texto}</Text>
                </View>
            }/>

            <InputComentario
              comentarioCallback={this.adicionaComentario.bind(this)}
            />

          </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({

  cabecalho: {
    margin: 10, 
    flexDirection: 'row', 
    alignItems: 'center'
  },

  foto: {
    borderRadius: 20,
     width: 40,
     height: 40,
     marginRight: 10
  },

  imagem: {
    width: width,
    height: width
  },

  botaoLike:{
    marginBottom: 10,
    height: 40,
    width: 40
  },

  rodape: {
    margin: 10
  },

  likes: {
    fontWeight: 'bold'
  },

  comentario:{
    flexDirection: 'row',

  },

  tituloComentario:{
    fontWeight: 'bold',
    marginRight: 5
  },

})