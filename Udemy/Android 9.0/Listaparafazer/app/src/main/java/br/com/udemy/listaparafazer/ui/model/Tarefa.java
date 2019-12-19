package br.com.udemy.listaparafazer.ui.model;

import java.io.Serializable;

public class Tarefa implements Serializable {
    private int id;
    private String descricao;
    private String imagem;
    private int excluido;


    public Tarefa() {
    }

    public Tarefa(int id, String descricao, String imagem, int excluido) {
        this.id = id;
        this.descricao = descricao;
        this.imagem = imagem;
        this.excluido = excluido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getExcluido() {
        return excluido;
    }

    public void setExcluido(int excluido) {
        this.excluido = excluido;
    }
}


