package asw.goodbooks.recensioni.rest;

import asw.goodbooks.recensioni.domain.Recensione; 

import lombok.*; 

/* Enigma, in formato breve (senza soluzione). */ 
@Data @NoArgsConstructor
public class GetRecensioneResponse {

	private Long id; 
	private String recensore; 
	private String titoloLibro; 
	private String autoreLibro; 
	private String testoRecensione; 

	public GetRecensioneResponse(Recensione r) {
		this.id = r.getId(); 
		this.recensore = r.getRecensore(); 
		this.titoloLibro = r.getTitoloLibro(); 
		this.autoreLibro = r.getAutoreLibro(); 
		this.testoRecensione = r.getTestoRecensione(); 
	}
	
}

