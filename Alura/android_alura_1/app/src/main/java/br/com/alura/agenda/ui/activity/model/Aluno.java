package br.com.alura.agenda.ui.activity.model;
import android.support.annotation.NonNull;

public class Aluno {

    private final String nome;
    private final String telefone;
    private final String email;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return nome;
    }
}
