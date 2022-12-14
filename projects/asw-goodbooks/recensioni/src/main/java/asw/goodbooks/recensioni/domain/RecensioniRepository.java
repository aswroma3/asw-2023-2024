package asw.goodbooks.recensioni.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*; 

public interface RecensioniRepository extends CrudRepository<Recensione, Long> {

	public Collection<Recensione> findAll();

	public Collection<Recensione> findByRecensore(String recensore);

	public Collection<Recensione> findByRecensoreIn(Collection<String> recensori);

	public Collection<Recensione> findByTitoloLibro(String titoloLibro);

	public Collection<Recensione> findByAutoreLibro(String autoreLibro);

	public Collection<Recensione> findByAutoreLibroIn(Collection<String> autoriLibri);

}

