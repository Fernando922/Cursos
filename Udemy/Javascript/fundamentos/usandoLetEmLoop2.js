const funcs = []

for (let i = 0; i<10; i++){
  funcs.push(function(){
    console.log(i)
  })
}

funcs[2]()  // retorna 2
funcs[9]()  //retorna 9

//dessa forma o valor ficou em memória
