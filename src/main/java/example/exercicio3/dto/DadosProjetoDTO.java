package example.exercicio3.dto;

import java.util.List;
import java.util.Optional;

import example.exercicio3.model.Funcionario;
import example.exercicio3.model.Projeto;
import lombok.Data;

@Data
public class DadosProjetoDTO {
    private String descricao;
    private List<String> funcionarios;

    public DadosProjetoDTO(Optional<Projeto> projeto) {
        this.descricao = projeto.getDescricao();
        this.funcionarios = projeto.getFuncionarios()
                                   .stream()
                                   .map(Funcionario::getNome)
                                   .toList();
    }
}
