package com.btcag.bootcamp.views;

import java.util.Scanner;

public class AskForRobotSymbolView {
    public static char display(){
        char symbol = 'o';
        System.out.println("""
                «-------------------------------------------------------»
                Bitte wähle zwischen einem der 4 unten gezeigten Symbole:
                
                1 ~ o
                2 ~ x
                3 ~ +
                4 ~ *
                
                «-------------------------------------------------------»
                """);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice == 1){
            symbol = 'o';
        } else if(choice == 2){
            symbol = 'x';
        } else if(choice == 3){
            symbol = '+';
        } else if(choice == 4){
            symbol = '*';
        } else{
            System.out.println("error");
        }
        return symbol;
    }
}
