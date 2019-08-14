const Post = require('../models/Post')
const sharp = require('sharp')
const path = require('path')
const fs = require('fs')

module.exports = {   
  async index(req, res) {   //retorna todos os post ordenados por data de criaçao decrescente
    const posts = await Post.find().sort('-createdAt')
    return res.json(posts)
  },

  async store(req, res) {   //sempre retorne um resultado :)
    const { author, place, description, hashtags } = req.body
    const { filename: image } = req.file   //pega o filename e altera para image

    const [name] = image.split('.')
    const fileName = `${name}.jpg`

    await sharp(req.file.path)   //diminui a imagem para no máximo 500px
      .resize(500)
      .jpeg({quality:70})
      .toFile(
        path.resolve(req.file.destination, 'resized', fileName)
      )

      fs.unlinkSync(req.file.path)  //apaga a versao original da foto salva no projeto

    const post = await Post.create({ //salva no bd
      author,
      place,
      description,
      hashtags,
      image: fileName
    })

    req.io.emit('post', post)   //envia info em tempo real 

    return res.json(post)
  }
}