package asw.goodbooks.recensioniseguite.domain;

import java.util.*; 

public interface ConnessioniClientPort {

	public Collection<ConnessioneConAutore> getConnessioniConAutoreByUtente(String utente); 
	
	public Collection<ConnessioneConRecensore> getConnessioniConRecensoreByUtente(String utente); 

}
