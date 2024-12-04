package com.btcag.bootcamp.enums;

public enum Alignments{
    NORD,
    SUED,
    OST,
    WEST,
    NORDWEST,
    NORDOST,
    SUEDWEST,
    SUEDOST;


    public static Alignments fromUserInput(char userChoice) {
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
}