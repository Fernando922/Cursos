package br.com.udemy.a29retrofit.api;

import java.util.List;

import br.com.udemy.a29retrofit.model.Foto;
import br.com.udemy.a29retrofit.model.Postagem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("/photos")
    Call<List<Foto>> recuperarFotos();


    @GET("/posts")
    Call<List<Postagem>> recuperarPostagens();
}
