package pl.jakubholik90;

// rekord do opakowania odpowiedzi i id odpowiedzi, wrzuci sie go w jako body response entity
public record MessageResponse(String response, String responseId) {
}
