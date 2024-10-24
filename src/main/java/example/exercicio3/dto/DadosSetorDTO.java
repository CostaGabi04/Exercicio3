package example.exercicio3.dto;

import java.util.List;

import example.exercicio3.model.Funcionario;
import example.exercicio3.model.Setor;
import lombok.Data;

@Data
public class DadosSetorDTO {
    private String nome;
    private List<String> funcionarios;

    public DadosSetorDTO(Setor setor) {
        this.nome = setor.getNome();
        this.funcionarios = setor.getFuncionarios()
                                 .stream()
                                 .map(Funcionario::getNome)
                                 .toList();
    }
}