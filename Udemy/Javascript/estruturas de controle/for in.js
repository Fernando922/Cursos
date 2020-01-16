const notas = [2, 4, 323, 54, 4, 2];

for (let i in notas) {
  console.log(notas[i]);
}

const pessoa = {
  nome: "Fernando",
  sobrenome: "de Paula",
  idade: 27,
  peso: 90
};

for (let atributo in pessoa) {
  //declare com let para o escopo ficar aqui dentro
  console.log(`${atributo} - ${pessoa[atributo]}`);
}
