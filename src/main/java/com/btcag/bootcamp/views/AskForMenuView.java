package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Bot;

import java.io.IOException;
import java.util.Scanner;

import static com.btcag.bootcamp.APIconnection.*;

public class AskForMenuView {
    public static Bot bot = new Bot("");
    public static int display() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Bitte wähle zwischen folgenden Möglichkeiten:
                    1 ~ gibt alle Roboter aus.
                    2 ~ gibt einen bestimmten Roboter aus.
                    3 ~ gibt alle Karten aus.
                    4 ~ gibt alle Spiele aus.
                    5 ~ gibt eine bestimmte Map aus.
                    6 ~ gibt ein bestimmtes Spiel aus.
                    7 ~ erstellt einen Roboter.
                    8 ~ erstellt ein Spiel.
                    9 ~ tritt einem Spiel bei.
                    10 ~ bewege den Roboter.
                    99 ~ Beenden.
                """);
        return scanner.nextInt();
    }

    public static void decideInput() throws IOException {
        int input;
        do {
            input = AskForMenuView.display();
            if (input == 1) {
                getAllBots();
            } else if (input == 2) {
                getSpecificBot();
            } else if (input == 3) {
                getAllMaps();
            } else if (input == 4) {
                getAllGames();
            } else if (input == 5) {
                getSpecificMap();
            } else if (input == 6) {
                getSpecificGame();
            } else if (input == 7) {
                bot.setName(AskForRobotNameView.display());
                AskForSkillPoints.display(bot);
                AskForSkillPoints.displayStats(bot);
                createRobot(bot);
            } else if (input == 8) {
                createGame();
            } else if (input == 9) {
                joinGame();
            } else if (input == 10) {
                makeAMove(bot);
            }else if (input == 99) {
                System.out.println("Programm beendet!");
            } else {
                System.out.println("error");
            }
        } while (input != 99);
    }
}
