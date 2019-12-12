package br.com.udemy.a29retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.udemy.a29retrofit.api.CEPService;
import br.com.udemy.a29retrofit.api.DataService;
import br.com.udemy.a29retrofit.model.CEP;
import br.com.udemy.a29retrofit.model.Foto;
import br.com.udemy.a29retrofit.model.Postagem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    private Button btnRecuperar;
    private TextView txtResultado;
    private Retrofit retrofit;
    private List<Foto> listaFotos = new ArrayList<>();
    private DataService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnRecuperar = findViewById(R.id.btnRecuperar);
        txtResultado = findViewById(R.id.txtResultado);

        retrofit = new Retrofit.Builder()
                //.baseUrl("https://viacep.com.br/ws/")  //url base
                .baseUrl("https://jsonplaceholder.typicode.com")  //url base
                .addConverterFactory(GsonConverterFactory.create())  //escolha de conversor
                .build();  //criar o retrofit
        service = retrofit.create((DataService.class));

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recuperarCepRetrofit();
                //recuperarListaRetrofit();
                //salvarPostagem();
                //atualizarPostagem();
                removerPostagem();
            }
        });

    }

    private void removerPostagem(){
        Call<Void> call = service.removerPostagem(2);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    txtResultado.setText("Status: " + response.code());

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }


    private void atualizarPostagem(){
        Postagem postagem = new Postagem("1234", null, "Corpo postagem!");
        Call<Postagem> call = service.atualizarPostagem(2, postagem);

        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                Postagem postagemResposta = response.body();
                txtResultado.setText(
                        "Codigo "+ response.code() + "id: "
                                + postagemResposta.getId() + "titulo"
                                + postagemResposta.getTitle() + "userId" + postagemResposta.getUserId() +"body " + postagemResposta.getBody()
                );
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });
    }

    private void salvarPostagem(){


        //Configura objeto postagem
        Postagem postagem = new Postagem("1234", "Titulo postagem!", "Corpo postagem!");

        //recupera o serviço e salva a postagem
        DataService service = retrofit.create((DataService.class));
        Call<Postagem> call = service.salvarPostagem(postagem);


        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if(response.isSuccessful()){
                    Postagem postagemResposta = response.body();
                    txtResultado.setText(
                            "Codigo "+ response.code() + "id: " + postagemResposta.getId() + "titulo" + postagemResposta.getTitle()
                    );
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });

    }


    private void recuperarListaRetrofit(){
        DataService service = retrofit.create((DataService.class));
        Call<List<Foto>> call = service.recuperarFotos();
        call.enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                if(response.isSuccessful()){
                    listaFotos = response.body();

                    for(int i = 0; i<listaFotos.size(); i++){
                        Foto foto = listaFotos.get(i);
                        Log.d("Resultado", "resultado: " + foto.getId() + "/" + foto.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {

            }
        });
    }

    private void recuperarCepRetrofit(){
        CEPService cepService = retrofit.create(CEPService.class);
        Call<CEP> call = cepService.recuperarCEP("14406584");
        call.enqueue(new Callback<CEP>() {//é criada uma tarefa assincrona dentro de uma thread
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if(response.isSuccessful()){
                    CEP cep = response.body();  //foi convertido em um model de forma automática, já que os atributos batem
                    txtResultado.setText(cep.getLogradouro()+"/"+cep.getBairro());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });

    }


//    class MyTask extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//
////            String stringUrl = strings[0];
////            InputStream inputStream;
////            InputStreamReader inputStreamReader;
////            StringBuffer buffer = null;
////
////            try {
////                URL url = new URL(stringUrl);  //cria um objeto do tipo URL, caso seja malformada cai no catch
////                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();  //inicia uma conexão com o servidor, caso de algum problema vai cair
////                inputStream = conexao.getInputStream(); //recuperar dados do servidor, mas ainda nao está no formato que vc precisa, está no formato de Bytes
////                inputStreamReader = new InputStreamReader(inputStream); //le os dados em bytes e em seguida decodifica em caracteres
////                BufferedReader reader = new BufferedReader(inputStreamReader);   //leitura dos caracteres do inputStreamReader
////                buffer = new StringBuffer();
////                String linha;
////                while ((linha = reader.readLine()) != null) {                  //ler linha a linha e armazenar na StringBuffer
////                    buffer.append(linha);
////                }
////
////
////            } catch (MalformedURLException e) {  //caso a url nao seja valida
////                e.printStackTrace();
////            } catch (IOException e) {  //pode ocorrer erro ao fazer a conexão com o servidor
////                e.printStackTrace();
////            }
////
////            return buffer.toString();
//        }
//
//        @Override
//        protected void onPostExecute(String resultado) {
//            super.onPostExecute(resultado);
//
//
////            String logradouro = null;
////            String cep = null;
////            String complemento = null;
////            String bairro= null;
////            String localidade = null;
////            String uf = null;
//            String objetoValor = null;
//            String valorMoeda = null;
//            String simbolo = null;
//
//
//
//            try {
//                //JSONObject jsonObject = new JSONObject(resultado); //converte a string para objeto json
////                logradouro = jsonObject.getString("logradouro"); //atribui o valor do logradouro para a variável criada
////                cep = jsonObject.getString("cep"); //atribui o valor do logradouro para a variável criada
////                complemento = jsonObject.getString("complemento"); //atribui o valor do logradouro para a variável criada
////                bairro = jsonObject.getString("bairro"); //atribui o valor do logradouro para a variável criada
////                localidade = jsonObject.getString("localidade"); //atribui o valor do logradouro para a variável criada
////                uf = jsonObject.getString("uf"); //atribui o valor do logradouro para a variável criada
//
//
//                JSONObject jsonObject = new JSONObject(resultado); //converte a string para objeto json
//                objetoValor = jsonObject.getString("BRL");
//
//
//                JSONObject jsonObjectReal = new JSONObject(objetoValor);
//                valorMoeda = jsonObjectReal.getString("last");
//                simbolo = jsonObjectReal.getString("symbol");
//
//
//            } catch (JSONException e) {  //sempre que acusar uma exception, o bloco de código deve pertencer a um try catch
//                e.printStackTrace();
//            }
//
//            txtResultado.setText(simbolo + ":"  + valorMoeda);
//            //txtResultado.setText(logradouro+" / "+cep+" / "+complemento+" / "+bairro+" / "+localidade+" / "+uf);
//        }
//    }
}
