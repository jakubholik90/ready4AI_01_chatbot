package pl.jakubholik90;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void runApp() {

        Scanner scanner = new Scanner(System.in);
        String welcomeMessage = "Witaj w Chatbocie!";
        String menu = "--- Wpisz swoje zapytanie do chatbota lub podaj \"quit\" w celu zakonczenia programu";
        String line = "---";
        String goodbyeMessage = "Zakonczono prace Chatbota. Dziekujemy za skorzystanie";
        String systemMessage = "--- Wysylam zapytanie ...";
        boolean runAppBool = true;

        System.out.println(welcomeMessage);
        String previousResponseId = null;
        while (runAppBool) {
            System.out.println(line);
            System.out.println(menu);
            System.out.println(line);
            String input = scanner.nextLine();

            if (!input.equals("quit")) {
                System.out.println(systemMessage);
                System.out.println(line);
               // String newResponseId = OpenAIAPIConnector.sendAndGetResponse(input,previousResponseId);
                // previousResponseId = newResponseId;
            } else {
                System.out.println(line);
                System.out.println(goodbyeMessage);
                runAppBool = false;
                break;
            }
        }

    }

}
