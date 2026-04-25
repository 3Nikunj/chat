package com.sarvam.chat.services;

import java.util.Date;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarvam.chat.entites.ChatInfo;
import com.sarvam.chat.repositories.ChatRepo;

@Service
public class AiService {
	
	@Autowired
	private ChatRepo repo;

    private final ChatClient chatClient;

    public AiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String askAi(String message) {
    		String res = chatClient
                    .prompt()
                    .user(message)
                    .call()
                    .content();
    		
    		ChatInfo obj = new ChatInfo (null,message, res, new Date());
    		
    		repo.save(obj);
        return res;
    }
}