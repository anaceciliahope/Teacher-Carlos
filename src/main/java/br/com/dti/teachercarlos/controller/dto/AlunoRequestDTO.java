package br.com.dti.teachercarlos.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class AlunoRequestDTO {

    @Valid
    private List<NotaRequestDTO> notas;

    @NotEmpty
    private String nome;

    public List<NotaRequestDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaRequestDTO> notas) {
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}