package br.com.udemy.requisicoeshttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnRecuperar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecuperar = findViewById(R.id.btnRecuperar);
        tvResultado = findViewById(R.id.tvResultado);

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask task = new MyTask();
                String urlApi = "https://blockchain.info/ticker";
                task.execute(urlApi);
            }
        });
    }

    class MyTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            StringBuffer buffer = null;

            try {  //obrigatorio ficar em try/catch
                URL url = new URL(stringUrl);
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                //recupera os dados em Bytes
                inputStream = conexao.getInputStream();

                //le os dados em bytes, e decodifica para caracteres
                inputStreamReader = new InputStreamReader(inputStream);


                //permite a leitura dos caracteres linha a linha
                BufferedReader reader = new BufferedReader(inputStreamReader);
                buffer = new StringBuffer();
                String linha;

                while( (linha = reader.readLine()) != null ){
                    buffer.append(linha);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {   //operação de entrada e saida de dados, pode ocorrer erro de conexão com o servidor, trate por aqui
                e.printStackTrace();
            }


            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);
            tvResultado.setText(resultado);
        }
    }
}
