package com.btcag.bootcamp;

public class Playfield {
    private int sizeX;
    private int sizeY;
    private Roboter playerOne;
    private Roboter playerTwo;
    private boolean playerSet = false;

    public Playfield() {
        sizeX = 15;
        sizeY = 10;
    }

    public void drawField(String RESET, String RED, String BLUE, String roboterSymbol, int playerOneX, int playerOneY, int playerTwoX, int playerTwoY) {
        if (playerSet) {
            int y = 0;
            while (y < sizeY) {
                int x = 0;
                while (x < sizeX) {
                    if (playerOne.checkPosition(x, y)) {
                        System.out.print(RED + "[" + RESET + RED + playerOne.roboterSymbol() + RESET + RED + "]" + RESET);
                    } else if (playerTwo.checkPosition(x, y)) {
                        System.out.print(BLUE + "[" + RESET + BLUE + playerTwo.roboterSymbol() + RESET + BLUE + "]" + RESET);
                    }
                    else {
                        System.out.print("[ ]");
                    }
                    x++;
                }
                System.out.println();
                y++;
            }
        }
    }

    public void setPlayers(Roboter playerOne, Roboter playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerSet = true;
    }
}