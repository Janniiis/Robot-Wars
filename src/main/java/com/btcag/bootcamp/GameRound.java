package com.btcag.bootcamp;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GameRound {
    private Playfield playfield;
    private Roboter playerOne;
    private Roboter playerTwo;


    public GameRound(){

    }

    public void startRound(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");

        String username;
        System.out.println("Bitte geben Sie einen Username an: ");
        username = scanner.nextLine();
        Roboter[] player = setupPlayer(username);
        playerOne = player[0];
        playerTwo = player[1];
        System.out.println("1 -> #\n" +
                "2 -> *\n" +
                "3 -> %");
        playerOne.getRoboterSymbol(scanner.nextInt());
        playerTwo.getRoboterSymbol(scanner.nextInt());
        playfield = new Playfield(Color.RESET);
        playfield.setPlayers(playerOne, playerTwo);
    }

    private Roboter[] setupPlayer(String username){
        Roboter[] players = new Roboter[2];
        players[0] = new Roboter(7, 9, 1, username, "*");
        players[1] = new Roboter(7,0,1,"enemy","#");
        return players;
    }

    public void mainGame(){
        int round = 0;
        do {
            if (round % 2 == 0){
                int damageDone = playerOne.doAction(playerOne.askAction(), playerOne.askDirection());
                playerTwo.getDamage(damageDone);
            }
            else {
                int damageDone = playerTwo.doAction(playerTwo.askAction(), playerTwo.askDirection());
                playerOne.getDamage(damageDone);
            }

            playfield.drawField("", 0,0,0,0);
            System.out.println(round + "Runde");
            round++;
        }while (!checkGameOver());
    }

    public boolean checkGameOver(){
        return playerOne.getHp() == 0 || playerTwo.getHp() == 0;
    }
}
