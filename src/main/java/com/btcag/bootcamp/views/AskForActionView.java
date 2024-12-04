package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

import java.util.Scanner;

public class AskForActionView {
    public static int displayPlayerOne(Robot robot){
        Scanner readIn = new Scanner(System.in);
        System.out.println("«--------------------»");
        System.out.println("Du bist am Zug: "+ robot.getName());
        System.out.println("""
                Wähle eine aktion:
                [1] Angreifen
                [2] Bewegen
                [3] Ausrichten
                «--------------------»
                """);
        return readIn.nextInt();
    }

    public static int displayPlayerTwo(Robot robot2){
        Scanner readIn = new Scanner(System.in);
        System.out.println("«--------------------»");
        System.out.println("Du bist am Zug: "+ robot2.getName());
        System.out.println("""
                Wähle eine aktion:
                [1] Angreifen
                [2] Bewegen
                [3] Ausrichten
                «--------------------»
                """);
        return readIn.nextInt();
    }
}
