package br.com.dti.teachercarlos.repository;

import br.com.dti.teachercarlos.controller.dto.FrequenciaGeralAlunoDTO;
import br.com.dti.teachercarlos.controller.dto.MediaNotaAlunoDTO;
import br.com.dti.teachercarlos.controller.dto.MediaNotaDisciplinaDTO;
import br.com.dti.teachercarlos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT AVG(n.valor) FROM Nota n")
    Double findMediaNotasDeTodosAlunos();

    @Query("SELECT new br.com.dti.teachercarlos.controller.dto.MediaNotaAlunoDTO(a.nome, AVG(n.valor)) " +
            "FROM Aluno a JOIN a.notas n " +
            "GROUP BY a.id, a.nome")
    List<MediaNotaAlunoDTO> findMediaNotasPorAluno();

    @Query("SELECT new br.com.dti.teachercarlos.controller.dto.MediaNotaDisciplinaDTO(n.disciplina, AVG(n.valor)) " +
            "FROM Nota n GROUP BY n.disciplina")
    List<MediaNotaDisciplinaDTO> findMediaNotaPorDisciplina();


    @Query("SELECT new br.com.dti.teachercarlos.controller.dto.FrequenciaGeralAlunoDTO(a.nome, AVG(n.frequencia)) " +
            "FROM Aluno a JOIN a.notas n " +
            "GROUP BY a.id, a.nome")
    List<FrequenciaGeralAlunoDTO> findFrequenciaGeralPorAluno();

    @Query("SELECT new br.com.dti.teachercarlos.controller.dto.MediaNotaAlunoDTO(a.nome, AVG(n.valor)) " +
            "FROM Aluno a JOIN a.notas n " +
            "GROUP BY a.id, a.nome " +
            "HAVING AVG(n.valor) >= :mediaMinima")
    List<MediaNotaAlunoDTO> findMediaNota(@Param("mediaMinima") Double mediaMinima);

    @Query("SELECT new br.com.dti.teachercarlos.controller.dto.FrequenciaGeralAlunoDTO(a.nome, AVG(n.frequencia)) " +
            "FROM Aluno a JOIN a.notas n " +
            "GROUP BY a.id, a.nome " +
            "HAVING AVG(n.valor) <= :frequenciaMinima")
    List<MediaNotaAlunoDTO> findFrequenciaBaixa(@Param("frequenciaMinima") Double frequenciaMinima);

}