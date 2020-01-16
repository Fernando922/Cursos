const prod1 = {}

prod1.nome = 'celular ultra mega'
prod1.preco = 4999.90
prod1['desconto legal'] = 0.40  //não é legal, não é recomendado


console.log(prod1)


const prod2 = {  //chave valor, a chave é unica dentro do objeto em referencia
  nome: 'Camisa polo',
  preco: 79.90,
  obj: {
    outra: 1,
    obj: {
      nome: 'Nome'
    }
  }
}

'{ "nome": "camisa", "preco": 10.50}'  // esse é um json valido, json não é objeto!!
//json é formato para troca entre sistemas
//json é texto, mas pode ser convertido para objeto


console.log(prod2)