package asw.goodbooks.connessioni.domain;

import javax.persistence.*; 

import lombok.*; 

@Entity 
@Data @NoArgsConstructor
public class ConnessioneConRecensore {

	@Id 
	@GeneratedValue
	private Long id; 
	private String utente; 
	private String recensore; 
	
	public ConnessioneConRecensore(String utente, String recensore) {
		this(); 
		this.utente = utente; 
		this.recensore = recensore; 
	}
	
}
