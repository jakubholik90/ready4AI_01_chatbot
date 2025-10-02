package pl.jakubholik90;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseOutputText;

import java.util.List;
import java.util.Optional;

public class APIConnector {

    public static String sendAndGetResponse(String input, String previousResponseId) {

        // tworzenie klienta
        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(PrivateData.apiKey)
                .build();

        // tworzenie parametrow
        ResponseCreateParams params = ResponseCreateParams.builder()
                .model(ChatModel.O3_MINI)
                .input(input)
                .previousResponseId(previousResponseId)
                .build();
        
        // tworzenie zapytania
        Response response = client.responses().create(params);

        // wyswietlanie wynikow

       response.output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(item -> item.content().stream())
                .flatMap(item -> item.outputText().stream())
                .map(ResponseOutputText::text)
               .forEach(System.out::println);

        return response.id();
    }


}
