package com.btcag.bootcamp;

public class Test {
    static int height = 15;
    public static int width = 10;
    public static String symbol = "♣";
    public static int robotX = 3;
    public static int robotY = 7;
    public static int counterY = -1;

    public static void main(String[] args) {
        printHeaderRow(width);
        printMainRow(width);
        printBottomRow(width);
        System.out.println("robotX: " + robotX);
        System.out.println("robotY: " + robotY);
    }

    public static void printHeaderRow(int width){
        for (int i = 0; i < width; i++){
            printHeaderRow(width, " ┌", "─", "┬");
        }

    }

    public static void printMainRow(int width){
        for (int i = 0; i < height / 2; i++){
            System.out.println();
            printRow(width, " ├", " ", "┼");
        }
        System.out.println();
    }

    public static void printBottomRow(int width)
    {
        printRow(width, "└", "─", "┴");
    }

    public static void printRow(int width, String start, String main, String connector){
        System.out.print(start);
        System.out.print(" "+main);
        System.out.print(" "+connector);
        System.out.print(" "+main);
        System.out.println();
        counterY++;
    }

    public static void printHeaderRow(int width, String start, String main, String connector){
        System.out.print(start);
        System.out.print(" "+main);
        System.out.print(" "+connector);
        System.out.print(" "+main);
        counterY++;
    }

}
