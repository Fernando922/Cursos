//função é um bloco de código, nomeado que pode ser reutilizado
//pode nao receber nenhum parametro e pode nao retornar nada

//Função sem retorno que recebe dois parametros, o dado por ser o que vc quiser
function imprimirSoma(a, b) {
  console.log(a + b);
}

imprimirSoma(2, 3); // imprime 5
imprimirSoma(2); // soma valor inteiro com undefined e retorna NaN
imprimirSoma(2, 3, 4, 5, 6); //pega os dois primeiro e ignora o resto
imprimirSoma()  // NaN

//função com retorno
function soma(a,b = 0){
  return a+b
}

console.log(soma(2,3))   //no caso é executada dentro de um console.log
console.log(soma(2))  //2+0 pq o b é zero por padrao