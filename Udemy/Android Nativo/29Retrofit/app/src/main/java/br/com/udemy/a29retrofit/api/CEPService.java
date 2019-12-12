package br.com.udemy.a29retrofit.api;

import br.com.udemy.a29retrofit.model.CEP;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {  //call é uma chamada ao servidor web que retornará uma resposta


    @GET("{cep}/json")
    Call<CEP> recuperarCEP(@Path("cep") String cep);  //uma call que retorna um model do tipo CEP, o model vc cria, poderia ser uma lista tb

    //path é para a lib saber que vc passou parametro e aplicar ele na url



//   exemplo:
//    @GET("/fotos")
//    Call<FOTO> recuperarFotos();  //uma call que retorna um model do tipo CEP, o model vc cria, poderia ser uma lista tb
}
