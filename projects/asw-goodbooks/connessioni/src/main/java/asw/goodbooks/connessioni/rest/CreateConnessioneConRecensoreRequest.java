package asw.goodbooks.connessioni.rest;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateConnessioneConRecensoreRequest {

	private String utente; 
	private String recensore; 

}

