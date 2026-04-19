package br.ifsp.contatos.controller;

import java.util.List;
import java.util.Optional;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ifsp.contatos.model.Contato;
import br.ifsp.contatos.repository.ContatoRepository;

public class ContatoController {

	  @Autowired
	    private ContatoRepository contatoRepository;

	@GetMapping
	public List<Contato> getALLContacts() {
		return null;
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
	    public Contato getContactByName(@PathVariable String nome) {
	        
	        Contato contatoAchado = contatoRepository.findByNome(nome)// começou de novo essa merda
	                .orElseThrow(() -> {
	                    System.out.println("Nao achamo ninguem nessa merda: " + nome);
	                    return new RuntimeException("Nao achamo ninguem nessa merda" + nome);
	                });
	        
	        return contatoAchado;
	    }

	    //exercicio2
	    @PatchMapping("/{id}")
	    public ResponseEntity<Contato> updatePartialContact(@PathVariable Long id, @RequestBody Contato updates) {

	        Contato contatoExistente = contatoRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Contato não encontrado aqui nessa merda: " + id));

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
		////coisa nova
	@GetMapping("/search")
		public List<Contato> searchContatoByName(@RequestParam String nome){
			return contatoRepository.findByNomeContainingIgnoreCase(nome);
	}
	public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long> {
		List<Contato> findByNomeContainingIgnoreCase(String nome);
		Contato save(Contato contatoExistente);

		Optional<Object> findById(Long id);
	}

    @Query
            ("SELECT c FROM Contato c WHERE LOWER(c.nome) LIKE LOWER('%, :nome,'%')")
    List<Contato> searchByNome(@Param("nome") String nome) {
        return null;
    }

	@PatchMapping("{id}")
	public Contato updateContactPartial(@PathVariable Long id, @RequestBody Map<String, String> updates){
			Contato contato = contatoRepository.findbyId(id)
					.orElseThrow(()-> new ResourceNotFoundEXception("Ninguem encontrado nessa porra" + id));
            updates.forEach((key, value) ->{
				switch (key){
					case "nome":
						contato.setNome(value);
						break;
					case "telefone":
						contato.setTelefone(value);
						break;
					case "email":
						contato.setEmail(valeu);
						break;
				}
		});
			return contatoRepository.save(contato);

	}
}
