class Negociacao {
  constructor(data, quantidade, valor) {
    //é criado uma nova data dentro do construtor, utilizando como 
    // referencia a data passada no momento da instancia da classe, por que?
    // porque se o parametro passado na instancia da classe for uma variavel, 
    // e depois vc alterar o valor dessa variavel, fodeu meu amigo!
    // o valor da data do objeto mesmo ele estando estanciado vai mudar,
    // por isso estou criando um novo objeto aqui dentro
    this._data = new Date(data.getTime());
    this._quantidade = quantidade;
    this._valor = valor;
    
    Object.freeze(this)  //impede que os valores sejam alterados diretamente
  }


  //get antes da função permite o acesso da atributo diretamente na instancia
  //sem chamar qualquer método da função  ex: n1.volume   n1.quantidade
  get volume(){
    return this._quantidade * this._valor
  }

  get valor(){
    return this._valor
  }


  //programação defensiva, cada alteração que vc tentar fazer no objeto data instanciado
  //só será aplicado na nova data criada, e ao chamar o get data para visualizar, 
  //você verá a verdadeira data, coisa do capeta nao?

  //pq o Object.freeze só congela os atributos na superficie do seu objeto, 
  //se o seu objeto tem um atributo que é um objeto instanciado, nada te impede de alterar ele usando seus
  //métodos
  get data(){
    return new Date(this._data.getTime())
  }

  get quantidade(){
    return this._valor
  }
}


//underline é convenção para o programador que as propriedades só podem 
// ser acessadas pelos proprios métodos da classe!!!

//já o javascript não possui modificadores de acesso!!!




