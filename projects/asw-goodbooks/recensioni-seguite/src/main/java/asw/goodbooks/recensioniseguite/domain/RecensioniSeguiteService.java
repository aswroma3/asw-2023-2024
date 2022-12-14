package asw.goodbooks.recensioniseguite.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 
import java.util.stream.*; 

@Service 
public class RecensioniSeguiteService {

	@Autowired 
	private ConnessioniClientPort connessioniClient;

	@Autowired 
	private RecensioniClientPort recensioniClient;

	/* Trova le recensioni seguite da un utente. */ 
	public Collection<Recensione> getRecensioniSeguite(String utente) {
		Collection<Recensione> recensioniSeguite = new TreeSet<>(); 
		
		Collection<ConnessioneConAutore> connessioniConAutore = connessioniClient.getConnessioniConAutoreByUtente(utente); 
		Collection<String> autoriSeguiti = 
			connessioniConAutore
				.stream()
				.map(c -> c.getAutore())
				.collect(Collectors.toSet()); 
		if (autoriSeguiti.size()>0) {
			Collection<Recensione> recensioniDiAutori = recensioniClient.getRecensioniByAutori(autoriSeguiti);
			recensioniSeguite.addAll(recensioniDiAutori); 
		}
		
		Collection<ConnessioneConRecensore> connessioniConRecensore = connessioniClient.getConnessioniConRecensoreByUtente(utente); 
		Collection<String> recensoriSeguiti = 
			connessioniConRecensore
				.stream()
				.map(c -> c.getRecensore())
				.collect(Collectors.toSet()); 
		if (recensoriSeguiti.size()>0) {
			Collection<Recensione> recensioniDiRecensori = recensioniClient.getRecensioniByRecensori(recensoriSeguiti);
			recensioniSeguite.addAll(recensioniDiRecensori); 
		}

		return recensioniSeguite; 
	}

}
