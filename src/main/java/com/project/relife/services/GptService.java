package com.project.relife.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.relife.dtos.Message;
import com.project.relife.dtos.requests.GptRequest;
import com.project.relife.dtos.responses.GptResponse;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GptService {

    private final String apiUrl = "https://api.openai.com/v1/chat/completions";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    public CompletableFuture<String> getChatGPTResponse(String prompt) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                GptRequest requestDto = new GptRequest(
                        "asst_FBHZc90SvGGhPtr0GvfUxFE6",
                        List.of(new Message("user", prompt))
                );

                String requestBody = objectMapper.writeValueAsString(requestDto);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(apiUrl))
                        .header("Authorization", "Bearer " + getApiKey())
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    return parseResponse(response.body());
                } else {
                    throw new RuntimeException("Error in response: " + response.body());
                }
            } catch (Exception e) {
                throw new RuntimeException("Error while calling ChatGPT API", e);
            }
        }, executor);
    }

    private String parseResponse(String responseBody) throws IOException {
        GptResponse responseDto = objectMapper.readValue(responseBody, GptResponse.class);
        return responseDto.getChoices().getFirst().getMessage().getContent();
    }

    public static String getApiKey() {
        System.getenv().forEach((key, value) -> System.out.println(key + ": " + value));

        String apiKey = System.getenv("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("API key is not set. Please set the OPENAI_API_KEY environment variable.");
        }

        return apiKey;
    }
}
