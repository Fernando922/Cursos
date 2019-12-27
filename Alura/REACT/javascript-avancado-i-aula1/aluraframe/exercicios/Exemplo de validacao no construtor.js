class Codigo {
  constructor(codigo) {
    //ja valida na hora de instanciar, senao nem valida
    if(!this._valida(codigo)) throw new Error("Não é um código valido")
    this._valor = codigo;
  }

  get valor() {
    return this._valor;
  }


  _valida(texto){
    return /\D{3}-\D{2}-\d{2}/.test(texto)
  }
}

let codigo1 = new Codigo('GWZ-JJ-12'); // válido
console.log(codigo1.valor);
let codigo2 = new Codigo('1X1-JJ-12'); // inválido
console.log(codigo2.texto);
