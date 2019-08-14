const multer = require('multer')  //permite que o express entenda os formatos de form-data enviados
const express = require('express')
const PostController = require('./controllers/PostController')
const LikeController = require('./controllers/LikeController')
const uploadConfig = require('./config/upload')

const routes = new express.Router()
const upload = multer(uploadConfig)  //para interpretar o retorno do post

routes.get('/posts', PostController.index) //NUCA USE './posts'
routes.post('/posts', upload.single('image'), PostController.store) //NUCA USE './posts'
routes.post('/posts/:id/like', LikeController.store)


module.exports = routes


