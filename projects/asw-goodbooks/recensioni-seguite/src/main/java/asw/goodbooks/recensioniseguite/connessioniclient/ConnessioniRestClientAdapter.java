package asw.goodbooks.recensioniseguite.connessioni;

import asw.goodbooks.recensioniseguite.domain.*; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*; 

@Service 
@Primary 
public class ConnessioniRestClientAdapter implements ConnessioniClientPort {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient loadBalancedWebClient;
	
	public Collection<ConnessioneConAutore> getConnessioniConAutoreByUtente(String utente) {
		Collection<ConnessioneConAutore> connessioni = null; 
        Flux<ConnessioneConAutore> response = loadBalancedWebClient
                .get()
				.uri("http://connessioni/connessioniautore/{utente}", utente)
                .retrieve()
                .bodyToFlux(ConnessioneConAutore.class);
        try {
            connessioni = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return connessioni; 
	}	

	public Collection<ConnessioneConRecensore> getConnessioniConRecensoreByUtente(String utente) {
		Collection<ConnessioneConRecensore> connessioni = null; 
        Flux<ConnessioneConRecensore> response = loadBalancedWebClient
                .get()
				.uri("http://connessioni/connessionirecensore/{utente}", utente)
                .retrieve()
                .bodyToFlux(ConnessioneConRecensore.class);
        try {
            connessioni = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return connessioni; 
	}	
	
}
