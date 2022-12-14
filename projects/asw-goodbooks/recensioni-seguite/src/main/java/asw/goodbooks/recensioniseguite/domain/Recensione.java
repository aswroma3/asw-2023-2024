package asw.goodbooks.recensioniseguite.domain;

import lombok.*; 

/* Recensione. */ 
@Data @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recensione implements Comparable<Recensione> {

	@EqualsAndHashCode.Include
	private Long id; 
	private String recensore; 
	private String titoloLibro; 
	private String autoreLibro; 
	private String testoRecensione; 

	@Override
	public int compareTo(Recensione other) {
		return this.id.compareTo(other.id); 
	}
	
}
