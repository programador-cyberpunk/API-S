package br.ifsp.contactos_api.repository;

import br.ifsp.contactos_api.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
   //agora esse caralho funciona vsf
    // Ao estender JpaRepository, o Spring cria os métodos save, findAll, etc, automaticamente.
}