package asw.goodbooks.recensioniseguite.enigmi;

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
import java.util.stream.*; 

@Service 
@Primary 
public class RecensioniRestClientAdapter implements RecensioniClientPort {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient loadBalancedWebClient;
	
	public Collection<Recensione> getRecensioniByAutori(Collection<String> autori) {
		Collection<Recensione> recensioni = null; 
        Flux<Recensione> response = loadBalancedWebClient
                .get()
				.uri("http://recensioni/cercarecensioni/autori/{autori}", toString(autori))
                .retrieve()
                .bodyToFlux(Recensione.class);
        try {
            recensioni = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return recensioni; 
	}	

	public Collection<Recensione> getRecensioniByRecensori(Collection<String> recensori) {
		Collection<Recensione> recensioni = null; 
        Flux<Recensione> response = loadBalancedWebClient
                .get()
				.uri("http://recensioni/cercarecensioni/recensori/{recensori}", toString(recensori))
                .retrieve()
                .bodyToFlux(Recensione.class);
        try {
            recensioni = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return recensioni; 
	}

	private static String toString(Collection<String> c) {
		String result = 
			c.stream()
				.map(n -> String.valueOf(n))
				.collect(Collectors.joining(",", "", ""));
		return result; 
	}

}
