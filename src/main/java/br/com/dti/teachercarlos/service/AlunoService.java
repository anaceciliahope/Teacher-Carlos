package br.com.dti.teachercarlos.service;

import br.com.dti.teachercarlos.exception.AlunoException;
import br.com.dti.teachercarlos.model.Aluno;
import br.com.dti.teachercarlos.model.Disciplina;
import br.com.dti.teachercarlos.model.Nota;
import br.com.dti.teachercarlos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno cadastrarAluno(Aluno aluno) {
        validarAluno(aluno);
        aluno.getNotas().forEach(n -> n.setAluno(aluno));
        repository.save(aluno);
        return aluno;
    }

    private void validarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new AlunoException("Aluno não pode ser nulo");
        } else if (aluno.getNotas().size() != Disciplina.values().length) {
            throw new AlunoException("Favor informar todas as 5 disciplinas");
        } else {
            Map<String, Integer> msg = new HashMap<>();
            for (Nota n : aluno.getNotas()) {
                if (n.getValor() == null || n.getValor() < 0 || n.getValor() > 10) {
                    msg.put(n.getDisciplina().name(), n.getValor());
                }
                if (n.getFrequencia() == null || n.getFrequencia() < 0 || n.getFrequencia() > 100) {
                    msg.put(n.getDisciplina().name(), n.getFrequencia());
                }
            }
            if (!msg.isEmpty()) {
                throw new AlunoException(msg.toString());
            }
        }
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }
}