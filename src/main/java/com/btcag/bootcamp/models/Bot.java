package com.btcag.bootcamp.models;

public class Bot {
    String name;
    int health;
    int attackDamage;
    int attackRange;
    int movementRate;
    char symbol;

    public Bot( String name) {
        this.name = name;
        this.health = 1;
        this.attackDamage= 1;
        this.attackRange= 1;
        this.movementRate= 1;
        this.symbol = 'o';
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public char getSymbol(){
        return symbol;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

