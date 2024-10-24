package example.exercicio3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.exercicio3.model.Funcionario;
import example.exercicio3.model.Projeto;
import example.exercicio3.repository.FuncionarioRepository;
import example.exercicio3.repository.ProjetoRepository;

import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Optional<Projeto> buscarProjetoPorId(Integer id) {
        return projetoRepository.findById(id);
    }

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

    public void adicionar(Projeto projeto) {
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }
}
