const funcs = []

for (var i = 0; i<10; i++){
  funcs.push(function(){
    console.log(i)
  })
}

funcs[2]()  // retorna 10
funcs[9]()  //retorna 10

//porque o escopo de i é global