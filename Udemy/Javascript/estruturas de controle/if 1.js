function soBoaNoticia(nota) {

  //se uma condição for verdadeira o bloco é executado
  if (nota >= 7) {
    console.log('passou de ano')
  }

}


function seForVerdadeiro(valor){
  if(valor){
    console.log('é verdadeiro' + valor)
  }
}

seForVerdadeiro()
seForVerdadeiro(null)
seForVerdadeiro(undefined)
seForVerdadeiro(NaN)
seForVerdadeiro('')
seForVerdadeiro(0)
seForVerdadeiro(-1)  //cuidado que é true
seForVerdadeiro(' ') 
seForVerdadeiro('?') 
seForVerdadeiro([]) 
seForVerdadeiro([1,2]) 
seForVerdadeiro({}) 

