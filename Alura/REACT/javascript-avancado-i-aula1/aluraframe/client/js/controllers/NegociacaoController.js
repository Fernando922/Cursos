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
    this._listaNegociacoes = new ListaNegociacoes()
    this._negociacoesView = new NegociacoesViews($("#negociacoesView"))


    this._negociacoesView.update(this._listaNegociacoes)
  }

  adiciona(event) {
    event.preventDefault();  //impede que a pagina seja atualizada!
    this._listaNegociacoes.adiciona(this._criaNegociacao())
    this._negociacoesView.update(this._listaNegociacoes)
    this._limpaFormulario()
  }

  _criaNegociacao(){
    return new Negociacao(
      DateHelper.textoParaData(this._inputData.value),
      this._inputQuantidade.value,
      this._inputValor.value
    );
  }

  _limpaFormulario(){
    this._inputData.value=""
    this._inputQuantidade.value=1
    this._inputValor.value=""

    this._inputData.focus()
  }
}
