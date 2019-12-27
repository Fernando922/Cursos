class ArquivoHelper {
  constructor(){
    throw new Error("Essa classe nao pode ser instanciada!")
  }


  static retornaArrayFormatado(text){
    return text.toUpperCase().split("/")
  }
}