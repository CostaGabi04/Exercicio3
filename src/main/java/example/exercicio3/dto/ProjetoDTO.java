package example.exercicio3.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProjetoDTO {
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}