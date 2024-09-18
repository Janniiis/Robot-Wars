package com.btcag.bootcamp;

import java.util.Scanner;

public class WelcomePlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie ihren Gamertag ein: ");
        String username = scanner.nextLine();
        System.out.println("Willkommen " + username + "!");
    }
}
