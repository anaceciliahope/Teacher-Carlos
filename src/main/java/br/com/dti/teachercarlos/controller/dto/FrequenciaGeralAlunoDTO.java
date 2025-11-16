package br.com.dti.teachercarlos.controller.dto;

public class FrequenciaGeralAlunoDTO {

    public FrequenciaGeralAlunoDTO(String nomeAluno, Double mediaFrequencia) {
        this.nomeAluno = nomeAluno;
        this.mediaFrequencia = mediaFrequencia;
    }

    private String nomeAluno;

    private Double mediaFrequencia;

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Double getMediaFrequencia() {
        return mediaFrequencia;
    }

    public void setMediaFrequencia(Double mediaFrequencia) {
        this.mediaFrequencia = mediaFrequencia;
    }
}