package asw.sentence.sentenceservice.wordclient;

import java.util.concurrent.CompletableFuture;

public interface WordRestClientAsync {

	public CompletableFuture<String> getWordAsync(String service); 

}
