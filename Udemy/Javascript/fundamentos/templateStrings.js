const nome = "rebeca";
const concatenacao = "Ola " + nome + "!";
console.log(concatenacao);

const template = `Olá ${nome}` //suporta quebra de linha, é adicionado a string
console.log(template)

console.log(`1+1 = ${1+1}`)  //interpolar é interpretar os dados dentro da string

const up = s => s.toUpperCase()

console.log(`Ei.... ${up('cuidado')} !`)   //função pode ser chamada dentro de um template string :D

// ECMA SCRIPT2015