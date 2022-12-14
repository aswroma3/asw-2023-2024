package asw.goodbooks.recensioni.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.*; 

@Service
public class RecensioniService {

	@Autowired
	private RecensioniRepository recensioniRepository;

 	public Recensione createRecensione(String recensore, String titoloLibro, String autoreLibro, String testoRecensione) {
		Recensione recensione = new Recensione(recensore, titoloLibro, autoreLibro, testoRecensione); 
		recensione = recensioniRepository.save(recensione);
		return recensione;
	}

 	public Recensione getRecensione(Long id) {
		Recensione recensione = recensioniRepository.findById(id).orElse(null);
		return recensione;
	}

	public Collection<Recensione> getRecensioni() {
		Collection<Recensione> recensioni = recensioniRepository.findAll();
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByRecensore(String recensore) {
		Collection<Recensione> recensioni = recensioniRepository.findByRecensore(recensore);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByRecensori(Collection<String> recensori) {
		Collection<Recensione> recensioni = recensioniRepository.findByRecensoreIn(recensori);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByTitolo(String titolo) {
		Collection<Recensione> recensioni = recensioniRepository.findByTitoloLibro(titolo);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByAutore(String autore) {
		Collection<Recensione> recensioni = recensioniRepository.findByAutoreLibro(autore);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByAutori(Collection<String> autori) {
		Collection<Recensione> recensioni = recensioniRepository.findByAutoreLibroIn(autori);
		return recensioni;
	}

}
