package pl.jakubholik90;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        // dzieki springdoc dokumentacja bedzie dostepna pod
        // localhost:8080/swagger-ui.html

    }
}