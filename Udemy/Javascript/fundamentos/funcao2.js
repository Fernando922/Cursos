// Armazenando uma função em uma variavel, é top :D

const imprimirSoma = function(a, b) {
  console.log(a + b);
};

imprimirSoma(2, 3);

// Armazenando uma função arrow em uma variavel
const soma = (a, b) => {
  return a + b;
};

console.log(soma(2, 4));

// retorno implicito
const subtracao = (a, b) => a - b;
const chamarNome = nome => console.log(`Olá ${nome}`);
chamarNome("Fernando");
console.log(subtracao(212, 12));

