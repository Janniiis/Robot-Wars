package com.btcag.bootcamp.models;

public class Battlefield {
    private static int width = 10;
    private static int height = 15;


    public Battlefield(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isValidField(int x, int y) {
        return x > 0 && x <= width && y > 0 && y <= height;
    }

    public void setField(int roboterPositionX, int roboterPositionY, char roboterSymbol) {

    }

    public static void printHeaderRow(int width, Robot robot, Robot robot2) {
        printRow(width, "┌", "─", "┬", "┐", robot, robot2);
    }

    public static int counterY = 1;

    public static void printMainRow(int width, int height, Robot robot, Robot robot2) {
        for (int i = 0; i < Battlefield.height - 2; i++) {
            printRow(width, "├", "─", "┼", "┤", robot, robot2);
        }
    }

    public static void printBottomRow(int width, Robot robot, Robot robot2) {
        printRow(width, "└", "─", "┴", "┘", robot, robot2);
    }

    public static void printRow(int width, String start, String main, String connector, String end, Robot robot, Robot robot2) {
        int counterX = 1;
        System.out.print(start);
        for (int i = 0; i < width; i++) {
            if (counterX == robot.getRoboterPositionX() && counterY == robot.getRoboterPositionY()) {
                System.out.print(robot.getRoboterSymbol());
                System.out.print(" (Roboter)"); // Debug-Ausgabe
            } else if (counterX == robot2.getRoboterPositionX() && counterY == robot2.getRoboterPositionY()) {
                System.out.print(robot2.getRoboterSymbol());
                System.out.print(" (Roboter2)");
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

    public static void display(Battlefield battlefield, Robot robot, Robot robot2) {
        printHeaderRow(width, robot, robot2);
        printMainRow(width, height, robot, robot2);
        printBottomRow(width, robot, robot2);
    }
}
