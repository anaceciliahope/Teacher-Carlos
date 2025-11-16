package br.com.dti.teachercarlos.controller.dto;


import br.com.dti.teachercarlos.model.Disciplina;

public class MediaNotaDisciplinaDTO {

    public Disciplina disciplina;

    public Double media;

    public MediaNotaDisciplinaDTO(Disciplina disciplina, Double media) {
        this.disciplina = disciplina;
        this.media = media;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}