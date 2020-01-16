//destructuring no contexto de função, você passa uma função
//como parametro ou declara ela na hora da execução
//os atributos de chave e valor devem ser os mesmos viu!?


function rand({min = 0, max = 1000}){
  const valor = Math.random() * (max-min) + min
  return Math.floor(valor)
}


const obj = {max: 50, min: 40}
console.log(rand(obj))   //ex 41


const obj2 = {min: 950}
console.log(rand(obj2))   //ex 959

console.log(rand({}))