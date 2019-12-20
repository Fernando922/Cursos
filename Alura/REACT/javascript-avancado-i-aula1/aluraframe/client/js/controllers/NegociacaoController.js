class NegociacaoController {
  //o método constructor já pega todas as referencias do DOM e armazena
  //nos atributos da classe a partir do seu construtor, por que?
  // porque o acesso a DOM não é tão performático assim, não é bom ficar
  // acessando a DOM toda hora, então neste caso, acessamos apenas uma vez mano

  constructor() {
    //.bind para manter o contexto do document, mesmo que o
    // queryselector esteja dentro de um novo contexto que é o dolar
    //sim, foi armazenado no dolar para vc nao ficar escrevendo codigo
    // é viadagem? eu achei, mas está seguindo mais ou menos o modo que o JQuery
    // funciona
    let $ = document.querySelector.bind(document);
    this._inputData = $("#data");
    this._inputQuantidade = $("#quantidade");
    this._inputValor = $("#valor");
  }

  adiciona(event) {
    event.preventDefault();

    let negociacao = new Negociacao(
      //this._inputData.value,
      // a forma acima logicamente vai dar erro, pq a classe espera uma instancia do
      // tipo data, e vc passou uma string '2019-11-01' por exemplo, o model espera uma
      // instancia de uma classe para  utilizar o metodo getTime(), então vc deve passar um
      // new Date() passando sua string retornada do input substituindo o "-" por ",", questão
      // de compatibilidade de data, a data vai vir errada se for com traço, então o exemplo
      // abaixo agora está certinho!!!

      //"2019-11-01" errado
      //"2019,11,01" certo, já que o new Date() faz um split por virgula automaticamente, e ele aceita
      //um array de ano, mes e dia, como parametro
      //2019, 11, 01 é retornado dezembro, já que segue contanto a partir do 0 ao 11 seus meses

      new Date(
        ...this._inputData.value.split("-").map((item, index) => item - (index % 2)) //comparção pelo resto da divisão, ousado
      ), //é subtraido via subtração implicita o mes em uma unidade ( 0 janeiro, 11 dezembro)
      this._inputQuantidade.value,
      this._inputValor.value
    );

    //adicionar negociação em uma lista!!
    console.log(negociacao);
  }
}
