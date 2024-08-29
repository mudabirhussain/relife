package com.project.relife.controllers;

import com.project.relife.dtos.requests.ChatRequest;
import com.project.relife.dtos.requests.GenerateImageRequest;
import com.project.relife.dtos.requests.TranscriptionRequest;
import com.project.relife.dtos.responses.GenerateImageResponse;
import com.project.relife.dtos.responses.GptResponse;
import com.project.relife.dtos.responses.WhisperTranscriptionResponse;
import com.project.relife.services.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/ai")
public class AIController {
    private final AIService aiService;

    @PostMapping(value = "/chat")
    public ResponseEntity<GptResponse> chat(@RequestBody ChatRequest chatRequest){
        return ResponseEntity.ok(aiService.chat(chatRequest));
    }

    @PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public WhisperTranscriptionResponse createTranscription(@ModelAttribute TranscriptionRequest transcriptionRequest){
        return aiService.createTranscription(transcriptionRequest);
    }

    @PostMapping(value = "/image", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenerateImageResponse generateImage(@RequestBody GenerateImageRequest request) {
        return  aiService.generateImage(request);
    }
}
