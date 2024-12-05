package com.btcag.bootcamp.enums;

public enum Directions {
    NORD(0, -1),
    SUED(0, 1),
    OST(1, 0),
    WEST(-1, 0),
    NORDWEST(-1, -1),
    NORDOST(1, -1),
    SUEDWEST(-1, 1),
    SUEDOST(1, 1);

    private final int x;
    private final int y;

    Directions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Directions fromUserInput(char userChoice) {
        return switch (userChoice) {
            case 'w' -> NORD;
            case 'x' -> SUED;
            case 'd' -> OST;
            case 'a' -> WEST;
            case 'q' -> NORDWEST;
            case 'e' -> NORDOST;
            case 'y' -> SUEDWEST;
            case 'c' -> SUEDOST;
            default -> null;
        };
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
