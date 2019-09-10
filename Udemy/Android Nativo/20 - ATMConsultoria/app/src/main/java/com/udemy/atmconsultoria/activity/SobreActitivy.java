package com.udemy.atmconsultoria.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.udemy.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;


public class SobreActitivy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String descricao = "A ATM consultoria tem como missão apoiar organizações através da excêlencia em gestão e da busca pela qualidade. \n \n \n" +
                "Nosso trabalho é desenvolver qualquer coisa, e até escrever qualquer coisa só para preencher estas linhas mesmo e meu app ficar legal";

        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale Concosco")
                .addEmail("dipaula018@gmail.com", "entre em contato!")
                .addWebsite("http://google.com.br", "acesse nosso site")
                .addGroup("Redes sociais")
                .addFacebook("google", "Facebook")
                .addTwitter("google")
                .addPlayStore("google")
                .addInstagram("google")
                .create();

        setContentView(sobre);
    }
}
