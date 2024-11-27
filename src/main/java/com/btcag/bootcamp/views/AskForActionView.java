package com.btcag.bootcamp.views;

import java.util.Scanner;

public class AskForActionView {
    public static int display(){
        Scanner readIn = new Scanner(System.in);
        System.out.println("""
                «--------------------»
                Wähle eine aktion:
                [1] Angreifen
                [2] Bewegen
                «--------------------»
                """);
        return readIn.nextInt();
    }
}
