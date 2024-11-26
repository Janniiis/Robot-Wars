package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

public class RobotView {
    public static void display(Robot robot){
        System.out.println("Dein Roboter heißt: " + robot.getName());
        System.out.println("Der Roboter befindet sich auf der Startposition x: " + robot.getRoboterPositionX() + "y: " + robot.getRoboterPositionY());
    }
}
