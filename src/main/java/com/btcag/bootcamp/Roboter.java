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
    static String roboterSymbol;
    String RESET;
    String RED;
    String BLUE;

    public Roboter(int x, int y, int movementSpeed, String username, String roboterSymbol, int hp, int energy, int shield, int damage, int range, int damageZone) {
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
                Movement.moveTop();
            }
            case "q" ->{
                Movement.moveTopLeft();
            }
            case "e" ->{
                Movement.moveTopRight();
            }
            case "y" ->{
                Movement.moveBottomLeft();
            }
            case "c" ->{
                Movement.moveBottomRight();
            }
            case "a" ->{
                Movement.moveLeft();
            }
            case "x" ->{
                Movement.moveBottom();
            }
            case "d" ->{
                Movement.moveRight();
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

    public static boolean checkPosition(int i, int j){
        return x == i && y == j;
    }

    public int getHp(){
        return hp;
    }

    public void getDamage(int damage){
        hp -= damage;
    }
}
