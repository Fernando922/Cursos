const express = require('express');   //dependencias
const mongoose = require('mongoose')
const path = require('path')
const cors = require('cors')

const app = express()

const server = require('http').Server(app)  //suporte http e websocket (tempo real)
const io = require('socket.io')(server)

mongoose.connect('mongodb+srv://semana:semana@cluster0-wuzjf.mongodb.net/test?retryWrites=true&w=majority', {
  useNewUrlParser: true,
})

app.use((req, res, next ) => {   //repassa pra todas as rotas
  req.io = io
  next()
})

app.use(cors())   //todas as urls possam acessar esse backend ( front, react etc)

app.use('/files', express.static(path.resolve(__dirname, '..', 'uploads', 'resized')))

app.use(require('./routes'))

server.listen(3333)