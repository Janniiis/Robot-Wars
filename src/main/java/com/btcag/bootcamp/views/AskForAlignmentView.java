package com.btcag.bootcamp.views;

import com.btcag.bootcamp.enums.Directions;

import java.util.Scanner;

public class AskForAlignmentView {
    public static String display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                «--------------------------------------------------------------»
                Bitte wähle eine Richtung in die dein Roboter ausgerichtet werden soll:
                
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

        String temp = scanner.nextLine();
        return temp;
    }
}

