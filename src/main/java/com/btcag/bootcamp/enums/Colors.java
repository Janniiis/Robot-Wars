package com.btcag.bootcamp.enums;

public enum Colors {
    RED("\u001B[0m"),
    BLUE("\u001B[34m"),
    RESET("\u001B[0m");


    private final String value;

    Colors(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
