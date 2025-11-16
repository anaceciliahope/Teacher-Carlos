package br.com.dti.teachercarlos.controller.dto;

public class MediaNotaAlunoDTO {

    public MediaNotaAlunoDTO(String nomeAluno, Double mediaNota) {
        this.nomeAluno = nomeAluno;
        this.mediaNota = mediaNota;
    }

    private String nomeAluno;

    private Double mediaNota;

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Double getMediaNota() {
        return mediaNota;
    }

    public void setMediaNota(Double mediaNota) {
        this.mediaNota = mediaNota;
    }
}