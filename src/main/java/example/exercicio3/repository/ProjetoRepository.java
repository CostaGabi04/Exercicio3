package example.exercicio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import example.exercicio3.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    @Query("SELECT p FROM Projeto p JOIN p.funcionarios f WHERE f.id = :idFuncionario")
    List<Projeto> findProjetosByFuncionarioId(@Param("idFuncionario") Integer idFuncionario);
}