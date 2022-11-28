package asw.sentence.sentenceservice.wordclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory; 
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;

import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;

import java.time.Duration;

/* Configurazione per Resilience4J. */
@Configuration
public class Resilience4JConfig {

	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
		/* ATTENZIONE: 
		 * QUESTA CONFIGURAZIONE E' PENSATA SOLO PER EFFETTUARE DEGLI ESPERIMENTI
		 * MA NON VA USATA IN PRODUZIONE */ 

		TimeLimiterConfig myTimeLimiterConfig = 
//			TimeLimiterConfig.ofDefaults(); 
			TimeLimiterConfig.custom()
					// timeout (default: 1000 ms) 
					.timeoutDuration(Duration.ofMillis(800))
					.build(); 

		CircuitBreakerConfig myCircuitBreakerConfig = 
//			CircuitBreakerConfig.ofDefaults(); 
			CircuitBreakerConfig.custom()
					// percentuale di errori per aprire il circuito (default: 50 percento) 
					.failureRateThreshold(30)
					// percentuale di ritardi per aprire il circuito (default: 100 percento) 
					.slowCallRateThreshold(30)
					// durata considerata un ritardo (default: 60000)
					.slowCallDurationThreshold(Duration.ofMillis(400))
					// dimensione della finestra (default: 100) 
					// numero di richieste problematiche che apre il circuito (default: 100) 
					// tipo di finestra (default: COUNT_BASED)
					.slidingWindow(100, 20, SlidingWindowType.COUNT_BASED)
					// tempo di apertura del circuito (default: 60 s) 
					.waitDurationInOpenState(Duration.ofMillis(10000))
					.build(); 
					
		return factory -> factory.configureDefault(
				id -> new Resilience4JConfigBuilder(id)
//					.timeLimiterConfig(TimeLimiterConfig.ofDefaults()) 
					.timeLimiterConfig(myTimeLimiterConfig) 
//					.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()) 
					.circuitBreakerConfig(myCircuitBreakerConfig) 
					.build());
	}

}

