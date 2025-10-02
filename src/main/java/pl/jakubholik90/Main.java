package pl.jakubholik90;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String welcomeMessage = "Witaj w Chatbocie!";
        String menu = "--- Wpisz swoje zapytanie do chatbota lub podaj \"quit\" w celu zakonczenia programu";
        String line = "---";
        String goodbyeMessage = "Zakonczono prace Chatbota. Dziekujemy za skorzystanie";
        String systemMessage = "--- Wysylam zapytanie ...";
        boolean runApp = true;
        List<String> chatHistory = new LinkedList<>();

        System.out.println(welcomeMessage);
        String previousResponseId = null;
        while (runApp) {
            System.out.println(line);
            System.out.println(menu);
            System.out.println(line);
            String input = scaner.nextLine();

            if (!input.equals("quit")) {
                System.out.println(systemMessage);
                System.out.println(line);
                String newResponseId = OpenAPIConnector.sendAndGetResponse(input,previousResponseId);
                previousResponseId = newResponseId;
            } else {
                System.out.println(line);
                System.out.println(goodbyeMessage);
                runApp = false;
                break;
            }
        }
    }
}