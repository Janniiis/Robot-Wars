package com.btcag.bootcamp.views;

import java.io.IOException;
import java.util.Scanner;

import static com.btcag.bootcamp.services.GetRequests.*;

public class SettingsMenuView {
    public static void display() throws IOException, InterruptedException {
        int choice;
        do {
            System.out.println("""
                    «-------------------------------------------------------»
                    
                                         _- Settings -_
                    
                                         [1] Alle Bot's
                                         [2] 1x Bot (ID)
                                         [3] Alle Map's
                                         [4] 1x Map (ID)
                                         [5] Alle Game's
                                         [6] 1x Game (ID)
                                         [7] Verlassen
                    
                    «-------------------------------------------------------»
                    """);

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if (choice == 1) {
                getAllBots();
            } else if (choice == 2) {
                getSpecificBot();
            } else if (choice == 3) {
                getAllMaps();
            } else if (choice == 4) {
                getSpecificMap();
            } else if (choice == 5) {
                getAllGames();
            } else if (choice == 6) {
                getSpecificGame();
            } else if (choice == 7) {
                MainMenuView.display();
            } else {
                System.out.println("error");
            }
        } while (choice != 7);
    }
}
