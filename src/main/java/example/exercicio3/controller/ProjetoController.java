package example.exercicio3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.exercicio3.dto.DadosProjetoDTO;
import example.exercicio3.dto.ProjetoDTO;
import example.exercicio3.model.Projeto;
import example.exercicio3.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public void adicionar(@RequestBody ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto(projetoDTO.getDescricao(), projetoDTO.getDataInicio(), projetoDTO.getDataFim());
        projetoService.adicionar(projeto);
    }

    @GetMapping("/{id}")
    public DadosProjetoDTO buscarProjetoPorId(@PathVariable Integer id) {
        Optional<Projeto> projeto = projetoService.buscarProjetoPorId(id);
        return new DadosProjetoDTO(projeto);
    }

    @PostMapping("/{idProjeto}/funcionario/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionarioAProjeto(idProjeto, idFuncionario);
        
    }
}