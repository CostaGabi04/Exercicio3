package example.exercicio3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.exercicio3.model.Setor;
import example.exercicio3.repository.SetorRepository;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public Setor adicionar(Setor setor) {
        return setorRepository.save(setor);
    }

    public List<Setor> listarSetoresComFuncionarios() {
        return SetorRepository.findAllWithFuncionarios();
    }
}