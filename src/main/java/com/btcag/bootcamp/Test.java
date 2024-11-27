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
        printRow(width, "┌", "─", "┬", "┐");
    }

    public static void printMainRow(int width){
        for (int i = 0; i < height - 2; i++){
            printRow(width, "├", "─", "┼", "┤");
        }
    }

    public static void printBottomRow(int width){
        printRow(width, "└", "─", "┴", "┘");
    }

    public static void printRow(int width, String start, String main, String connector, String end){
        int counterX = 1;
        System.out.print(start);
        for (int i = 0; i < width; i++){
            if (counterX == robotX && counterY == robotY) {
                System.out.print(symbol);
            } else {
                System.out.print(main);
            }

            if (i < width - 1) {
                System.out.print(connector);
            }
            counterX++;
        }
        System.out.print(end);
        System.out.println();
        counterY++;
    }
}
