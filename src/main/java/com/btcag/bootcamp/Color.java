package com.btcag.bootcamp;

public enum Color {
    RED("\u001B[0m"),
    BLUE("\u001B[34m"),
    RESET("\u001B[0m");


    private final String value;

    Color(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}

