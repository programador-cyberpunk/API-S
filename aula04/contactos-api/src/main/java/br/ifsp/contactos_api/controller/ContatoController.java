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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/contactos")
    public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public List<Contato> getALLContacts(){
        return contatoRepository.findAll();
    }

    @GetMapping("/{id}")
        public Contato getContactById(@PathVariable Long id){
            return contatoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Contato nao encontrado: "+id));
    }

    @PostMapping
        public Contato createContact(@RequestBody Contato contato){
            return contatoRepository.save(contato);
    }

    @PutMapping ("/{id}")
    public Contato updateContact(@PathVariable Long id, @RequestBody Contato updateContato){
        Contato existingContato = contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado" + id));

        existingContato.setNome(updateContato.getNome());
        existingContato.setTelefone(updateContato.getTelefone());
        existingContato.setEmail(updateContato.getEmail());

            return contatoRepository.save(existingContato);
    }

    @DeleteMapping("/{id}")
     public void deleteContatc(@PathVariable Long id){
        contatoRepository.deleteById(id);
    }

    //exercicio1
    @GetMapping("{/api/contactos/search}")
    // jeito certo
    public List<Contato>searchContatoByName(@RequestParam String nome){
        return contatoRepository.findbyNomeContaintIgnoreCase(nome);
        // grande bosta, continua errado
 }
    public interface ContatoRepository extends JpaRepository<Contato, Long> {
        List<Contato> findByNomeContaintIgnoreCase(String nome);
    }
    /*public Contato getContactByName(@PathVariable String nome) {
        return contatoRepository.findbyName(nome);
        Contato contatoAchado = contatoRepository.findByName(nome)// começou de novo essa merda
                .orElseThrow(() -> {
                    System.out.println("Nao achamo ninguem nessa merda: " + nome);
                    return new RuntimeException("Nao achamo ninguem nessa merda" + nome);
                });
    */}

    //exercicio2
    @PatchMapping("/{id}")
    public ResponseEntity<Contato> updatePartialContact(@PathVariable Long id, @RequestBody Contato updates) {

        Contato contatoExistente = contatoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado aqui nessa merda: " + id));

  //pra atualizar os nao nulos
        if (updates.getNome() != null) {
            contatoExistente.setNome(updates.getNome());
        }
        if (updates.getEmail() != null) {
            contatoExistente.setEmail(updates.getEmail());
        }
        if (updates.getTelefone() != null) {
            contatoExistente.setTelefone(updates.getTelefone());
        }
        //continua dando erro essa bosta
        Contato contatoAtualizado = contatoRepository.save(contatoExistente);
        return ResponseEntity.ok(contatoAtualizado);
    }
    }


