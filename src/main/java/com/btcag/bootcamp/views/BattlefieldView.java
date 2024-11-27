package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Battlefield;
import com.btcag.bootcamp.models.Robot;

public class BattlefieldView {
    public static int height = 15;
    public static int width = 10;
    public static int counterY = 1;

    public static void printHeaderRow(int width) {
        printRow(width, "┌", "─", "┬", "┐", null);
    }

    public static void printMainRow(int width, int height) {
        for (int i = 0; i < BattlefieldView.height - 2; i++) {
            printRow(width, "├", "─", "┼", "┤", null);
        }
    }

    public static void printBottomRow(int width) {
        printRow(width, "└", "─", "┴", "┘", null);
    }

    public static void printRow(int width, String start, String main, String connector, String end, Robot robot) {
        int counterX = 1;
        System.out.print(start);
        for (int i = 0; i < width; i++) {
            if (counterX == robot.getRoboterPositionX() && counterY == robot.getRoboterPositionY()) {
                System.out.print(robot.getRoboterSymbol());
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

    public static void display(Battlefield battlefield) {

        printHeaderRow(width);
        printMainRow(width, height);
        printBottomRow(width);
    }
}
