package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Bot;
import com.btcag.bootcamp.services.GetRequests;
import com.btcag.bootcamp.services.PostRequests;
import java.io.IOException;
import java.util.Scanner;

public class GameMenuView {
    public static Bot bot = new Bot("");
    public static void display() throws IOException, InterruptedException {
        int choice;
        do {
            System.out.println("""
                «-------------------------------------------------------»
                
                                     _- Game Menu -_
                                     
                                     [1] Roboter erstellen
                                     [2] Spiel erstellen
                                     [3] Spiel beitreten
                                     [4] Einen Spielzug machen
                                     [5] Verlassen
                
                «-------------------------------------------------------»
                """);

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if(choice == 1){
                bot.setName(AskForRobotNameView.display());
                bot.setSymbol(AskForRobotSymbolView.display());
                AskForSkillPointsView.display(bot);
                AskForSkillPointsView.displayStats(bot);
                Thread.sleep(5000);
                PostRequests.createRobot(bot);
            }else if (choice == 2){
                PostRequests.createGame();
            } else if (choice == 3){
                PostRequests.joinGame();
            } else if (choice == 4){
                PostRequests.makeAMove(bot);
            }
            else if (choice == 5){
                MainMenuView.display();
            }
            else{
                System.out.println("error");
            }
        }while (choice != 5);
    }
}
