package com.btcag.bootcamp.models;

public class Battlefield {
    private char[]board;
    private final int rows;
    private final int   cols;

    // Erstellung der Map
    public Battlefield(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new char[rows*cols];
        for(int i = 0; i < board.length; i++) {
            board[i] = '.';
        }
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
}
