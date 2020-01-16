//par nome/valor

const saudacao = 'opa'  //contexto lexico 1

//cada nivel do escopo é um contexto lexico

function exec(){
  const saudacao = 'Fala'   //contexto lexico 2
  return saudacao
}

//Objeto são grupos aninhados de pares nome/valor
const cliente = {
  nome: 'Pedro',
  idade: 22,
  peso: 90,
  endereco: {
    logradouro: 'Rua top',
    numero: 123
  }
}

console.log(saudacao)
console.log(exec())
console.log(cliente)