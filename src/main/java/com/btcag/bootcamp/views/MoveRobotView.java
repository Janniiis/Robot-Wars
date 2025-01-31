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




    int mapIndex = 0;
        if (direction.equals("w")){
        mapIndex -= 9;
    } else if (direction.equals("s")){
        mapIndex += 9;
    } else if (direction.equals("a")){
        mapIndex--;
    } else if (direction.equals("d")){
        mapIndex++;
    } else if (direction.equals("q")){
        mapIndex -= 10;
    } else if (direction.equals("e")){
        mapIndex -= 8;
    } else if (direction.equals("y")){
        mapIndex += 8;
    } else if (direction.equals("c")){
        mapIndex += 10;
    }
        return mapIndex;
}
}
