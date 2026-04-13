package br.ifsp.contactos_api.controller;
import br.ifsp.contactos_api.repository.ContatoRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import br.ifsp.contactos_api.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    }

