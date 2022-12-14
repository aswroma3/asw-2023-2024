package asw.goodbooks.recensioniseguite.domain;

import java.util.*; 

public interface RecensioniClientPort {

	public Collection<Recensione> getRecensioniByAutori(Collection<String> autori); 

	public Collection<Recensione> getRecensioniByRecensori(Collection<String> recensori); 

}
