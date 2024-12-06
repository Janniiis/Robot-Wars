package com.btcag.bootcamp.models;

public class Items {
    private final String itemName;
    private final int itemPositionX;
    private final int itemPositionY;
    private final int itemEffect;
    private final int itemDurability;

    public Items(String itemName, int itemPositionX, int itemPositionY, int itemEffect, int itemDurability) {
        this.itemName = itemName;
        this.itemPositionX = itemPositionX;
        this.itemPositionY = itemPositionY;
        this.itemEffect = itemEffect;
        this.itemDurability = itemDurability;
    }

    public int getItemPositionX() {
        return itemPositionX;
    }

    public int getItemPositionY() {
        return itemPositionY;
    }

    public double getItemEffect() {
        return itemEffect;
    }

    public int getItemDurability() {
        return itemDurability;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemPositionX(int itemPositionX) {
        itemPositionX = itemPositionX;
    }

    public void setItemPositionY(int itemPositionY) {
        itemPositionY = itemPositionY;
    }
}
