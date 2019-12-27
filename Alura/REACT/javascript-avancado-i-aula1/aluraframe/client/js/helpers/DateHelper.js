class DateHelper {
  constructor() {
    throw new Error("Esta classe nao pode ser instanciada");
  }

  //um método estático pode ser utilizado sem estanciar a classe!
  static textoParaData(texto) {
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
    if (!/^\d{4}-\d{2}-\d{2}$/.test(texto)) {
      throw new Error("Deve estar no formato aaaa-mm-dd");
    }
    return new Date(
      ...texto.split("-").map((item, index) => item - (index % 2))
    ); //comparção pelo resto da divisão, ousado
  }

  static dataParaTexto(data) {
    return `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`;
  }
}
