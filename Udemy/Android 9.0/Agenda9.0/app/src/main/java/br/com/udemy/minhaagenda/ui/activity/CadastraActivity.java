package br.com.udemy.minhaagenda.ui.activity;

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

import br.com.udemy.minhaagenda.BuildConfig;
import br.com.udemy.minhaagenda.R;
import br.com.udemy.minhaagenda.data.dao.ContatoDao;
import br.com.udemy.minhaagenda.data.model.Contato;
import br.com.udemy.minhaagenda.utils.ImagemUtils;
import br.com.udemy.minhaagenda.utils.MascarasUtil;

public class CadastraActivity extends AppCompatActivity {

    public static final String PARAMETRO_CONTATO = "PARAMETRO CONTATO";
    private static final int CAMERA_REQUEST_CODE = 495;
    private Contato contato;
    private EditText viewNome;
    private EditText viewEmail;
    private EditText viewTelefone;
    private ImageView viewImagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra);


        viewNome = findViewById(R.id.cadastra_nome);
        viewEmail  = findViewById(R.id.cadastra_email);
        viewTelefone = findViewById(R.id.cadastra_telefone);
        viewImagem = findViewById(R.id.cadastra_imagem);

        Intent intent = getIntent();
        contato = new Contato();

        if(intent.hasExtra(PARAMETRO_CONTATO)){
            Contato contatoRecuperado = (Contato) intent.getSerializableExtra(PARAMETRO_CONTATO);  //OBRIGATÓRIO FAZER O CAST!
            contato = contatoRecuperado;
            popularTela();
        }

        MascarasUtil.colocaMascara(viewTelefone, "(NN) NNNNN-NNNN");

        viewImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarCamera();
            }
        });

    }

    private void chamarCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  //chama camera
        String caminhoImagem = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
        contato.setImagem(caminhoImagem);

        File foto = new File(caminhoImagem);


        intent.putExtra(
                MediaStore.EXTRA_OUTPUT,
                FileProvider.getUriForFile(
                        this, BuildConfig.APPLICATION_ID + ".provider", foto
                )

        );

        startActivityForResult(intent, CAMERA_REQUEST_CODE );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            ImagemUtils.setImagem(viewImagem, contato.getImagem());
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void popularTela() {
        viewNome.setText(contato.getNome());
        viewEmail.setText(contato.getEmail());
        viewTelefone.setText(contato.getTelefone());
        ImagemUtils.setImagem(viewImagem, contato.getImagem());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_cadastra_salva){
            salvarContato();
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvarContato() {

        pegaValoresTela();

        ContatoDao dao = new ContatoDao(this);
        if(contato.getId() == 0){
            dao.insere(contato);
        }else{
            dao.edita(contato);
        }
        dao.close();
        finish();  //encerra a activity
    }

    private void pegaValoresTela() {
        contato.setNome(viewNome.getText().toString());
        contato.setEmail(viewEmail.getText().toString());
        contato.setTelefone(viewTelefone.getText().toString());
    }
}
