// novo recusto ECMASCRIPT2015

const pessoa = {
  nome: 'ana',
  idade: 21,
  endereco: {
    logradouro: 'Rua ABC',
    numero: 1000
  }
}

//retirando atributos

const {nome, idade} = pessoa
console.log(nome, idade) 

const {nome: n, idade: i} = pessoa  //atribuindo outros nomes
console.log(n, i)

const { sobrenome, bemHumorada = true} = pessoa  //atribui valor padrao caso nao tenha
console.log(sobrenome, bemHumorada)   //undefined true  (undefined, o valor existe mas nao foi atribuido nada)


const {endereco: {logradouro, numero, cep }} = pessoa
console.log(logradouro, numero, cep)


const { conta: {ag, numero}} = pessoa  //vai dar erro, pq o caminho nao existe
