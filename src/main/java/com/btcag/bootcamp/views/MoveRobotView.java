package com.btcag.bootcamp.views;

import java.util.Scanner;

public class MoveRobotView {
    public static int display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                «--------------------------------------------------------------»
                
                Bitte wähle eine Richtung in die sich dein Roboter bewegen soll:
                
                [w] Oben
                [s] unten
                [a] links
                [d] rechts
                [q] oben-links
                [e] oben-rechts
                [y] unten-links
                [c] unten-rechts
                
                «--------------------------------------------------------------»
                """);

        String direction = scanner.nextLine();
        scanner.close(); // Scanner schließen

        int mapIndex = 0;
        switch (direction) {
            case "w" -> mapIndex -= 9;
            case "s" -> mapIndex += 9;
            case "a" -> mapIndex--;
            case "d" -> mapIndex++;
            case "q" -> mapIndex -= 10;
            case "e" -> mapIndex -= 8;
            case "y" -> mapIndex += 8;
            case "c" -> mapIndex += 10;
            default -> System.out.println("Ungültige Eingabe. Bitte wähle eine gültige Richtung.");
        }
        return mapIndex;
    }
}