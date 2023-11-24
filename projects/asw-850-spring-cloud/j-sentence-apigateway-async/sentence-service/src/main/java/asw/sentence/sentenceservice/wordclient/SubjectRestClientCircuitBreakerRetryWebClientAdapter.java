package asw.sentence.sentenceservice.wordclient;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service("subjectRestClient") 
public class SubjectRestClientCircuitBreakerRetryWebClientAdapter implements WordRestClient {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient webClient;
	
    @CircuitBreaker(name = "subjectClientCircuitBreaker", fallbackMethod = "getFallbackWord")
    @Retry(name = "wordClientRetry")
	// oppure 
    // @CircuitBreaker(name = "subjectClientCircuitBreaker", fallbackMethod = "getFallbackWord")
	// oppure 
    // @Retry(name = "wordClientRetry", fallbackMethod = "getFallbackWord")
	public String getWord(String service) {
		String serviceUri = "http://" + service; 
        Mono<String> response = webClient
                .get()
				.uri(serviceUri)
                .retrieve()
                .bodyToMono(String.class);
        return response.block();
	}	

	private String getFallbackWord(Exception e) {
		String fallbackWord = "* fallback word *"; 
		return fallbackWord; 
	}

}
