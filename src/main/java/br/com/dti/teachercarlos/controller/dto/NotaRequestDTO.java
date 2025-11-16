package br.com.dti.teachercarlos.controller.dto;


import br.com.dti.teachercarlos.model.Disciplina;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotaRequestDTO {


    @NotNull(message = "A Disciplina é Obrigatória")
    @Schema(description = "Disciplina da nota. Valores possíveis: MATEMATICA, PORTUGUES, CIENCIAS, ARTES, HISTORIA")
    private Disciplina disciplina;

    @NotNull(message = "A nota é obrigatória")
    @Min(value = 0, message = "A nota mínima é 0")
    @Max(value = 10, message = "A nota máxima é 10")
    private Integer valor;

    @NotNull(message = "A frequência é obrigatória")
    @Min(value = 0, message = "A frequência mínima é 0")
    @Max(value = 100, message = "A frequência máxima é 10")
    private Integer frequencia;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }
}