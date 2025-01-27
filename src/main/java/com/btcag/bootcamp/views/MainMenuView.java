package com.btcag.bootcamp.views;

import java.io.IOException;
import java.util.Scanner;

public class MainMenuView {
    public static void display() throws IOException, InterruptedException {
        int choice;
        do {
            System.out.println("""
                «-------------------------------------------------------»
                
                                     _- Main Menu -_
                                     
                                     [1] Spielen
                                     [2] Einstellungen
                                     [3] Verlassen
                
                «-------------------------------------------------------»
                """);

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if(choice == 1){
                GameMenuView.display();
            }else if (choice == 2){
                SettingsMenuView.display();
            } else if (choice == 3){
                System.out.println("Programm beendet!");
            } else{
                System.out.println("error");
            }
        }while (choice != 3);
    }
}
