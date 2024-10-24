package example.exercicio3.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import example.exercicio3.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

    @Query("SELECT s FROM Setor s LEFT JOIN FETCH s.funcionarios")
    static
    
    List<Setor> findAllWithFuncionarios() {
        throw new UnsupportedOperationException("Unimplemented method 'findAllWithFuncionarios'");
    }    
} 
