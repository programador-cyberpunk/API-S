package br.ifsp.contactos_api.controller;
import br.ifsp.contactos_api.model.Contato;
import br.ifsp.contactos_api.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    @PostMapping
    public Contato salvar(@RequestBody Contato contato) {
        return contatoRepository.save(contato);
    }

    @GetMapping("/{id}")
    public Contato buscarPorId(@PathVariable Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Contato updateContatoPartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "nome":
                    contato.setNome((String) value);
                    break;
                case "telefone":
                    contato.setTelefone((String) value);
                    break;
                case "email":
                    contato.setEmail((String) value);
                    break;
            }
        });

        return contatoRepository.save(contato);
    }
}