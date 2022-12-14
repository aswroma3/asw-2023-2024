package asw.goodbooks.connessioni.rest;

import asw.goodbooks.connessioni.domain.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 

import java.util.logging.Logger; 

@RestController
public class ConnessioniController {

	@Autowired 
	private ConnessioniService connessioniService; 

    private final Logger logger = Logger.getLogger(this.getClass().toString());

	/* Crea una nuova connessione con autore. 
	* La richiesta contiene nel corpo una stringa della forma utente:autore */ 
	@PostMapping("/connessioniautore")
	public ConnessioneConAutore createConnessioneConAutore(@RequestBody CreateConnessioneConAutoreRequest request) {
		String utente = request.getUtente();
		String autore = request.getAutore();
		logger.info("REST CALL: createConnessioneConAutore " + utente + ", " + autore); 
		ConnessioneConAutore connessione = connessioniService.createConnessioneConAutore(utente, autore);
		return connessione; 
	}	

	/* Trova tutte le connessioni con autore. */ 
	@GetMapping("/connessioniautore")
	public Collection<ConnessioneConAutore> getConnessioniConAutore() {
		Collection<ConnessioneConAutore> connessioni = null; 
		logger.info("REST CALL: getConnessioniConAutore"); 
		connessioni = connessioniService.getConnessioniConAutore();
		logger.info("REST CALL: getConnessioniConAutore: " + connessioni); 
		return connessioni;
	}

	/* Trova tutte le connessioni con autore di un utente. */ 
	@GetMapping("/connessioniautore/{utente}")
	public Collection<ConnessioneConAutore> getConnessioniConAutoreByUtente(@PathVariable String utente) {
		Collection<ConnessioneConAutore> connessioni = null; 
		logger.info("REST CALL: getConnessioniConAutoreByUtente " + utente); 
		connessioni = connessioniService.getConnessioniConAutoreByUtente(utente);
		logger.info("REST CALL: getConnessioniConAutoreByUtente " + utente + ": " + connessioni); 
		return connessioni;
	}

	/* Crea una nuova connessione con recensore. 
	* La richiesta contiene nel corpo una stringa della forma utente:recensore */ 
	@PostMapping("/connessionirecensore")
	public ConnessioneConRecensore createConnessioneConRecensore(@RequestBody CreateConnessioneConRecensoreRequest request) {
		String utente = request.getUtente();
		String recensore = request.getRecensore();
		logger.info("REST CALL: createConnessioneConRecensore " + utente + ", " + recensore); 
		ConnessioneConRecensore connessione = connessioniService.createConnessioneConRecensore(utente, recensore);
		return connessione; 
	}	

	/* Trova tutte le connessioni con recensore. */ 
	@GetMapping("/connessionirecensore")
	public Collection<ConnessioneConRecensore> getConnessioniConRecensore() {
		Collection<ConnessioneConRecensore> connessioni = null; 
		logger.info("REST CALL: getConnessioniConRecensore"); 
		connessioni = connessioniService.getConnessioniConRecensore();
		logger.info("REST CALL: getConnessioniConRecensore: " + connessioni); 
		return connessioni;
	}

	/* Trova tutte le connessioni con recensore di un utente. */ 
	@GetMapping("/connessionirecensore/{utente}")
	public Collection<ConnessioneConRecensore> getConnessioniConRecensoreByUtente(@PathVariable String utente) {
		Collection<ConnessioneConRecensore> connessioni = null; 
		logger.info("REST CALL: getConnessioniConRecensoreByUtente " + utente); 
		connessioni = connessioniService.getConnessioniConRecensoreByUtente(utente);
		logger.info("REST CALL: getConnessioniConRecensoreByUtente " + utente + ": " + connessioni); 
		return connessioni;
	}

}
