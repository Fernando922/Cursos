package br.com.udemy.a29retrofit.api;

import java.util.List;

import br.com.udemy.a29retrofit.model.Foto;
import br.com.udemy.a29retrofit.model.Postagem;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DataService {

    @GET("/photos")
    Call<List<Foto>> recuperarFotos();


    @GET("/posts")
    Call<List<Postagem>> recuperarPostagens();


    @POST("/posts")
    Call<Postagem> salvarPostagem(@Body Postagem postagem);  //body define o corpo da requisição


//    //userId=1234&title=Titulo postado&body=Corpo postagem    método para xml
//    @FormUrlEncoded
//    @POST("/posts")
//    Call<Postagem> salvarPostagem(
//            @Field("userId") String userId,
//            @Field("title") String title,
//            @Field("body") String body
//    );



    @PUT("/posts/{id}")   //atualiza all the object, all the campos, a postagem antiga morre e é postada uma nova mantendo o ID, um novo objeto substitui o antigo
    Call<Postagem> atualizarPostagem(@Path("id") int id, @Body Postagem postagem);

    @PATCH("/posts/{id}")  //atualiza só os campos que vc enviar, se vc enviar um campo como nulo, ou nao enviar, ele não será atualizado
    Call<Postagem> atualizarPostagemPatch(@Path("id") int id, @Body Postagem postagem);


    @DELETE("/posts/{id}")
    Call<Void> removerPostagem(@Path("id") int id);
}
