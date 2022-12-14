package asw.goodbooks.recensioni.rest;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecensioneRequest {

	private String recensore; 
	private String titoloLibro; 
	private String autoreLibro; 
	private String testoRecensione; 

}

