package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWars {

    //-------------- Cords --------------

    public static int playerOneY = 0;
    public static int playerOneX = 7;
    public static int playerTwoY = 9;
    public static int playerTwoX = 7;

    //-------------- Icons --------------

    public static String avatarIconPlayerOne = "";
    public static String avatarIconPlayerTwo = "";

    //-------------- Colors -----------------

    public static String RESET = "\u001B[0m";
    public static String RED = "\u001B[31m";
    public static String BLUE = "\u001B[34m";
    public static String WHITE = "\u001B[37m";

    //-------------- Sonstiges --------------

    public static Scanner readIn = new Scanner(System.in);
    public static boolean state = true;
    public static boolean gameState;
    public static String playerOne;
    public static String playerTwo;


    public static void main(String[] args) {
        gameState = true;
        while (gameState) {

            Scanner readIn = new Scanner(System.in);
            String ascii = "\"                                             bbbbbbbb                                                                                                                                                                   \\n\" +\n" +
                    "                \"RRRRRRRRRRRRRRRRR                   b::::::b                                   ttttttt                           WWWWWWWW                           WWWWWWWW                                                   \\n\" +\n" +
                    "                \"R::::::::::::::::R                  b::::::b                                   t:::::t                           W::::::W                           W::::::W                                                   \\n\" +\n" +
                    "                \"R::::::RRRRRR:::::R                 b::::::b                                   t:::::t                           W::::::W                           W::::::W                                                   \\n\" +\n" +
                    "                \"RR:::::R     R:::::R                 b:::::b                                   t:::::t                           W::::::W                           W::::::W                                                   \\n\" +\n" +
                    "                \"  R::::R     R:::::R   ooooooooooo   b:::::bbbbbbbbb       ooooooooooo   ttttttt:::::ttttttt                      W:::::W           WWWWW           W:::::Waaaaaaaaaaaaa  rrrrr   rrrrrrrrr       ssssssssss   \\n\" +\n" +
                    "                \"  R::::R     R:::::R oo:::::::::::oo b::::::::::::::bb   oo:::::::::::oo t:::::::::::::::::t                       W:::::W         W:::::W         W:::::W a::::::::::::a r::::rrr:::::::::r    ss::::::::::s  \\n\" +\n" +
                    "                \"  R::::RRRRRR:::::R o:::::::::::::::ob::::::::::::::::b o:::::::::::::::ot:::::::::::::::::t                        W:::::W       W:::::::W       W:::::W  aaaaaaaaa:::::ar:::::::::::::::::r ss:::::::::::::s \\n\" +\n" +
                    "                \"  R:::::::::::::RR  o:::::ooooo:::::ob:::::bbbbb:::::::bo:::::ooooo:::::otttttt:::::::tttttt     ---------------     W:::::W     W:::::::::W     W:::::W            a::::arr::::::rrrrr::::::rs::::::ssss:::::s\\n\" +\n" +
                    "                \"  R::::RRRRRR:::::R o::::o     o::::ob:::::b    b::::::bo::::o     o::::o      t:::::t           -:::::::::::::-      W:::::W   W:::::W:::::W   W:::::W      aaaaaaa:::::a r:::::r     r:::::r s:::::s  ssssss \\n\" +\n" +
                    "                \"  R::::R     R:::::Ro::::o     o::::ob:::::b     b:::::bo::::o     o::::o      t:::::t           ---------------       W:::::W W:::::W W:::::W W:::::W     aa::::::::::::a r:::::r     rrrrrrr   s::::::s      \\n\" +\n" +
                    "                \"  R::::R     R:::::Ro::::o     o::::ob:::::b     b:::::bo::::o     o::::o      t:::::t                                  W:::::W:::::W   W:::::W:::::W     a::::aaaa::::::a r:::::r                  s::::::s   \\n\" +\n" +
                    "                \"  R::::R     R:::::Ro::::o     o::::ob:::::b     b:::::bo::::o     o::::o      t:::::t    tttttt                         W:::::::::W     W:::::::::W     a::::a    a:::::a r:::::r            ssssss   s:::::s \\n\" +\n" +
                    "                \"RR:::::R     R:::::Ro:::::ooooo:::::ob:::::bbbbbb::::::bo:::::ooooo:::::o      t::::::tttt:::::t                          W:::::::W       W:::::::W      a::::a    a:::::a r:::::r            s:::::ssss::::::s\\n\" +\n" +
                    "                \"R::::::R     R:::::Ro:::::::::::::::ob::::::::::::::::b o:::::::::::::::o      tt::::::::::::::t                           W:::::W         W:::::W       a:::::aaaa::::::a r:::::r            s::::::::::::::s \\n\" +\n" +
                    "                \"R::::::R     R:::::R oo:::::::::::oo b:::::::::::::::b   oo:::::::::::oo         tt:::::::::::tt                            W:::W           W:::W         a::::::::::aa:::ar:::::r             s:::::::::::ss  \\n\" +\n" +
                    "                \"RRRRRRRR     RRRRRRR   ooooooooooo   bbbbbbbbbbbbbbbb      ooooooooooo             ttttttttttt                               WWW             WWW           aaaaaaaaaa  aaaarrrrrrr              sssssssssss    \\n\" +\n" +
                    "                \"                                                                                                                                                                                                               \\n\" +\n" +
                    "                \"                                                                                                                                                                                                               \\n\" +\n" +
                    "                \"                                                                                                                                                                                                               \\n\" +\n" +
                    "                \"                                                                                                                                                                                                               \\n\" +\n" +
                    "                \"                                                                                                                                                                                                               \\n\" +\n" +
                    "                \"                                                                                                                                                                                                               \\n\" +\n" +
                    "                \"                                                                 ";

            System.out.println(ascii);

            //------------------ Player One ---------------------------

            System.out.println("Bitte geben Sie ihren Gamertag ein (Player 1): ");
            playerOne = readIn.nextLine();
            System.out.println("Willkommen " + playerOne + "!");

            System.out.println("Bitte gebe deinen Gamertag ein (Player 2):");
            playerTwo = readIn.nextLine();
            System.out.println("Willkommen " + playerTwo + "!");

            //------------------ Roboter Erstellung --------------------

            System.out.println("Erstellt euren eigenen Roboter!");

            System.out.println("Gib deinem Roboter einen Namen (Player 1): ");
            String robotNameOne = readIn.nextLine();
            System.out.println("Hi, " + robotNameOne);

            System.out.println("Gib deinem Roboter einen Namen (Player 2): ");
            String robotNameTwo = readIn.nextLine();
            System.out.println("Hi, " + robotNameTwo);

            //------------------ Avatar / Icon -------------------------

            System.out.println("1 --> %, 2 --> §, 3 --> ^, 4 --> #, 5 --> *");
            System.out.print("Wähle ein Icon für Player 1: ");
            avatarIconPlayerOne = chooseAvatar(readIn.nextInt());

            System.out.println("1 --> %, 2 --> §, 3 --> ^, 4 --> #, 5 --> *");
            System.out.print("Wähle ein Icon für Player 2: ");
            avatarIconPlayerTwo = chooseAvatar(readIn.nextInt());

            System.out.println("Avatar Spieler 1: " + avatarIconPlayerOne);
            System.out.println("Avatar Spieler 2: " + avatarIconPlayerTwo);

            //------------------ Gameplay ------------------------------

            playField();
            gameplay();

        }
    }


    public static String chooseAvatar(int icon) {
        String avatarIcon;
        switch (icon) {
            case 1:
                avatarIcon = "%";
                break;
            case 2:
                avatarIcon = "§";
                break;
            case 3:
                avatarIcon = "^";
                break;
            case 4:
                avatarIcon = "#";
                break;
            case 5:
                avatarIcon = "*";
                break;
            default:
                avatarIcon = "Ungültige Auswahl";
                break;
        }
        return avatarIcon;
    }

    public static void avatarCheck() {
        if (avatarIconPlayerTwo.equals(avatarIconPlayerOne)){
            state = false;
        }

    }

    public static void playField() {
        int y = 0;
        while (y < 10) {
            int x = 0;
            while (x < 15) {
                while (y == playerOneY && x == playerOneX) {
                    System.out.print(RED+"["+RESET + RED+avatarIconPlayerOne+RESET + RED+"]"+RESET);
                    x++;
                }
                while (y == playerTwoY && x == playerTwoX) {
                    System.out.print(BLUE+"["+RESET + BLUE+avatarIconPlayerTwo+RESET + BLUE+"]"+RESET);
                    x++;
                }
                System.out.print(WHITE+"[ ]"+RESET);
                x++;
            }
            System.out.println();
            y++;
        }
    }

    public static void movementPlayerOne() {
        System.out.println(playerOne + " du bist dran! Mache einen Zug. (W, A, S, D)");
        String input = readIn.nextLine();
        switch (input) {
            case "w":
                playerOneY--;
                break;

            case "a":
                playerOneX--;
                break;

            case "s":
                playerOneY++;
                break;

            case "d":
                playerOneX++;
                break;
        }
        playField();
    }

    public static void movementPlayerTwo() {
        System.out.println(playerTwo + " du bist dran! Mache einen Zug. (W, A, S, D)");
        String input = readIn.nextLine();
        switch (input) {
            case "w":
                playerTwoY--;
                break;

            case "a":
                playerTwoX--;
                break;

            case "s":
                playerTwoY++;
                break;

            case "d":
                playerTwoX++;
                break;
        }
        playField();
    }

    public static void gameplay(){
        while (gameState){
            movementPlayerOne();
            movementPlayerTwo();
            if (playerOneX == playerTwoX && playerOneY == playerTwoY){
                System.out.println("Das Spiel ist vorbei!");
                gameState = false;
            }
        }
    }
}