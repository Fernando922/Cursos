let contador = 1;

while (contador <= 10) {
  console.log(contador);
  contador++;
}

//com for
for (let i = 1; i <= 10; i++) {
  console.log(`com for ${i}`);
}

//percorrendo um array 
let array = [2, 4, 5, 3, 6, 2];
for (let i = 1; i < array.length; i++) {
  console.log(`elemento do array ${array[i]}`);
}
