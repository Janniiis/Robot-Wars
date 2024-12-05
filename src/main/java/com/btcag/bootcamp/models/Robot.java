package com.btcag.bootcamp.models;

public class Robot {
    private final String name;
    private int roboterPositionX;
    private int roboterPositionY;
    private final char roboterSymbol;
    private int hp;
    private int movementRange;
    private int attackDamage;
    private int attackRange;
    private String alignment;

    public Robot(String name, int x, int y, char roboterSymbol, int hp, int movementRange, int attackDamage, int attackRange, String alignment) {
        this.alignment = alignment;
        this.name = name;
        this.roboterSymbol = roboterSymbol;
        this.hp = hp;
        this.movementRange = movementRange;
        this.roboterPositionX = x;
        this.roboterPositionY = y;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setMovementRange(int movementRange) {
        this.movementRange = movementRange;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp(){
        return hp;
    }

    public int getMovementRange(){
        return movementRange;
    }

    public int getAttackDamage(){
        return attackDamage;
    }

    public int getAttackRange(){
        return attackRange;
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

    public String getAlignment() {
        return alignment;
    }

    public void setPosition(int roboterPositionX, int roboterPositionY) {
        this.roboterPositionX = roboterPositionX;
        this.roboterPositionY = roboterPositionY;
    }
}

