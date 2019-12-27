function exibeLista(lista){
  lista.forEach(element => {
    console.log(element)
  });
}

lista1 = ["Fernando", "Maria", "Joao"]
lista2 = ["Joaquim", "Outra Maria", "Pedro"]

exibeLista([].concat(lista1, lista2, "mais outro"))