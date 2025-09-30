package pl.jakubholik90;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

import java.util.List;

public class APIConnector {

    public static List<String> sendAndGetResponse(String input) {
        // tworzenie klienta
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(PrivateData.apiKey)
                .build();

        // tworzenie parametrow
        ResponseCreateParams params = ResponseCreateParams.builder()
                .model(ChatModel.O3_MINI)
                .input(input)
                .build();
        
        // tworzenie zapytania
        Response response = client.responses().create(params);

        List<String> outputList = response.output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(item -> item.content().stream())
                .flatMap(item -> item.outputText().stream())
                .map(item -> item.text()).toList();

        return outputList;
    }


}
