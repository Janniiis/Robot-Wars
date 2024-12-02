package com.btcag.bootcamp;

public class ASCIIBoard {
    private int height;
    private int width;
    private char[][] board;

    public ASCIIBoard(int height, int width) {
        this.height = height;
        this.width = width;
        board = new char[height][width];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void placeSymbol(int x, int y, char symbol) {
        if (x >= 0 && x < height && y >= 0 && y < width) {
            board[x][y] = symbol;
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

    public static void main(String[] args) {
        ASCIIBoard board = new ASCIIBoard(10, 15);
        board.placeSymbol(2, 3, 'X');
        board.placeSymbol(5, 7, 'O');
        board.printBoard();
    }
}

