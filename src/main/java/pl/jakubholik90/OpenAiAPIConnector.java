package pl.jakubholik90;

import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseOutputText;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/chat")
// caly chatbot bedzie dostepny pod serwerem / chat (np. localhost:8080/chat)
@RestController
public class OpenAiAPIConnector {

    private final OpenAIClient client;

    public OpenAiAPIConnector(OpenAIClient aiClient) {
        this.client = aiClient;
    }


    // testowa metoda do sprawdzania czy restApi dziala
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping
    public ResponseEntity<MessageResponse> message(@RequestBody MessageRequest messageRequest) {
        ResponseCreateParams params = ResponseCreateParams.builder()
                .model(ChatModel.O3_MINI)
                .input(messageRequest.message())
                .previousResponseId(messageRequest.previousResponseId())
                .build();

        Response response = client.responses().create(params);

        String responseText = response.output().stream()
                .flatMap(item -> item.message().stream())
                .flatMap(item -> item.content().stream())
                .flatMap(item -> item.outputText().stream())
                .map(ResponseOutputText::text)
                .toList()
                .getFirst();
        return ResponseEntity.ok(new MessageResponse(responseText,response.id()));
    }
}
