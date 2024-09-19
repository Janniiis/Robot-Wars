package com.btcag.bootcamp;

import java.util.Scanner;

public class WelcomePlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie ihren Gamertag ein: ");
        String username = scanner.nextLine();
        System.out.println("Willkommen " + username + "!");

        System.out.println("Erstelle deinen eigenen Roboter.");
        System.out.println("Gib deinem Roboter einen Namen: ");
        String RoboName = scanner.nextLine();
        System.out.println("Hi, " + RoboName);

        System.out.println("8888888b.          888               888         888       888                           \n" +
                "888   Y88b         888               888         888   o   888                           \n" +
                "888    888         888               888         888  d8b  888                           \n" +
                "888   d88P .d88b.  88888b.   .d88b.  888888      888 d888b 888  8888b.  888d888 .d8888b  \n" +
                "8888888P\" d88\"\"88b 888 \"88b d88\"\"88b 888         888d88888b888     \"88b 888P\"   88K      \n" +
                "888 T88b  888  888 888  888 888  888 888         88888P Y88888 .d888888 888     \"Y8888b. \n" +
                "888  T88b Y88..88P 888 d88P Y88..88P Y88b.       8888P   Y8888 888  888 888          X88 \n" +
                "888   T88b \"Y88P\"  88888P\"   \"Y88P\"   \"Y888      888P     Y888 \"Y888888 888      88888P' \n" +
                "                                                                                        ");

    }
}
