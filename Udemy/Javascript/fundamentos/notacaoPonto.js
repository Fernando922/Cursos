console.log(Math.ceil(6.1));

const obj1 = {};
obj1.nome = "Bola";
//  obj1['nome'] = 'Bola'  -> outra forma, mas não é recomendada, é feio
console.log(obj1.nome);

function Obj(nome) {
  this.nome = nome; // o nome associado ao objeto que será estanciado (this.nome), é um atributo público
  this.exec = function() {
    console.log("Exec....");
  };
}

//this mantem o atribuito fora da do escopo da função assim que for instanciada!

const obj2 = new Obj("Cadeira");
console.log(obj2.nome);
obj2.exec();

//notação ponto, vc acessa atributos do objeto,
// voce acessa os membros de uma função, ou objeto a partir da notação ponto
