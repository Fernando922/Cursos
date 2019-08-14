import React, { Component } from 'react'
import { View, Text, Button } from 'react-native'
import firebase from 'firebase'

export default class App extends Component {


  componentWillMount() {
    var firebaseConfig = {
      apiKey: "AIzaSyBE1UIyvzn5Zdwg0kQaMda5yIGSbl115Lo",
      authDomain: "projeto-teste-911eb.firebaseapp.com",
      databaseURL: "https://projeto-teste-911eb.firebaseio.com",
      projectId: "projeto-teste-911eb",
      storageBucket: "projeto-teste-911eb.appspot.com",
      messagingSenderId: "822989760258",
      appId: "1:822989760258:web:594bbb40fdd86c89"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
  }

  // salvarDados(){
  //   //database.ref('pontuacao').set('1050')  //salva e atualiza o mesmo
  //   //database.ref('pontuacao').remove()  //remove o mesmo
  //   firebase.database().ref('pontuacao').set(10560)
  //   //funcionarios.child('002').child('nome').set('Rogério')  //salva e atualiza
  //   //funcionarios.child('001').remove()  remove apenas o funcionario 001
  //   //funcionarios.push().child('nome').set('maria')  //cria e gera o id unico
  //   // funcionarios.push().set(    //salvar como objeto literal
  //   //   {
  //   //     nome: 'Fernando de Paula',
  //   //     altura: '1,75',
  //   //     peso: '85Kg'
  //   //   }
  //   // )
  // }

  // listarDados(){
  //   let pontuacao = firebase.database().ref('pontuacao')
  //   pontuacao.on('value', (snapshot) => {   //ativa o listener que é chamado a cada alteração
  //     let pontos = snapshot.val()
  //     this.setState({
  //       pontuacao: pontos
  //     })
  //   })
  // }

  cadastrarUsuario() {
    let email = 'email@email.com.br'
    let senha = '123456'

    var usuario = firebase.auth()

    usuario.createUserWithEmailAndPassword
      (email, senha).catch(
        (erro) => {
          //erro.code
          if (erro.code === 'auth/weak-password') {
            mensagemErro = 'A senha precisa ter no mínimo 6 caracteres'
            alert(mensagemErro)
          } else if (erro.code === 'auth/email-already-in-use') {
            alert('email já cadastrado!')
          }
        }
      )
  }

  verificarUsuarioLogado() {
    const usuario = firebase.auth()
    // const usuarioAtual = usuario.currentUser

    // if(usuarioAtual){
    //   alert('usuario está logado')
    // }else{
    //   alert('usuario não está logado')
    // }
    usuario.onAuthStateChanged(   //isso é um listener!!! este é melhor que o anterior!
      //um listener, cada vez que vc implementar um novo será incluido
      (usuarioAtual) => {
        if (usuarioAtual) {
          alert('usuario está logado')
        } else {
          alert('usuario não está logado')
        }
      }
    )
  }

  deslogarUsuario() {
    const usuario = firebase.auth()
    usuario.signOut()
  }

  login() {
    let email = 'email@email.com.br'
    let senha = '123456'
    const usuario = firebase.auth()
    usuario.signInWithEmailAndPassword(email,senha)
  }

  render() {
    return (
      <View>
        <Button
          onPress={() => this.salvarDados()}
          title='Salvar dados'
          color='#941584'
          accessibilityLabel='Salvar Dados'
        />
        <Button
          onPress={() => this.listarDados()}
          title='Listar Dados'
          color='#145674'
          accessibilityLabel='Listar Dados'
        />
        <Button
          onPress={() => this.cadastrarUsuario()}
          title='Cadastrar usuario'
          color='#487a65'
          accessibilityLabel='Cadastrar usuario'
        />
        <Button
          onPress={() => this.verificarUsuarioLogado()}
          title='Verificar usuario logado'
          color='#5874FF'
          accessibilityLabel='Verificar usuario logado'
        />
        <Button
          onPress={() => this.deslogarUsuario()}
          title='Deslogar usuario'
          color='#941584'
          accessibilityLabel='deslogar'
        />
        <Button
          onPress={() => this.login()}
          title='Login'
          color='#ff662f'
          accessibilityLabel='login'
        />
      </View>
    )
  }
}