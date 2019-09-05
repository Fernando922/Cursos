package com.udemy.passandodadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);


                //instanciar um objeto
                Usuario user = new Usuario("Fernando", "dipaula018@gmail.com");

                intent.putExtra("nome", "Fernando");
                intent.putExtra("numero", 27);
                intent.putExtra("objeto", user);
                startActivity(intent);
            }
        });

    }

    public void trocarPagina(){

    }
}

//intent significa INTENÇÃO, "o que vc quer fazer?"
//intent serve para outras coisas, utilizar camera, bluetooth etc.
//intent serve para abrir um pdf por exemplo