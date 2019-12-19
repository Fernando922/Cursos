package br.com.udemy.listaparafazer.ui.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

import br.com.udemy.listaparafazer.BuildConfig;
import br.com.udemy.listaparafazer.R;
import br.com.udemy.listaparafazer.ui.dao.TarefaDao;
import br.com.udemy.listaparafazer.ui.model.Tarefa;
import br.com.udemy.listaparafazer.ui.utils.Constants;
import br.com.udemy.listaparafazer.ui.utils.ImageUtils;

public class CadastraTarefa extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 495;
    private Tarefa tarefa;  //aqui vc declara nome e tipo e não instancia!
    private EditText etDescricao;
    private ImageView ivTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_tarefa);


        etDescricao = findViewById(R.id.etDescricao);
        ivTarefa = findViewById(R.id.ivTarefa);

        Intent intent = new Intent();
        tarefa = new Tarefa();

        if (intent.hasExtra(Constants.PARAMETRO_TAREFA)) {
            Tarefa tarefaRecuperada = (Tarefa) intent.getSerializableExtra(Constants.PARAMETRO_TAREFA);  //TEM QUE FAZER O CAST SEU ANIMAL!
            tarefa = tarefaRecuperada;
            popularTela();
        }

        ivTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarCamera();
            }
        });
    }

    private void popularTela() {
        etDescricao.setText(tarefa.getDescricao());
        exibirImagem();
    }

    private void exibirImagem() {
        ImageUtils.setImagem(ivTarefa, tarefa.getImagem());
    }


    private void chamarCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //abre a camera do dispositivo
        String caminhoImagem = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
        tarefa.setImagem(caminhoImagem);

        File foto = new File(caminhoImagem);

        intent.putExtra(
                MediaStore.EXTRA_OUTPUT,
                FileProvider.getUriForFile(
                        this, BuildConfig.APPLICATION_ID + ".provider", foto
                )
        );
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  //quando a camera fechar apos a foto
        if(requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            exibirImagem();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override  //cria o menu na toolbar do app como layout criado por voce em res/menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);  //inflater!!
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_cadastra_salva){
            salvarTarefa();
        }
        return super.onOptionsItemSelected(item);
    }


    private void salvarTarefa(){
        pegaValoresTela();
        TarefaDao dao = new TarefaDao(this);
        if(tarefa.getId() == 0){  //então é a primeira vez que vc cadastra
            dao.insere(tarefa);
        }else{
            dao.edita(tarefa);
        }
        dao.close();
        finish(); //encerra a activity
    }

    private void pegaValoresTela(){
        tarefa.setDescricao(etDescricao.getText().toString());
    }
}
