package com.sarvam.chat.Configurations;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AiConfigs {
	@Value("${SARVAM_API_KEY}")
    private String sarvamApiKey;

    @Bean
    public OpenAiApi openAiApi() {

        if (sarvamApiKey == null || sarvamApiKey.isBlank()) {
            throw new IllegalArgumentException("Sarvam API key is missing. Add sarvam.api.key in application.properties");
        }

        return OpenAiApi.builder()
                .apiKey(sarvamApiKey)
                .baseUrl("https://api.sarvam.ai")
                .completionsPath("/v1/chat/completions")
                .build();
    }

    @Bean
    public OpenAiChatModel chatModel(OpenAiApi openAiApi) {
        return OpenAiChatModel.builder()
                .openAiApi(openAiApi)
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("sarvam-105b")
                        .temperature(0.7)
                        .build())
                .build();
    }

    @Bean
    public ChatClient chatClient(OpenAiChatModel chatModel) {
        return ChatClient.builder(chatModel).build();
    }
}
