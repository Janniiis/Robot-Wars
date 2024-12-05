package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

import java.util.Scanner;

public class AskForSkillPoints {
    public static void display(Robot robot){
        int skillpoints = 10;
        Scanner readIn = new Scanner(System.in);
        while (skillpoints > 0){
            System.out.println("Du hast noch " + skillpoints + " skillpunkte.");
            System.out.println("""
                
                Bitte wähle erst aus welche fähigkeit du leveln möchtest,
                anschließen wie viele Skillpunkte du verteilen willst.
                
                [1] - Movement
                [2] - Damage
                [3] - Health
                [4] - Range
                
                «-----------------------------------------------»
                """);
        int choice = readIn.nextInt();
        int temp = displayAmount();


            if (choice == 1) {
                robot.setMovementRange(temp);
                skillpoints-=temp;
            } else if (choice == 2) {
                robot.setAttackDamage(temp);
                skillpoints-=temp;
            } else if (choice == 3) {
                robot.setHp(temp);
                skillpoints-=temp;
            } else if (choice == 4) {
                robot.setAttackRange(temp);
                skillpoints-=temp;
            } else {
                System.out.println("Ungültige auswahl");
            }

        }
    }

     public static int displayAmount(){
        Scanner readIn = new Scanner(System.in);
        System.out.println("""
                «-----------------------------------------------»
                
                Wie viele Skillpunkte möchtest du vergeben,
                du hast 10 zum verteilen. [1-10]
                
                «-----------------------------------------------»
                """);

         return readIn.nextInt();
    }

    public static void displayStats(Robot robot){
        System.out.println("«-----------------------------------------------»\n\n"  +
                "Du hast folgende Skillpunkte verteilt: "+
                "\nHealthpoints: " + robot.getHp()+
                "\nDamage: " + robot.getAttackDamage() +
                "\nRange: " + robot.getAttackRange() +
                "\nBewegunsrate: " + robot.getMovementRange()+
                "\n\n«-----------------------------------------------»");
    }
}
