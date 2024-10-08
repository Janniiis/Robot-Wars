package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWars {

    public static int rows = 10;
    public static int columns = 15;
    public static String field = "[ ]";
    public static String[][] playfield = new String[rows][columns];



    public static void main(String[] args) {
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
        System.out.println("Bitte geben Sie ihren Gamertag ein: ");
        String username = readIn.nextLine();
        System.out.println("Willkommen " + username + "!");

        System.out.println("Erstelle deinen eigenen Roboter.");
        System.out.println("Gib deinem Roboter einen Namen: ");
        String RoboName = readIn.nextLine();
        System.out.println("Hi, " + RoboName);
        System.out.println("1 --> %, 2 --> §, 3 --> ^, 4 --> #, 5 --> *");
        int icon = readIn.nextInt();
        chooseAvatar(icon);
    }


    public static String chooseAvatar(int icon) {
        String avatarIcon = "";
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

    public static void playField(int number, String avatarIcon) {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                playfield[i][j] = field;
            }
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(playfield[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void moveUp(){

    }

    public static void moveLeft(){

    }

    public static void moveDown(){

    }

    public static void moveRight(){

    }

    public static void movement(String input) {
        switch (input) {
            case "w":
                moveUp();
                break;

            case "a":
                moveLeft();
                break;

            case "s":
                moveDown();
                break;

            case "d":
                moveRight();
                break;
        }
    }
}