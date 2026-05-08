package br.ifsp.contactos_api.model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Query
public class Query{
@Query("SELECT c FROM Contato c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%, :nome, '%'))")
List<Contato> searchByNome(@Param("nome") String nome);
}
