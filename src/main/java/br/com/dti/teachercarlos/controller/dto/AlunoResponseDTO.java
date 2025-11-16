package br.com.dti.teachercarlos.controller.dto;

import java.util.List;

public class AlunoResponseDTO {

    private Long id;
    private List<NotaResponseDTO> notas;
    private String nome;

    public List<NotaResponseDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaResponseDTO> notas) {
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}