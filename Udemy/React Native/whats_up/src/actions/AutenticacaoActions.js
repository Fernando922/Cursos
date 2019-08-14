import firebase from 'firebase'
import { Actions } from 'react-native-router-flux'
import b64 from 'base-64'
import {
  LOADING,
  MODIFICA_EMAIL,
  MODIFICA_NOME,
  MODIFICA_SENHA,
  CADASTRO_USUARIO_SUCESSO,
  CADASTRO_USUARIO_ERRO,
  LOGIN_USUARIO_ERRO,
  LOGIN_USUARIO_SUCESSO
} from './types'

export const modificaEmail = (texto) => {
  return {
    type: MODIFICA_EMAIL,
    payload: texto
  }
}

export const modificaSenha = (texto) => {
  return {
    type: MODIFICA_SENHA,
    payload: texto
  }
}

export const modificaNome = (texto) => {
  return {
    type: MODIFICA_NOME,
    payload: texto
  }
}

export const cadastraUsuario = ({ nome, email, senha }) => {
  return dispatch => {
    dispatch({ type: LOADING })
    firebase.auth().createUserWithEmailAndPassword(email, senha)
      .then(user => {
        let emailB64 = b64.encode(email) //um path nao pode ter caracteres especiais, entao converte para b64
        firebase.database().ref(`/contatos/${emailB64}`)
          .push({ email, nome, senha })
          .then(() => cadastroUsuarioSucesso(dispatch))
      })
      .catch(erro => cadastroUsuarioErro(erro, dispatch))
  }
}

const cadastroUsuarioSucesso = (dispatch) => {
  dispatch({
    type: CADASTRO_USUARIO_SUCESSO
  })
  Actions.boasVindas()
}

const cadastroUsuarioErro = (erro, dispatch) => {
  dispatch({
    type: CADASTRO_USUARIO_ERRO,
    payload: erro.message
  })
}

export const autenticarUsuario = ({ email, senha }) => {
  return dispatch => {
    dispatch({ type: LOADING })

    firebase.auth().signInWithEmailAndPassword(email, senha)
      .then(value => loginUsuarioSucesso(value, dispatch))
      .catch(erro => loginUsuarioErro(erro, dispatch))
  }
}

const loginUsuarioSucesso = (value, dispatch) => {
  dispatch({
    type: LOGIN_USUARIO_SUCESSO
  })
  Actions.principal()
}

const loginUsuarioErro = (erro, dispatch) => {

  dispatch({
    type: LOGIN_USUARIO_ERRO,
    payload: erro.message
  })
}