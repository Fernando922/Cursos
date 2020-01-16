let a = 3


global.b = 123

this.c = 456
this.d = false
this.e = 'teste'



console.log(a)
console.log(global.b)
console.log(this.c)
console.log(module.exports.c)
console.log(module.exports === this)
console.log(module.exports)

// criando uma variavel maluca: sem var e let!
abc = 3
console.log(global.abc)


//cuidado com o escopo, global ou nao, nunca coloque variaveis no escopo global
//onde vc está usando 

