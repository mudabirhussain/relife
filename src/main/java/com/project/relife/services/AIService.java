package com.project.relife.services;

import com.project.relife.client.AIClient;
import com.project.relife.configs.AIClientConfig;
import com.project.relife.dtos.internals.Message;
import com.project.relife.dtos.requests.ChatRequest;
import com.project.relife.dtos.requests.GptRequest;
import com.project.relife.dtos.requests.TranscriptionRequest;
import com.project.relife.dtos.requests.WhisperTranscriptionRequest;
import com.project.relife.dtos.responses.GenerateImageResponse;
import com.project.relife.dtos.responses.GptResponse;
import com.project.relife.dtos.responses.WhisperTranscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.project.relife.dtos.requests.GenerateImageRequest;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AIService {
    private final AIClient aiClient;
    private final AIClientConfig aiClientConfig;

    private final static String ROLE_USER = "user";

    public GptResponse chat(ChatRequest chatRequest) {
        Message message = new Message();
        message.setRole(ROLE_USER);
        message.setContent(chatRequest.getQuestion());

        GptRequest gptRequest = new GptRequest();
        gptRequest.setModel(aiClientConfig.getModel());
        gptRequest.setMessages(Collections.singletonList(message));
        return aiClient.chat(gptRequest);
    }

    public WhisperTranscriptionResponse createTranscription(TranscriptionRequest transcriptionRequest){
        WhisperTranscriptionRequest whisperTranscriptionRequest = WhisperTranscriptionRequest.builder()
                .model(aiClientConfig.getAudioModel())
                .file(transcriptionRequest.getFile())
                .build();
        return aiClient.createTranscription(whisperTranscriptionRequest);
    }

    public GenerateImageResponse generateImage(GenerateImageRequest request) {
        GenerateImageRequest generateImageRequest = GenerateImageRequest.builder()
                .prompt(request.getPrompt())
                .build();
        return aiClient.generateImage(generateImageRequest);
    }
}
