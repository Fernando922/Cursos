let isAtivo = false


console.log(isAtivo)

isAtivo = true   //sempre priorize const e se precisar alterar use let
console.log(isAtivo)

isAtivo = 1
console.log(!isAtivo)   //console.log(!!isAtivo)  negação da negação se for true, continua sendo true

console.log('os verdadeiros...')
console.log(!!3)
console.log(!!-3)
console.log(!!-1)
console.log(!!' ')
console.log(!!'teste')
console.log(!![])
console.log(!!{})
console.log(!!Infinity)
console.log(!!(isAtivo = true))  //se houve atribuição é true exceto se a atribuição for zero

console.log('os falsos')
console.log(!!0)
console.log(!!'')
console.log(!!null)
console.log(!!NaN)
console.log(!!undefined) 
console.log(!!(isAtivo = false))  //se o resultado for false, entao o resultado é false

console.log('pra finalizar')
console.log(!!('' || null || 0 || ' '))  //unico verdadeiro é o ultimo (retorna true)

let nome = ''  //foi false, entao retorna o true da operação
console.log(nome || 'Desconhecido')