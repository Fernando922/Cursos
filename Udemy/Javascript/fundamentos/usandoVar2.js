var numero = 1
{
  var numero = 2
  console.log('dentro: ', numero)
}

console.log('fora: ', numero)

//nao existe escopo para VAR e ela pode ser recriada com o mesmo nome, substituindo o valor anterior