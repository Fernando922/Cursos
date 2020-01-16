console.log(typeof Object)  // function
console.log(typeof new Object)  // object

const Cliente = function(){}
console.log(typeof Cliente)
console.log(typeof new Cliente)  // object
 
class Produto {}  // uma classe, internamente é uma função
console.log(typeof Produto)
console.log(typeof new Produto())


// uma função instanciada é um objeto
// funções podem ter atributos e comportamentos e podem ser instanciadas