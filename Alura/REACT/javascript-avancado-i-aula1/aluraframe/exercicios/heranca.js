class Conta {

  constructor(saldo) {
      this._saldo = saldo;
  }

  get saldo() {
      return this._saldo;
  }

  atualiza(taxa) {
      throw new Error('Você deve sobrescrever o método ');
  }
}

class ContaCorrente extends Conta {
 

  atualiza(taxa){
    return this._saldo+taxa
  }

}

class ContaPoupanca extends Conta {

  atualiza(taxa){
    return this._saldo+(taxa*2)
  }

}

let c1 = new ContaCorrente(200)
let c2 = new ContaPoupanca(200)

console.log(c2.atualiza(200))