package examples;

import java.time.Duration;
import java.lang.System;

import io.github.stefanbratanov.jvm.openai.*;
import io.github.stefanbratanov.jvm.openai.OpenAI;

public class ExampleChatClient {
	
	public static void main(String... args) {
    Duration TIMEOUT = Duration.ofSeconds(20);
    String token = System.getenv("OPENAI_API_KEY");

    OpenAI openAI;
    String prompt="Who won the world series in 2020?";
    System.out.print("run ExampleChatClient.java");
    openAI = OpenAI.newBuilder(token)
    .requestTimeout(TIMEOUT)
    .build();
  
  // Test simple chat connection
  ChatClient chatClient = openAI.chatClient();
  CreateChatCompletionRequest createChatCompletionRequest = CreateChatCompletionRequest.newBuilder()
    .model("gpt-4.1")
    .message(ChatMessage.userMessage(prompt))
    .build();
  ChatCompletion chatCompletion = chatClient.createChatCompletion(createChatCompletionRequest);
  //System.out.println(chatCompletion.choices().get(0));
 
  System.out.println("Prompt: "+ prompt);
  System.out.println("Result: "+chatCompletion.choices().get(0).message().content());

  }
}