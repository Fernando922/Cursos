let valor; // nao inicializada, mas foi declarada (defined)

console.log(valor); //undefined

valor = null; // ausencia de valor, mas foi você que definiu assim
//sempre use nulo quando desejar zerar o endereço de memoria para ela
//nunca atribua undefined
console.log(valor);
//console.log(valor.toString())   //  Cannot read property 'toString' of null (typeError)
// no caso acima sempre tenha um valor padrao

const produto = {}
console.log(produto.preco)  //undefined
//console.log(produto.preco.comDesconto)  // TypeError: Cannot read property 'comDesconto' of undefined

produto.preco = 3.50
console.log(produto)

produto.preco = undefined  // evite atribuir undefined, deixa que linguagem decida
console.log(!!produto.preco)  // false
console.log(produto)  // { preco: undefined }  // nao faz sentido

produto.preco = null  //sem preco
console.log(!!produto.preco)  //false
console.log(produto)


delete produto.preco  
console.log(produto)  // {}