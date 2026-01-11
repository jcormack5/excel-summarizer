package org.example;
import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.SimpleOpenAI.SimpleOpenAIBuilder;
import io.github.sashirestela.openai.domain.chat.ChatMessage;
import io.github.sashirestela.openai.domain.chat.ChatMessage.SystemMessage;
import io.github.sashirestela.openai.domain.chat.ChatMessage.UserMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;

public class AISummarize {
	private String text;
	private final SimpleOpenAI openAI;
	
	
	public AISummarize() {
		String apiKey = System.getenv("OPENAI_API_KEY");
		if (apiKey == null || apiKey.isEmpty()) throw new IllegalArgumentException("API_KEY not set");
		this.openAI = SimpleOpenAI.builder()
			    .apiKey(apiKey)
				.build();
		
		
	}
	public String callSummarize(String text) {
		var chatRequest = ChatRequest.builder()
				.model("gpt-4o-mini")
				.message(SystemMessage.of("You are an expert in data analysis. " ))
				.message(UserMessage.of(text))
				.temperature(0.0)
				.maxCompletionTokens(500)
				.build();
		var futureChat = openAI.chatCompletions().create(chatRequest);
		var chatResponse = futureChat.join();
		return chatResponse.firstContent();
				
						
		
	}
}
