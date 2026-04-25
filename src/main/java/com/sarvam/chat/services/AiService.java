package com.sarvam.chat.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatClient chatClient;

    public AiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String askAi(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}