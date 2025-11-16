package br.com.dti.teachercarlos.service;

import br.com.dti.teachercarlos.controller.dto.FrequenciaGeralAlunoDTO;
import br.com.dti.teachercarlos.controller.dto.MediaNotaAlunoDTO;
import br.com.dti.teachercarlos.controller.dto.MediaNotaDisciplinaDTO;
import br.com.dti.teachercarlos.repository.AlunoRepository;
import br.com.dti.teachercarlos.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private NotaRepository notaRepository;

    public List<MediaNotaAlunoDTO> findMediaNotasPorAluno() {
        return repository.findMediaNotasPorAluno();
    }

    public List<FrequenciaGeralAlunoDTO> findFrequenciaGeralPorAluno() {
        return repository.findFrequenciaGeralPorAluno();
    }

    public List<MediaNotaDisciplinaDTO> findMediaTurmaPorDisciplina() {
        return repository.findMediaNotaPorDisciplina();
    }

    public List<MediaNotaAlunoDTO> findMediaNotaACimaTurma() {
        Double mediaTurma = repository.findMediaNotasDeTodosAlunos();
        return repository.findMediaNota(mediaTurma);
    }

    public List<MediaNotaAlunoDTO> findFrequenciaBaixa() {
        return repository.findFrequenciaBaixa(75.0);
    }
}