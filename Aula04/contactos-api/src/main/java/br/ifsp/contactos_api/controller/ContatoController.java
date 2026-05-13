package br.ifsp.contactos_api.controller;
import br.ifsp.contactos_api.repository.ContatoRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import br.ifsp.contactos_api.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contactos")
    public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public List<Contato> getALLContacts() {
        return contatoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Contato getContactById(@PathVariable Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato nao encontrado: " + id));
    }

    @PostMapping
    public Contato createContact(@RequestBody Contato contato) {
        return contatoRepository.save(contato);
    }

    @PutMapping("/{id}")
    public Contato updateContact(@PathVariable Long id, @RequestBody Contato updateContato) {
        Contato existingContato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado" + id));

        existingContato.setNome(updateContato.getNome());
        existingContato.setTelefone(updateContato.getTelefone());
        existingContato.setEmail(updateContato.getEmail());

        return contatoRepository.save(existingContato);
    }

    @DeleteMapping("/{id}")
    public void deleteContatc(@PathVariable Long id) {
        contatoRepository.deleteById(id);
    }

    //exercicio1
    @GetMapping("{/api/contactos/search}")
    // jeito certo
    public List<Contato> searchContatoByName(@RequestParam String nome) {
        return contatoRepository.findbyNomeContaintIgnoreCase(nome);
        // grande bosta, continua errado
    }

    public interface ContatoRepository extends JpaRepository<Contato, Long> {
        List<Contato> findByNomeContaintIgnoreCase(String nome);
    }

    //jeito certo, que claro eu não fiz
    @PatchMapping("/{id}")
    public Contato updateContatoPartial(@PathVariable Long id, @RequestBody Map<String, String> upedates){
    Contato contato = contatoRepository.findById(id)
            .orElseThrow(() -> new  ResourceNotFoundException("Contato não encontrado nessa porra" + id))
            .updates.forEach((key, value) -> {
                switch (key) {
                    case "nome":
                        contato.setNome(value);
                        break;
                    case "telefone":
                        contato.setTelefone(value);
                        break;
                    case "email":
                        contato.setEmail(value);
                        break;
                }
            });
            return contatoRepository.save(contato);
        }
    }
}


