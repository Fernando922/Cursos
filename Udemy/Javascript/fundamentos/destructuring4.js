function rand([min = 0, max = 1000]){
  if(min> max) [min,max] = [max, min]  //os array é invertido
  const valor = Math.random() * (max-min) + min
  return Math.floor(valor)
}

console.log(rand([50, 40]))
console.log(rand([992]))    // min 992 maxx 1000
console.log(rand([, 10]))  // 0 e 10
console.log(rand([]))  // 0 e 1000