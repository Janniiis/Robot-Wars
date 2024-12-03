package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

public class RobotView {
    public static void display1(Robot robot){
        System.out.println("«-----------------------------------------------»");
        System.out.println("Dein Roboter heißt: " + robot.getName());
        System.out.println("Der Roboter befindet sich auf der Startposition x: " + robot.getRoboterPositionX() + "y: " + robot.getRoboterPositionY());
        System.out.println("«-----------------------------------------------»");
    }

    public static void display2(Robot robot2){
        System.out.println("«-----------------------------------------------»");
        System.out.println("Dein Roboter heißt: " + robot2.getName());
        System.out.println("Der Roboter befindet sich auf der Startposition x: " + robot2.getRoboterPositionX() + "y: " + robot2.getRoboterPositionY());
        System.out.println("«-----------------------------------------------»");
    }
}
