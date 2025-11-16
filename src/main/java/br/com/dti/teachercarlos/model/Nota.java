package br.com.dti.teachercarlos.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aluno aluno;

    private Integer frequencia;

    private Disciplina disciplina;
    private Integer valor;

    public Nota() {
        super();
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }

    public Nota(Disciplina disciplina, Integer valor) {
        this.disciplina = disciplina;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Integer getValor() {
        return valor;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nota)) return false;
        Nota nota = (Nota) o;
        return disciplina == nota.disciplina; // Só compara a disciplina!
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplina); // Só usa a disciplina!
    }
}