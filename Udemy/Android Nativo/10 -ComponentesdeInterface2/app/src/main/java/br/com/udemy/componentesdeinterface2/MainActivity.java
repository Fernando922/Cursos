package br.com.udemy.componentesdeinterface2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch swEstado;
    private ToggleButton tbEstado;
    private CheckBox cbEstado;
    private TextView textResultado, tvSeekBar;
    private ProgressBar pbBarra, pbCirculo;
    private SeekBar sbEscolha;
    private int progresso = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swEstado = findViewById(R.id.swLembrarSenha);
        tbEstado = findViewById(R.id.tbQualquer);
        cbEstado = findViewById(R.id.cbLembrarSenha);
        textResultado = findViewById(R.id.tvResultado);
        pbBarra = findViewById(R.id.pbBarra);
        pbCirculo = findViewById((R.id.pbCirculo));
        sbEscolha = findViewById(R.id.sbEscolha);
        tvSeekBar = findViewById(R.id.tvSeekResultado);


        pbCirculo.setVisibility(View.GONE);

        cbEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sua senha será lembrada!!", Toast.LENGTH_SHORT).show();
            }
        });

        sbEscolha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeekBar.setText("Escolha: " + seekBar.getProgress() + " de " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Escolha com carinho!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Excelente escolha!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void enviar(View view) {
        //verifica switch
//        if(swEstado.isChecked()){
//            textResultado.setText("Switch ligado!");
//        }else{
//            textResultado.setText("Switch desligado!");
//        }

        //verifica toggle
//        if(tbEstado.isChecked()){
//            textResultado.setText("Toogle ligado!");
//        }else{
//            textResultado.setText("Toogle desligado!");
//        }

        //verifica checkbox
        if (cbEstado.isChecked()) {
            textResultado.setText("CheckBox ligado!");
        } else {
            textResultado.setText("CheckBox desligado!");
        }
    }


    public void abrirToast(View view) {
        ImageView imagem = new ImageView(this);
        imagem.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(imagem);
        toast.show();
    }

    public void abrirAlert(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);


        dialog.setTitle("Título");
        dialog.setMessage("Mensagem");
        dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener() {  // a interface NAO ESTA SENDO INSTANCIADA, ESTÁ SENDO CRIADA UMA CLASSE ANONIMA QUE IMPLEMENTA A INTERFACE
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Sim foi pressionado", Toast.LENGTH_LONG).show();
            }
        });
        dialog.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Não foi pressionado!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setIcon(android.R.drawable.ic_delete);
        dialog.setCancelable(false);

        dialog.create();
        dialog.show();
    }


    public void carregar(View view) {
        pbCirculo.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {   //thread por si só nao atualiza interface
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {

                    final int progresso = i;
                    runOnUiThread(new Runnable() {   //agora sim
                        @Override
                        public void run() {
                            pbBarra.setProgress(progresso);
                            if(progresso == 100){
                                pbCirculo.setVisibility(View.GONE);
                            }
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
