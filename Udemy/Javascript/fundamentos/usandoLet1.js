var numero = 1;
{
  let numero = 2; //nasce e morre aqui dentro (escopos diferentes)
  console.log("dentro =", numero);
}

console.log("fora =", numero);

//para manipular uma variável a linguagem da preferencia para o escopo mais interno, se nao tiver nada
// e chamado do escopo maior e por ai vai
// ex:

var numero12 = 12
{
  let numero = 1  
  console.log(numero12)  //não existe aqui dentro, entao é chamado do escopo de fora!
}


//var  = escopo global e funçao
// let = escopo global, função e bloco
