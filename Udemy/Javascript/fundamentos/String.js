const escola = "Cod3r";

//javascript não retorna muito erro, é bom testar antes na duvida:)
console.log(escola.charAt(4)); //'r'
// console.log(escola.charAt(5))  //retornou valor vazio

console.log(escola.charCodeAt(3));  //retorna o valor da tabela ascii
console.log(escola.indexOf('3'))  //se nao tiver retorna -1

console.log(escola.substring(1))  // od3R
console.log(escola.substring(0,3))  // Cod ( do zero e anda 3)
console.log('Escola '.concat(escola).concat('!'))  // concatena pode concatenar com + ou usando ``

//literal  é um valor nao armazenado em uma variável ex: 1  'Escola'
console.log(escola.replace(3, 'e'))  
console.log(escola.replace(/\d/g, 'e'))  //todos os números por 'e'
console.log('Maria333'.replace(/\d/, 'e'))  //substitui apenas o primeiro caso
console.log('Maria333'.replace(/\d/g, 'W')) //substitui TODOS os casos
 
console.log('Ana,Maria,Pedro'.split(/,/))  //separa e gera um array separando pelo parametro necessario

