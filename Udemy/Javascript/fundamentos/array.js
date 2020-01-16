const valores = [1,2,3,4,5]  //criado de forma literal
console.log(valores[0], valores[3])
console.log(valores[12])  // retorna undefined (perigoso hein, pode gerar um efeito colateral)


valores[12] = 666
console.log(valores[12])

console.log(valores) //retorna [ 1, 2, 3, 4, 5, <7 empty items>, 666 ]
console.log(valores.length) //retorna 13

valores.push({id: 3}, false, null, 'teste')  //um array aceita qualquer tipo (mas não vá fazer isso nao zezao!!)
console.log(valores)


console.log(valores.pop())  //retira o valor e retorna para o usuário

delete valores[0]  //retira o valor do indice especificado, mas mantem o indice vazio (delete é do contexto de objeto)
console.log(valores)
console.log(typeof valores)  //um array é do tipo object