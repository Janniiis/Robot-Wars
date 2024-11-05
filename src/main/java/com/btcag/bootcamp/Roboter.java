package com.btcag.bootcamp;

import java.util.Scanner;

public class Roboter {
    int hp;
    int energy;
    int shield;
    int damage;
    int range;
    int damageZone;
    int accuracy;
    static int movementSpeed;
    static int x;
    static int y;
    String username;
    String roboterSymbol;
    String RESET;
    String RED;
    String BLUE;

    public Roboter(int x, int y, int movementSpeed, String username, String roboterSymbol) {
        this.hp = 1;
        this.energy = 1;
        this.shield = 1;
        this.damage = 1;
        this.range = 1;
        this.damageZone = 1;
        this.accuracy = 1;
        this.movementSpeed = 1;
        this.x = x;
        this.y = y;
        this.RESET = "\u001B[0m";
        this.RED = "\u001B[31m";
        this.BLUE = "\u001B[34m";
    }


    public int getPositionX(){
        return x;
    }

    public int getPositionY(){
        return y;
    }

    public int getEnergy(){
        return energy;
    }

    public int getShield(){
        return shield;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getDamageZone() {
        return damageZone;
    }

    public int getRange() {
        return range;
    }

    public String getRoboterSymbol(int userInput){
        switch (userInput){
            case 1 ->{
                roboterSymbol = "#";
            }
            case 2 ->{
                roboterSymbol = "*";
            }
            case 3 ->{
                roboterSymbol ="%";
            }
        }
        return  roboterSymbol;
    }

    public void move(String direction){
        switch (direction){
            case "w" ->{
                if (y > 0) {
                    y--;
                }
                else {
                    System.out.println("Invalider Spielzug, versuche es erneut!");
                    return;
                }
            }
            case "q" ->{
                if (y > 0 && x > 0) {
                    y--;
                    x--;
                }
                else {
                    System.out.println("Invalider Spielzug, versuche es erneut!");
                    return;
                }
            }
            case "e" ->{
                if (y > 0 && x < 15) {
                    y--;
                    x++;
                }
                else {
                    System.out.println("Invalider Spielzug, versuche es erneut!");
                    return;
                }
            }
            case "y" ->{
                if (y < 15 && x < 0) {
                    y++;
                    x--;
                }
                else {
                    System.out.println("Invalider Spielzug, versuche es erneut!");
                    return;
                }
            }
            case "c" ->{
                if (y < 15 && x < 15) {
                    y++;
                    x++;
                }
                else {
                    System.out.println("Invalider Spielzug, versuche es erneut!");
                    return;
                }
            }
            case "a" ->{
                if (x > 0) {
                    x--;
                }
                else {
                    System.out.println("Invalider Spielzug, versuche es erneut!");
                    return;
                }
            }
            case "x" ->{
                if (y < 15) {
                    y++;
                }
                else {
                    System.out.println("Invalider Spielzug, versuche es erneut!");
                    return;
                }
            }
            case "d" ->{
                if (x < 15) {
                    x++;
                }
                else {
                    System.out.println("Invalider Spielzug, versuche es erneut!");
                    return;
                }
            }
        }
    }

    public int attack(){
        return damage;
    }

    public int doAction(int action, String direction){
        switch (action){
            case 1 -> {
                move(direction);
                return 0;
            }
            case 2 -> {
                return damage;
            }
        }
        return 0;
    }

    public int askAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte wähle einen Spielzug: \n [1] Bewegen \n [2] Angreifen");
        return scanner.nextInt();
    }

    public String askDirection(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe die Richtung ein: ");
        return scanner.nextLine();
    }

    public boolean checkPosition(int i, int j){
        return x == i && y == j;
    }

    public int getHp(){
        return hp;
    }

    public void getDamage(int damage){
        hp -= damage;
    }
}
