package example.exercicio3.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.exercicio3.model.Funcionario;
import example.exercicio3.model.Projeto;
import example.exercicio3.repository.FuncionarioRepository;
import example.exercicio3.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public void vincularFuncionarioAProjeto(Integer idFuncionario, Integer idProjeto) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(idFuncionario);
        Optional<Projeto> projetoOpt = projetoRepository.findById(idProjeto);

        if (funcionarioOpt.isPresent() && projetoOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();
            Projeto projeto = projetoOpt.get();

            projeto.getFuncionarios().add(funcionario);

            projetoRepository.save(projeto);
        } else {
            throw new RuntimeException("Funcionário ou Projeto não encontrado");
        }
    }

    public List<Projeto> buscarProjetosPorFuncionario(Integer idFuncionario) {
        return projetoRepository.findProjetosByFuncionarioId(idFuncionario);
    }

    public void adicionar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }
}