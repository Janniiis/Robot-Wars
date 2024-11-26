package com.btcag.bootcamp.models;

import com.btcag.bootcamp.views.BattlefieldView;


public class Battlefield {
    private final int width;
    private final int height;

    BattlefieldView map = new BattlefieldView();

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

    private void initializeMap() {
        BattlefieldView.printHeaderRow(width);
        BattlefieldView.printMainRow(width, height);
        BattlefieldView.printBottomRow(width);
    }

    public void setField(int roboterPositionX, int roboterPositionY, char roboterSymbol) {
    }
}
