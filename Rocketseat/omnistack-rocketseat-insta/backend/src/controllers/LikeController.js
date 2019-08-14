const Post = require('../models/Post')

module.exports = {

  async store(req, res) {   //sempre retorne um resultado :)
    const post = await Post.findById(req.params.id)
    post.likes += 1   //adiciona um like a mais
    await post.save()

    req.io.emit('like', post)  //retorna em tempo real
   
    return res.json(post)
  }
}