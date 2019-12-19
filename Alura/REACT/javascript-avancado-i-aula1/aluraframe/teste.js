class Pessoa {
  constructor(nome, sobrenome){
    this.nome = nome
    this.sobrenome = sobrenome
  }

  retornaNome(){
    return `${this.nome} ${this.sobrenome}`
  }
}

let p1 = new Pessoa('Fernando', 'de Paula')
console.log(p1.retornaNome())


class Conta {
  constructor(titular, conta, saldo){
    this._titular = titular
    this._conta = conta
    this._saldo = saldo
  }

  depositar(valor){
    this._saldo+=valor
  }

  get titular(){
    return this._titular
  }

  get conta(){
    return this._conta
  }

  get saldo(){
    return this._saldo
  }

}

let c1 = new Conta('Fernando', '212141', 100)
c1.depositar(199)

console.log(c1)
console.log(c1.saldo)

var nome = 'Flávio';
var nome = 'Almeida';