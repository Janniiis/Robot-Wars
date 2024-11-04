package com.btcag.bootcamp;

public class Playfield {
    private int sizeX;
    private int sizeY;
    private Roboter playerOne;
    private Roboter playerTwo;
    private boolean playerSet = false;
    private final Color color;

    public Playfield(Color color) {
        this.color = color;

        sizeX = 15;
        sizeY = 10;
    }

    public void drawField(String roboterSymbol, int playerOneX, int playerOneY, int playerTwoX, int playerTwoY) {

        if (playerSet) {
            int y = 0;
            while (y < sizeY) {
                int x = 0;
                while (x < sizeX) {
                    if (playerOne.checkPosition(x, y)) {
                        System.out.print(Color.RED + "[" + Color.RESET + Color.RED + playerOne.roboterSymbol + Color.RESET + Color.RED + "]" + Color.RESET);
                    } else if (playerTwo.checkPosition(x, y)) {
                        System.out.print(Color.BLUE + "[" + Color.RESET + Color.BLUE + playerTwo.roboterSymbol + Color.RESET + Color.BLUE + "]" + Color.RESET);
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