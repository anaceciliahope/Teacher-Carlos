package br.com.dti.teachercarlos.service;

import br.com.dti.teachercarlos.controller.dto.FrequenciaGeralAlunoDTO;
import br.com.dti.teachercarlos.controller.dto.MediaNotaAlunoDTO;
import br.com.dti.teachercarlos.controller.dto.MediaNotaDisciplinaDTO;
import br.com.dti.teachercarlos.repository.AlunoRepository;
import br.com.dti.teachercarlos.repository.NotaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RelatorioServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @Mock
    private NotaRepository notaRepository;

    @InjectMocks
    private RelatorioService relatorioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve retornar a média das notas por aluno")
    void testFindMediaNotasPorAluno() {
        List<MediaNotaAlunoDTO> mockList = List.of(new MediaNotaAlunoDTO(null, null), new MediaNotaAlunoDTO(null, null));
        when(alunoRepository.findMediaNotasPorAluno()).thenReturn(mockList);

        List<MediaNotaAlunoDTO> result = relatorioService.findMediaNotasPorAluno();

        assertEquals(2, result.size());
        verify(alunoRepository, times(1)).findMediaNotasPorAluno();
    }

    @Test
    @DisplayName("Deve retornar a frequência geral por aluno")
    void testFindFrequenciaGeralPorAluno() {
        List<FrequenciaGeralAlunoDTO> mockList = Collections.singletonList(new FrequenciaGeralAlunoDTO(null, null));
        when(alunoRepository.findFrequenciaGeralPorAluno()).thenReturn(mockList);

        List<FrequenciaGeralAlunoDTO> result = relatorioService.findFrequenciaGeralPorAluno();

        assertEquals(1, result.size());
        verify(alunoRepository, times(1)).findFrequenciaGeralPorAluno();
    }

    @Test
    @DisplayName("Deve retornar a média da turma por disciplina")
    void testFindMediaTurmaPorDisciplina() {
        List<MediaNotaDisciplinaDTO> mockList = Collections.singletonList(new MediaNotaDisciplinaDTO(null, null));
        when(alunoRepository.findMediaNotaPorDisciplina()).thenReturn(mockList);

        List<MediaNotaDisciplinaDTO> result = relatorioService.findMediaTurmaPorDisciplina();

        assertEquals(1, result.size());
        verify(alunoRepository, times(1)).findMediaNotaPorDisciplina();
    }

    @Test
    @DisplayName("Deve retornar alunos com média acima da média da turma")
    void testFindMediaNotaACimaTurma() {
        Double mediaTurma = 7.0;
        List<MediaNotaAlunoDTO> mockList = Arrays.asList(new MediaNotaAlunoDTO(null, null));
        when(alunoRepository.findMediaNotasDeTodosAlunos()).thenReturn(mediaTurma);
        when(alunoRepository.findMediaNota(mediaTurma)).thenReturn(mockList);

        List<MediaNotaAlunoDTO> result = relatorioService.findMediaNotaACimaTurma();

        assertEquals(1, result.size());
        verify(alunoRepository).findMediaNotasDeTodosAlunos();
        verify(alunoRepository).findMediaNota(mediaTurma);
    }

    @Test
    @DisplayName("Deve retornar alunos com frequência baixa")
    void testFindFrequenciaBaixa() {
        List<MediaNotaAlunoDTO> mockList = List.of(new MediaNotaAlunoDTO(null, null));
        when(alunoRepository.findFrequenciaBaixa(75.0)).thenReturn(mockList);

        List<MediaNotaAlunoDTO> result = relatorioService.findFrequenciaBaixa();

        assertEquals(1, result.size());
        verify(alunoRepository).findFrequenciaBaixa(75.0);
    }
}