package br.com.udemy.threads;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button botaoIniciar;
    private int numero;
    private Handler handler = new Handler();
    private Boolean pararExecucao = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoIniciar = findViewById(R.id.btnIniciar);


    }

    public void iniciarThread(View view) {

//        for (int i = 0; i <= 15; i++) {     //vai rodar na principal, o app é travado
//            Log.d("THREAD", "iniciarThread: " + i);
//
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }

        //MyThread thread = new MyThread();   //nao atrapalha a execução da thread principal
        //thread.start();
        pararExecucao = false;
        MyRunnable runnable = new MyRunnable();  //uso mais indicado já que vc pode fazer alterações na instancia antes de executar
        new Thread(runnable).start();
        //runnable.run();
    }

    public void pararThread(View view) {
        pararExecucao = true;

    }

//    class MyThread extends Thread {
//        @Override
//        public void run() {
//            for (int i = 0; i <= 15; i++) {
//                Log.d("THREAD", "iniciarThread: " + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }



    class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 15; i++) {
                if(pararExecucao)  //mata o for
                    return;
                numero = i;
//                runOnUiThread(new Runnable() { //uma thread criada pelo usuário nao pode alterar a principal, mais simples de escrever
//                    @Override
//                    public void run() { //só por aqui vc altera a thread principal
//                        botaoIniciar.setText("Contador: " + numero);
//                    }
//                });

                handler.post(new Runnable() {  //mesa forma da anterior, permite personalização
                    @Override
                    public void run() {
                        botaoIniciar.setText("Contador: " + numero);
                    }
                });

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
