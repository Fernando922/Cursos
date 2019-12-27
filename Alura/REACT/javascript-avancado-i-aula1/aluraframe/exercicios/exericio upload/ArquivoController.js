class ArquivoController {

  constructor() {
      this._inputDados = document.querySelector('.dados-arquivo');
  }


  envia() {
      //cria um Arquivo com as suas propriedades;
      let dadosFormatados = ArquivoHelper.retornaArrayFormatado(this._inputDados.value)
      let arquivo = new Arquivo(...dadosFormatados)
      this._limpaFormulario();
      console.log(arquivo.nome)
      console.log(arquivo.tamanho)
      console.log(arquivo.tipo)
      // exibe mensagem no console com os dados do arquivo.
  }

  _limpaFormulario() {
      this._inputDados.value = '';
      this._inputDados.focus();
  }
}