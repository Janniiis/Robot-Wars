package com.btcag.bootcamp;

import java.util.Scanner;

public class SurfaceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Groesse des Spielfeldes: ");
        int number = scanner.nextInt();
        int i = 0;
        while (i < number) {
            int j = 0;
            while (j < number) {
                System.out.print("[ ]");
                j++;
            }
            System.out.println("");
            i++;
        }
    }
}
