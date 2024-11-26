package com.btcag.bootcamp;

public class Test {
    static int height = 15;
    public static int width = 10;
    public static void main(String[] args) {
        printHeaderRow(width);
        printMainRow(width);
        printBottomRow(width);
    }

    public static void printHeaderRow(int width){
        printEmptyRow(width, "┌", "─", "┬","┐");
    }

    public static void printMainRow(int width){
        for (int i = 0; i < height-2; i++){
            printEmptyRow(width,"├", "─","┼", "┤");
        }
    }

    public static void printBottomRow(int width){
        printEmptyRow(width, "└", "─", "┴", "┘");
    }

    public static void printEmptyRow(int width, String start, String main, String connector, String end){
        System.out.print(start);
        for (int i = 0; i < width-1; i++){
            System.out.print(main);
            System.out.print(connector);
        }
        System.out.print(main);
        System.out.print(end);
        System.out.println();
    }
}
