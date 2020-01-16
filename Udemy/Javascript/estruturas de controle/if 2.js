function teste1(num) {
  if (num > 7) //apenas uma sentença de codigo é associada ao if declarado sem chaves, na duvida, sempre abra chaves, gera confusão se nao tiver
    console.log(num) 
    console.log('Final')
}


teste1(10)

//console.log('final') sempre será executado, ele nao faz parte do IF, faria se estivesse dentro de chaves!!!




function teste2(num){
  if(num>7);{
    console.log(num)
  }
}

teste2(5)  
teste2(120)

//na função teste 2 como vc matou o bloco do if por conta do ponto e virgula, a condição nao será considerada

//formatando certo

// if(num>7);

// {
//   console.log(num)
// }

//NUNCA USE PONTO E VIRGULA COM ESTRUTURAS DE CONTROLE