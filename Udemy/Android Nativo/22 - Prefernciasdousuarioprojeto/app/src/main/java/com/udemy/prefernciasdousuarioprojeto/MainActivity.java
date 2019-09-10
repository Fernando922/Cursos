package com.udemy.prefernciasdousuarioprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";   //sempre será o mesmo independente da instancia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonSalvar = findViewById(R.id.btnSalvar);
        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.tvResultado);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);  //Zero é modo privado, apenas o app tem acesso
                SharedPreferences.Editor editor = preferences.edit();

                //validar o nome
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Digite seu nome!", Toast.LENGTH_SHORT).show();
                }else{

                    //salvar os dados
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();  //só aqui salva corretamente
                    textResultado.setText("Olá, " + nome);
                }
            }
        });

        //recuperar os dados

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);  //Zero é modo privado, apenas o app tem acesso

        //valida se tem o nome em preferencias
        if(preferences.contains("nome")){
            String nome = preferences.getString("nome", "Anônimo");
            textResultado.setText("Olá, " + nome);
        }else{
            textResultado.setText("Olá, usuario não definido!");
        }

    }
}
