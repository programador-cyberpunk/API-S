package br.ifsp.contactos_api.repository;

import org.springframework.data.jpa.repository.Query;
import br.ifsp.contactos_api.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    // deve ser findByNomeContainingIgnoreCase (com 'ing')
    List<Contato> findByNomeContainingIgnoreCase(String nome);

    // Corrigido: Removidas as chaves extras e corrigida a concatenação do SQL
    @Query(value = "SELECT * FROM Contato WHERE LOWER(nome) LIKE LOWER(CONCAT('%', :nome, '%'))", nativeQuery = true)
    List<Contato> searchByNome(@Param("nome") String nome);
}