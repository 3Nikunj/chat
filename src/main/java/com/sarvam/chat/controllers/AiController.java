package com.sarvam.chat.controllers;

import com.sarvam.chat.dto.ChatRequest;
import com.sarvam.chat.dto.ChatResponse;
import com.sarvam.chat.services.AiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return new ChatResponse(aiService.askAi(request.getMessage()));
    }
}