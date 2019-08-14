import {
  LOADING,
  MODIFICA_EMAIL,
  MODIFICA_NOME,
  MODIFICA_SENHA,
  CADASTRO_USUARIO_SUCESSO,
  CADASTRO_USUARIO_ERRO,
  LOGIN_USUARIO_ERRO,
  LOGIN_USUARIO_SUCESSO
} from '../actions/types'

const INITIAL_STATE = {
  nome: '',
  email: 'email@email.com',
  senha: '123456',
  erro: '',
  erroLogin: '',
  loading_login: false
}

export default (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case MODIFICA_EMAIL:
      return { ...state, email: action.payload }
    case MODIFICA_SENHA:
      return { ...state, senha: action.payload }
    case MODIFICA_NOME:
      return { ...state, nome: action.payload }
    case CADASTRO_USUARIO_ERRO:
      return { ...state, erro: action.payload, loading_login: false }
    case CADASTRO_USUARIO_SUCESSO:
      return { ...state, nome: '', senha: '', loading_login: false }
    case LOGIN_USUARIO_ERRO:
      return { ...state, erroLogin: action.payload, loading_login: false }
    case LOGIN_USUARIO_SUCESSO:
      return { ...state, senha: '', email: '', loading_login: false }
    case LOADING:
      return { ...state, loading_login: true }
    default:
      return state
  }
}