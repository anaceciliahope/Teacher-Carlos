package br.com.dti.teachercarlos.controller;

import br.com.dti.teachercarlos.controller.dto.FrequenciaGeralAlunoDTO;
import br.com.dti.teachercarlos.controller.dto.MediaNotaAlunoDTO;
import br.com.dti.teachercarlos.controller.dto.MediaNotaDisciplinaDTO;
import br.com.dti.teachercarlos.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService service;

    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @GetMapping("/media-notas-por-aluno")
    public List<MediaNotaAlunoDTO> calcularMediaNotasPorAluno() {
        return this.service.findMediaNotasPorAluno();
    }

    @GetMapping("/media-turma-por-disciplina")
    public List<MediaNotaDisciplinaDTO> calcularMediaTurmaPorDisciplina() {
        return this.service.findMediaTurmaPorDisciplina();
    }

    @GetMapping("/frequencia-por-aluno")
    public List<FrequenciaGeralAlunoDTO> calcularFrequenciaGeralPorAluno() {
        return this.service.findFrequenciaGeralPorAluno();
    }

    @GetMapping("/alunos-a-cima-da-media")
    public List<MediaNotaAlunoDTO> calcularMediaNotaACimaTurma() {
        return this.service.findMediaNotaACimaTurma();
    }

    @GetMapping("/alunos-baixa-frequencia")
    public List<MediaNotaAlunoDTO> calcularFrequenciaABaixo75() {
        return this.service.findFrequenciaBaixa();
    }

}