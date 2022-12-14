package asw.goodbooks.connessioni.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.*; 

public interface ConnessioniConAutoriRepository extends CrudRepository<ConnessioneConAutore, Long> {

	public Collection<ConnessioneConAutore> findAll();

	public Collection<ConnessioneConAutore> findByUtente(String utente);

}

