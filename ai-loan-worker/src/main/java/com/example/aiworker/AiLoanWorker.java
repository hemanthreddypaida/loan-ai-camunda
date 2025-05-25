package com.example.aiworker;

import org.camunda.bpm.client.ExternalTaskClient;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class AiLoanWorker {
    public static void main(String[] args) {
        ExternalTaskClient client = ExternalTaskClient.create()
            .baseUrl("http://localhost:8080/engine-rest")
            .build();

        client.subscribe("ai-loan-analysis")
            .lockDuration(1000)
            .handler((externalTask, externalTaskService) -> {
                String claimText = externalTask.getVariable("loanNarrative");
                String prompt = "Analyze this loan application: " + claimText;

                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/completions"))
                    .header("Authorization", "Bearer YOUR_OPENAI_KEY")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{"prompt": "" + prompt + "", "max_tokens": 200}"))
                    .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                String aiRecommendation = response.body();

                externalTaskService.complete(externalTask,
                    Map.of("aiRecommendation", aiRecommendation));
            });
    }
}
