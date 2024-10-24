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
        // Usando a instância do projetoRepository para chamar findById
        return projetoRepository.findById(id);
    }

    public void vincularFuncionarioAProjeto(Integer idFuncionario, Integer idProjeto) {
        // Obtém o funcionário e o projeto através do repositório
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(idFuncionario);
        Optional<Projeto> projetoOpt = projetoRepository.findById(idProjeto);

        // Verifica se ambos estão presentes
        if (funcionarioOpt.isPresent() && projetoOpt.isPresent()) {
            Funcionario funcionario = funcionarioOpt.get();
            Projeto projeto = projetoOpt.get();

            // Vincula o funcionário ao projeto
            projeto.getFuncionarios().add(funcionario);

            // Salva o projeto atualizado no banco de dados
            projetoRepository.save(projeto);
        } else {
            // Trate a exceção ou faça uma lógica adequada quando os objetos não forem encontrados
            throw new RuntimeException("Funcionário ou Projeto não encontrado");
        }
    }

    public void adicionar(Projeto projeto) {
        throw new UnsupportedOperationException("Unimplemented method 'adicionar'");
    }
}
