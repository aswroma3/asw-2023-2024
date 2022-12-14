package asw.goodbooks.connessioni.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.*; 

@Service
public class ConnessioniService {

	@Autowired
	private ConnessioniConAutoriRepository connessioniConAutoriRepository;

	@Autowired
	private ConnessioniConRecensoriRepository connessioniConRecensoriRepository;

 	public ConnessioneConAutore createConnessioneConAutore(String utente, String autore) {
		ConnessioneConAutore connessione = new ConnessioneConAutore(utente, autore); 
		connessione = connessioniConAutoriRepository.save(connessione);
		return connessione;
	}

 	public ConnessioneConAutore getConnessioneConAutore(Long id) {
		ConnessioneConAutore connessione = connessioniConAutoriRepository.findById(id).orElse(null);
		return connessione;
	}

 	public Collection<ConnessioneConAutore> getConnessioniConAutore() {
		Collection<ConnessioneConAutore> connessioni = connessioniConAutoriRepository.findAll();
		return connessioni;
	}

	public Collection<ConnessioneConAutore> getConnessioniConAutoreByUtente(String utente) {
		Collection<ConnessioneConAutore> connessioni = connessioniConAutoriRepository.findByUtente(utente);
		return connessioni;
	}

 	public ConnessioneConRecensore createConnessioneConRecensore(String utente, String recensore) {
		ConnessioneConRecensore connessione = new ConnessioneConRecensore(utente, recensore); 
		connessione = connessioniConRecensoriRepository.save(connessione);
		return connessione;
	}

 	public ConnessioneConRecensore getConnessioneConRecensore(Long id) {
		ConnessioneConRecensore connessione = connessioniConRecensoriRepository.findById(id).orElse(null);
		return connessione;
	}

 	public Collection<ConnessioneConRecensore> getConnessioniConRecensore() {
		Collection<ConnessioneConRecensore> connessioni = connessioniConRecensoriRepository.findAll();
		return connessioni;
	}

	public Collection<ConnessioneConRecensore> getConnessioniConRecensoreByUtente(String utente) {
		Collection<ConnessioneConRecensore> connessioni = connessioniConRecensoriRepository.findByUtente(utente);
		return connessioni;
	}

}
