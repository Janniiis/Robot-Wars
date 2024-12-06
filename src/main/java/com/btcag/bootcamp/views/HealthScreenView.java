package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

public class HealthScreenView {
    public static void display(Robot robot, Robot robot2){
        System.out.println("Du hast noch: " + robot.getHp() + " Hp!");
    }
}
