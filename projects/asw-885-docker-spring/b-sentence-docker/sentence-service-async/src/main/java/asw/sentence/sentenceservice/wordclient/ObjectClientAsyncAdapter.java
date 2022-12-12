package asw.sentence.sentenceservice.wordclient;

import asw.sentence.sentenceservice.domain.WordClientAsyncPort;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;

@Service 
public class ObjectClientAsyncAdapter implements WordClientAsyncPort {

	@Autowired 
	private WordRestClientAsync wordRestClientAsync;
	
	public CompletableFuture<String> getWordAsync() {
		return wordRestClientAsync.getWordAsync("object"); 
	}

}



