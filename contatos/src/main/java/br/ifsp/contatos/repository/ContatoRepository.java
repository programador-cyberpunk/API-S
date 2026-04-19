package br.ifsp.contatos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsp.contatos.model.Contato;

public interface  ContatoRepository extends JpaRepository<Contato, Long>{

	Optional<Contato> findByNome(String nome);

}
