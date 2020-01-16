let num1 = 1
let num2 = 2

num1++  // forma pos fixada, acrescenta uma unidade ao valor da variável
// console.log(num1)

// --num1   //sinal antes ou depois, tanto faz da na mesma está é a forma pré fixada
// //porém ela tem mais prioridade de execução do que da forma anterior
// console.log(num1)


console.log(++num1 === num2--)  // retorna true
//  porque o incremento é feito antes da comparação para o num1 e depois da comparação para o num2