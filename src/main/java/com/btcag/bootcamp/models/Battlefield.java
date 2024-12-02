package com.btcag.bootcamp.models;

import com.btcag.bootcamp.ASCIIBoard;

public class Battlefield {
    private static int width = 10;
    private static int height = 15;
    private char[][] board;


    public Battlefield(int width, int height) {
        this.width = width;
        this.height = height;
        board = new char[height][width];
        initializeBoard();

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isValidField(int x, int y) {
        return x > 0 && x <= width && y > 0 && y <= height;
    }

    private void initializeBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void placeSymbol(int x, int y, char symbol) {
        if (y >= 0 && y < height && x >= 0 && x < width) {
            board[y][x] = symbol;
        } else {
            System.out.println("Koordinate außerhalb des Spielfelds.");
        }
    }

    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
