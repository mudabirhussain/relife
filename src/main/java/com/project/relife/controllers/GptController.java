package com.project.relife.controllers;

import com.project.relife.dtos.requests.ChatRequest;
import com.project.relife.services.GptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class GptController {

    private final GptService gptService;

    @Autowired
    public GptController(GptService gptService) {
        this.gptService = gptService;
    }

    @GetMapping("/chat")
    public CompletableFuture<String> getChatResponse(@RequestBody ChatRequest request) {
        return gptService.getChatGPTResponse(request.getChat());
    }
}
