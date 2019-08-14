import React from 'react';
import { BrowserRouter } from 'react-router-dom'
import './global.css'
import Routes from './Routes'
import Header from './components/Header'

function App() {   //função ou classe
  return (
    <BrowserRouter>
      <Header />
      <Routes />
    </BrowserRouter>
  );
}

export default App;
