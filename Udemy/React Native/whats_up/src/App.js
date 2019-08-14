import React, { Component } from 'react'
import { Provider } from 'react-redux'
import { createStore, applyMiddleware } from 'redux'
import Rotas from './Rotas'
import reducers from './reducers'
import firebase from 'firebase'
import ReduxThunk from 'redux-thunk'

export default class App extends Component {

  componentWillMount() {
    // Your web app's Firebase configuration
    var firebaseConfig = {
      apiKey: "AIzaSyAIDiME4vvnpbYoXHWjaITCtcKk8G5tsE4",
      authDomain: "whatsclone-b070b.firebaseapp.com",
      databaseURL: "https://whatsclone-b070b.firebaseio.com",
      projectId: "whatsclone-b070b",
      storageBucket: "",
      messagingSenderId: "553753825023",
      appId: "1:553753825023:web:c7be8450e713bafa"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
  }

  render() {
    return (
      <Provider store={createStore(reducers, {}, applyMiddleware(ReduxThunk))}>
        <Rotas />
      </Provider>
    )
  }
}

//objeto vazio é para criar estado inicial 
