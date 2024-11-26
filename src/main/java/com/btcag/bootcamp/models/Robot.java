package com.btcag.bootcamp.models;

public class Robot {
    private final String name;
    private int roboterPositionX;
    private int roboterPositionY;
    private final char roboterSymbol;

    public Robot(String name, int x, int y, char roboterSymbol) {
        this.name = name;
        this.roboterPositionX = roboterPositionX;
        this.roboterPositionY = roboterPositionY;
        this.roboterSymbol = roboterSymbol;
    }

    public int getRoboterPositionX() {
        return roboterPositionX;
    }

    public int getRoboterPositionY() {
        return roboterPositionY;
    }

    public char getRoboterSymbol() {
        return roboterSymbol;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int roboterPositionX, int roboterPositionY) {
        this.roboterPositionX = roboterPositionX;
        this.roboterPositionY = roboterPositionY;
    }
}

