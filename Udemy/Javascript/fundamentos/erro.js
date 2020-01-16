//try catch para blocos de codigo que podem dar erros!

function tratarErro(e){
  throw new Error('Ocorreu um erro! Tente novamente!')
  // throw 10
  // throw 'Erro ai mano'
  // throw {
  //   nome: e.name,
  //   msg: e.message,
  //   date: new Date
  // }
}


function imprimirNomeGritado(obj){
  try{  //bloco que pode gerar um erro!!!
    console.log(obj.name.toUpperCase() + '!!!!!!!')
  }catch(e){  //tratar o erro
    tratarErro(e)
  }finally{  //sempre será executado
    console.log('final')
  }
}


const obj = { nome: 'Fernando'}
imprimirNomeGritado(obj)



//evite mostrar ao cliente mensagens de erros do sistema, em ultimo caso retorne uma mensagem padrao de erro!!!