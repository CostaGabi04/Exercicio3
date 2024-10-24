package example.exercicio3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.exercicio3.dto.DadosSetorDTO;
import example.exercicio3.dto.SetorDTO;
import example.exercicio3.model.Setor;
import example.exercicio3.service.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {
    @Autowired
    private SetorService setorService;

    @PostMapping
    public void adicionar(@RequestBody SetorDTO setorDTO) {
        Setor setor = new Setor(setorDTO.getNome());
        setorService.adicionar(setor);
    }

    @GetMapping
    public List<DadosSetorDTO> listarSetoresComFuncionarios() {
        return setorService.listarSetoresComFuncionarios()
                           .stream()
                           .map(DadosSetorDTO::new)
                           .toList();
    }
}