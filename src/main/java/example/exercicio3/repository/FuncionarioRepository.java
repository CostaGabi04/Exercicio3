package example.exercicio3.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import example.exercicio3.model.Funcionario;
import example.exercicio3.model.Projeto;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT p FROM Projeto p JOIN p.funcionarios f WHERE f.id = :id")
    List<Projeto> findProjetosByFuncionarioId(@Param("id") Integer id);
}