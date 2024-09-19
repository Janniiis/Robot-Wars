package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ascii = "                                                                                                                                                                                                               \n" +
                "                                    bbbbbbbb                                                                                                                                                                   \n" +
                "RRRRRRRRRRRRRRRRR                   b::::::b                                      tttt                           WWWWWWWW                           WWWWWWWW                                                   \n" +
                "R::::::::::::::::R                  b::::::b                                   ttt:::t                           W::::::W                           W::::::W                                                   \n" +
                "R::::::RRRRRR:::::R                 b::::::b                                   t:::::t                           W::::::W                           W::::::W                                                   \n" +
                "RR:::::R     R:::::R                 b:::::b                                   t:::::t                           W::::::W                           W::::::W                                                   \n" +
                "  R::::R     R:::::R   ooooooooooo   b:::::bbbbbbbbb       ooooooooooo   ttttttt:::::ttttttt                      W:::::W           WWWWW           W:::::Waaaaaaaaaaaaa  rrrrr   rrrrrrrrr       ssssssssss   \n" +
                "  R::::R     R:::::R oo:::::::::::oo b::::::::::::::bb   oo:::::::::::oo t:::::::::::::::::t                       W:::::W         W:::::W         W:::::W a::::::::::::a r::::rrr:::::::::r    ss::::::::::s  \n" +
                "  R::::RRRRRR:::::R o:::::::::::::::ob::::::::::::::::b o:::::::::::::::ot:::::::::::::::::t                        W:::::W       W:::::::W       W:::::W  aaaaaaaaa:::::ar:::::::::::::::::r ss:::::::::::::s \n" +
                "  R:::::::::::::RR  o:::::ooooo:::::ob:::::bbbbb:::::::bo:::::ooooo:::::otttttt:::::::tttttt     ---------------     W:::::W     W:::::::::W     W:::::W            a::::arr::::::rrrrr::::::rs::::::ssss:::::s\n" +
                "  R::::RRRRRR:::::R o::::o     o::::ob:::::b    b::::::bo::::o     o::::o      t:::::t           -:::::::::::::-      W:::::W   W:::::W:::::W   W:::::W      aaaaaaa:::::a r:::::r     r:::::r s:::::s  ssssss \n" +
                "  R::::R     R:::::Ro::::o     o::::ob:::::b     b:::::bo::::o     o::::o      t:::::t           ---------------       W:::::W W:::::W W:::::W W:::::W     aa::::::::::::a r:::::r     rrrrrrr   s::::::s      \n" +
                "  R::::R     R:::::Ro::::o     o::::ob:::::b     b:::::bo::::o     o::::o      t:::::t                                  W:::::W:::::W   W:::::W:::::W     a::::aaaa::::::a r:::::r                  s::::::s   \n" +
                "  R::::R     R:::::Ro::::o     o::::ob:::::b     b:::::bo::::o     o::::o      t:::::t    tttttt                         W:::::::::W     W:::::::::W     a::::a    a:::::a r:::::r            ssssss   s:::::s \n" +
                "RR:::::R     R:::::Ro:::::ooooo:::::ob:::::bbbbbb::::::bo:::::ooooo:::::o      t::::::tttt:::::t                          W:::::::W       W:::::::W      a::::a    a:::::a r:::::r            s:::::ssss::::::s\n" +
                "R::::::R     R:::::Ro:::::::::::::::ob::::::::::::::::b o:::::::::::::::o      tt::::::::::::::t                           W:::::W         W:::::W       a:::::aaaa::::::a r:::::r            s::::::::::::::s \n" +
                "R::::::R     R:::::R oo:::::::::::oo b:::::::::::::::b   oo:::::::::::oo         tt:::::::::::tt                            W:::W           W:::W         a::::::::::aa:::ar:::::r             s:::::::::::ss  \n" +
                "RRRRRRRR     RRRRRRR   ooooooooooo   bbbbbbbbbbbbbbbb      ooooooooooo             ttttttttttt                               WWW             WWW           aaaaaaaaaa  aaaarrrrrrr              sssssssssss    \n" +
                "                                                                                                                                                                                                               \n" +
                "                                                                                                                                                                                                               \n" +
                "                                                                                                                                                                                                               \n" +
                "                                                                                                                                                                                                               \n" +
                "                                                                                                                                                                                                               \n" +
                "                                                                                                                                                                                                               \n" +
                "                                                                                                                                                                                                               ";
        System.out.println(ascii);
        System.out.println("Bitte geben Sie ihren Gamertag ein: ");
        String username = scanner.nextLine();
        System.out.println("Willkommen " + username + "!");

        System.out.println("Erstelle deinen eigenen Roboter.");
        System.out.println("Gib deinem Roboter einen Namen: ");
        String RoboName = scanner.nextLine();
        System.out.println("Hi, " + RoboName);

        System.out.println("Beginnen wir mit dem Aussehen deines Roboters, wähle eine Zahl zwischen 1 und 5: ");
        System.out.println("Avatar 1 -> %\n" +
                "Avatar 2 -> §\n" +
                "Avatar 3 -> ^\n" +
                "Avatar 4 -> #\n" +
                "Avatar 5 -> *");
        int avatar = scanner.nextInt();
        String icon = "";
        switch (avatar) {
            case 1:
                icon = "%";
                break;

            case 2:
                icon = "§";
                break;

            case 3:
                icon = "^";
                break;

            case 4:
                icon = "#";
                break;

            case 5:
                icon = "*";
                break;

        }
        System.out.println("Dein Avatar sieht folgendermaßen aus: " + icon);

        System.out.println("Bestimme die Größe deines Spielfeldes: ");
        int number = scanner.nextInt();
        int i = 0;
        while (i < number) {
            int j = 0;
            while (j < number) {
                System.out.print("[ ]");
                j++;
                if(i == 3 && j ==6){
                    System.out.print("["+icon+"]");
                    j++;
                }
            }
            System.out.println("");
            i++;
        }
    }
}
