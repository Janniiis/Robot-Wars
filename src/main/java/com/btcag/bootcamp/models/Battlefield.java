package com.btcag.bootcamp.models;

import static com.btcag.bootcamp.views.GameMenuView.bot;

public class Battlefield {
    private char[]board;
    private final int rows;
    private final int   cols;
    private int playerIndex;

    // Erstellung der Map
    public Battlefield(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new char[rows*cols];
        for(int i = 0; i < board.length; i++) {
            board[i] = '.';
        }
        playerIndex = 0;
        board[playerIndex] = bot.getSymbol();
    }

    // Map wird initalisiert
    public void initialiseMap() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(board[i*cols+j] + " ");
            }
            System.out.println();
        }
    }

    // Symbol (Roboter, Hindernisse oder items) auf die Karte bringen
    public void printSymbol(int mapIndex, char symbol) {
        board[mapIndex] = symbol;
    }

    public void movePlayer(int newIndex){
        if (newIndex >= 0 && newIndex < board.length) {
            board[playerIndex] = '.';
            playerIndex = newIndex;
            board[playerIndex] = bot.getSymbol();
        } else {
            System.out.println("Ungültiger Index");
        }
    }
}
