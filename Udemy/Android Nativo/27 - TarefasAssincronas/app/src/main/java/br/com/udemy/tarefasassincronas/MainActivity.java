package br.com.udemy.tarefasassincronas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }

    public void iniciarAsyncTask(View view) {
        MyAsyncTask task = new MyAsyncTask();
        task.execute(10, 15);
    }
    /* 1 - Parâmetro a ser passado para a classe
       2 - Tipo de valor que será utilizado para o progresso da tarefa
       3 - Retorno após tarefa finalizada
       (void é valor vazio)
     */


    class MyAsyncTask extends AsyncTask<Integer, Integer, String> { //entrada, progresso, retorno
        //na ordem de execução (onprogress é junto com doInBackground)

        @Override
        protected void onPreExecute() {  //configurações iniciais, não deve ser nada pesado!
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {    //3 pontos permite vários parametros (var args é o nome do conceito) vc passa separando por virgula
            //para recuperar é por tipo de array  ex: String nome = string[0]


            int numero = integers[0];
            int numero2 = integers[1];
            for (int i = 0; i <= numero; i++) {
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return "Finalizado";   //é exibido no post execute
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            progressBar.setProgress(0);
            progressBar.setVisibility(View.INVISIBLE);
        }


    }


}
