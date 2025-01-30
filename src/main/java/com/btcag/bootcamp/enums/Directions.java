package com.btcag.bootcamp.enums;

public enum Directions{
    N,
    S,
    E,
    W,
    NW,
    NO,
    SW,
    SO;


    public static Directions fromUserInput(char userChoice) {
        return switch (userChoice) {
            case 'w' -> N;
            case 'x' -> S;
            case 'd' -> E;
            case 'a' -> W;
            case 'q' -> NW;
            case 'e' -> NO;
            case 'y' -> SW;
            case 'c' -> SO;
            default -> null;
        };
    }
}