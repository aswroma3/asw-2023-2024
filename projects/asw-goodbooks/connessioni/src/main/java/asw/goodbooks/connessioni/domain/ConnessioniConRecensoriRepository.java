package asw.goodbooks.connessioni.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.*; 

public interface ConnessioniConRecensoriRepository extends CrudRepository<ConnessioneConRecensore, Long> {

	public Collection<ConnessioneConRecensore> findAll();

	public Collection<ConnessioneConRecensore> findByUtente(String utente);

}

