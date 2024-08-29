package com.project.relife.client;

import com.project.relife.configs.AIClientConfig;
import com.project.relife.dtos.requests.GenerateImageRequest;
import com.project.relife.dtos.requests.GptRequest;
import com.project.relife.dtos.requests.WhisperTranscriptionRequest;
import com.project.relife.dtos.responses.GenerateImageResponse;
import com.project.relife.dtos.responses.GptResponse;
import com.project.relife.dtos.responses.WhisperTranscriptionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "openai-service",
        url = "${openai-service.urls.base-url}",
        configuration = AIClientConfig.class
)
public interface AIClient {
    @PostMapping(value = "${openai-service.urls.chat-url}", headers = {"Content-Type=application/json"})
    GptResponse chat(@RequestBody GptRequest gptRequest);

    @PostMapping(value = "${openai-service.urls.create-transcription-url}", headers = {"Content-Type=multipart/form-data"})
    WhisperTranscriptionResponse createTranscription(@ModelAttribute WhisperTranscriptionRequest whisperTranscriptionRequest);

    @PostMapping(value = "${openai-service.urls.image-generation-url}", headers = {"Content-Type=application/json"})
    GenerateImageResponse generateImage(@RequestBody GenerateImageRequest request);
}