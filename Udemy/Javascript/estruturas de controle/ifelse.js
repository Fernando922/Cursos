const imprimirResultado = function(nota){
  if(nota>=7){
    console.log('Aprovado')
  }else{
    console.log('Reprovado')
  }
}

imprimirResultado(10)
imprimirResultado(4)
imprimirResultado('Epa') //vai ser falso, pq nao é um valor maior ou igual a 7 (deve ser erro mesmo!)

//se o retorno for apenas uma sentença, o retorno pode ser sem chaves