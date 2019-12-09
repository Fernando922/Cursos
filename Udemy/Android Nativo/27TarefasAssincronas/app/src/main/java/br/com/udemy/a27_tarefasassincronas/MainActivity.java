package br.com.udemy.a27_tarefasassincronas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = findViewById(R.id.progressBar);
    }

    public void iniciarAsyncTask(View view){
        MyAsyncTask task = new MyAsyncTask();
        task.execute(10,15);
    }


    /*
    * 1 - Parâmetro a ser passado para a classe (é o que será passado para o doInBackground)
    * 2 - Tipo de valor que será utilizado para o progresso da tarefa
    * 3 - Retorno após tarefa finalizada
    *  Qualquer valor que você nao desejar passar, deve ser passado como VOID
    * */
    class MyAsyncTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected void onPreExecute() {  //EXECUTADO NA UITHREAD
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {  // ... significa varArgs, vc pode passar vários argumentos que serão convertidos em um array
            int numero = integers[0];
            int numero2 = integers[1];
            for(int i = 0;i<numero;i++){
                publishProgress(i);  //pode-se passar vários parâmetros, que serão capturados por um array
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finalizado";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {  //recuperando o S e exibindo no toast
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }

    }
}



//classe Asynctask
//facilita a comunicação entre a Thread criada e a ui Thread
//com essa classe vc nao precisa se preocupar em criar threads


//quando vc extende sua classe vc tem que sobrescrever seus métodos


//doInBackground()  -> executado em uma nova thread (processamento mais pesado)  é o único obrigatorio a ser sobrescrito
//onPreExecute()  -> é chamado antes de tudo
//onProgressUpdate() -> é executado durante seu processamento
//OnPostExecute() -> é chamado apos a tarefa ser finalizada


//order de execução

//onPreExecute()
// doInBackground()  onProgressUpdate()
// onPostExecute()
