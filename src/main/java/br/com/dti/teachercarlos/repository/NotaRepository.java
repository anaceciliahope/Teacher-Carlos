package br.com.dti.teachercarlos.repository;

import br.com.dti.teachercarlos.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}