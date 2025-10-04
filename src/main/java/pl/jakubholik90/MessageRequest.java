package pl.jakubholik90;

// rekord jako opakowanie do przechowania nowego zapytania oraz id starej odpowiedzi
public record MessageRequest(String message, String previousResponseId) {
}
