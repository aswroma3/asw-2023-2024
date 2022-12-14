package asw.goodbooks.recensioni.rest;

import asw.goodbooks.recensioni.domain.*;

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
import java.util.stream.*; 

import java.util.logging.Logger; 

@RestController
public class RecensioniController {

	@Autowired 
	private RecensioniService recensioniService; 

    private final Logger logger = Logger.getLogger(this.getClass().toString());

	/* Crea una nuova recensione. */ 
	@PostMapping("/recensioni")
	public Recensione createRecensione(@RequestBody CreateRecensioneRequest request) {
		String recensore = request.getRecensore();
		String titoloLibro = request.getTitoloLibro();
		String autoreLibro = request.getAutoreLibro();
		String testoRecensione = request.getTestoRecensione();
		logger.info("REST CALL: createRecensione " + recensore + ", " + titoloLibro + ", " + autoreLibro + ", " + testoRecensione); 
		Recensione recensione = recensioniService.createRecensione(recensore, titoloLibro, autoreLibro, testoRecensione);
		return recensione; 
	}	

	/* Trova la recensione con recensioneId. */ 
	@GetMapping("/recensioni/{recensioneId}")
	public Recensione getRecensione(@PathVariable Long recensioneId) {
		logger.info("REST CALL: getRecensione " + recensioneId); 
		Recensione recensione = recensioniService.getRecensione(recensioneId);
		if (recensione!=null) {
			logger.info("REST CALL: getRecensione " + recensioneId + ": " + recensione); 
			return recensione;
		} else {
			logger.info("REST CALL: getRecensione " + recensioneId + ": Recensione not found"); 
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Recensione not found"
			);
		}
	}

	/* Trova tutte le recensioni. */ 
	@GetMapping("/recensioni")
	public Collection<GetRecensioneResponse> getRecensioni() {
		Collection<Recensione> recensioni = null; 
		Collection<GetRecensioneResponse> recensioniResponse = null; 
		logger.info("REST CALL: getRecensioni"); 
		recensioni = recensioniService.getRecensioni();
		recensioniResponse = toRecensioniResponse(recensioni);
		logger.info("REST CALL: getRecensioni: " + recensioniResponse); 
		return recensioniResponse;
	}
	
	/* Trova tutte le recensioni di un recensore. */ 
	@GetMapping("/cercarecensioni/recensore/{recensore}")
	public Collection<GetRecensioneResponse> getRecensioniByRecensore(@PathVariable String recensore) {
		Collection<Recensione> recensioni = null; 
		Collection<GetRecensioneResponse> recensioniResponse = null; 
		logger.info("REST CALL: getRecensioniByRecensore " + recensore); 
		recensioni = recensioniService.getRecensioniByRecensore(recensore);
		recensioniResponse = toRecensioniResponse(recensioni);
		logger.info("REST CALL: getRecensioniByRecensore " + recensore + ": " + recensioniResponse); 
		return recensioniResponse;
	}

	/* Trova tutte le recensioni di un insieme di recensori. */ 
	@GetMapping("/cercarecensioni/recensori/{recensori}")
	public Collection<GetRecensioneResponse> getRecensioniByRecensori(@PathVariable Collection<String> recensori) {
		Collection<Recensione> recensioni = null; 
		Collection<GetRecensioneResponse> recensioniResponse = null; 
		logger.info("REST CALL: getRecensioniByRecensori " + recensori); 
		recensioni = recensioniService.getRecensioniByRecensori(recensori);
		recensioniResponse = toRecensioniResponse(recensioni);
		logger.info("REST CALL: getRecensioniByRecensori " + recensori + ": " + recensioniResponse); 
		return recensioniResponse;
	}

	/* Trova tutte le recensioni relative a un certo libro. */ 
	@GetMapping("/cercarecensioni/titolo/{titolo}")
	public Collection<GetRecensioneResponse> getRecensioniByTitolo(@PathVariable String titolo) {
		Collection<Recensione> recensioni = null; 
		Collection<GetRecensioneResponse> recensioniResponse = null; 
		logger.info("REST CALL: getRecensioniByTitolo " + titolo); 
		recensioni = recensioniService.getRecensioniByTitolo(titolo);
		recensioniResponse = toRecensioniResponse(recensioni);
		logger.info("REST CALL: getRecensioniByTitolo " + titolo + ": " + recensioniResponse); 
		return recensioniResponse;
	}

	/* Trova tutte le recensioni relative a un certo autore. */ 
	@GetMapping("/cercarecensioni/autore/{autore}")
	public Collection<GetRecensioneResponse> getRecensioniByAutore(@PathVariable String autore) {
		Collection<Recensione> recensioni = null; 
		Collection<GetRecensioneResponse> recensioniResponse = null; 
		logger.info("REST CALL: getRecensioniByAutore " + autore); 
		recensioni = recensioniService.getRecensioniByAutore(autore);
		recensioniResponse = toRecensioniResponse(recensioni);
		logger.info("REST CALL: getRecensioniByAutore " + autore + ": " + recensioniResponse); 
		return recensioniResponse;
	}

	/* Trova tutte le recensioni relative a un insieme di autori. */ 
	@GetMapping("/cercarecensioni/autori/{autori}")
	public Collection<GetRecensioneResponse> getRecensioniByAutori(@PathVariable Collection<String> autori) {
		Collection<Recensione> recensioni = null; 
		Collection<GetRecensioneResponse> recensioniResponse = null; 
		logger.info("REST CALL: getRecensioniByAutori " + autori); 
		recensioni = recensioniService.getRecensioniByAutori(autori);
		recensioniResponse = toRecensioniResponse(recensioni);
		logger.info("REST CALL: getRecensioniByAutori " + autori + ": " + recensioniResponse); 
		return recensioniResponse;
	}
	
	/* Converte una collezione di recensioni (in formato completo), in una collezione di recensioni (in formato breve). */ 
	private Collection<GetRecensioneResponse> toRecensioniResponse(Collection<Recensione> recensioni) {
		Collection<GetRecensioneResponse> recensioniResponse = 
			recensioni
				.stream()
				.map(r -> new GetRecensioneResponse(r))
				.collect(Collectors.toList());
		return recensioniResponse; 
	}

	private static String toString(String[] a) {
		return Arrays.toString(a); 
	}

}
