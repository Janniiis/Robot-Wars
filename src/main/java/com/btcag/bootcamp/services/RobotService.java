package com.btcag.bootcamp.services;

import com.btcag.bootcamp.models.Robot;

public class RobotService {
    public static boolean checkCollision(Robot robot, Robot enemy){
        return (robot.getRoboterPositionX() == enemy.getRoboterPositionX() && robot.getRoboterPositionY() == enemy.getRoboterPositionY());
    }

    public static boolean checkGameOver(Robot robot, Robot enemy) {
        return(robot.getHp() > 0) || checkCollision(robot, enemy);
    }
}
