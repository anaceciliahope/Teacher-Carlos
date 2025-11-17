package br.com.dti.teachercarlos.controller;

import br.com.dti.teachercarlos.controller.dto.AlunoRequestDTO;
import br.com.dti.teachercarlos.controller.dto.AlunoResponseDTO;
import br.com.dti.teachercarlos.model.Aluno;
import br.com.dti.teachercarlos.service.AlunoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;
    private ObjectMapper mapper;

    public AlunoController() {
        this.mapper = new ObjectMapper();
    }

    // CREATE - POST /alunos
    @PostMapping
    public AlunoResponseDTO criarAluno(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Disciplinas obrigatórias no payload para criar nota. Disciplinas disponíveis: MATEMATICA, PORTUGUES, CIENCIAS, ARTES, HISTORIA."
            )
            @RequestBody @Valid AlunoRequestDTO alunoRequest) {
        Aluno aluno = service.cadastrarAluno(mapper.convertValue(alunoRequest, Aluno.class));
        aluno.getNotas().forEach(n -> n.setAluno(null));
        return mapper.convertValue(aluno, AlunoResponseDTO.class);
    }

    // READ - GET /alunos
    @GetMapping
    public List<AlunoResponseDTO> listarAlunos() {
        List<Aluno> alunos = service.findAll();
        alunos.forEach(a -> a.getNotas().forEach(n -> n.setAluno(null)));
        return alunos.stream()
                .map(a -> mapper.convertValue(a, AlunoResponseDTO.class))
                .collect(Collectors.toList());
    }


}