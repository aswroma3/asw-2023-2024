package asw.goodbooks.connessioni.domain;

import javax.persistence.*; 

import lombok.*; 

@Entity 
@Data @NoArgsConstructor
public class ConnessioneConAutore {

	@Id 
	@GeneratedValue
	private Long id; 
	private String utente; 
	private String autore; 
	
	public ConnessioneConAutore(String utente, String autore) {
		this(); 
		this.utente = utente; 
		this.autore = autore; 
	}
	
}
