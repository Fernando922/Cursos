const peso1 = 1.0  //é considerado inteiro 1.1 é considerado double

const peso2 = Number('2.1')  //outra forma de criar numero

console.log(peso1)
console.log(peso2)

console.log(Number.isInteger(peso1))
console.log(Number.isInteger(peso2))

const avaliacao1 = 9.871
const avaliacao2 = 6.871

const media =  (avaliacao1+ avaliacao2)/2
console.log(media.toFixed(2))  //retorna formatado sem alterar
console.log(media.toString(2)) //connverte para binário (retorna um binario)
console.log(typeof media)
console.log(typeof toString)