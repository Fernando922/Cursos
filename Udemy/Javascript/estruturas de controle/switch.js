const imprimirResultado = function(nota) {
  switch (Math.floor(nota)) {
    case 10: // se for 10 ou 9
    case 9:
      console.log("Quadro de Honra"); //posso colocar varias linhas de codigo sem precisar colocar chaves
      break;
    case 8: //as condições podem ser na mesma linha também: case 8: case 7:
    case 7:
      console.log("Aprovado");
      break;
    case 6:
    case 5:
    case 4:
      console.log("Recuperação");
      break;
    case 3:
    case 2:    //case 3,2,1,0 nao funciona    case 3-0 tambem nao
    case 1:
    case 0:
      console.log("Reprovado");
      break;
    default:
      console.log("Nota inválida.");
  }
};

imprimirResultado(10)


//lembre-se, se não tiver o break todas as condições abaixo da verdadeira serão executadas também!
//switch nao retorna verdadeiro ou falso
