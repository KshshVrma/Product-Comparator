package com.compare.products.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GeminiService {

    private final RestTemplate restTemplate = new RestTemplate();
//    @Value("${gemini.api.key}")
    private String API_KEY=System.getenv("GEMINI_API_KEY");

    private final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + API_KEY;

    public String generateContent(String promptText) {
        // Build request body
        Map<String, Object> requestBody = new HashMap<>();
        List<Map<String, String>> parts = List.of(Map.of("text", promptText));
        requestBody.put("contents", List.of(Map.of("parts", parts)));

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    GEMINI_URL,
                    HttpMethod.POST,
                    entity,
                    Map.class
            );

            // Parse result
            Map responseBody = response.getBody();
            List candidates = (List) responseBody.get("candidates");
            if (candidates != null && !candidates.isEmpty()) {
                Map first = (Map) candidates.get(0);
                Map content = (Map) first.get("content");
                List partsList = (List) content.get("parts");
                Map part = (Map) partsList.get(0);
                return part.get("text").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "No response from Gemini.";
    }
}
