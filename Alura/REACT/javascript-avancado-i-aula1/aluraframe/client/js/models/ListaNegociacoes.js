class ListaNegociacoes {
  constructor(){
    this._negociacoes = []
  }


  adiciona(negociacao){
    this._negociacoes.push(negociacao)
  }

  get negociacoes(){
    //aquela mesma regra de programação defensiva lembra?
    //get retorna sua lista, porem pode-se usar esse método para alterar
    //sua lista interna, adicionar, remover, zerar a lista
    //por conta disso, como array se trata de objeto, vamos protege-lo
    //retornando um novo array copia do array original, com isso, se alguem
    //quiser fazer qualquer brincadeira, será feita no array cópia!!
    return [].concat(this._negociacoes);
  }

}