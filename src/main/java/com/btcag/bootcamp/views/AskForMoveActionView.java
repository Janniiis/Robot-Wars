package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Bot;

import java.util.Scanner;

public class AskForMoveActionView {
    public static String display(Bot bot){
        Scanner scanner = new Scanner(System.in);
        System.out.println("«--------------------»");
        System.out.println("Du bist am Zug: "+ bot.getName());
        System.out.println("""
                
                Wähle eine aktion:
                
                [1] Angreifen
                [2] Bewegen
                [3] Ausrichten
                
                «--------------------»
                """);
        int readIn = scanner.nextInt();

        String choice = "";
        if (readIn == 2) {
            if (bot.getMovementRate() != 0) {
                choice = "MOVE";
            } else if(bot.getMovementRate() <= 0) {
                choice = "END";
            }
        } else if (readIn == 1) {
            choice = "ATTACK";
        } else if (readIn == 3) {
            choice = "ALIGN";
        } else {
            System.out.println("error");
        }
        return choice;
    }
}
