package br.com.dti.teachercarlos.service;

import br.com.dti.teachercarlos.exception.AlunoException;
import br.com.dti.teachercarlos.model.Aluno;
import br.com.dti.teachercarlos.model.Disciplina;
import br.com.dti.teachercarlos.model.Nota;
import br.com.dti.teachercarlos.repository.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // 1. Cadastro com sucesso
    @Test
    @DisplayName("Deve cadastrar o aluno com sucesso.")
    void deveCadastrarAlunoComSucesso() {
        Aluno aluno = new Aluno();
        Set<Nota> notas = new HashSet<>();
        for (Disciplina d : Disciplina.values()) {
            Nota n = new Nota();
            n.setDisciplina(d);
            n.setValor(8);
            n.setFrequencia(90);
            notas.add(n);
        }
        aluno.setNotas(notas);

        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        Aluno resultado = alunoService.cadastrarAluno(aluno);

        assertNotNull(resultado);
        verify(alunoRepository, times(1)).save(aluno);
    }

    // 2. Aluno nulo
    @Test
    @DisplayName("Deve levantar uma exceção quando o aluno for nulo")
    void deveLancarExcecaoQuandoAlunoForNulo() {
        AlunoException ex = assertThrows(AlunoException.class, () -> alunoService.cadastrarAluno(null));
        assertEquals("Aluno não pode ser nulo", ex.getMessage());
    }

    // 3. Disciplinas incompletas
    @Test
    @DisplayName("Deve levantar uma exceção quando as disciplinas estiverem incompletas")
    void deveLancarExcecaoQuandoDisciplinasIncompletas() {
        Aluno aluno = new Aluno();
        Set<Nota> notas = new HashSet<>();
        // Adiciona só 2 disciplinas, mas o correto são todas
        for (int i = 0; i < 2; i++) {
            Nota n = new Nota();
            n.setDisciplina(Disciplina.values()[i]);
            n.setValor(7);
            n.setFrequencia(80);
            notas.add(n);
        }
        aluno.setNotas(notas);

        AlunoException ex = assertThrows(AlunoException.class, () -> alunoService.cadastrarAluno(aluno));
        assertEquals("Favor informar todas as 5 disciplinas", ex.getMessage());
    }

    // 4. Nota inválida (menor que 0)
    @Test
    @DisplayName("Deve levantar quando a nota for menor que zero")
    void deveLancarExcecaoQuandoNotaMenorQueZero() {
        Aluno aluno = new Aluno();
        Set<Nota> notas = new HashSet<>();
        for (Disciplina d : Disciplina.values()) {
            Nota n = new Nota();
            n.setDisciplina(d);
            n.setValor(-1); // valor inválido!
            n.setFrequencia(90);
            notas.add(n);
        }
        aluno.setNotas(notas);

        AlunoException ex = assertThrows(AlunoException.class, () -> alunoService.cadastrarAluno(aluno));
        assertTrue(ex.getMessage().contains("-1"));
    }

    // 5. Nota inválida (maior que 10)
    @Test
    @DisplayName("Deve levantar uma exceção quando a nota for maior que 10")
    void deveLancarExcecaoQuandoNotaMaiorQueDez() {
        Aluno aluno = new Aluno();
        Set<Nota> notas = new HashSet<>();
        for (Disciplina d : Disciplina.values()) {
            Nota n = new Nota();
            n.setDisciplina(d);
            n.setValor(11); // valor inválido!
            n.setFrequencia(90);
            notas.add(n);
        }
        aluno.setNotas(notas);

        AlunoException ex = assertThrows(AlunoException.class, () -> alunoService.cadastrarAluno(aluno));
        assertTrue(ex.getMessage().contains("11"));
    }

    // 6. Frequência inválida (menor que 0)
    @Test
    @DisplayName("Deve lavantar uma exceção quando a fraquência for menor que zero")
    void deveLancarExcecaoQuandoFrequenciaMenorQueZero() {
        Aluno aluno = new Aluno();
        Set<Nota> notas = new HashSet<>();
        for (Disciplina d : Disciplina.values()) {
            Nota n = new Nota();
            n.setDisciplina(d);
            n.setValor(8);
            n.setFrequencia(-5); // frequência inválida!
            notas.add(n);
        }
        aluno.setNotas(notas);

        AlunoException ex = assertThrows(AlunoException.class, () -> alunoService.cadastrarAluno(aluno));
        assertTrue(ex.getMessage().contains("-5"));
    }

    // 7. Frequência inválida (maior que 100)
    @Test
    @DisplayName("Deve leventar uma exceção quando a frequência for maior que 100")
    void deveLancarExcecaoQuandoFrequenciaMaiorQueCem() {
        Aluno aluno = new Aluno();
        Set<Nota> notas = new HashSet<>();
        for (Disciplina d : Disciplina.values()) {
            Nota n = new Nota();
            n.setDisciplina(d);
            n.setValor(8);
            n.setFrequencia(120); // frequência inválida!
            notas.add(n);
        }
        aluno.setNotas(notas);

        AlunoException ex = assertThrows(AlunoException.class, () -> alunoService.cadastrarAluno(aluno));
        assertTrue(ex.getMessage().contains("120"));
    }

    // 8. Nota ou frequência null
    @Test
    @DisplayName("Deve levantar uma exceção quando a frequência for nula")
    void deveLancarExcecaoQuandoNotaOuFrequenciaForNull() {
        Aluno aluno = new Aluno();
        Set<Nota> notas = new HashSet<>();
        for (Disciplina d : Disciplina.values()) {
            Nota n = new Nota();
            n.setDisciplina(d);
            n.setValor(null); // valor null!
            n.setFrequencia(null); // frequência null!
            notas.add(n);
        }
        aluno.setNotas(notas);

        AlunoException ex = assertThrows(AlunoException.class, () -> alunoService.cadastrarAluno(aluno));
        assertTrue(ex.getMessage().contains("null"));
    }

    // 9. Teste do findAll()
    @Test
    @DisplayName("Deve Retornar todos os alunos cadastrados")
    void deveRetornarTodosAlunos() {
        List<Aluno> lista = Arrays.asList(new Aluno(), new Aluno());
        when(alunoRepository.findAll()).thenReturn(lista);

        List<Aluno> resultado = alunoService.findAll();

        assertEquals(2, resultado.size());
        verify(alunoRepository, times(1)).findAll();
    }
}