package com.btcag.bootcamp.views;

import com.btcag.bootcamp.enums.Directions;

import java.util.Scanner;

public class MoveRobotView {
    public static String display() {
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


        Directions direction;
        do {
            direction = Directions.fromUserInput(
                    scanner.next().charAt(0)
            );
        } while (null == direction);
        return direction.toString();
    }
}
