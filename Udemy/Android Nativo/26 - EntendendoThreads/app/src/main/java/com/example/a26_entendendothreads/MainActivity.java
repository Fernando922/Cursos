package com.example.a26_entendendothreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        private Button botaoIniciar;
        private Button botaoParar;
        private int cont;
        private Handler handler = new Handler();  //permite enviar codigos para serem executados em uma thread ou enviar mensagens de uma thread para outra
        private boolean pararExecucao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoIniciar = findViewById(R.id.buttonIniciar);
        botaoParar = findViewById(R.id.buttonParar);
    }


    //nunca execute nada na thread principal
    public void iniciarThread(View view){
        //MyThread thread = new MyThread();  //executando a nova thread criada!
        //thread.start();
        pararExecucao = false;
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }

    public void pararThread(View view){
        pararExecucao = true;
    }

    class MyRunnable implements Runnable{ //nao é restrita do android
        @Override
        public void run() {

            for (int i = 0; i<=15; i++){
                if(pararExecucao)
                    return;

                cont = i;
                //esta é uma forma de alterar a UI thread


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        botaoIniciar.setText("Contador " + cont);
                    }
                });


//                runOnUiThread(new Runnable() {  //assim você pode alterar a thread principal
//                    @Override
//                    public void run() {
//                        botaoIniciar.setText("Contador " + cont);
//                    }
//                });


                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
            }
        }
    }


    class MyThread extends Thread{  //não é restrita do android!
        @Override
        public void run() {
            for (int i = 0; i<=15; i++){
                Log.d("Thread", "iniciarThread: " + i);
                try{
                    Thread.sleep(1000);

                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
            }
        }
    }
}

//você pode criar uma nova thread utilizando a classe thread sobrescrevendo o methodo run
// ou criar uma classe que implementa o runnable e executar cirando uma nova thread passando
// o runnable criado como parâmetro!

//A classe Thread utiliza o run() de Runnable já que ela implementa a interface Runnable!


//Utilizando a classe Thread vc já executada o metodo run() da interface runnable
//A diferença é que criando um runnable vc pode criar novas funcionalidades antes de executar a nova thread

//É uma recomendação vc criar um runnable, já que você pode fazer alterações nele antes de executar


//alterações na ui thread

//você nunca poderá fazer qualquer alteração na ui thread a partir de uma thread criada
//o app crasha na hora mano

//o android trava por padrão por questão de concorrência e segurança, para que nao tenhamos várias threads
//querendo alterar a interface

//toda thread trabalha com fila de execução, que é gerenciado pelo proprio android
//no caso do handler a thread que vai receber o codigo é a thread principal já que nesse caso
//o handler foi instanciado dentro dele
// o codigo recebido sempre será para a thread onde o handler foi instanciado


//runOnUiThread utiliza um handler da mesma forma, então tanto faz usar ele ou a instancia da classe Handler
//a diferença é que ao utilizar um handler você pode fazer alterações em sua execução, ou seja, você
//pode até programar quando vc quer que aquele bloco de código seja executado

//mas o mais comum mesmo de utilizar é o runOnUiThread!!!!!! É mais rápido e mais legivel o seu código


