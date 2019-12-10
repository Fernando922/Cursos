package br.com.udemy.a28_requisicoesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    private Button buttonRecuperar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonRecuperar = findViewById(R.id.btnRecuperar);
        txtResultado = findViewById(R.id.txtResultado);

        buttonRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask request = new MyTask();
                String urlApi = "https://blockchain.info/ticker";
                String cep = "14405039";
                String urlCep = "https://viacep.com.br/ws/" + cep + "/json/";
                request.execute(urlApi);
            }
        });

    }


    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            String stringUrl = strings[0];
            InputStream inputStream;
            InputStreamReader inputStreamReader;
            StringBuffer buffer = null;

            try {
                URL url = new URL(stringUrl);  //cria um objeto do tipo URL, caso seja malformada cai no catch
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();  //inicia uma conexão com o servidor, caso de algum problema vai cair
                inputStream = conexao.getInputStream(); //recuperar dados do servidor, mas ainda nao está no formato que vc precisa, está no formato de Bytes
                inputStreamReader = new InputStreamReader(inputStream); //le os dados em bytes e em seguida decodifica em caracteres
                BufferedReader reader = new BufferedReader(inputStreamReader);   //leitura dos caracteres do inputStreamReader
                buffer = new StringBuffer();
                String linha;
                while ((linha = reader.readLine()) != null) {                  //ler linha a linha e armazenar na StringBuffer
                    buffer.append(linha);
                }


            } catch (MalformedURLException e) {  //caso a url nao seja valida
                e.printStackTrace();
            } catch (IOException e) {  //pode ocorrer erro ao fazer a conexão com o servidor
                e.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);


//            String logradouro = null;
//            String cep = null;
//            String complemento = null;
//            String bairro= null;
//            String localidade = null;
//            String uf = null;
              String objetoValor = null;
              String valorMoeda = null;
              String simbolo = null;



            try {
                  //JSONObject jsonObject = new JSONObject(resultado); //converte a string para objeto json
//                logradouro = jsonObject.getString("logradouro"); //atribui o valor do logradouro para a variável criada
//                cep = jsonObject.getString("cep"); //atribui o valor do logradouro para a variável criada
//                complemento = jsonObject.getString("complemento"); //atribui o valor do logradouro para a variável criada
//                bairro = jsonObject.getString("bairro"); //atribui o valor do logradouro para a variável criada
//                localidade = jsonObject.getString("localidade"); //atribui o valor do logradouro para a variável criada
//                uf = jsonObject.getString("uf"); //atribui o valor do logradouro para a variável criada


                JSONObject jsonObject = new JSONObject(resultado); //converte a string para objeto json
                objetoValor = jsonObject.getString("BRL");


                JSONObject jsonObjectReal = new JSONObject(objetoValor);
                valorMoeda = jsonObjectReal.getString("last");
                simbolo = jsonObjectReal.getString("symbol");


            } catch (JSONException e) {  //sempre que acusar uma exception, o bloco de código deve pertencer a um try catch
                e.printStackTrace();
            }

            txtResultado.setText(simbolo + ":"  + valorMoeda);
            //txtResultado.setText(logradouro+" / "+cep+" / "+complemento+" / "+bairro+" / "+localidade+" / "+uf);
        }
    }
}
