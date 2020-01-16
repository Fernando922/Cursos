// referencia e valor

//uma variável não contem um objeto, ela armazena o endereço que o objeto está localizado

const a = { name: "teste" };
b = a;
b.name = "Maria";
console.log(a); //imprime maria

//quando são valores primitivos, a cópia é feita por valor e os valores são independentes!

let ab = 3;
let gh = ab;

gh++;

console.log(gh); //4
console.log(ab); //mantem os 3
