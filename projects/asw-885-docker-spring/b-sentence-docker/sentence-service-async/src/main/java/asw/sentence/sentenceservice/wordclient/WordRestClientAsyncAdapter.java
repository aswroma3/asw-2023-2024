package asw.sentence.sentenceservice.wordclient;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Async;
import java.util.concurrent.CompletableFuture;

@Service
public class WordRestClientAsyncAdapter implements WordRestClientAsync {

	@Autowired 
	private WordRestClient wordRestClient; 

	@Async
	public CompletableFuture<String> getWordAsync(String service) {
		return CompletableFuture.completedFuture(wordRestClient.getWord(service)); 
	} 

}
