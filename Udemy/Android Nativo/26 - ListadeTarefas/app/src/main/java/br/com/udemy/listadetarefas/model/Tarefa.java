package br.com.udemy.listadetarefas.model;

import java.io.Serializable;

//ja que será enviado via intent, deve ser serializavel
public class Tarefa implements Serializable {
    private Long id;
    private String nomeTarefa;

    public Tarefa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
}
