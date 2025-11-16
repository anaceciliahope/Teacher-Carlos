package br.com.dti.teachercarlos.model;

public enum Disciplina {

    PORTUGUES("Português"),
    MATEMATICA("Matemática"),
    CIENCIAS("Ciências"),
    ARTES("Artes"),
    HISTORIA("História");

    private final String descricao;

    Disciplina(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}